package at.openfactory.ep.profiles

import at.openfactory.ep.Profile

/**
 * User: mkuhl
 * Date: 25.05.2009
 * Time: 18:29:03
 * Description:
 */

public class GenericProfile extends Profile
{
  byte[] profilePic
  String description

  static constraints = {
    description (nullable:true)
    profilePic (nullable:true)
  }

  static mapping = {
    description type:'text'
  }
}