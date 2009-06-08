package de.uenterprise.ep
/**
 * User: mkuhl
 * Date: 25.05.2009
 * Time: 19:47:14
 * Description:
 */

public class Entity {
  static hasMany = [tagslinks : EntityTagLink]

  EntityType type ;

  String name ;
  Date dateCreated
  Date lastUpdated

  User user ;
  Profile profile ;

  static constraints = {
    name(size:3..20)
    user(nullable: true)
    profile (nullable:true)
}


  String toString() {"Entity:$name"}

}