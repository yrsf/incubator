# gradle

## wrapper 

SDP uses
[Gradle Wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html)
to execute Gradle build. To be compatible with TXM release, SDP gradle
wrapper is set with the same version as in
'sdpworkspace/gradle/wrapper/gradle-wrapper.properties'.

## descriptors

These gradle descriptors are loaded by 'sdpworkspace/build.gradle' as
the general gradle settings of sdpworkspace, including:
- Bitbucket Repositories
- External dependencies
- Artifacts Download Repositories
- Maven Publish Repositories
- Documentations
- Miscellaneous Settings (Test, Aspectj etc.)

### git.gradle

This descriptor defines the settings of bitbucket repositories, and how
the local tracked branches of these repositories are organized in file
system.

The usages of the properties
- ATM_REPO_URL_ROOT //DOC TODO
- RTO_REPO_URL_ROOT //DOC TODO
- RELEASE_BRANCH_NAME //DOC TODO
- FEATURE_BRANCH_NAME //DOC TODO
- repos //DOC TODO

With the support of SDP gradle plugin 'sdp-git', it uniforms the
workspace setup between developing and engineering.

### lib.gradle

TXM uses
[Nebula Dependency Recommender Plugin](https://github.com/nebula-plugins/nebula-dependency-recommender-plugin)
to leave off version numbers in dependencies section and have versions
recommended by the Maven BOM in the TXM module
'com.dieboldnixdorf.txm.externals:externals'.

This descriptor centralizes the external dependencies and their
recommended versions, including:
- The libraries are being used in SDP, but provided by the TXM Maven
  BOM. For example, RTO modules.
- The version is incompatible with the provided in TXM. Take log4j2 for
  instance, the TXM-provided log4j2 2.9.1 has a known issue when being
  the log implementation of PowerMock. Therefore, the log4j2 has to be
  overwritten by 2.10.0+ to fix the known issue as SDP uses PowerMock.

### repo.gradle

This descriptor configures the maven repositories of downloading, and
publishing as well as the publishing group and version. Unlike maven
descriptors, this is the only place where the remote repository is
configured for downloading the dependencies from.

Publishing is mainly used for CI and Release in Jenkins pipeline. As the
environment variable 'IS_UPLOAD' is set to true, the publishing to
remote repositories is activated; otherwise the artifacts are published
to sdpworkspace/.publish for local use.

In pipeline, the version number determines which repository is
published to.
- If version number ends with 'SNAPSHOT' or equals to 'unspecified' 
  (gradle default), the artifacts are published to snapshot repository.
- If version number matches '9.9.9.N', the artifacts are published to CI
  repository. (This is current logic in SDP engineering)
- In other situations, the artifacts are published to release
  repository.

### misc.gradle

This script descriptor includes miscellaneous gradle settings, such as
max processors for unit test.