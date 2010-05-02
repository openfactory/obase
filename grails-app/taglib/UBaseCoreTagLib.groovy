import de.uenterprise.ep.Entity
import de.uenterprise.ep.Account

class UBaseCoreTagLib {
  def entityHelperService

  static namespace = "ub"



   /**
   * returns a url to a application resource if exists - plugin resource otherwise
    */
    def resource = {attrs->
      def path = "$attrs.dir/$attrs.file"
      def url
      if (grailsApplication.mainContext.getResource(path).exists())
        url = g.resource (dir:"$attrs.dir", file:attrs.file)
      else
        url = g.resource (dir:"$pluginContextPath/$attrs.dir/", file:attrs.file)

      log.debug "loading ubase resource '$path' from $url"

      out << url
    }


  def entityName = {attrs->
    Entity entity
    if (attrs.email)
      entity = Entity.findByUser (new Account(email:attrs.email))

    entity = entity ?:  entityHelperService.loggedIn
    if (!entity)
      out << "not logged in"
    else {
      entity.refresh()
      entity.profile.refresh()
      out << "$entity.name ($entity.profile.fullName)"
    }

  }

  def ifGrailsEnv = {attrs, body->
    def env = grails.util.GrailsUtil.environment

    if (attrs.env && attrs.env instanceof List && attrs.env.contains (env))
      out << body()
    else if (attrs.env == env)
      out << body() 
  }

}
