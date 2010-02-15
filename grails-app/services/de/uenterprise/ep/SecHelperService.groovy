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

    boolean hasAllRoles (Entity e, List roles) {
      if (!e)
        return false

//      if (e.user?.authorities?.find { roles.contains(it.authority) })
//        return true

      def matching = roles.findAll { e.user?.authorities*.authority.contains(it) }
      return matching.size() == roles.size()
    }

    boolean hasNoRoles (Entity e, List roles) {
      if (!e)
        return true

      def res = !roles.find { e.user?.authorities*.authority.contains (it) }
      return res
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
