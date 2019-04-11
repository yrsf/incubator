# sdp

## Modules
 
The folder 'sdp' contains server modules. Specific suffixes are added to
the modules due to naming restrictions of TXM gradle plugins.

| Module           | Suffix   | TXM Plugin     | Description                                          |
|:-----------------|:---------|:---------------|:-----------------------------------------------------|
| sdpeisconnector  | -rar     | txm-rar        |                                                      |
| sdphealthcheck   | -webapp  | txm-skinny-war |                                                      |
| sdpmasterdataws  | -webapp  | txm-skinny-war |                                                      |
| sdpserver-core   | -ejb     | txm-ejb        |                                                      |
| sdpserver        | -ocm-ejb | txm-ejb        | renamed from sdpwebadminconsole                      |
| sdpserver        | -ocm-wf  | txm-ocm-wf     | renamed from sdpwebadminconsole-core                 |
| sdpserver        | -scc-wf  | txm-wf         | renamed from sdpsmartclientwebapp                    |
| sdpassets        | -scc-wf  | txm-wf         |                                                      |
| sdpwebcontent    | -scc-wf  | txm-wf         |                                                      |
| sdpserver-common |          | txm-lib        | merged from sdpserver-shared and sdpserver-sopshared |
| sdpclient-common |          | txm-lib        | renamed from sdpsmartclientwebapp-shared             |
| pceversion       |          |                | removed as duplicate function with assembly-meta.jar |