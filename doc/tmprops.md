Starting a Gradle Daemon, 2 incompatible and 1 stopped Daemons could not be reused, use --status for details
Parallel execution is an incubating feature.

> Task :properties

------------------------------------------------------------
Root project
------------------------------------------------------------

//(only: relevant for the createDB task when dbType=postgresql)
//Database: connection parameters
//JBoss: location. If this is not set, the environment variable JBOSS_HOME will be used.
//Maven: repository user settings
//Proxy: settings
//jbossHome: C:/path/to/jboss
//set: this to true if you want your build to fail when an sql error occurs
//systemProp.http.nonProxyHosts: davis.wincor-nixdorf.com|tom.wincor-nixdorf.com|sonar.wincor-nixdorf.com
//systemProp.https.nonProxyHosts: davis.wincor-nixdorf.com|tom.wincor-nixdorf.com|sonar.wincor-nixdorf.com
allprojects: [root project 'refapp-devhandler', project ':devhandler-assembly', project ':devhandler-sample-dml', project ':devhandler-scc-client-assembly', project ':devhandler-scc-sample-dml']
ant: org.gradle.api.internal.project.DefaultAntBuilder@147cb3bf
antBuilderFactory: org.gradle.api.internal.project.DefaultAntBuilderFactory@338c44f3
archivesBaseName: refapp-devhandler
artifactHelper: com.dieboldnixdorf.txm.BuildInitPlugin$ArtifactHelper_Decorated@596139b5
artifacts: org.gradle.api.internal.artifacts.dsl.DefaultArtifactHandler_Decorated@6299e155
asDynamicObject: DynamicObject for root project 'refapp-devhandler'
baseClassLoaderScope: org.gradle.api.internal.initialization.DefaultClassLoaderScope@130957f2
buildDir: C:\ant\devkit\devkit-2.0.1-Build.8\refapp-devhandler-2.0.1-Build.8\build
buildFile: C:\ant\devkit\devkit-2.0.1-Build.8\refapp-devhandler-2.0.1-Build.8\build.gradle
buildPath: :
buildScriptSource: org.gradle.groovy.scripts.TextResourceScriptSource@427332bc
buildscript: org.gradle.api.internal.initialization.DefaultScriptHandler@120f07d6
childProjects: {devhandler-assembly=project ':devhandler-assembly', devhandler-sample-dml=project ':devhandler-sample-dml', devhandler-scc-client-assembly=project ':devhandler-scc-client-assembly', devhandler-scc-sample-dml=project ':devhandler-scc-sample-dml'}
class: class org.gradle.api.internal.project.DefaultProject_Decorated
classLoaderScope: org.gradle.api.internal.initialization.DefaultClassLoaderScope@3fb1cf8b
components: SoftwareComponentInternal set
configurationActions: org.gradle.configuration.project.DefaultProjectConfigurationActionContainer@66dea948
configurationTargetIdentifier: org.gradle.configuration.ConfigurationTargetIdentifier$1@3de391fd
configurations: configuration container
convention: org.gradle.api.internal.plugins.DefaultConvention@57380020
dbConnection: localhost
dbName: XE
dbPW: ruegen
dbPort: 1521
dbType: oracle
dbUser: ruegen
defaultArtifacts: org.gradle.api.internal.plugins.DefaultArtifactPublicationSet_Decorated@66c450db
defaultTasks: []
deferredProjectConfiguration: org.gradle.api.internal.project.DeferredProjectConfiguration@75c321a2
dependencies: org.gradle.api.internal.artifacts.dsl.dependencies.DefaultDependencyHandler_Decorated@540e2a9e
dependencyConstraints: com.dieboldnixdorf.txm.DependencyConstraintsPlugin$DependencyConstraintsExtension_Decorated@43a0193f
dependencyInsightEnhanced: task ':dependencyInsightEnhanced'
dependencyLocking: org.gradle.internal.locking.DefaultDependencyLockingHandler_Decorated@7a6cb18
dependencyRecommendations: RecommendationProvider container
depth: 0
description: null
displayName: root project 'refapp-devhandler'
distsDir: C:\ant\devkit\devkit-2.0.1-Build.8\refapp-devhandler-2.0.1-Build.8\build\distributions
distsDirName: distributions
downloadRepositories: init_3hxhot9p3i9syye6685hl8oz3$_run_closure1$_closure3@6b84247f
ext: org.gradle.api.internal.plugins.DefaultExtraPropertiesExtension@4efba94b
extensions: org.gradle.api.internal.plugins.DefaultConvention@57380020
fileOperations: org.gradle.api.internal.file.DefaultFileOperations@d51284a
fileResolver: org.gradle.api.internal.file.BaseDirFileResolver@3c1eccf3
gradle: build 'refapp-devhandler'
group: com.dieboldnixdorf.txm.delivery
identityPath: :
inheritedScope: org.gradle.api.internal.ExtensibleDynamicObject$InheritedDynamicObject@76f3b0d3
layout: org.gradle.api.internal.file.DefaultProjectLayout@65d1feb7
libsDir: C:\ant\devkit\devkit-2.0.1-Build.8\refapp-devhandler-2.0.1-Build.8\build\libs
libsDirName: libs
logger: org.gradle.internal.logging.slf4j.OutputEventListenerBackedLogger@61c6893f
logging: org.gradle.internal.logging.services.DefaultLoggingManager@2b75b8a0
mavenLocalPath: C:\Users\txm/.txm-local
mavenOfflinePath: C:\Users\txm/.txm-offline
mavenPassword: <maven-repository-password-token>
mavenUser: <maven-repository-user-token>
modelRegistry: org.gradle.model.internal.registry.DefaultModelRegistry@40ebe035
modelSchemaStore: org.gradle.model.internal.manage.schema.extract.DefaultModelSchemaStore@2aa59ad9
module: org.gradle.api.internal.artifacts.ProjectBackedModule@3c4f2453
name: refapp-devhandler
nebulaDependencyBase: com.netflix.nebula.dependencybase.DependencyManagement@7fff71c3
nebulaDependencyManagement: netflix.nebula.dependency.recommender.publisher.MavenBomXmlGenerator_Decorated@79c97624
normalization: org.gradle.normalization.internal.DefaultInputNormalizationHandler_Decorated@66bccb60
objects: org.gradle.api.internal.model.DefaultObjectFactory@6049e63c
org.gradle.jvmargs: -Xmx1536m
org.gradle.parallel: true
parent: null
parentIdentifier: null
path: :
pluginManager: org.gradle.api.internal.plugins.DefaultPluginManager_Decorated@64bce29f
plugins: [org.gradle.api.plugins.HelpTasksPlugin@6deda994, org.gradle.language.base.plugins.LifecycleBasePlugin@25f8f137, org.gradle.api.plugins.BasePlugin@3fd0f8f8, com.netflix.nebula.dependencybase.DependencyBasePlugin@1fe5c7da, netflix.nebula.dependency.recommender.DependencyRecommendationsPlugin@550fa6d3, com.dieboldnixdorf.txm.DependencyConstraintsPlugin@248ae4b, com.dieboldnixdorf.txm.BuildInitPlugin@48478059]
postgresFailOnSQLError: false
processOperations: org.gradle.api.internal.file.DefaultFileOperations@d51284a
project: root project 'refapp-devhandler'
projectConfigurator: org.gradle.api.internal.project.BuildOperationCrossProjectConfigurator@5676c07a
projectDir: C:\ant\devkit\devkit-2.0.1-Build.8\refapp-devhandler-2.0.1-Build.8
projectEvaluationBroadcaster: ProjectEvaluationListener broadcast
projectEvaluator: org.gradle.configuration.project.LifecycleProjectEvaluator@5611f61f
projectPath: :
projectRegistry: org.gradle.api.internal.project.DefaultProjectRegistry@79c682e7
properties: {...}
providers: org.gradle.api.internal.provider.DefaultProviderFactory@7aed2f5a
recommend: org.codehaus.groovy.runtime.MethodClosure@1af8456d
repositories: repository container
resourceLoader: org.gradle.internal.resource.transfer.DefaultUriTextResourceLoader@4380e923
resources: org.gradle.api.internal.resources.DefaultResourceHandler@e9c9a0e
rootDir: C:\ant\devkit\devkit-2.0.1-Build.8\refapp-devhandler-2.0.1-Build.8
rootProject: root project 'refapp-devhandler'
script: false
scriptHandlerFactory: org.gradle.api.internal.initialization.DefaultScriptHandlerFactory@1d18f378
scriptPluginFactory: org.gradle.configuration.ScriptPluginFactorySelector@45130e9b
serviceRegistryFactory: org.gradle.internal.service.scopes.ProjectScopeServices$4@11e2eeb
services: ProjectScopeServices
standardOutputCapture: org.gradle.internal.logging.services.DefaultLoggingManager@2b75b8a0
state: project state 'EXECUTED'
status: integration
subprojects: [project ':devhandler-assembly', project ':devhandler-sample-dml', project ':devhandler-scc-client-assembly', project ':devhandler-scc-sample-dml']
systemProp.http.proxyHost: proxy.wincor-nixdorf.com
systemProp.http.proxyPort: 81
systemProp.https.proxyHost: proxy.wincor-nixdorf.com
systemProp.https.proxyPort: 81
tasks: task set
uploadRepositoriesRelease: init_3hxhot9p3i9syye6685hl8oz3$_run_closure1$_closure5@6bb8882c
uploadRepositoriesSnapshot: init_3hxhot9p3i9syye6685hl8oz3$_run_closure1$_closure4@31e12510
version: 2.0.1-Build.8
wrapper: task ':wrapper'

BUILD SUCCESSFUL in 23s
1 actionable task: 1 executed
