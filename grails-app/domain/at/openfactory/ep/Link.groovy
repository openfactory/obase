package at.openfactory.ep

import at.openfactory.ep.attr.DynAttr

public class Link {

  static hasMany = [dynattrs : DynAttr]

  Date      dateCreated
  LinkType  type
  Entity    source
  Entity    target

  static constraints = {
  }

}
