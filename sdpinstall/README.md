# sdpinstall
 
The folder 'sdpinstall' contains modules of installation, such as
database, application server etc. Specific suffixes are added to the
modules due to naming restrictions of TXM gradle plugins.

| Module            | Suffix Restriction | Plugin                         | Description |
|:------------------|:-------------------|:-------------------------------|:------------|
| sdpserver         | -ddl               | txm-database <br>txm-install   |             |
| sdpserver         | -dml               | txm-database <br>txm-install   |             |
| sdpserver-install |                    | txm-install                    |             |
| sdpeng            |                    | sdp-eng                        |             |
| sdpchameleon      |                    | sdp-chameleon <br>txm-addition |             |

For details about these gradle plugins, see buildSrc.