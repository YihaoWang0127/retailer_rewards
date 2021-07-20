#Implementation
1. For this assignment, we apply Springboot and H2 database. We encourage using Intellij
   
2. Run the main class of this project
   
3. Connect to the H2 database. In you browser, use http://localhost:8080/h2-console to login.
Remember set JDBC URL as jdbc:h2:mem:default, username as yihaowang and password as 1234
   (which is matched with value in properties file)
   
4. Run the script.sql command in H2 console, it will establish several users with some transactions

5. Use Postman or other tool to grab the outcome
   http://localhost:8080/customers/{customerId}/rewards
   
#Logic
1. we calculate each user's rewards based on transaction and time period. 
   So we need two entities customer and transaction, we also need one more entity rewards to store the value
   For time period, we can use timestamp to point to the duration.
   
2. We use rest api to handle request, in the controller layer, we also apply error message for the possible error
In this project, we catch the user not found exception.
   
3. In service layer, we do the calculation and bussiness logic there

4. In repository layer, we extends CrudRepository to handle the basic query for us in H2 DB.

