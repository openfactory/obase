package at.openfactory.ep.attr

/**
 * User: mkuhl
 *
 * Implements a Dynamic Attribute to used in Entity, Links, etc. 
 *
 *
 */
class DynAttr {

  String name
  String value
  
  static constraints = {
    name  blank: false
    value nullable: false
  }

}
