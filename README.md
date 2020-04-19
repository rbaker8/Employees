The Employee service is a Maven-built Spring Boot and Spring 5 REST web service running on a Tomcat server with an in-memory H2 SQL database backend.

The service uses JDBC to directly access the backend database rather than the Java Persistence API so that specific SQL queries could be tuned for maximum performance and can be configured to use lazy or eager loading of the employee hierarchy.  However, this could be changed to using JPA2 and Hibernate and configuring eager or lazy loading with a possible performance penalty and less control.

A docker file is provided for a Windows Server image with remote debugging.

The database is provided with sample SQL data and consists of two tables, one that models the employee hierachy and one that supports an arbitrary dictionary of employee properties.  The database configuration can be found in the resources folder of the source code.

The service is configured to run on HTTP://localhost:8081.

The REST API's for the service are the following:

==========================================================
HTTP://localhost:8081/employees

Returns a JSON string of all top level employees and their direct reports (either one level deep or with eager loading).

==========================================================
HTTP://localhost:8081/employees/{id}

Returns a JSON string of a specific employee ID and their direct reports (either one level deep or with eager loading)
 
Richard Baker
jobs@richabaker.com 
