class UBaseSecTagLib {
  def entityHelperService
  def secHelperService

  static namespace = "ub"

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
    if (secHelperService.isAdmin())
      out << body()
  }

  def notAdmin = {attrs, body->
    if (!secHelperService.isAdmin())
      out << body()
  }

}
