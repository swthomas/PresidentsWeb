# Summary
A collaborative Java web-app developed with eclipse that displays information on presidents of the United States based on user input.

<img src="WebContent/PresPics/scrn1.png" height="350">
<img src="WebContent/PresPics/scrn2.png" height="350">

## In This Document
1. [How to Execute](#how-to-execute)
2. [Class Structure Overview](#class-structure-overview)

## How to Execute
- The web-app is hosted on: insert URL <a href="http://52.43.150.156:8080/PresidentsWeb/">**here**</a>
- Download the entire program as a .war file <a href="PresidentsWeb.war">**here**</a>

## Instructions
1. User arrives on landing page.
2. User can select president based on term #
3. Information is displayed on chosen president.
4. User can navigate forwards or backwards. When user gets to the end or the beginning, arrows will take them back to the other end.
5. User can also click on 'Go Back' to get back to dropdown menu.

## Class Structure Overview
- The **PresServlet** class is the controller and interacts with the **PresDAOImpl** class which implements methods declared in the **PresDAO** interface. The president object and list objects are constructed using information from the **President** class and accompanying .txt and .csv files.
- The **PresServlet** provides information back through a **.jsp** file for the user to view and chooses what president's information (name, term years, picture, facts, etc.) will be displayed based upon if-logic located in the servlet that evaluates user navigation in put.

**example of back-button**

```
<a href="start.do?back=back&id=${presData[term-1].termNumber}">&#9756;</a>
```

**example of back-button logic on servlet**

```
if (back != null) {
				try {
					term2 = term - 1;
					if (term == 1) {
						term2 = 45;
					}
					req.setAttribute("id", id);
					req.setAttribute("presData", data);
					req.setAttribute("term", term2);
					req.getRequestDispatcher("/Output.jsp").forward(req, resp);
				} catch (Exception e) {
					req.setAttribute("presData", data);
					req.setAttribute("term", term2);
					req.getRequestDispatcher("/Output.jsp").forward(req, resp);}
```

- The JavaServer Pages included references to stylesheets and the use of bootstrap which enables the use of the 'baseball-like' card format on unordered lists, which displays the president data.

```
<div class="card">
                <ul class="list-group list-group-flush">
                    <img class="portrait" src="./PresPics/${presData[term-1].photo}" alt="president pic">
                    <li><h1>${presData[term-1].firstName} ${presData[term-1].lastName}</h1></li>
                    <li><h3>${presData[term-1].termYear}</h3></li>
                    <li id ="party" class="list-group-item">${presData[term-1].party} Party</li>
                    <li class="list-group-item">${presData[term-1].fact}</li>
                </ul>
            </div>
```
###Chart of responsibilities
<img src="WebContent/PresPics/chart.png" height="400">
