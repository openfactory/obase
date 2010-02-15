package de.uenterprise.ep
/**
 * User: mkuhl
 * Date: 25.05.2009
 * Time: 18:22:15
 * Description:
 */

public class EntitySuperType {
  static hasMany = [ entityTypes : EntityType ]

  String      name
  String      profileType = "Generic"



}