## sdpchameleon

### Module

This module contains base24's chameleon configurations, including

- startup scripts
- communication protocol
- message formats using XML implementation TXM provided

### SourceSet

These base24's chameleon configurations are placed at 
> src/extension/chameleon

which is a conventional SourceSet in gradle plugin [txm-addition](#txm-addition).

### Install
 
With gradle plugin [txm-server-assembly](#txm-server-assembly), the task *install*
assembles the distribution of TXM chameleon into
> sdpworkspace/sdpassembly/build/install/sdpassembly/chameleon

and drops base24's chameleon configurations there. 

### Starting and Stopping Chameleon

With gradle plugin [sdp-chameleon](#sdp-chameleon),
```bash
gradlew startch //start chameleon
gradlew stopch //stop chameleon
```
