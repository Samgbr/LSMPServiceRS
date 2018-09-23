# LSMPServiceRS
COMP433

This repository is used to store a market place web service maven project for the course fulfillment of COMP 433 at Loyola University Fall 2018.
As the development progressed, this application will be deployed to aws.

Tools/Languages used in this project are:
  1. Java/J2ee
  2. Eclipse
  3. Mysql
  4. aws
  5. REST
  6. Paypal
    
# To-do list

+ Setup the repository and give access to collaborators: -- done
      ==> 1. Hussaini, Nasrullah    2. Samuel Habte
+ As a starting point use HRServicesRS template source code for the project -- done
+ Create a branch for each tier or functionality and 
    feature instead of committing it to master -- done
+ Create an Operational Model for the appliction -- done
+ Create a database schema for the application -- done
+ Create a aws account free tier -- Processing
+ Create an instance of mysql aws RDS -- Processing
+ Connect the database and create a data access layer -- Processing
+ Create model classes for the application -- done

================================
# Operational Model
https://drive.google.com/open?id=1zYD-7Usdf8q3bc2zK9e0cRaoYAmPgLHg
+ On the OM foreign key are not used on the model class instance variables instead used on database schema
+ For Payment - not yet decided in need of model class because Paypal api is used and may not need to store card information to our database.
+ Classes that have association/composition characteristics, used list data structre.
+ Color and image of produt functionality will be done later time, now focused on basic functionalities
+ State and city model class not needed but might be used as a lookup.

# Database schema
https://drive.google.com/open?id=1aQAzSQvIsakS18C4bLQyMqiDbjHGuFBJ
+ MySql DB on AWS is used to create DB and connect
