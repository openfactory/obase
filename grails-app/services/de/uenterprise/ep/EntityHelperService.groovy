package de.uenterprise.ep

import de.uenterprise.ep.profiles.PersonProfile

/**
 * User: mkuhl
 * Date: 25.05.2009
 * Time: 22:18:53
 * Description: entity related business rules and helpers
 */

public class EntityHelperService {
  def authenticateService

  static transactional = true



/**
* creates an entity optionally calls an closure to modify the entity and save it

*/
Entity createEntity (String name, EntityType type, Closure c=null) {
  def ent = new Entity(name:name, type:type)
  if (c)
    c.call (ent)

  if (ent.save())
    return ent

  ent.errors.allErrors.each {
    log.error ("create entity $name: field: '$it.field' code: $it.code, rejectedValue: $it.rejectedValue")
  }
  throw new EntityException(entity:ent, message:"failed to create entity '$name'")
}


/**
* creates an entity with an user
*/
  Entity createEntityWithUser (String name, EntityType type, String emailAddr, Closure c=null) {
    createEntity(name, type) {Entity ent->
      def role = Role.findByAuthority("ROLE_USER")
      if (!role)
        throw new EntityException(message:"cannot create user account. ROLE_USER not found", entity:ent)

      ent.user = new Account (email:emailAddr, password:authenticateService.encodePassword("pass"), enabled:true)
      ent.user.addToAuthorities (role)
      if (c) c.call (ent)
    }
  }

  Entity createEntityWithUserAndProfile (String name, EntityType type, String emailAddr, String fullName, Closure c=null) {
    createEntityWithUser (name, type, emailAddr) {Entity ent->
      ent.profile = new Profile (fullName:fullName)
      if (c) c.call (ent)
    }
  }

  EntitySuperType getPersonSuperType () {
    return EntitySuperType.findByName ("Person")
  }
}

class EntityException extends RuntimeException {
  String message
  Entity entity
}