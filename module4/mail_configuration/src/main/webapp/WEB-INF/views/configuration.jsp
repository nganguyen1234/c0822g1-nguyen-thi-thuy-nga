<%--
  Created by IntelliJ IDEA.
  User: Nga
  Date: 12/16/2022
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    Settings
</h1>
<p style="color: red">${mess}</p>
<form:form action="/update" modelAttribute="mailConfiguration">
    <form:label path="language">Languages</form:label>
    <form:select path="language" items="${languageList}"/>
    <br>
    <form:label path="pageSize">Page size </form:label>
    <span>Show </span><form:select path="pageSize" items="${pageSizeList}"/><span> emails per page</span>
    <br>
    <form:label path="spamFilter">Spams filter</form:label>
    <form:checkbox path="spamFilter"></form:checkbox>
    <br>
    <form:label path="signature">Signature</form:label>
    <form:input path="signature"/>
    <br>
    <input type="submit" value="Update">
    <input type="reset" value="Cancel">
</form:form>
</body>
</html>
