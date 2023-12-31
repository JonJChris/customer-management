# Customer Management
#### Spring boot - React - Redux

Customer management system is a web based application built to onboard and manage retail bank customer details in a bank. It is a customer lifecycle management system which allows application users to onboard a new customer as well as manage customer details during its life cycle. Different permissions are built within the application that restricts specific users to perform selected actions.

**Tech Stack**

- Frontend: React, React Router, Redux Toolkit, Redux Persistence, Bootstrap
- Backend : Java 17, Spring Boot
- Database: H2 Database
- Hosting: onrender.com
- GitHub: https://github.com/JonJChris/customer-management
- URL: https://customer-management-80v7.onrender.com/
> **_NOTE:_**  This is a free hosting platform. Hence the application will be shutdown after 15 minutes of inactivity. In such a case, please wait for **~5** minutes, when you load the link for the first time. Once the application boot up then, the application will function as expected.

**Actions users can perform,**
- Login/ Logout
- Search existing request
- Search existing customer
- Create a new customer
- Manage existing customer details
  - Address Amendment
  - KYC Amendment
  - Product Amendment
  - Document Amendment

**Users Permissions**
- KYC Owner
  - Edit KYC details
  - Add or remove products
- Document Owner
  - Add or remove documents
- Front office Approver
  - Provide first level approval
- Final Approver
  - Provise second level/final approval


