package de.uenterprise.ep.profiles

import de.uenterprise.ep.Profile

/**
 * User: mkuhl
 * Date: 25.05.2009
 * Time: 18:28:29
 * Description:
 */

public class PersonProfile extends GenericProfile
{
  int  gender
  Date birthday

  String profession
  String hobbies

  static constraints = {
    profession (nullable:true)
    hobbies (nullable:true)
    birthday (nullable:true)
  }

}