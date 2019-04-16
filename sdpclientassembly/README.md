# sdpclientassembly

## Module
 
This module is a placeholder in which client distribution is assembled.

## Install

With gradle plugin [txm-sc-assembly](#txm-sc-assembly), the task
*install* assembles the modules that are with configuration
*smartClientRuntime* into various setup types of installation.

```bash
-- sdpworkspace
   |-- sdpclientassembly
       |-- build
           |-- install
               |-- sdpclientassembly
                   |-- smartclient             // setup type of devkit    
                   |-- smartclient-msi         // setup type of msi
                   |-- dependency.report   
```

## Installing and Uninstalling SmartClient MSI
 
With gradle plugin [sdp-smartclient](#sdp-smartclient),
```bash
gradlew msi         // install smartclient msi
gradlew msix        // uninstall smartclient msi
```

## Starting and Stopping SmartClient MSI

With gradle plugin [sdp-smartclient](#sdp-smartclient),
```bash
gradlew startmsi    // start smartclient msi
gradlew stopmsi     // stop smartclient msi
```