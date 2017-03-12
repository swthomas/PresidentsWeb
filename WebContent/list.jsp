<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head><link rel="stylesheet" href="style2.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Presidents Home</title>
    <link rel="stylesheet" href="president.css">
</head>

<body>
    <h1 id="head">United States<br>Presidents</h1>
	${president}
	<c:forEach var="president" items="${presidentList}">
		<a href="getPresident.do?id=${president.termNumber }"><img
			style="width: 20%;" src="PresPics/${president.picture }" /></a>
	</c:forEach>

	<div id="mainContainer">
        <div id="selectName">
            <form method="POST" action="showPres.do">
                <h3>Select by Name:</h3>
                <select class="selector" name="president">
              <option value=""></option>
                       <c:forEach var="president" items="${presList}">
             <option value="${president.termNumber}">${president.name}</option>               </c:forEach>
                </select><br>
                <input class="button1" type="submit" value="Search by Name">

            </form>
        </div>

        <div id="selectParty">
            <form method="POST" action="showPres.do">
                <h2>Select by Party:</h2>
                <select class="selector" name="party">
              <option value=""></option>
                      <option value="Independent">Independent</option>
                      <option value="Federalist">Federalist</option>
                      <option value="Democratic-Republican">Democratic-Republican</option>
                      <option value="Democrat">Democrat</option>
                      <option value="Republican">Republican</option>
                      <option value="Whig">Whig</option>
              </select><br>
                <input class="button" type="submit" value="Search by Party">
            </form>

        </div>

        <div id="selectTerm">

            <form method="POST" action="showPres.do">
                <h2>Select by Term:</h2>
                <select class="selector" name="term">
              <option value=""></option>
                 <c:forEach var="president" items="${presList}">
              <option value="${president.termNumber}">${president.termNumber}</option>
                 </c:forEach>
            </select><br>
                <input class="button" type="submit" value="Search by Term">

            </form>
        </div>
    </div>

</body>

</html>
