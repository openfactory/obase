package at.openfactory.ep
class OBaseSecTagLib {
  def entityHelperService
  def secHelperService
  def securityManager

  static namespace = "ob"

  def meOrAdmin = {attrs, body->
    if (secHelperService.isMeOrAdmin(attrs.entityName))
      out << body()
  }

  def notMe = {attrs, body->
    if (entityHelperService.loggedIn?.name != attrs.entityName)
      out << body()
  }

  def hasAllRoles = {attrs, body->
    if (secHelperService.hasAllRoles (attrs.entity, attrs.roles))
      out << body() ;
  }

  def hasNoRoles = {attrs, body->
    if (secHelperService.hasNoRoles (attrs.entity, attrs.roles))
      out << body() ;
  }

  def isAdmin = {attrs, body->
    Entity e = getEntity (attrs) ;
    if (!e)
      e = securityManager.getLoggedIn(request)

    if (secHelperService.isAdmin(e))
      out << body()
  }

  def notAdmin = {attrs, body->
    if (!secHelperService.isAdmin())
      out << body()
  }


  private Entity getEntity (def attrs) {
    if (attrs.entity)
      return attrs.entity
    if (attrs.entityName)
      return Entity.findByName (attrs.entityName)
  }

}
