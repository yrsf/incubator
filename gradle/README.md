# gradle

## wrapper 

SDP uses gradle wrapper to execute Gradle build. More details about
gradle wrapper, see
[Gradle Wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html)

To be compatible with TXM release 2.0.1, SDP gradle wrapper is set with
the same version as in wrapper/gradle-wrapper.properties.

## descriptors

These script descriptors are loaded by build.gradle in the root project
and describe how SDP workspace is setup. The descriptors includes

- Bitbucket Repositories
- Dependent Libraries
- Artifacts Download Repositories
- Maven Publish Repositories
- Documentations
- Miscellaneous Settings (Test, Aspectj etc.)

### git.gradle

This script descriptor defines not only the settings of bitbucket
repositories, but also how the local tracked branches of these
repositories are organized in file system.

The usages of the properties

- ATM_REPO_URL_ROOT //DOC TODO
- RTO_REPO_URL_ROOT //DOC TODO
- RELEASE_BRANCH_NAME //DOC TODO
- FEATURE_BRANCH_NAME //DOC TODO
- repos //DOC TODO

As how these properties are programmed, read the documentation of SDP
plugin 'sdp-git'.

### lib.gradle

TXM uses Nebula Dependency Recommender plugin to leave off version
numbers in dependencies section and have versions recommended by the TXM
Maven BOM in the module 'com.dieboldnixdorf.txm.externals:externals'.
More details, see
[Nebula Dependency Recommender Plugin](https://github.com/nebula-plugins/nebula-dependency-recommender-plugin)

This descriptor centralizes the dependent libraries and their
recommended versions. The libraries added in this descriptor are being
used in SDP but being provided by the TXM Maven BOM, or incompatible
with the ones TXM provided.

Take log4j2 for instance, log4j2 2.9.1 provided by TXM is not compatible
with PowerMock that SDP uses for unit test, and has to be overwritten by
2.10.0+ to fix the known issue.

Besides, the SDP-specialized libraries, such as RTO modules, are
referred.

### repo.gradle

This script descriptor configures the maven repositories of downloading
and publishing, as well as the group and version when publishing.

Publishing is mainly used for CI and Release in Jenkins pipeline. As the
environment variable 'IS_UPLOAD' is set to true, the publishing to
remote repositories is activated; otherwise the artifacts are published
to sdpworkspace/.publish for local use.

In Jenkins pipeline, the version number determines which repository is
published to.
- If version number ends with 'SNAPSHOT' or equals to 'unspecified' 
  (gradle default), the artifacts are published to snapshot repository.
- If version number matches '9.9.9.N', the artifacts are published to CI
  repository. (This is current logic in SDP engineering)
- In other situations, the artifacts are published to release
  repository.

### misc.gradle

This script descriptor includes miscellaneous gradle settings, such as
max parallel forks for unit test.