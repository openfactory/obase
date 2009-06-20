package de.uenterprise.ep

class UserController {
  def scaffold = Account

  static navigation = [group:'main',
          order:50, title:'Users', action:'list']



}
