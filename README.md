### Setup
add line `127.0.0.1 auth-server` to file /etc/hosts

### Run
- Start auth-server
- Start resource-server
- Start client
- then use your browser to visit: `http://127.0.0.1:8080/articles`
  Enter the credentials `admin/password`

### Functional Requirements
Create a simple spring boot application that handles the following endpoints:
```
Endpoint for user to 'create' an account
  POST /api/register
    {
      username,
      password
    }
    
Endpoint for user to log in
  POST /api/login
    {
      username,
      password
    }

Secure endpoint for user to get their personal information
  GET /api/users/{uuid}


Secure endpoint for user to update their personal information
  POST /api/users/{uuid}
    {
      name,
      email,
      phone
    }

Please note that the secure endpoints should have some form of validation for the user to be
able to perform those actions.
