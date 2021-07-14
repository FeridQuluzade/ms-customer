# ms-customer

JPA Repositories
This chapter points out the specialties for repository support for JPA. This builds on the core repository support explained in “Working with Spring Data Repositories”. Make sure you have a sound understanding of the basic concepts explained there.
Crud operations for Customer model

Postman requests:

PUT ,update a customer : http://localhost:8080/customers

Get ,get single a customer : http://localhost:8080/customers/{id}

Delete, delete single a customer : http://localhost:8080/customers/{id}

Post, create a custoemer : http://localhost:8080/customers

Create request body 
{
    "firstName" : "",
    "lastName" : "",
    "birthDate" : "YYYY-MM-DD",
    "email" : "",
    "phoneNumber" : ""
}

