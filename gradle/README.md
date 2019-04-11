# gradle

## Gradle Wrapper

SDP uses
[Gradle Wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html)
to execute Gradle build. To be compatible with TXM release, the version
of gradle wrapper in SDP is with the same version as set in
'sdpworkspace/gradle/wrapper/gradle-wrapper.properties'

## Gradle Descriptors

These gradle descriptors are loaded by root descriptor
'sdpworkspace/build.gradle' as the general settings of SDP workspace.

- git - Bitbucket repositories
- lib - External dependencies
- repo - Libraries repositories and publications repositories
- misc - Documentations and miscellaneous settings(Test, Aspectj etc.)

### git.gradle

This gradle descriptor defines the settings of bitbucket repositories,
and how the local tracked branches of these repositories are organized
in file system.

The usages of the properties

| Property            | Usage                                                                                                                                                                                                                                |
|:--------------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ATM_REPO_URL_ROOT   | URL root of repositories in sdpatm                                                                                                                                                                                                   |
| RTO_REPO_URL_ROOT   | URL root of repositories in sdprto                                                                                                                                                                                                   |
| RELEASE_BRANCH_NAME | indicates which release branch to checkout, and it could be overwritten by FEATURE_BRANCH_NAME                                                                                                                                       |
| FEATURE_BRANCH_NAME | indicates which feature branch to checkout, and it overwrites RELEASE_BRANCH_NAME only if the branch with name FEATURE_BRANCH_NAME does exist                                                                                        |
| REPOS               | defines all the repositories that are managed in sdpworkspace. Each repository has two properties, url and directory. Url is the location of remote repository; whereas directory is location with the relative path to sdpworkspace |

The mappings of remote repositories and directories in file system 
(relative path to sdpworkspace)

| Repository                     | Directory                |
|:-------------------------------|:-------------------------|
| sdpatm/sdp                     | sdp                      |
| sdpatm/sdpprojectclient        | sdpclient                |
| sdpatm/sdpprojectconfiguration | sdpinstall               |
| sdpatm/sdpassets               | sdp/sdpassets-scc-wf     |
| sdpatm/sdpwebcontent           | sdp/sdpwebcontent-scc-wf |
| sdpatm/sdpsimulators           | sdpcommon/sdpsimulators  |
| sdprto/*                       | sdpcommon/*              |

### lib.gradle

SDP uses
[Nebula Dependency Recommender Plugin](https://github.com/nebula-plugins/nebula-dependency-recommender-plugin)
to leave off version numbers in dependencies section and have versions
recommended by the Maven BOM in TXM module
'com.dieboldnixdorf.txm.externals:externals'.

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
environment variable 'IS_UPLOAD' is set to true, the publishing to
remote repositories is activated; otherwise the artifacts are published
to sdpworkspace/.publish for local use.

In pipeline, the version number determines which repository is
published to.

- snapshot repository - if version number ends with 'SNAPSHOT' or equals
  to gradle default 'unspecified'
- CI repository - if version number matches '9.9.9.N'
- release repository

The usages of the properties

| Property | Usage                                                                                                                                                                           |
|:---------|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| group    | fixed value of artifact publishing path                                                                                                                                         |
| version  | version can be overridden in the command line with 'gradlew publish -Pversion=1.0.0'; environment variable 'VERSION' is with higher priority in order to integrate engineering. |

### misc.gradle

This gradle descriptor includes miscellaneous gradle settings.

- set max processors for unit test
- aggregate javadoc and readme
- disable publishing options to accelerate build 