<%--
  Created by IntelliJ IDEA.
  User: Nga
  Date: 12/1/2022
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Display list</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Price</th>
        <th scope="col">Description</th>
        <th scope="col">Manufacturer</th>
        <th scope="col">Edit</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${productList}" varStatus="nyc">
        <tr>
            <th scope="row">${nyc.count}</th>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>${product.manufacturer}</td>
            <td>
                    <a href="/product?action=edit&id=${product.id}">
                        <img src="https://img.icons8.com/external-anggara-basic-outline-anggara-putra/24/null/external-create-social-media-interface-anggara-basic-outline-anggara-putra.png"/>
                    </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
