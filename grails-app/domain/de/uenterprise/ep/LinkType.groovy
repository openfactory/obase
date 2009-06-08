package de.uenterprise.ep
/**
 * User: mkuhl
 * Date: 25.05.2009
 * Time: 19:23:17
 * Description:
 */

public class LinkType {
  static hasMany = [ links : Link ]
  LinkSuperType type 
  String name
}