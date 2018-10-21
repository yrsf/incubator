### SDPTM2 PLAN

I try to figure out what we are about to do after I completely build the development environment of SDP and TM2. 
The assembly procedures of SDP and TM2 are quite similar. (The difference of assembly procedure is the base. SDP is assembled on the base of git projects, whereas PCE25/TM2 are assembled on the base of components.)
I’d like to give a clear picture by making the important tasks detached. The important tasks includes TM2 customization, SDP build scripts migration, SDP components upgrade, and the integration of them. I introduce some examples of user stories and tasks for your reference as following.
(As the attached pic shown, the US4 could be carried out either before US3, or after US3.)

#### US1.Customize TM2 environment to be SDP compatible

The objective of this user story is to produce a TM2 environment without SDP, which contains the latest components that SDP will be based on, and can be completely assembled with gradle into a deployment-friendly enterprise application server.

##### Task1.Discuss the necessity of creating a new git project for tm2 build

##### Task2.Get the latest component list and theirs versions, and the latest third-party libraries

##### Task3.Datebase level change, investigate the incremental changes on table, column, and row etc.

##### ...



#### US2.Build SDP with Gradle in PCE25

The objective of this user story is to change the build scripts from maven to gradle, make sure the build results function the same as maven, and work out a general solution which can be applied to all git projects.

##### Task1.Work out a general solution, write down the steps, and publish a document

##### Task2.Use the solution of Task1 to update Git Project A

##### Task3.Use the solution of Task1 to update Git Project B

##### ...


#### US3.Integrate the Outcomes of US1 and US2

The objective of this user story is to make TM2 and SDP work with each other.

##### Task1. A switch that could be capable of diverting the build process between PCE25 and TM2, which is free for developer to test in wither environment.

##### Task2. Resolve compilation error

##### Task3. Integration Test

##### ...



#### US4.Upgrade the Components Version to the Latest

The objective of this user story is to make new components of TM2 be compatible with SDP

##### Task1. Decide when this user story starts, before US3 or after?

##### Task2. Read the release notes, and find out if new features influence


##### ...



#### US5.Integration Test

#### US6.Regression Test

#### US7.User Assurance Test

#### ...