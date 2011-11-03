package at.openfactory.ep

public class Profile {
  static belongsTo = [entity: Entity]

  String fullName
  String tagline

  static constraints = {
    tagline   nullable: true
    fullName  size: 5..80
  }

}