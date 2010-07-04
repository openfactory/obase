package at.openfactory.ep

import at.openfactory.ep.attr.DynAttr

/**
 * User: mkuhl
 * Date: 25.05.2009
 * Time: 19:22:08
 * Description:
 */

public class Link {
  Date dateCreated
  
  LinkType type 
  Entity source
  Entity target

  static hasMany = [dynattrs : DynAttr] 
}
