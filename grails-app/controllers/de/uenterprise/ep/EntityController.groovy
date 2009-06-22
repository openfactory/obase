package de.uenterprise.ep


/**
 * User: mkuhl
 * Date: 25.05.2009
 * Time: 20:00:24
 * Description:
 */

public class EntityController {
  def scaffold = Entity
  static navigation = [group:'admin',
                          order:50, title:'Entities', action:'list']

}