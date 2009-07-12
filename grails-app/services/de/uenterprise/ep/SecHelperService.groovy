package de.uenterprise.ep

class SecHelperService {

    boolean transactional = false

    boolean isMeOrAdmin(String entityName) {
      Entity e = Entity.getByName(entityName)
      if (!e)
        return false
    }

    boolean isMeOrAdmin(Entity e) {
      if (!e)
        return false

      if (entityHelperService.loggedIn.name == e.name)
        return true

      return isAdmin()
    }

    boolean isAdmin () {
      authenticateService.ifAllGranted('ROLE_ADMIN')
    }

}
