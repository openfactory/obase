package de.uenterprise.ep
/**
 * User: mkuhl
 * Date: 25.05.2009
 * Time: 18:15:43
 * Description: base class for all profiles
 */

public class Profile {
  static belongsTo = [ entity: Entity]
  String fullName ;
  String tagline ;

  static constraints = {
    tagline(nullable:true)
    fullName(size:5..35)
  }


}