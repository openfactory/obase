package de.uenterprise.ep
/**
 * User: mkuhl
 * Date: 25.05.2009
 * Time: 19:25:09
 * Description:
 */

public class LinkSuperType {
  static hasMany = [ types : LinkType ]

  String name ;
  String description ;

  static constraints = {
    description (nullable:true)
  }

}