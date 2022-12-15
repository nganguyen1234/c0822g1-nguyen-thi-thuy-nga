<%--
  Created by IntelliJ IDEA.
  User: Nga
  Date: 12/15/2022
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>choose sandwich condiments</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>Sandwich Condiments</h1>
<div class="input-group">
    <form action="/select">
        <input type="checkbox" class="form-check-input mt-0"  name="condiment" id="lettuce" value="Lettuce">
        <label for="lettuce"> Lettuce</label><br>
        <input type="checkbox" class="form-check-input mt-0"  name="condiment" id="tomato" value="Tomato">
        <label for="tomato"> Tomato</label><br>
        <input type="checkbox" class="form-check-input mt-0"  name="condiment" id="mustard" value="Mustard">
        <label for="mustard"> Mustard</label><br>
        <input type="checkbox" class="form-check-input mt-0"  name="condiment" id="sprouts" value="Sprouts">
        <label for="sprouts"> Sprouts</label><br>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

</body>
</html>
