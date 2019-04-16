# buildSrc

SDP uses
[buildSrc](https://docs.gradle.org/current/userguide/organizing_gradle_projects.html#sec:build_sources)
to encapsulate custom plugins, and takes TXM binary plugins as
supplements. It is imperative to understand the usages of these plugins
and how they function in the build process.

## TXM Plugin

### txm-lib
### txm-ejb
### txm-rar
### txm-ocm-ejb
### txm-ocm-wf
### txm-wf
### txm-skinny-war

### txm-database
### txm-install
### txm-server-assembly

| Type          | Name          | Description                                                                                                                                                                                                                                                     |
|:--------------|:--------------|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Task          | install       | Assembles the modules that are with configuration *serverRuntime* into txm-server.ear, and drops the modules that are with configuration *includedDist* into consistent directories <br>The output path is *sdpworkspace/sdpassembly/build/install/sdpassembly* |
| Configuration | serverRuntime | Specifies the modules those are to be assembled in the runtime EAR, and the uninvolved modules                                                                                                                                                                  |
| Configuration | includedDist  | Specifies the modules those are to be dropped into the distribution of assembly                                                                                                                                                                                 |

### txm-sc-assembly

| Type          | Name               | Description                                                                                                                                                                                                                |
|:--------------|:-------------------|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Task          | install            | Assembles the modules that are with configuration *smartClientRuntime* into various types of installation, such as devkit and msi. <br>The output path is *sdpworkspace/sdpclientassembly/build/install/sdpclientassembly* |
| Configuration | smartClientRuntime | Specifies the modules those are to be assembled within smartclient runtime                                                                                                                                                 |
| Property      | msiWixToolsetDir   |                                                                                                                                                                                                                            |
| Property      | msiWixCandleArgs   |                                                                                                                                                                                                                            |
| Property      | msiWixMatching     |                                                                                                                                                                                                                            |

### txm-publish

## SDP Plugin

### sdp-env-sourceset
### sdp-test-archive
### sdp-cfp
### sdp-jaxb
### sdp-wsdl

### sdp-git

This gradle plugin performs git operations.

| Type     | Name                | Description                                                                                                                                                                                                                            |
|:---------|:--------------------|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Task     | clone               | Git clones remote repositories into local workspace                                                                                                                                                                                    |
| Task     | pull                | Git pulls remote repositories into local workspace                                                                                                                                                                                     |
| Property | ATM_REPO_URL_ROOT   | URL root of repositories in sdpatm                                                                                                                                                                                                     |
| Property | RTO_REPO_URL_ROOT   | URL root of repositories in sdprto                                                                                                                                                                                                     |
| Property | RELEASE_BRANCH_NAME | Indicates which release branch to checkout, and it could be overwritten by FEATURE_BRANCH_NAME                                                                                                                                         |
| Property | FEATURE_BRANCH_NAME | Indicates which feature branch to checkout, and it overwrites RELEASE_BRANCH_NAME only if the branch with name FEATURE_BRANCH_NAME does exist                                                                                          |
| Property | REPOS               | Specifies all the repositories that are managed in sdpworkspace. Each repository has two properties, url and directory. Url is the location of remote repository; whereas directory is location with the relative path to sdpworkspace |

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
| Task | startch   | Starts the chameleon from *sdpworkspace/sdpinstall/sdpchameleon/build/runtime* <br>By this task, the logs are centralized to *sdpworkspace/.log/chameleon* |
| Task | stopch    | Stops chameleon                                                                                                                                            |
| Task | deploych  | Deploys chameleon to *sdpworkspace/sdpinstall/sdpchameleon/build/runtime*                                                                                  |
| Task | ~~clean~~ | Disables this task to prevent the deployed runtime being deleted                                                                                           |

### sdp-jboss

| Type | Name       | Description                                                                                                                                                                                                                                                                                                                              |
|:-----|:-----------|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Task | startjb    | Starts jboss instance from *sdpworkspace/sdpassembly/build/install/sdpassembly/installjboss/run.cmd* with environment variables in jbossoptions.orig loaded <br>By this task, jboss logs are centralized to *sdpworkspace/.log/jboss*; whereas txm logs are centralized to *sdpworkspace/.log/server*                                    |
| Task | stopjb     | Stops the started jboss instance                                                                                                                                                                                                                                                                                                         |
| Task | optimizejb | Changes start options of jboss instance before deploy                                                                                                                                                                                                                                                                                    |
| Task | deployjb   | Resets *JBOSS_HOME/standalone/deployments* and *JBOSS_HOME/configuration/standalone-full.xml* <br>Runs customized scripts from *sdpworkspace/sdpassembly/build/install/sdpassembly/installjboss/customize.cmd* <br>Explodes *sdpworkspace/sdpassembly/build/install/sdpassembly/txm-server.ear* into *JBOSS_HOME/standalone/deployments* |

### sdp-smartclient

| Type | Name     | Description                                                                                                                                                     |
|:-----|:---------|:----------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Task | msi      | Installs smartclient from the msi setup in *sdpworkspace/sdpclientassembly/build/install/sdpclientassembly/smartclient-msi*                                     |
| Task | msix     | Uninstalls smartclient from the msi setup in *sdpworkspace/sdpclientassembly/build/install/sdpclientassembly/smartclient-msi*                                   |
| Task | startmsi | Starts the smartclient with the installed in c:/pce <br>By this task, the logs are centralized to *sdpworkspace/.log/client*                                    |
| Task | stopmsi  | Stops smartclient                                                                                                                                               |
| Task | startsc  | \<incubator\> Starts the smartclient with the devkit setup in *sdpworkspace/sdpclientassembly/build/install/sdpclientassembly/smartclient/home/run_develop.cmd* |

### sdp-simulator

| Type | Name      | Description                                                      |
|:-----|:----------|:-----------------------------------------------------------------|
| Task | startsim  | Starts sdpsimulators                                             |
| Task | stopsim   | Stops sdpsimulators                                              |
| Task | ~~clean~~ | Disables this task to prevent the deployed runtime being deleted |
