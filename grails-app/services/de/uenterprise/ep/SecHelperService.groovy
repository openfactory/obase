package de.uenterprise.ep

class SecHelperService {
    def entityHelperService
    def authenticateService

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

      Entity el = entityHelperService.loggedIn ;
      if (!el)
        return false

      if (el.name == e.name)
        return true

      return   isAdmin()
    }

    boolean isNotMe (Entity e) {
      if (!e)
        return true

      return entityHelperService.loggedIn.name != e.name
    }

    boolean isAdmin () {
      authenticateService.ifAllGranted('ROLE_ADMIN')
    }

    boolean isLoggedIn () {
      authenticateService.isLoggedIn()
    }

}
