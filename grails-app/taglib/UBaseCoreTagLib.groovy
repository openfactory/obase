class UBaseCoreTagLib {
  static namespace = "ub"



   /**
    * returns the 'style' that is in use. affects in turn the layout,css,js tags
    *  -> first looks for a request parameter with the name 'layout'
    *    -> looks for an 'ue.default.layout' parameter from config.groovy
    *      -> takes 'ustd' as a last resort
  */
  def styleName = {attrs->
    def name = params.style
    if (!name)
      name = grailsApplication.config.de.uenterprise.ep.defaultStyle ?: 'ustd'

    out << name
  }


  /**
   * returns a web resource relative to the current style directoty
   */
  def styleResource = {attrs->
    def name = styleName()
    def url = g.resource (dir:"styles/$name", file:attrs.file)
    out << url
  }

  /**
  * returns the name of the (default) layout to use based on the current style
   */
  def layoutName = {attrs->
    out << styleName()
  }

  def layout = {attrs->
    out << "<meta name=\"layout\" content=\"${layoutName()}\" />"
  }

}
