## sdpeng

### Module

This module contains engineering shell scripts.

| Name | Description                                                                                            |
|:-----|:-------------------------------------------------------------------------------------------------------|
| qrep | Generates customized replication scripts for various environments                                      |
| perf | Generates sql scripts of master data(workstation etc.) for performance tests                           |
| ddl  | Aggregates ddl scripts into single sql file for various environment types, including QA, PERF and PROD |
| conf | Generates environment variables that are loaded to each instance of application server                 |
| dml  | Aggregates dml scripts into single sql file for each instance of application server                    |

### Running Scripts

With gradle plugin *sdp-eng*,
```bash
gradlew eng    // run the engineering shell scripts listed above
```

More details about this plugin, see buildSrc.