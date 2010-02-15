package de.uenterprise.ep

class UserController {
  def scaffold = Account

  static navigation = [group:'admin',
          order:50, title:'Users', action:'list']



}
