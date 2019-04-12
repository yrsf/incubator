# sdpassembly

With gradle plugin *txm-server-assembly*, these tasks and configurations
are imported.

| Type          | Name          | Description                                                                                                                                                                                                                                |
|:--------------|:--------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Task          | install       | Assembles server modules into installation artifacts, such as ear, database scripts, deploy scripts of application server, and standalone applications etc. <br>The path of output is *sdpworkspace/sdpassembly/build/install/sdpassembly* |
| Configuration | serverRuntime | Specifies the modules those are to be assembled within runtime, and the uninvolved depending modules                                                                                                                                       |
| Configuration | includedDist  | Specifies the modules those are to be dropped into the distribution                                                                                                                                                                        |
