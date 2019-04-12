# sdpclientassembly

With gradle plugin *txm-sc-assembly*, these tasks, configurations and
properties are imported.

| Type          | Name               | Description                                                                                                                                                                                     |
|:--------------|:-------------------|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Task          | install            | Assembles client modules of SDP and TXM into installation artifacts, such as MSI and JInstall. <br>The path of output is  *sdpworkspace/sdpclientassembly/build/install/sdpclientassembly* |
| Configuration | smartClientRuntime | Specifies the modules those are to be assembled within smartclient runtime                                                                                                                      |
| Property      | msiWixToolsetDir   |                                                                                                                                                                                                 |
| Property      | msiWixCandleArgs   |                                                                                                                                                                                                 |
| Property      | msiWixMatching     |                                                                                                                                                                                                 |
