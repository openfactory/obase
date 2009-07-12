class UBaseSecTagLib {
  def entityHelperService
  def secHelperService

  static namespace = "ub"

  def meOrAdmin = {attrs, body->
    if (secHelperService.isMeOrAdmin(attrs.entity))
      out << body()
  }

  def isAdmin = {attrs, body->
    if (secHelperService.isAdmin())
      out << body()
  }
}
