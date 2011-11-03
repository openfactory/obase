package at.openfactory.ep

class Tag {

  static hasMany = [entityLinks: EntityTagLink]

  String  name
  Date    dateCreated

  static constraints = {
  }

}
