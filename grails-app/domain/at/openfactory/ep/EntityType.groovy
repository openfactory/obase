package at.openfactory.ep

public class EntityType {

  static hasMany    = [entities: Entity]
  static belongsTo  = [supertype: EntitySuperType]

  String name

  static constraints = {
    name blank: false
  }

  String toString () {
    "EntityType: $name"
  }

}