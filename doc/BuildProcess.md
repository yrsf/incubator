      ./gradlew clean install resetJboss customizeJboss expand2Jboss createDB
      cd build/install/refapp-xxx/installjboss
      ./run.sh



      ./gradlew clean --refresh-dependencies



       ./mvn clean fr.jcgay.maven.plugins:buildplan-maven-plugin:list-phase



       ./gradlew :dependencyInsight --configuration testCompile --dependency org.glassfish.hk2.exter

cglib-2.2.1-v20090111.pom

​                          

    plugins {
        id 'com.gradle.build-scan' version '1.16'                    
    }
    
    buildScan {
        termsOfServiceUrl = 'https://gradle.com/terms-of-service'    
        termsOfServiceAgree = 'yes'        
    publishAlways()     
    }






-scan

https://scans.gradle.com/s/2rkpd5i7pomq4/





		task fileTree {
		doLast {
	        println 'Hello world!'
			
		fileTree('../sdp') {
			include '**/build.gradle'
		}.collect { relativePath(it.parent).replace(File.separator, ':').replace("..", "") }
		.each { println it }
	
	println 'Hello world!!!'
	}
	}
