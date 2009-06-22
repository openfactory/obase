import de.uenterprise.ep.*
import de.uenterprise.ep.profiles.PersonProfile
import de.uenterprise.ep.ubase.BootStrapper

class BootStrap {
    def   defaultObjectService

    def init = { servletContext ->
      defaultObjectService.bootstrapData()
    }

     def destroy = {
     }

}