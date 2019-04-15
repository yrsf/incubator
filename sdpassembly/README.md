# sdpassembly

## Module
 
This module is a placeholder, in which server distribution is assembled.

## Install

With this gradle plugin, the task *install* assembles the modules that
are with configuration *serverRuntime* into txm-server.ear, and drops
the modules that are with configuration *includedDist* into consistent
directories. The file tree of distribution

```bash
|-- sdpworkspace
|   |-- sdpassembly
|       |-- build
|           |-- install
|               |-- sdpassembly
|                   |-- chameleon           // application chameleon and SDP customizations    
|                   |-- database            // database scripts including DDL and DML
|                   |-- installjboss        // JBoss scripts of deploy and startup
|                   |-- installwas          // WebSphere scripts of deploy and startup
|                   |-- replication-scripts // scripts of replication support
|                   |-- workbench           // utilities, like config editor and trace viewer
|                   |-- dependency.report   
|                   |-- txm-server.ear      
```

## Starting and Stopping JBoss
 
With gradle plugin *sdp-jboss*
```bash
gradlew startjb    // start jboss instance
gradlew stopjb     // stop jboss instance
```

More details about these plugins, see buildSrc.