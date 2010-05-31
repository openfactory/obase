package obase

import at.openfactory.ep.OBaseSecTagLib

/**
 * this taglib provides access to the ubase 1.X ub: prefixed tags for compatibility reasons. usage of those
 * in new code is strongly discouraged.
 * 
 */

class UBaseAliasTagLib {
  static namespace = "ub"


  // coreTagLib
  def resource = {attrs->ob.resource(attrs)}
  def entityName = {attrs->ob.entityName(attrs)}
  def ifGrailsEnv = {attrs, body->ob.ifGrailsEnv(attrs,body)}

  // secTagLib
  def isAdmin = {attrs, body->
    out      <<  ob.isAdmin(attrs,body)
  }

  def notAdmin = {attrs, body->out      << ob.notAdmin(attrs,body)}
  def meOrAdmin = {attrs, body->out     << ob.meOrAdmin(attrs,body)}
  def notMe = {attrs, body-> out        << ob.notMe(attrs,body)}
  def hasAllRoles = {attrs, body-> out  << ob.hasAllRoles(attrs,body)}
  def hasNoRoles = {attrs, body-> out   << ob.hasNoRoles(attrs,body)}

  // assets
  def assetImage = {attrs-> out << ob.assetImage(attrs)}
  
  def profileImage = {attrs-> out << ob.profileImage(attrs)}
  

}
