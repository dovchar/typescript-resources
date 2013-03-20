class TypescriptGrailsPlugin {
    // the plugin version
    def version = "0.3"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.0 > *"
    // resources that are excluded from plugin packaging
    def dependsOn = [resources: '1.0 > *']
    def loadAfter = ['resources']
    def pluginExcludes = [
        "grails-app/views/error.gsp",
        "web-app/js/**/*.*"
    ]

    // TODO Fill in these fields
    def title = "TypeScript resource plugin"
    def author = "Dima Ovcharenko"
    def authorEmail = "o.snich@gmail.com"
    def description = '''\
This plugin can help you manage typescript code in your grails application.
'''

    def documentation = "http://grails.org/plugin/typescript"
    def license = "MIT"

    //    def organization = [ name: "My Company", url: "http://www.my-company.com/" ]
    //    def developers = [ [ name: "Joe Bloggs", email: "joe@bloggs.net" ]]
    //    def issueManagement = [ system: "JIRA", url: "http://jira.grails.org/browse/GPMYPLUGIN" ]

    def scm = [ url: "http://github.com/dovchar/typescript-resources" ]
}
