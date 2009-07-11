/**
 * User: mkuhl
 * Date: 11.07.2009
 * Time: 14:17:33
 * Description:
 */
package de.uenterprise.ep.ubase

import de.uenterprise.ep.ubase.IByteStore

class FileSystemByteStore implements IByteStore{
  File storeRoot = new File ("c:/temp/astore") ;

  def void put(String id, byte[] content) {
    storeRoot.mkdirs()
    def afile = new File (storeRoot, id)
    afile.withOutputStream {os-> os << content}
  }

  def byte[] get(String id) {
    def afile = new File (storeRoot, id)
    return afile.readBytes()
  }


}