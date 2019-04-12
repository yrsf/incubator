# gradle

## Gradle Wrapper

SDP uses
[Gradle Wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html)
to execute Gradle build. To be compatible with TXM release, the version
of gradle wrapper in SDP is with the same version as set in
*sdpworkspace/gradle/wrapper/gradle-wrapper.properties*

## Gradle Descriptors

These gradle descriptors are loaded by root descriptor
*sdpworkspace/build.gradle* as the general settings of SDP workspace.

- git - Bitbucket repositories
- lib - External dependencies
- repo - Libraries repositories and publications repositories
- misc - Documentations and miscellaneous settings(Test, Aspectj etc.)

### git.gradle

This gradle descriptor defines the settings of bitbucket repositories,
and how the local tracked branches of these repositories are organized
in file system.

With the gradle plugin *sdp-git*, these properties can be configured.

| Property            | Usage                                                                                                                                                                                                                                |
|:--------------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ATM_REPO_URL_ROOT   | URL root of repositories in sdpatm                                                                                                                                                                                                   |
| RTO_REPO_URL_ROOT   | URL root of repositories in sdprto                                                                                                                                                                                                   |
| RELEASE_BRANCH_NAME | indicates which release branch to checkout, and it could be overwritten by FEATURE_BRANCH_NAME                                                                                                                                       |
| FEATURE_BRANCH_NAME | indicates which feature branch to checkout, and it overwrites RELEASE_BRANCH_NAME only if the branch with name FEATURE_BRANCH_NAME does exist                                                                                        |
| REPOS               | defines all the repositories that are managed in sdpworkspace. Each repository has two properties, url and directory. Url is the location of remote repository; whereas directory is location with the relative path to sdpworkspace |

For the property of REPOS, thess are the mappings of remote repositories
and directories in file system.

| Remote Repository              | Directory(File system)                |
|:-------------------------------|:--------------------------------------|
| sdpatm/sdp                     | sdpworkspace/sdp                      |
| sdpatm/sdpprojectclient        | sdpworkspace/sdpclient                |
| sdpatm/sdpprojectconfiguration | sdpworkspace/sdpinstall               |
| sdpatm/sdpassets               | sdpworkspace/sdp/sdpassets-scc-wf     |
| sdpatm/sdpwebcontent           | sdpworkspace/sdp/sdpwebcontent-scc-wf |
| sdpatm/sdpsimulators           | sdpworkspace/sdpcommon/sdpsimulators  |
| sdprto/*                       | sdpworkspace/sdpcommon/*              |

### lib.gradle

SDP uses
[Nebula Dependency Recommender Plugin](https://github.com/nebula-plugins/nebula-dependency-recommender-plugin)
to leave off version numbers in dependencies section and have versions
recommended by the Maven BOM in TXM module
*com.dieboldnixdorf.txm.externals:externals*.

This gradle descriptor centralizes the external dependencies and their
recommended versions, including:

- The libraries that are being used in SDP, but provided by the TXM
  Maven BOM. For example, RTO modules.
- The libraries which versions are incompatible with the provided ones
  in the TXM Maven BOM. Take log4j2 for instance, the TXM-provided
  log4j2 2.9.1 has a known issue when being the log implementation of
  PowerMock. Therefore, the log4j2 has to be overwritten by 2.10.0+ to
  fix the known issue as SDP uses PowerMock.

### repo.gradle

This gradle descriptor configures the maven repositories of downloading,
and publishing as well as the publishing group and version. Unlike maven
descriptors, this is the only place where the remote repository is
configured for downloading the dependencies.

Publishing is mainly used for CI and release in Jenkins pipeline. As the
environment variable *IS_UPLOAD* is set to true, the publishing to
remote repositories is activated; otherwise the artifacts are published
to sdpworkspace/.publish for local use.

The usages of the publishing properties

| Property | Usage                                                                                                                                                                        |
|:---------|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| group    | fixed value of artifact publishing path                                                                                                                                      |
| version  | *version* determines which repository is published to: <br>**Snapshot**, if *version* ends with *SNAPSHOT* or equals to gradle default *unspecified* <br>**CI**, if *version* matches *9.9.9.N* <br>**Release**, if otherwise <br><br>*version* can be overridden in the command line, though environment variable *VERSION* is with higher priority <br>*gradlew publish -Pversion=1.0.0* |

### misc.gradle

This gradle descriptor includes miscellaneous gradle settings.

- set max processors for unit test
- aggregate javadoc and readme
- disable publishing options to accelerate build 

With the gradle plugin *sdp-misc*, these tasks are imported.

| Type | Name             | Description                                                                        |
|:-----|:-----------------|:-----------------------------------------------------------------------------------|
| Task | aggregatejavadoc | Aggregates Javadoc API documentation of all sub-projects                           |
| Task | aggregatereadme  | Aggregates README markdown documentation of all sub-projects, and converts to HTML |
