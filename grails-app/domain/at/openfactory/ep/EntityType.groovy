package at.openfactory.ep
/**
 * User: mkuhl
 * Date: 25.05.2009
 * Time: 18:11:00
 * Description:
 */

public class EntityType {
  static hasMany = [ entities : Entity ]
  static belongsTo = [supertype : EntitySuperType ]

  String name

  static constraints = {
    name (blank:false)
  }

  String toString () {"EntityType:$name" }

}