grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.docs.output.dir = 'docs' // for the gh-pages branch

//grails.tomcat.jvmArgs = ["-Xmx1024m","-Xms512m", "-agentpath:C:\\Program Files (x86)\\YourKit Java Profiler 9.0.9\\bin\\win64\\yjpagent.dll=sampling,onexit=snapshot"]
grails.project.repos.myRepo.url = "http://23.21.171.7/nexus/content/repositories/plang/"
grails.project.repos.myRepo.username = "deployment"
grails.project.repos.myRepo.password = "deploymentG"
grails.project.repos.default = "myRepo"
grails.release.scm.enabled = false

//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        mavenLocal()
        mavenCentral()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
        mavenRepo "http://oss.sonatype.org/content/repositories/releases/"
		
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        runtime "org.elasticsearch:elasticsearch:0.19.11"
        runtime "org.elasticsearch:elasticsearch-lang-groovy:1.1.0"
		runtime "joda-time:joda-time:2.1"
		//runtime 'org.xerial.snappy:snappy-java:1.0.4.1' --> throws java.lang.UnsatisfiedLinkError: org.xerial.snappy.SnappyNative.maxCompressedLength(I)I
    }
    plugins {
		runtime ":hibernate:$grailsVersion"
        build (":release:2.0.4", ":rest-client-builder:latest.integration") {
            export = false
        }
        test (":spock:0.6") {
            export = false
        }
    }
}
