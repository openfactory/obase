package de.uenterprise.ep

class DashboardController {
  def authenticateService
  def entityHelperService
  def profileHelperService

  static navigation = [group:'main',
                          order:10, title:'Dashboard', action:'index',
                subItems: [
                      [action:'test3', order:1, title:"dashboard action 3"],
                    ]

  ]

    def index = {
      if (!params.id)  {
        redirect(id:entityHelperService.loggedIn.name)
        return ;
      }

      log.debug ("requested entity was '$params.id'")

      // the logged in user account can only view it's own dashbord if he's not admin
      if (params.id != entityHelperService.loggedIn.name && !authenticateService.ifAllGranted('ROLE_ADMIN')) {
        log.error ("requested entity '$params.id' is not the logged in user (and not an admin).")
        log.error ("current user '$entityHelperService.loggedIn.name' requested '$params.id' dashboard w/o beeing an admin !")
        redirect (controller:'login', action:'denied')
        return
      }

      def ent = Entity.findByName(params.id)
      if (!ent) {
        log.warn  ("requested entity '$params.id' not found.")
        response.sendError (404, "[$params.id] no such entity")
        return
      }
      return [entity:ent]
    }


    def test3 = {

    }

}
