import org.codehaus.groovy.grails.commons.GrailsApplication

class UbaseGrailsPlugin {
    def version = "snapshot"
    def grailsVersion = "1.1.1 > *"
    def dependsOn = [navigation:'1.1 > *', jquery:'1.3.2.4 > *', acegi:'0.5.1 > *']


    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    def author = "Mike P. Kuhl"
    def authorEmail = "mk@uenterprise.de"
    def title = "ue/ep ubase plugin"
    def description = 'base objects and functions needed by all ue/ep applications'


    // URL to the plugin's documentation
    def documentation = "http://dev.uenterprise.de/ep/grails/plugins/ubase"

    def doWithSpring = {
      def storeDir = ((GrailsApplication)application).config.de.uenterprise.ep.assetStore
      storeDir = storeDir ?: "${System.properties.'user.home'}/.${application.metadata.'app.name'}/assets"
      println ("STORE-ROOT: $storeDir")
      log.info ("installing FileSystemByteStore as default assetStore with storeRoot: $storeDir")

      assetStore (de.uenterprise.ep.ubase.FileSystemByteStore) {bean->
        storeRoot = storeDir
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
