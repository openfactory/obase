import at.openfactory.ep.Entity

class SecFilters {
    def securityManager


    def filters = {
      // store the current sessions logged in entity to a thread-local for usage in services etc where no session
     // access is avail.

      currentEntityFilter(controller:'*', action:'*') {
        before = {
          Entity e = securityManager.getLoggedIn(request) ;
          if (e) {
            e = Entity.get(e?.id)
            log.debug ("mapping entity ${e?.name} into request chain")
            log.debug ("account: ${e?.user?.email} ")
            e.user.authorities.each{log.debug "role: $it.authority"}
          }
          return true
        }

        // inject currentEntity into model for backward compatibility -> use the tag instead
        after = {model->
          if (model)  {
            Entity e = securityManager.getLoggedIn(request) ;
            if (e)
              model['currentEntity'] = e
          }
        }
      }
   }
}