# buildSrc (Gradle Plugin)

## TXM Plugin

TXM supplies several plugins to package up reusable pieces of build
logic, which can be used across many different projects and builds. It
is imperative to comprehend the usages of these plugins from the
perspective of gradle lifecycle tasks.
 
- build - assembles archives, based on the classes and resources
  attached to the main source set. These archives typically are
  components of application server with archive type of JAR, WAR, RAR,
  and ZIP.
  
- install - assembles archives that serves as distribution, based on the
  outputs of *build*. Distribution archives typically contain the
  executable application and other supporting files, such as EAR and
  database scripts.

In TXM, plugin *txm-server-assembly* and plugin *txm-sc-assembly*
expand the task *install* to assemble server distribution and client
distribution respectively; whereas other plugins expand the task *build*
to assemble archives that serve as component.

Search OperatorManual_Devkit at [Knowledge Base](go/tm2kb) for more
details about TXM plugins.

### txm-lib

*txm-lib* extends the
[Java Plugin](https://docs.gradle.org/current/userguide/java_plugin.html)
to build JVM-based projects. With TXM assembly plugins, the build output
can be assembled into server distribution and client distribution.

*txm-lib* extended and modified the following tasks.

| Type | Name    | Provider              | Description                                                                   |
|:-----|:--------|:----------------------|:------------------------------------------------------------------------------|
| Task | build   | *java*                | assembles the source sets into application JAR files                          |
| Task | install | *txm-server-assembly* | assembles the JAR files into server distribution <br> txm-server.ear/lib      |
| Task | install | *txm-sc-assembly*     | assembles the JAR files build output into client distribution <br> c:/pce/lib |

You can find a comprehensive introduction and overview to the Java
plugin at
[Building Java Projects](https://docs.gradle.org/current/userguide/building_java_projects.html#building_java_projects)

### txm-rar

*txm-rar* builds projects with resource adapters, which provides
communication between a Java EE application and an Enterprise
Information System using the Java Connector Architecture specification.
With TXM assembly plugins, the build output can be assembled into TXM
server distribution.

*txm-rar* extended and modified the following tasks.

| Type | Name    | Provider              | Description                                                            |
|:-----|:--------|:----------------------|:-----------------------------------------------------------------------|
| Task | build   | *txm-rar*             | assembles the source sets into application RAR files                   |
| Task | install | *txm-server-assembly* | assembles the RAR files into server distribution <br> txm-server.ear/  |

### txm-ejb

*txm-ejb* extends *txm-lib* to build projects with EJB modules, which is
an API for developing distributed, transactional, secure and portable
Java EE applications. With TXM assembly plugins, the build output can be
assembled into server distribution.

*txm-ejb* extended and modified the following tasks.

| Type | Name    | Provider              | Description                                                          |
|:-----|:--------|:----------------------|:---------------------------------------------------------------------|
| Task | build   | *java*                | assembles the source sets into application JAR files                 |
| Task | install | *txm-server-assembly* | assembles the JAR files into server distribution <br> txm-server.ear |

### txm-ocm-ejb

Similarly, *txm-ocm-ejb* extends *txm-ejb* to build projects with EJB
modules which associate with the Web Services Application of Operation &
Control Manager(OCM).

### txm-wf

*txm-wf* extends *txm-lib* to build projects with Web Fragments, which
modularize deployment descriptors to enables web frameworks to
self-register to the web container. This plugin is applied to the
projects that associate with the Web Services Application of SmartClient
Connector(SCC). With TXM assembly plugins, the build output can be
assembled into server distribution.

*txm-wf* extended and modified the following tasks.

| Type | Name    | Provider              | Description                                                                               |
|:-----|:--------|:----------------------|:------------------------------------------------------------------------------------------|
| Task | build   | *java*                | assembles the source sets into application JAR files                                      |
| Task | install | *txm-server-assembly* | assembles the JAR files into server distribution <br> txm-server.ear/scc.war/WEB-INFO/lib |

### txm-ocm-wf

Similarly, *txm-ocm-wf* extends *txm-wf* to build projects with Web
Fragments which associate with the Web Services Application of Operation
& Control Manager(OCM).

*txm-wf* extended and modified the following tasks.

| Type | Name    | Provider               | Description                                                                               |
|:-----|:--------|:-----------------------|:------------------------------------------------------------------------------------------|
| Task | build   | *java*                 | assembles the source sets into application JAR files                                      |
| Task | install | *txm-server-assembly*  | assembles the JAR files into server distribution <br> txm-server.ear/ocm.war/WEB-INFO/lib |
  
### txm-skinny-war

*txm-skinny-war* extends the Java plugin to build projects. With TXM
assembly plugins, the build output(JAR files) can be assembled into
server distribution as web application WAR archive.

*txm-skinny-war* extended and modified the following tasks.

| Type          | Name     | Provider              | Description                                                                             |
|:--------------|:---------|:----------------------|:----------------------------------------------------------------------------------------|
| Task          | build    | *jar*                 | assembles the source sets into application JAR files                                    |
| Task          | install  | *txm-server-assembly* | assembles the JAR files as a WAR archive into server distribution <br> txm-server.ear/  |
| Configuration | archives | *txm-server-assembly* | declares explicitly that the JAR files of build output should be archived as a WAR file |

The default Gradle
[War Plugin](https://docs.gradle.org/current/userguide/war_plugin.html)
disables the default JAR archive generation of the Java plugin and adds
a default WAR archive task. Unlikely, *txm-skinny-war* uses the
default JAR archive generation of the Java plugin, and adds the
configuration *archives* to explicitly declare that the JAR archives
should be assembled into WAR.

### txm-database

*txm-database* builds database scripts that attached to the main source
set, including DDL and DML, into ZIP files. With TXM assembly plugins,
the build output can be assembled into server distribution.

| Type | Name    | Provider              | Description                                                                                                                              |
|:-----|:--------|:----------------------|:-----------------------------------------------------------------------------------------------------------------------------------------|
| Task | build   | *txm-database*        | assembles the source sets into application ZIP files                                                                                     |
| Task | install | *txm-server-assembly* | assembles the ZIP files into server distribution <br> txm-server.ear/database/DDL/sqlscripts <br> txm-server.ear/database/DML/sqlscripts |

### txm-install

*txm-install* builds install scripts that attached to the main source
set, including scripts of various application servers, into ZIP files.
With TXM assembly plugins, the build output can be assembled into server
distribution.

| Type | Name    | Provider              | Description                                                                                                      |
|:-----|:--------|:----------------------|:-----------------------------------------------------------------------------------------------------------------|
| Task | build   | *txm-install*         | assembles the source sets into application ZIP files                                                             |
| Task | install | *txm-server-assembly* | assembles the ZIP files into server distribution <br> txm-server.ear/installjboss <br> txm-server.ear/installwas |

### txm-server-assembly

*txm-server-assembly* collects the build outputs of all server modules,
and assembles them into server distribution.

*txm-server-assembly* provided the following tasks and configurations.
  
| Type          | Name          | Description                                                                                                                                                                      |
|:--------------|:--------------|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Configuration | serverRuntime | specifies which modules' build outputs are to be assembled into the deployable EAR                                                                                               |
| Configuration | includedDist  | specifies which modules' build outputs are to be dropped into server distribution                                                                                                |
| Task          | install       | assembles the modules that are with configuration *serverRuntime* into txm-server.ear, and drops the modules that are with configuration *includedDist* into server distribution |

In SDP this plugin is applied to the project *sdpassembly*. As shown
below is the output of task *install* (server distributions).

```bash
-- sdpworkspace
   |-- sdpassembly
       |-- build
           |-- install
               |-- sdpassembly
                   |-- chameleon           // SDP customized chameleon    
                   |-- database            // Database scripts, DDL and DML
                   |-- installjboss        // JBoss scripts, deploy and startup
                   |-- installwas          // WebSphere scripts, deploy and startup
                   |-- replication-scripts // Replication scripts
                   |-- workbench           // Utilities, configEditor and traceViewer
                   |-- dependency.report   
                   |-- txm-server.ear      
```
    
### txm-sc-assembly

*txm-sc-assembly* collects the build outputs of all client modules, and
assembles them into client distribution.

*txm-sc-assembly* provided the following tasks and configurations.

| Type          | Name               | Description                                                                                                              |
|:--------------|:-------------------|:-------------------------------------------------------------------------------------------------------------------------|
| Task          | install            | assembles the modules that are with configuration *smartClientRuntime* into client distributions, such as devkit and msi |
| Configuration | smartClientRuntime | specifies which modules are to be assembled into client distribution.                                                    |
| Property      | msiWixToolsetDir   |                                                                                                                          |
| Property      | msiWixCandleArgs   |                                                                                                                          |
| Property      | msiWixMatching     |                                                                                                                          |

In SDP this plugin is applied to the project *sdpclientassembly*. As
shown below is the output of task *install* (client distributions).

```bash
-- sdpworkspace
   |-- sdpclientassembly
       |-- build
           |-- install
               |-- sdpclientassembly
                   |-- smartclient             // setup type of devkit    
                   |-- smartclient-msi         // setup type of msi
                   |-- dependency.report   
```

### txm-publish

*txm-publish* extends the
[Publishing Plugin](https://docs.gradle.org/current/userguide/publishing_overview.html)
to upload artifacts. 

## Custom Plugin

SDP uses
[buildSrc](https://docs.gradle.org/current/userguide/organizing_gradle_projects.html#sec:build_sources)
to encapsulate custom plugins. It is the supplements to TXM plugins, the
customizations of external plugins and utilities for daily developing.

### sdp-env-sourceset

sdp-env-sourceset modified the source sets of default
[Java Plugin](https://docs.gradle.org/current/userguide/java_plugin.html).

### sdp-test-archive
### sdp-cfp
### sdp-jaxb
### sdp-wsdl

### sdp-git

*sdp-git* performs git commands with the API provided by the git plugin
[grgit](https://plugins.gradle.org/plugin/org.ajoberstar.grgit)

*sdp-git* added and modified the following tasks and provided the
properties for customizing.

| Type     | Name                | Description                                                                                                                                                                                                                            |
|:---------|:--------------------|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Task     | clone               | Git clones remote repositories into local workspace                                                                                                                                                                                    |
| Task     | pull                | Git pulls remote repositories into local workspace                                                                                                                                                                                     |
| Task     | nuke                | Deletes all local tracked branches in local workspace                                                                                                                                                                                  |
| Property | ATM_REPO_URL_ROOT   | URL root of repositories in sdpatm                                                                                                                                                                                                     |
| Property | RTO_REPO_URL_ROOT   | URL root of repositories in sdprto                                                                                                                                                                                                     |
| Property | RELEASE_BRANCH_NAME | Indicates which release branch to checkout, and it could be overwritten by FEATURE_BRANCH_NAME                                                                                                                                         |
| Property | FEATURE_BRANCH_NAME | Indicates which feature branch to checkout, and it overwrites RELEASE_BRANCH_NAME only if the branch with name FEATURE_BRANCH_NAME does exist                                                                                          |
| Property | REPOS               | Specifies all the repositories that are managed in sdpworkspace. Each repository has two properties, url and directory. <br> Url is the location of remote repository <br>Directory is location with the relative path to sdpworkspace |

### sdp-eng

| Type | Name    | Description                                                       |
|:-----|:--------|:------------------------------------------------------------------|
| Task | eng     | Runs the engineering scripts(qrep, perf, ddl, conf, dml)          |
| Task | tgz     | Archives publishing artifacts into publications with suffix *tgz* |
| Task | aim     | Copies the publications to aim dirs                               |
| Task | publish | Uploads the publications to remote maven repository               |

### sdp-javadoc

| Type | Name             | Description                                              |
|:-----|:-----------------|:---------------------------------------------------------|
| Task | aggregateJavadoc | Aggregates Javadoc API documentation of all sub-projects |

### sdp-readme

| Type | Name             | Description                                                                        |
|:-----|:-----------------|:-----------------------------------------------------------------------------------|
| Task | aggregateReadme  | Aggregates README markdown documentation of all sub-projects, and converts to HTML |

### sdp-chameleon

| Type | Name      | Description                                                                                                                                                |
|:-----|:----------|:-----------------------------------------------------------------------------------------------------------------------------------------------------------|
| Task | startch   | Starts the chameleon from *sdpworkspace/sdpconfig/sdpchameleon/build/runtime* <br>By this task, the logs are centralized to *sdpworkspace/.log/chameleon* |
| Task | stopch    | Stops chameleon                                                                                                                                            |
| Task | deploych  | Deploys chameleon to *sdpworkspace/sdpconfig/sdpchameleon/build/runtime*                                                                                  |
| Task | ~~clean~~ | Disables this task to prevent the deployed runtime being deleted                                                                                           |

### sdp-jboss

| Type | Name       | Description                                                                                                                                                                                                                                                                                                                              |
|:-----|:-----------|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Task | startjb    | Starts jboss instance from <br>*sdpworkspace/sdpassembly/build/install/sdpassembly/installjboss/run.cmd* with environment variables in jbossoptions.orig loaded <br>By this task, jboss logs are centralized to *sdpworkspace/.log/jboss*; whereas txm logs are centralized to *sdpworkspace/.log/server*                                |
| Task | stopjb     | Stops the started jboss instance                                                                                                                                                                                                                                                                                                         |
| Task | optimizejb | Changes start options of jboss instance before deploy                                                                                                                                                                                                                                                                                    |
| Task | deployjb   | Resets *JBOSS_HOME/standalone/deployments* and *JBOSS_HOME/configuration/standalone-full.xml* <br>Runs customized scripts from *sdpworkspace/sdpassembly/build/install/sdpassembly/installjboss/customize.cmd* <br>Explodes *sdpworkspace/sdpassembly/build/install/sdpassembly/txm-server.ear* into *JBOSS_HOME/standalone/deployments* |

### sdp-smartclient

| Type | Name     | Description                                                                                                                                                         |
|:-----|:---------|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Task | msi      | Installs smartclient from the msi setup in <br>*sdpworkspace/sdpclientassembly/build/install/sdpclientassembly/smartclient-msi*                                     |
| Task | msix     | Uninstalls smartclient from the msi setup in <br>*sdpworkspace/sdpclientassembly/build/install/sdpclientassembly/smartclient-msi*                                   |
| Task | startmsi | Starts the smartclient with the installed in c:/pce <br>By this task, the logs are centralized to *sdpworkspace/.log/client*                                        |
| Task | stopmsi  | Stops smartclient                                                                                                                                                   |
| Task | startsc  | \<incubator\> Starts the smartclient with the devkit setup in <br>*sdpworkspace/sdpclientassembly/build/install/sdpclientassembly/smartclient/home/run_develop.cmd* |

### sdp-simulator

| Type | Name      | Description                                                      |
|:-----|:----------|:-----------------------------------------------------------------|
| Task | startsim  | Starts sdpsimulators                                             |
| Task | stopsim   | Stops sdpsimulators                                              |
| Task | ~~clean~~ | Disables this task to prevent the deployed runtime being deleted |