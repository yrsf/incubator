# sdpinstall
 
The folder 'sdpinstall' contains modules of installation, such as
database, application server etc. Specific suffixes are added to the
modules due to naming restrictions of TXM gradle plugins.

| Module            | Suffix Restriction | Plugin       | Description |
|:------------------|:-------------------|:-------------|:------------|
| sdpserver         | -ddl               | txm-database |             |
| sdpserver         | -dml               | txm-database |             |
| sdpserver-install |                    | txm-install  |             |
| sdpeng            |                    | sdp-eng      |             |
| sdpchameleon      |                    |              |             |

For details about these gradle plugins, see the chapter buildSrc.