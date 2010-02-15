package de.uenterprise.ep
/**
 * User: mkuhl
 * Date: 25.05.2009
 * Time: 19:47:14
 * Description:
 */

public class Entity {
  static hasMany = [tagslinks:EntityTagLink, assets:Asset]

  EntityType type ;

  String name ;
  Date dateCreated
  Date lastUpdated

  Account user ;
  Profile profile ;

  static constraints = {
    name(size:3..50)
    user(nullable: true)
    profile (nullable:true)
  }


  String toString() {"Entity:$name"}

}