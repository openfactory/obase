package at.openfactory.ep

/**
 * Creator: mkuhl
 * Date: 27.10.2009
 * Time: 12:42:55
 *
 * asset related tags
 */
class OBaseAssetTagLib {
  static namespace = "ob"
  

  def assetImage = {attrs->
    def name = attrs.remove ('name')
    def type = attrs.remove ('type')

    def imgattrs = [:]
    imgattrs['src'] = g.createLink (controller:'asset', action:'get', params:[type:type, entity:name])
    attrs.each {key, val-> imgattrs[key]=val ;}
    def mkp = new groovy.xml.MarkupBuilder(out)
    mkp { img (imgattrs) }
  }

  def profileImage = {attrs->
    out << assetImage (attrs + [type:'profile'])
  }

}
