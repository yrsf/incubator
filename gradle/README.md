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

With gradle plugin [sdp-git](#sdp-git), the mappings of remote repositories and
directories in file system are specified.

| Remote Repository              | Directory                             |
|:-------------------------------|:--------------------------------------|
| sdpatm/sdp                     | sdpworkspace/sdp                      |
| sdpatm/sdpprojectclient        | sdpworkspace/sdpclient                |
| sdpatm/sdpprojectconfiguration | sdpworkspace/sdpconfig               |
| sdpatm/sdpassets               | sdpworkspace/sdp/sdpassets-scc-wf     |
| sdpatm/sdpwebcontent           | sdpworkspace/sdp/sdpwebcontent-scc-wf |
| sdpatm/sdpsimulators           | sdpworkspace/sdpcommon/sdpsimulators  |
| sdprto/*                       | sdpworkspace/sdpcommon/*              |

More details about properties in git.gradle, see [sdp-git](#sdp-git)

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

| Property | Usage                                                                                                                                                                                                                                                                                                                                                                                         |
|:---------|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| group    | fixed value of artifact publishing path                                                                                                                                                                                                                                                                                                                                                       |
| version  | *version* determines which repository is published to: <br>**SNAPSHOT** - if *version* ends with *SNAPSHOT* or equals to gradle default *unspecified* <br>**CI** - if *version* matches *9.9.9.N* <br>**RELEASE** - if otherwise <br><br>*version* can be overridden in the command line, though environment variable *VERSION* is with higher priority <br>*gradlew publish -Pversion=1.0.0* |

### misc.gradle

This gradle descriptor includes miscellaneous gradle settings.

- set max processors for unit test
- aggregate javadoc with gradle plugin [sdp-javadoc](#sdp-javadoc)
- aggregate readme with gradle plugin [sdp-readme](#sdp-readme)
- disable publishing options to accelerate build

## Other descriptors 

| File                           | Reference                                                                                                                                                              |
|:-------------------------------|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| sdpworkspace/setting.gradle    | [Always_define_a_settings_file](https://docs.gradle.org/current/userguide/organizing_gradle_projects.html#always_define_a_settings_file)                               |
| sdpworkspace/gradle.properties | [Declare properties in gradle.properties file](https://docs.gradle.org/current/userguide/organizing_gradle_projects.html#declare_properties_in_gradle_properties_file) |
