<%--
  Created by IntelliJ IDEA.
  User: Nga
  Date: 11/29/2022
  Time: 11:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
    <link rel="stylesheet" href="./css/bootstrap-5.0.2-dist/css/bootstrap.css">
  </head>
  <body>
  <h3>
    Product Discount Calculator
  </h3>
  <form action="/display-discount" method="post">
    <div class="mb-3">
      <label class="form-label">Product Description</label>
      <input type="text" class="form-control" name="description">
    </div>
    <div class="mb-3">
      <label class="form-label">List Price</label>
      <input type="number" class="form-control" name="price">
    </div>
    <div class="mb-3">
      <label class="form-label">Discount Percent</label>
      <input type="number" class="form-control" name="discount">
    </div>
    <div>
      <button type="submit" class="btn btn-danger">
        Submit
      </button>
    </div>
  </form>
  </body>
</html>
