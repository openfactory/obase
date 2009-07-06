class UBaseCoreTagLib {
  static namespace = "ub"



   /**
   * returns a url to a application resource if exists - plugin resource otherwise
    */
    def resource = {attrs->
      def path = "$attrs.dir/$attrs.file"
      def url
      if (grailsApplication.mainContext.getResource(path).exists())
        url = g.resource (dir:"$attrs.dir", attrs.file)
      else
        url = g.resource (dir:"$pluginContextPath/$attrs.dir/", attrs.file)

      log.debug "loading ubase resource '$path' from $url"

      out << url
    }


   /**
    * returns the 'style' that is in use. affects in turn the layout,css,js tags
    *  -> first looks for a request parameter with the name 'layout'
    *    -> looks for an 'ue.default.layout' parameter from config.groovy
    *      -> takes 'ustd' as a last resort
  */
  def styleName = {attrs->
    def name = params.style
    if (!name)
      name = grailsApplication.config.de.uenterprise.ep.defaultStyle ?: 'grailsdefault'

    out << name
  }


  /**
   * returns a web resource relative to the current style directoty
   */
  def styleResource = {attrs->
    def path = "styles/${styleName()}"

    def url
    if (grailsApplication.mainContext.getResource("$path/$attrs.file").exists())
      url = g.resource (dir:"$path", file:attrs.file)
    else
      url = g.resource (dir:"$pluginContextPath/$path", file:attrs.file)

    log.debug "loading ubase 'style' resource '$attrs.file' from $url"

    out << url
  }


   /**
    * renders all needed (style)Resources
    */
  def resources = {attrs->
    out << "<link rel=\"stylesheet\" type=\"text/css\" href=\"${ub.resource(dir:'css', file: 'yui-reset-fonts-grids.css')}\"/>"
    if (attrs.grailscss == 'true')
      out << "<link rel=\"stylesheet\" type=\"text/css\" href=\"${ub.styleResource(file: "grails.css")}\"/>"

    out << "<link rel=\"stylesheet\" type=\"text/css\" href=\"${ub.styleResource(file: "layout.css")}\"/>"
    out << "<link rel=\"stylesheet\" type=\"text/css\" href=\"${ub.styleResource(file: "forms.css")}\"/>"
    out << "<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"${ub.styleResource(file: "favicon.ico")}\"/>"
    out << nav.resources(override:true)
  }

  /**
  * returns the name of the (default) layout to use based on the current style
   */
  def layoutName = {attrs->
    out << "styles/${styleName()}"
  }

  def layout = {attrs->
    out << "<meta name=\"layout\" content=\"${layoutName()}\" />"
  }

}
