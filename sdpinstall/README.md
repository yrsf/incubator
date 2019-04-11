# sdpinstall

## Modules
 
The folder 'sdpinstall' contains install modules. Specific suffixes are
added to the modules due to naming restrictions of TXM gradle plugins.

| Module       | Suffix   | TXM Plugin   | Description |
|:-------------|:---------|:-------------|:------------|
| sdpserver    | -ddl     | txm-database |             |
| sdpserver    | -dml     | txm-database |             |
| sdpserver    | -install | txm-install  |             |
| sdpchameleon |          |              |             |

For more details about usages of TXM plugins, see the chapter buildSrc.