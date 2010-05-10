import at.openfactory.ep.asset.FileSystemByteStore
import at.openfactory.ep.security.DefaultSecurityManager

beans = {
  assetStore (FileSystemByteStore) {bean->
    storeRoot = "c:/temp/ue-assets"
  }

  securityManager (DefaultSecurityManager) {bean->
    salt = 0x010222562L ; 
  }
}