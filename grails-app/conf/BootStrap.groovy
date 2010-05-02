class BootStrap {
    def   defaultObjectService

    def init = { servletContext ->
      defaultObjectService.bootstrapData()
    }

     def destroy = {
     }

}