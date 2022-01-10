# evolent
evolentproject

This project is to add, update, delete and get contact information of customers. I am using derby DB for storing information. Following are endpoints to do so,

HTTP Method - GET
URL - http://localhost:8080/contact
      
      This URL will return JSON string of all users available in the system.

HTTP Method - GET
URL - http://localhost:8080/contact/{firstName}
  
      This URL will return JSON string of one user with first name matches in the system.
      
HTTP Method - POST
URL - http://localhost:8080/contact

      This URL will add entry to system, input JSON body as below,
      {
        "firstName":"Manoj",
        "lastName":"Mali",
        "email":"mm@gmail.com",
        "phoneNumber":"123123123",
        "status":"Active"
      }

HTTP Method - PUT
URL - http://localhost:8080/contact

      This URL will update entry to system, input JSON body as below,
      {
        "firstName":"Manoj",
        "lastName":"Mali",
        "email":"mm@gmail.com",
        "phoneNumber":"123123123",
        "status":"Active"
      }

HTTP Method - DELETE
URL - http://localhost:8080/contact/{firstName}

      This URL will remove entry from system based on path variable username provided. It will delete entry if status Inactive or else will show error message.
      
