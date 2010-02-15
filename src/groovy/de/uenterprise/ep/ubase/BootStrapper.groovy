package de.uenterprise.ep.ubase
/**
 * User: mkuhl
 * Date: 20.06.2009
 * Time: 17:09:58
 * Description: Bootstrap helper functions
 */

public class BootStrapper {
  def   sessionFactory
  def   entityHelperService

  def   testBootstrap = {
    assert sessionFactory
    assert entityHelperService
    log.warn "start bootstrapping..."
  }


}