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

| Type          | Name          | Description                                                                                                                                                                                                                                |
|:--------------|:--------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Task          | install       | Assembles server modules into installation artifacts, such as ear, database scripts, deploy scripts of application server, and standalone applications etc. <br>The path of output is *sdpworkspace/sdpassembly/build/install/sdpassembly* |
| Configuration | serverRuntime | Specifies the modules those are to be assembled within runtime, and the uninvolved depending modules                                                                                                                                       |
| Configuration | includedDist  | Specifies the modules those are to be dropped into the distribution                                                                                                                                                                        |

### txm-sc-assembly

| Type          | Name               | Description                                                                                                                                                                                     |
|:--------------|:-------------------|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Task          | install            | Assembles client modules of SDP and TXM into installation artifacts, such as MSI and JInstall. <br>The path of output is  *sdpworkspace/sdpclientassembly/build/install/sdpclientassembly* |
| Configuration | smartClientRuntime | Specifies the modules those are to be assembled within smartclient runtime                                                                                                                      |
| Property      | msiWixToolsetDir   |                                                                                                                                                                                                 |
| Property      | msiWixCandleArgs   |                                                                                                                                                                                                 |
| Property      | msiWixMatching     |                                                                                                                                                                                                 |

### txm-publish

## SDP Plugin

### sdp-env-sourceset
### sdp-test-archive
### sdp-cfp
### sdp-jaxb
### sdp-wsdl

### sdp-git
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
| Task | aggregatejavadoc | Aggregates Javadoc API documentation of all sub-projects |

### sdp-readme

| Type | Name             | Description                                                                        |
|:-----|:-----------------|:-----------------------------------------------------------------------------------|
| Task | aggregatereadme  | Aggregates README markdown documentation of all sub-projects, and converts to HTML |

### sdp-chameleon

| Type | Name      | Description                                                                                                                                    |
|:-----|:----------|:-----------------------------------------------------------------------------------------------------------------------------------------------|
| Task | startch   | Starts the chameleon in *sdpworkspace/sdpinstall/sdpchameleon/build/runtime* <br>By this task, the logs are centralized to *sdpworkspace/.log* |
| Task | stopch    | Stops chameleon                                                                                                                                |
| Task | deploych  | Deploys chameleon to *sdpworkspace/sdpinstall/sdpchameleon/build/runtime*                                                                      |
| Task | ~~clean~~ | Disables this task to prevent the deployed runtime being deleted                                                                               |

### sdp-jboss
### sdp-smartclient
### sdp-simulator