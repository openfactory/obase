package de.uenterprise.ep
/**
 * User: mkuhl
 * Date: 25.05.2009
 * Time: 18:05:31
 * Description:
 */

public class User {
  static belongsTo = [ entity : Entity ]

  String email

  static constraints = {
    email (email:true, nullable:false, blank:false, unique:true)
  }

}