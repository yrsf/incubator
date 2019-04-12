## sdpchameleon

With execution of task *install*

- the application of chameleon and SDP customizations are assembled into
  *sdpworkspace/sdpassembly/build/install/sdpassembly/chameleon*

With gradle plugin *sdp-chameleon*, these tasks are imported.

| Type | Name      | Description                                                                                                |
|:-----|:----------|:-----------------------------------------------------------------------------------------------------------|
| Task | startch   | Starts chameleon with SDP customizations. <br>By this task, the output path of logs is *sdpworkspace/.log* |
| Task | stopch    | Stops chameleon                                                                                            |
| Task | deploych  | Deploys chameleon to *sdpworkspace/sdpinstall/sdpchameleon/build/runtime*                                  |
| Task | ~~clean~~ | Disables this task to prevent the deployed runtime being deleted                                           |
