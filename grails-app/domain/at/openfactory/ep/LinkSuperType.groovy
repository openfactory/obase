package at.openfactory.ep

public class LinkSuperType {

  static hasMany = [types: LinkType]

  String name
  String description

  static constraints = {
    description nullable: true
  }

}