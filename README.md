## REVIEW 

### Application Properties 
Application properties are vital config files of your application and you need to create two separate ones apart from the default one. application-dev.properties and application-prod.properties <br/>
These two files help you make fast changes to which environment you are currently working in, for example:
```
 spring.profile.active=dev
```


### Packages and Java files 
    1. Controller Package:
    This holds the files with endpoints and the classes here are either annotated with @RestController or @Controller ( I have created the service package and done the needful) Controller do not need to hold business logic, the logic goes to service that includes the Repository

    2. Routes
    This file is not necessary on the Java application, this is content expected in the Controller package, routes are  Laravel or javascript issues.


API endpoints are supposed to be predicted hence the response is supposed to be constant, it is advised to use a Pojo, in most cases the API needs to have statusCode and message, I have done an example for you, please finish the rest up.


### Test Cases
YOU NEED TO WRITE TEST CASE ALL THE TIME FAM.

PS: Wrote this in VSCode and I Haven't tested the code LOL <br/>

Happy Coding.