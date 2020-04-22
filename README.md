#### Employee Service

The Employee service is a Maven Spring Boot and Spring 5 REST micro web service running on an imbeded Tomcat server with an in-memory H2 SQL database backend.

#### Implementation
The service uses JDBC to directly access the backend database rather than the Java Persistence API so that specific SQL queries could be tuned for maximum performance and can be configured to use lazy or eager loading of the employee hierarchy.  However, this could be changed to using JPA2 and Hibernate and configuring eager or lazy loading with a possible performance penalty and less control.  The Properties table is not very suitable in a relational database, it is used just as an example.

#### Docker

A docker file is provided for a Windows Server image with remote debugging enabled.

#### Database
The database is provided with sample SQL data and consists of two tables, one that models the employee hierachy and one that supports an arbitrary dictionary of employee properties.  

#### Schema
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

Returns a JSON string of all top level employees and their direct reports (either one level deep or with eager loading).


#####employees/{id}

Returns a JSON string of a specific employee ID and their direct reports (either one level deep or with eager loading)

Sample JSON:

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
