<%--
  Created by IntelliJ IDEA.
  User: Nga
  Date: 12/14/2022
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Dictionary</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<form action="/translate">
        <div class="col-lg-3">
            <input class="form-control me-2" name="word" value="${word}" type="search" placeholder="Search"
                   aria-label="Search">
            <div class="mb-3">
                <label class="form-label">Nghĩa Tiếng Việt</label>
                <input class="form-control" type="text" value="${meaning}" aria-label="readonly input example" readonly>
            </div>
            <div class="col-lg-3">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </div>

        <c:if test="${map.size() > 0}">
        <table class="table table-striped table-bordered" id="dictionaryMap">
            <thead>
            <tr>
                <th scope="col">STT</th>
                <th scope="col">Word</th>
                <th scope="col">Meaning</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="word" items="${map.keySet()}" varStatus="stt">
            <tr>
                <td>${stt.count}</td>
                <td>${word}</td>
                <td>${map.get(word)}</td>
            </tr>
            </c:forEach>
            </c:if>
        </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
