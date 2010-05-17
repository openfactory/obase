import org.codehaus.groovy.grails.commons.GrailsApplication
import at.openfactory.ep.asset.FileSystemByteStore
import at.openfactory.ep.security.DefaultSecurityManager

class ObaseGrailsPlugin {
    def version = "snapshot"
    def grailsVersion = "1.2.2 > *"
    def dependsOn = [:]


    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    def author = "Mike P. Kuhl"
    def authorEmail = "mkuhl@softmachine.at"
    def title = "open factory base plugin"
    def description = 'base objects and functions needed by all ep applications'


    // URL to the plugin's documentation
    def documentation = "http://www.openfactory.de/dev/docs/plugins/obase"

    def doWithSpring = {
      // initialize asset store
      def storeDir = ((GrailsApplication)application).config.de.uenterprise.ep.assetStore
      storeDir = storeDir ?: "${System.properties.'user.home'}/.${application.metadata.'app.name'}/assets"
      println ("STORE-ROOT: $storeDir")
      log.info ("installing FileSystemByteStore as default assetStore with storeRoot: $storeDir")

      assetStore (FileSystemByteStore) {bean->
        storeRoot = storeDir
      }

      // initialize security Manager
      securityManager (DefaultSecurityManager) {bean->
        salt = 0x010222562L ; 
      }




    }

    def doWithApplicationContext = { applicationContext ->
        // TODO Implement post initialization spring config (optional)
    }

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional)
    }

    def doWithDynamicMethods = { ctx ->
        // TODO Implement registering dynamic methods to classes (optional)
    }

    def onChange = { event ->
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }
}
