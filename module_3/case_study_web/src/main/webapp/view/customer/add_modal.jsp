<%@ page import="service.ICustomerService" %>
<%@ page import="service.Impl.CustomerService" %>
<%@ page import="java.util.List" %>
<%@ page import="model.customer.Customer" %><%--
  Created by IntelliJ IDEA.
  User: Nga
  Date: 11/30/2022
  Time: 8:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
    <title>Add customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<%--Kết nối SQL với jsp--%>
<%--<sql:setDataSource var="snapshot"--%>
<%--                   url="jdbc:mysql://localhost:3306/furama_resort"--%>
<%--                   user="root"  password="ngathuy3456"/>--%>
<%--<sql:query dataSource="" var="customerTypeList">--%>
<%--    SELECT name from customer_type;--%>
<%--</sql:query>--%>
<!-- Modal -->
<div class="modal fade" id="addCustomer" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add customer information</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form class="vh-100">
                    <div class="mb-3">
                        <label class="form-label">Name</label>
                        <input type="text" class="form-control" name="name">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Birthday</label>
                        <input type="text" class="form-control" name="dateOfBirth">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Gender</label>
                        <input type="number" class="form-control" name="gender">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">ID card</label>
                        <input type="text" class="form-control" name="idCard">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Phone</label>
                        <input type="text" class="form-control" name="phoneNumber">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Email</label>
                        <input type="text" class="form-control" name="email">
                    </div>
                    <div class="mb-3">
                        <%--                        <label class="form-label">Customer type</label>--%>
                        <%--                        <input type="text" class="form-control" name="customerType">--%>

                        <select class="form-select" id="inputGroupSelect03"
                                aria-label="Example select with button addon" name="customerType">
                            <c:forEach var="type" items="customerTypeList">
                                <option value="${type}">${type}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Address</label>
                        <input type="text" class="form-control" name="address">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <form action="/customer?action=add" method="post">
                    <button type="Submit" class="btn btn-danger">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
