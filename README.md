# Summary
A collaborative Java web-app developed with eclipse that displays information on presidents of the United States based on user input.

## In This Document
1. [How to Execute](#how-to-execute)
2. [Class Structure Overview](#class-structure-overview)

## How to Execute
- The web-app is hosted on: insert URL <a href="http://35.162.216.236:8080/PresidentsWeb/">**here**</a>

## Instructions
1. User arrives on landing page.
2. User can select president based on term #, name or party.
3. Information is displayed on chosen president.
4. User can navigate forwards or backwards. When user gets to the end or the beginning, arrows will take them back to the other end.

## Class Structure Overview
- The **PresServlet** class is the controller and interacts with the **PresDAOImpl** class which implements methods declared in the **PresDAO** interface. The president object and list objects are constructed using information from the **President** class and accompanying .txt and .csv files.
- The **PresServlet** provides information back through a **.jsp** file for the user to view and chooses what president's information (name, term years, picture, facts, etc.) will be displayed based upon if-logic located in the servlet that evaluates user navigation in put.
