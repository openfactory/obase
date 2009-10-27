package de.uenterprise.ep
/**
 * User: mkuhl
 * Date: 25.05.2009
 * Time: 18:05:31
 * Description:
 */

public class Account {
  static belongsTo = [ entity : Entity]
  static hasMany = [authorities: Role]


  String email
  String password
  boolean enabled
  Date    lastLogin
  Date    prevLogin 

  static constraints = {
    email (email:true, nullable:false, blank:false, unique:true)
  }

}