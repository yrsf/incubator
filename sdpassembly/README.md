# sdpassembly

## Module
 
This module is a placeholder in which server distribution is assembled.

## Install

With this gradle plugin, the task *install* assembles the modules that
are with configuration *serverRuntime* into txm-server.ear, and drops
the modules that are with configuration *includedDist* into consistent
directories. The file tree of distribution

```bash
-- sdpworkspace
   |-- sdpassembly
       |-- build
           |-- install
               |-- sdpassembly
                   |-- chameleon           // SDP customized chameleon    
                   |-- database            // Database scripts, DDL and DML
                   |-- installjboss        // JBoss scripts, deploy and startup
                   |-- installwas          // WebSphere scripts, deploy and startup
                   |-- replication-scripts // Replication scripts
                   |-- workbench           // Utilities, configEditor and traceViewer
                   |-- dependency.report   
                   |-- txm-server.ear      
```

## Starting and Stopping JBoss
 
With gradle plugin *sdp-jboss*
```bash
gradlew startjb    // start jboss
gradlew stopjb     // stop jboss
```

More details about these plugins, see buildSrc.