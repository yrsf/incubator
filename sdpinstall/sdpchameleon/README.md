## sdpchameleon

### Module

This module contains base24's chameleon configurations, including

- startup scripts
- communication protocol
- message formats using XML implementation TXM provided

### SourceSet

These base24's chameleon configurations should be placed at 
> src/extension/chameleon

which is a conventional SourceSet in the gradle plugin *txm-addition*.

### Install
 
With gradle plugin *txm-server-assembly*, the task *install* assembles
the distribution of TXM chameleon into
> sdpworkspace/sdpassembly/build/install/sdpassembly/chameleon

and drops base24's chameleon configurations there. 

### Usage

With gradle plugin *sdp-chameleon*, these tasks are supported.
```bash
gradlew startch //start chameleon
gradlew stopch //stop chameleon
```

More details about these plugins, see buildSrc.