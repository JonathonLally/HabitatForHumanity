Welcome to my final project for CSE248.  This is an inventory system for habitat for humanity.  
My program uses a mysql database that must be setup prior to use otherwise it won't have
any data or even users to login with.  

To setup mySql Server
1.Open mySQL Workbench and login to localhost. 
2.Go to root user account and change the password to "U3Z3aacoskOO55ndVAOf".
You may need to reconnect or re-enter this password after.  
3.Go to File, Run SQL Script then navigate to filepath where my project is and then to
the sqldump directory should be a .sql file "sqldump".
4.Under default Schema name wrote "habitatsql" and then run.  
5.Database should work with .jar in my project folder "HabitatTest.jar"


To Login to Application
1.Run HabitatTest.Jar in project folder
2.Login system works on users Table on mySQL
Based on the login you will be have access to different things based on user type
	Username - "customer" password - "password" type - customer
	Username - "employee" password - "password" type - employee
	Username - "manager"  password - "password" type - manager
If logged in under manager you may add/remove users and access a userlist.  

To view inventory, login as customer or choose view inventory option.  You can sort via the buttons provided
and to see an object directly enter it's id and view.  To add/remove inventory you must be logged in
as an employee or manager.  