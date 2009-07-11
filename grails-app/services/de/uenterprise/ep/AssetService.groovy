package de.uenterprise.ep

import org.springframework.web.multipart.MultipartFile
import de.uenterprise.ep.ubase.util.HashTools
import de.uenterprise.ep.ubase.IByteStore


class AssetService {
    boolean transactional = true
    IByteStore assetStore

    def storeAsset(Entity ent, String type, MultipartFile mfile) {
      storeAsset(ent, type, mfile.contentType, mfile.getBytes())
    }



   /**
    * creates and if nessesarry stores an asset from the given data.
    * The corresponding storage is identified by a SHA hash (of the content) and re-used if already
    * exists. This will avoid duplicate storage and has other interesting usages
    */
    def storeAsset(Entity ent, String type, String contentType, byte[] content) {
      def sid = HashTools.SHA(content)

      // see if we have it already stored somehow ...
      def store = AssetStorage.findByStorageId (sid)
      if (!store) {
        store = new AssetStorage (storageId:sid, contentType:contentType)
        assetStore.put (sid, content)
        store = store.save()
      }

      // now see if we have a linked asset for this user type and storage
      def asset = Asset.createCriteria().get {
        and {
          eq ('entity', ent)
          eq ('type', type)
          eq ('storage', store)
        }
      }

      // only if it's not there, create a new one and link it with the storage
      if (!asset) {
        asset = new Asset(entity:ent, storage:store, type:type)
        if (!asset.save()) {
          current.errors.allErrors.each {
            log.error ("create asset $name: field: '$it.field' code: $it.code, rejectedValue: $it.rejectedValue")
          }
          return null
        }
      }

      log.debug ("asset for $ent.name of type $type is stored as $sid") 
      return asset

    }

}
