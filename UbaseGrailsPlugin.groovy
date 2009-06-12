class UbaseGrailsPlugin {
    def version = "0.1.1"
    def grailsVersion = "1.1.1 > *"
    def dependsOn = [jquery:"1.0RC2b", navigation:"1.0.4 > *", acegi:"0.5 > *"]

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
        // TODO Implement runtime spring config (optional)
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
