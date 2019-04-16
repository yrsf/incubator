# sdpinstall
 
The folder 'sdpinstall' contains modules of installation, such as
database, application server etc. Specific suffixes are added to the
modules due to naming restrictions of TXM gradle plugins.

| Module            | Suffix Restriction | Plugin                                                            |
|:------------------|:-------------------|:------------------------------------------------------------------|
| sdpserver         | -ddl               | [txm-database](#txm-database) <br>[txm-install](#txm-install)     |
| sdpserver         | -dml               | [txm-database](#txm-database) <br>[txm-install](#txm-install)     |
| sdpserver-install |                    | [txm-install](#txm-install)                                       |
| sdpeng            |                    | [sdp-eng](#sdp-eng)                                               |
| sdpchameleon      |                    | [sdp-chameleon](#sdp-chameleon) <br>[txm-addition](#txm-addition) |
