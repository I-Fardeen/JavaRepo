# JavaRepo

Welcome to My Java Repository

In the folder EmployeeWalletProject you will find these four files:

1 - Classes.java

2 - Index.java

3 - dbcon.java

4 - constrng.java

The project uses MySQL database, the schema is as follows:

--------------------
Table : employee    |
                    |
- ssno int pk       |
- salary double     |
- name varchar(20)  |
--------------------
         |
         |
         V
--------------------
Table: Wallet       |
- amount            |
- ssno fk employee  |
--------------------

- constrng.java is used to store the credentials to access MySQL database
all its member attributes are public static final Strings

- Classes.java maps the main schema of our db into java classes
here wallet is an interface and employee is a class
Classes.java interacts with db.con to make all changes permanent
in the database. 

- db.con acts as a Data Link Layer and provides the functionality
of interacting with the database, each function defined here is used
to make changes with the database. For security reasons, every file
which needs to make any changes in the db has to go through dbcon to 
do so.

- Index.java is our driver class which has our main function,
For now, untill further additions to this repo, Index.java is
our UI and takes the input from the user and maps the same to 
obj of employee class, uses this obj to call functions of employee
which in turn use the dbcon functions to interact with the database
