<%--
  Created by IntelliJ IDEA.
  User: moldovanrares
  Date: 7/18/2019
  Time: 4:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cars</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/style.css">
    <script src="../js/form.js"></script>
</head>
<body>
<br><br>
<div class="main-page">

    <div class="form">
        <form>
            <div class="form-group">
                <label for="brand">Brand</label>
                <input type="text" class="form-control" id="brand" placeholder="Enter brand">
            </div>
            <div class="form-group">
                <label for="model">Model</label>
                <input type="text" class="form-control" id="model" placeholder="Enter Model">
            </div>
            <div class="form-group">
                <label for="year">Year</label>
                <input type="number" min="1950" class="form-control" id="year" placeholder="Enter Year">
            </div>
            <div>
                <button onclick="addButton()" type="button" class="btn btn-primary">Add car</button>
                <button onclick="updateButton()" type="button" class="btn btn-primary">Update car</button>
                <button onclick="deleteButton()" type="button" class="btn btn-primary">Delete car</button>
            </div>
        </form>
    </div>

    <div class="table-div">
        <table class="table table-dark" id="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Brand</th>
                <th scope="col">Model</th>
                <th scope="col">Year</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="car" items="${list}">
                <tr onclick="displayRow()">
                    <th id="col-id">${car.id}</th>
                    <td>${car.brand}</td>
                    <td>${car.model}</td>
                    <td>${car.year}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>
