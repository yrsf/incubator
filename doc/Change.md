#### Change guide TM 2.0.0

### TRAMID-335 - preferences isolated by tenant / mandator

#### JBOSS 7.2

##### The old vendor specific deployment descriptors for EJBs, jboss.xml, is no longer supported. JBoss 7.2 uses a file named jboss-ejb3.xml.

##### There is no way of defining custom JNDI names for EJBs. Only the names defined in the EJB 3.1 specification are supported.

##### JBoss 7.2 checks that all references to resources or EJBs are satisfied as required by the EJB 3.1 specification.

#### simplified programming model for OCM

##### 



##### Tech Selection

1. TM Build Process Project Prototype, Project Publish, hook in project
2. TM Build Process How Project Documentation 
3. multi repos, tm/ra/pceoption,filter
4. deploy filter python,jenkins ci deploy pceoption
5. resourceadpter

