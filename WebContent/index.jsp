<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>Presidents</title>
    <link rel="stylesheet" href="pres.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
</head>

<body>
    <div id="container">
        <header>
            <h1>Presidents of the United States of America.</h1>
            <p id="oath">
                <em><strong>"I do solemnly swear (or affirm) that I will faithfully execute the Office of President of the United States, and will to the best of my ability, preserve, protect and defend the Constitution of the United States."</strong>"</em>
            </p>
        </header>
        ${presList[0]}

        <div class="photobanner">
            <a href="something.do?pres=${presList[0].termNumber }"><img class="first" src="PresPics/${presList[0].picture}" width="350px" height="233px" /></a>
        	<c:forEach var="president" items="${presList}">
            <a href="something.do?pres=${president.termNumber }"><img src="PresPics/${president.picture}" width="350px" height="233px" /></a>
           </c:forEach>
        </div>
    </div>


</body>

</html>
