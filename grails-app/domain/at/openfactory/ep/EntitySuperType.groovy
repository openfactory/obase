package at.openfactory.ep

public class EntitySuperType {

  static hasMany = [entityTypes: EntityType]

  String  name
  String  profileType = "Generic"

  static constraints = {
  }


}