package at.openfactory.ep.profiles

import at.openfactory.ep.Profile

public class GenericProfile extends Profile {

  byte[] profilePic
  String description

  static constraints = {
    description nullable: true
    profilePic  nullable: true
  }

  static mapping = {
    description type:'text'
  }

}