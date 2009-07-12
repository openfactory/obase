package de.uenterprise.ep

class SecHelperService {
    def entityHelperService

    boolean transactional = false

    boolean isMeOrAdmin(String entityName) {
      Entity e = Entity.findByName(entityName)
      if (!e)
        return false

      return (isMeOrAdmin (e))
    }

    boolean isMeOrAdmin(Entity e) {
      if (!e)
        return false

      if (entityHelperService.loggedIn.name == e.name)
        return true

      return isAdmin()
    }

    boolean isNotMe (Entity e) {
      if (!e)
        return true

      return entityHelperService.loggedIn.name != e.name
    }

    boolean isAdmin () {
      authenticateService.ifAllGranted('ROLE_ADMIN')
    }

}
