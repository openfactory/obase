package de.uenterprise.ep

class UserController {
  def scaffold = User

  static navigation = [group:'main',
          order:10, title:'Users', action:'list']



}
