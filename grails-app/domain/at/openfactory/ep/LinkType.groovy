package at.openfactory.ep

public class LinkType {

  static hasMany = [links: Link]

  LinkSuperType type
  String        name

  static constraints = {
  }

}