<%--
  Created by IntelliJ IDEA.
  User: moldovanrares
  Date: 7/18/2019
  Time: 4:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Cars</title>
</head>
<body>
    <h2></h2>
    <table border="2">
        <tr>
            <th>Id</th>
            <th>Brand</th>
            <th>Model</th>
            <th>Year</th>
        </tr>
        <c:forEach var="car" items="${list}">
            <tr>
                <td>${car.id}</td>
                <td>${car.brand}</td>
                <td>${car.model}</td>
                <td>${car.year}</td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
