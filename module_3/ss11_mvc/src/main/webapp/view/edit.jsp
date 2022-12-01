<%--
  Created by IntelliJ IDEA.
  User: Nga
  Date: 12/1/2022
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<form class="vh-100" action="/product?action=edit&id=${id}" method="post">
    <div class="mb-3">
        <label class="form-label">Name</label>
        <input type="text" class="form-control" name="name" value="${product.name}">
    </div>
    <div class="mb-3">
        <label class="form-label">Price</label>
        <input type="text" class="form-control" name="price" value="${product.price}">
    </div>
    <div class="mb-3">
        <label class="form-label">Description</label>
        <input type="text" class="form-control" name="description" value="${product.description}">
    </div>
    <div class="mb-3">
        <label class="form-label">Manufacturer</label>
        <input type="text" class="form-control" name="manufacturer" value="${product.manufacturer}">
    </div>
    <div class="mb-3 justify-content-center text-center">
        <button type="submit" class="btn btn-danger">
            Submit
        </button>
    </div>
</form>
</body>
</html>
