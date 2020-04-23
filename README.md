#### Employee Service

The Employee service is a Spring Boot and Spring 5 REST micro service running on an imbeded Tomcat server with an in-memory H2 SQL database backend for demonstration purposes.

#### Implementation
In branch V_1, the service uses JDBC to directly access the backend database rather than JPA2/Hibernate so that specific SQL queries could be demonstrated and tuned for maximum performance.

In branch V_2, the service uses JPA2 and Hibernate rather than directly using JDBC.  The service also uses the default OAuth2 authentication and TLS 1.3 security for demonstration purposes.

The PROPERTIES database table is not very suitable in a relational database, it is more appropriate for a no SQL database.  It is used just as an example here.

#### Docker

A docker file is provided for a Windows Server/openJDK image with remote debugging enabled.

#### Database
The database is provided with sample SQL data and consists of two tables, one that models the employee hierachy and one that supports an arbitrary dictionary of employee properties.  

##### Schema
**EMPLOYEE**
A primary id for an employee and a reference to the employees supervisor.

| Column        | Type          |
| ------------- | ------------- |
| ID            | BIGINT(19)    |
| SUPERVISOR_ID | BIGINT(19)    |

**PROPERTIES**
A map of key/value pairs of properties assigned to an employee.

| Column        | Type          |
| ------------- | ------------- |
| EMPLOYEE_ID   | BIGINT(19)    |
| KEY           | VARCHAR(256)  |
| VALUE         | VARCHAR(256)  |

#### REST API:

The REST endpoints for the service are the following:

#####employees

Returns all top level employees and their direct reports (configurable for eager or lazy loading).


#####employees/{id}

Returns a specific employee and their direct reports (configurable for eager or lazy loading)

####Sample JSON:

_{
   "supervisorId" : 1,
   "properties" : {
     "name" : "Joe Doe VP",
     "title" : "Vice President of Sales"
   },
   "directReportsArray" : [ {
     "supervisorId" : 2,
     "properties" : {
       "name" : "Jane Doe DR",
       "region" : "North America",
       "title" : "Regional Director of Sales"
     },
     "directReportsArray" : [ {
       "supervisorId" : 3,
       "properties" : {
         "name" : "Jack Sales Rep",
         "title" : "Sales Representative"
       },
       "directReportsArray" : [ ],
       "id" : 4
     } ],
     "id" : 3
   }, {
     "supervisorId" : 2,
     "properties" : {
       "region" : "Europe",
       "title" : "Regional Director of Sales"
     },
     "directReportsArray" : [ ],
     "id" : 5
   } ],
   "id" : 2
 }_
 
####Richard Baker

####jobs@richabaker.com 

<div class="LI-profile-badge"  data-version="v1" data-size="large" data-locale="en_US" data-type="vertical" data-theme="dark" data-vanity="richard-baker-a71bb827"><a class="LI-simple-link" href='https://www.linkedin.com/in/richard-baker-a71bb827?trk=profile-badge'>Richard Baker</a></div>