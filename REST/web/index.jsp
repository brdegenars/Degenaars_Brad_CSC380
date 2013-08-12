<%--
  Created by IntelliJ IDEA.
  User: brdegenaars
  Date: 8/11/13
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Restaurants</title>
</head>
<body>
    <h1>All restaurants: </h1>
    <p>
        <c:forEach var="restaurant" items="${requestScope.restaurants}">
            Restaurant: ${restaurant.name} (${restaurant.genre})<br/>
        </c:forEach>
    </p>
</body>
</html>