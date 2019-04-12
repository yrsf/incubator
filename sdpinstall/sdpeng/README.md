## sdpeng

This module provides specific tasks to support engineering, such as
running scripts. These are the scripts

| Name | Description                                                                                            |
|:-----|:-------------------------------------------------------------------------------------------------------|
| qrep | Generates customized replication scripts of various environments                                       |
| perf | Generates sql scripts of master data(workstation etc.) for performance tests                           |
| ddl  | Aggregates ddl scripts into single sql file for various environment types, including QA, PERF and PROD |
| conf | Generates environment variables that are loaded to each instance of application server                 |
| dml  | Aggregates dml scripts into single sql file for each instance of application server                    |

With gradle plugin *sdp-eng*, these tasks are imported.

| Type | Name    | Description                                                       |
|:-----|:--------|:------------------------------------------------------------------|
| Task | eng     | Running the engineering scripts listed above                      |
| Task | tgz     | Archives publishing artifacts into publications with suffix *tgz* |
| Task | aim     | Copies the publications to aim dirs                               |
| Task | publish | Uploads the publications to remote maven repository               |
