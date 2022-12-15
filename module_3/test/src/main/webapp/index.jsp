<%--
  Created by IntelliJ IDEA.
  User: Nga
  Date: 12/12/2022
  Time: 12:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>$Title$</title>
    <%--<link href="css/bootstrap-5.0.2-dist/css/bootstrap.css">--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <%--    show modal--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        #footer {
            background-color: #264F1A;
            height: 50px;
            margin-bottom: 1px;
            position: relative;
            padding: 10px 50px;
            justify-content: center;
            color: white;
        }

        #header {
            height: 90px;
            margin-bottom: 20px;
        }

        body {
            font-family: sans-serif;
            font-size: 90%;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <%--------------------------------------------------------    header ----------------------------------------------------------%>
    <div class="row" style="margin-top: 10px">
        <div class="col-auto col-sm-5 col-lg-3 d-flex align-items-center bestel-logo">
            <a href="https://furamavietnam.com/" class="header-logo"><img
                    src="https://furamavietnam.com/wp-content/uploads/2018/08/logo@2x.png" alt="logo " class="img-fluid"
                    width="50%" height="50%"></a>
        </div>
        <div class="col-lg-2 text-center">
            <button type="button" class="btn btn-light">User Name</button>
        </div>
    </div>
    <%-----------------------------------------------------------  navbar------------------------------------------------------------%>
    <div class="row">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <div class="col-lg-3">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </div>
                    </form>
                    <div class="col-lg-4">
                        <a href="/mat-bang?action=themMoi">
                            <img src="https://img.icons8.com/offices/30/null/plus-2-math.png"/>
                        </a>
                    </div>
                </div>
            </div>
        </nav>
    </div>
    <%-------------------------------------------------------------  main content--------------------------------------------------------%>
    <div class="row main vh-100">
        <%-------------------------------------------------------------      list-------------------------------------------------------------%>
            <table class="table table-striped table-bordered" id="tableStudent">
                <thead>
                <tr>
                    <th scope="col">STT</th>
                    <th scope="col">Name</th>
                    <th scope="col">Birthday</th>
                    <th scope="col">Gender</th>
                    <th scope="col">ID card</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Email</th>
                    <th scope="col">Customer type</th>
                    <th scope="col">Address</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="customer" items="${matBangList}" varStatus="stt">
                    <tr>
                        <td>${stt.count}</td>
                        <td>${customer.name}</td>
                        <td>${customer.dateOfBirth}</td>
                        <td>${customer.gender}</td>
                        <td>${customer.idCard}</td>
                        <td>${customer.phoneNumber}</td>
                        <td>${customer.email}</td>
                        <td>${customer.customerType.name}</td>
                        <td>${customer.address}</td>
                        <td>
                            <button onclick="getCustomerInfo('${customer.id}','${customer.name}','${customer.dateOfBirth}','${customer.gender}','${customer.idCard}','${customer.phoneNumber}','${customer.email}','${customer.address}')"
                                    type="button" class="btn btn-light" data-bs-toggle="modal"
                                    data-bs-target="#editCustomer">
                                <img src="https://img.icons8.com/external-anggara-basic-outline-anggara-putra/24/null/external-create-social-media-interface-anggara-basic-outline-anggara-putra.png"/>
                            </button>
                        </td>
                        <td>
                            <button onclick="getCustomerId('${customer.id}','${customer.name}')"
                                    type="button"
                                    class="btn btn-light" data-bs-toggle="modal"
                                    data-bs-target="#deleteCustomer">
                                <img src="https://img.icons8.com/ios-glyphs/30/null/trash--v1.png"/>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
    <%-----------------------------------------------------------  footer-----------------------------------------------------------------------%>
    <div class="row " id="footer">@copyright by me</div>

    <%---------------------------------------------------------    form-------------------------------------------------------------------------%>
<%--    <form action="/customer?action=add" method="post">--%>
<%--        <div class="modal-body">--%>
<%--            <form class="vh-100">--%>
<%--                <div class="mb-3">--%>
<%--                    <label class="form-label">Name</label>--%>
<%--                    <input type="text" value="${errorCustomer.name}" class="form-control" name="name" required>--%>
<%--                    <c:if test="${!errorMap.isEmpty}">--%>
<%--                        <p style="color: red">${errorMap.get("name")}</p>--%>
<%--                    </c:if>--%>
<%--                </div>--%>
<%--                <div class="mb-3">--%>
<%--                    <label class="form-label">Birthday</label>--%>
<%--                    <input type="date" value="${errorCustomer.dateOfBirth}" class="form-control"--%>
<%--                           name="dateOfBirth " required>--%>
<%--                </div>--%>
<%--                <div class="mb-3">--%>
<%--                    <label class="form-label">Gender</label>--%>
<%--                    <input type="text" value="${errorCustomer.gender}" class="form-control" name="gender"--%>
<%--                           required>--%>
<%--                </div>--%>
<%--                <div class="mb-3">--%>
<%--                    <label class="form-label">ID card</label>--%>
<%--                    <input type="text" value="${errorCustomer.idCard}" class="form-control" name="idCard"--%>
<%--                           required>--%>
<%--                    <c:if test="${!errorMap.isEmpty}">--%>
<%--                        <p style="color: red">${errorMap.get("idCard")}</p>--%>
<%--                    </c:if>--%>
<%--                </div>--%>
<%--                <div class="mb-3">--%>
<%--                    <label class="form-label">Phone number</label>--%>
<%--                    <input type="text" value="${errorCustomer.phoneNumber}"--%>
<%--                           pattern="(090\d{7})|(091\d{7})|(\(84\)\+90\d{7})|(\(84\)\+91\d{7})"--%>
<%--                           class="form-control" name="phoneNumber" required>--%>
<%--                    <c:if test="${!errorMap.isEmpty}">--%>
<%--                        <p style="color: red">${errorMap.get("phoneNumber")}</p>--%>
<%--                    </c:if>--%>
<%--                </div>--%>
<%--                <div class="mb-3">--%>
<%--                    <label class="form-label">Email</label>--%>
<%--                    <input type="text" value="${errorCustomer.email}" pattern="[a-zA-Z]\w+@gmail\.com"--%>
<%--                           class="form-control" name="email"--%>
<%--                           required>--%>
<%--                    <c:if test="${!errorMap.isEmpty}">--%>
<%--                        <p style="color: red">${errorMap.get("email")}</p>--%>
<%--                    </c:if>--%>
<%--                </div>--%>
<%--                <div class="mb-3">--%>
<%--                    <label class="form-label">Customer type</label>--%>
<%--                    <select class="form-select" id="inputGroupSelect03"--%>
<%--                            aria-label="Example select with button addon" name="customerTypeId">--%>
<%--                        <c:forEach var="type" items="${customerTypeList}">--%>
<%--                            <option value="${type.id}">${type.name}</option>--%>
<%--                        </c:forEach>--%>
<%--                    </select>--%>
<%--                </div>--%>
<%--                <div class="mb-3">--%>
<%--                    <label class="form-label">Address</label>--%>
<%--                    <input type="text" value="${errorCustomer.address}" class="form-control" name="address"--%>
<%--                           required>--%>

<%--                </div>--%>
<%--            </form>--%>
<%--            <div class="modal-footer">--%>
<%--                <form action="/customer">--%>
<%--                    <button type="submit" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>--%>
<%--                </form>--%>
<%--                <button type="Submit" class="btn btn-danger">Submit</button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </form>--%>
<%--    &lt;%&ndash;----------------------------------------------------    modal---------------------------------------------&ndash;%&gt;--%>
<%--    <!-- Button trigger modal -->--%>
<%--    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">--%>
<%--        Launch demo modal--%>
<%--    </button>--%>

<%--    <!-- Modal -->--%>
<%--    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--        <div class="modal-dialog">--%>
<%--            <div class="modal-content">--%>
<%--                <div class="modal-header">--%>
<%--                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>--%>
<%--                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>--%>
<%--                </div>--%>
<%--                <div class="modal-body">--%>
<%--                    ...--%>
<%--                </div>--%>
<%--                <div class="modal-footer">--%>
<%--                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>--%>
<%--                    <button type="button" class="btn btn-primary">Save changes</button>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    &lt;%&ndash;---------------------------------------------------------------------------&ndash;%&gt;--%>
</div>
</body>
<script src="css/bootstrap-5.0.2-dist/js/bootstrap.bundle.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<%-------------------------------setting for table paging sorting----------------------------%>

<%--<script src="jquery/jquery-3.5.1.min.js"></script>--%>
<%--<script src="datatables/js/jquery.dataTables.min.js"></script>--%>
<%--<script src="datatables/js/dataTables.bootstrap5.min.js"></script>--%>
<%--<script>--%>
<%--    $(document).ready(function() {--%>
<%--        $('#tableStudent').dataTable( {--%>
<%--            "dom": 'lrtip',--%>
<%--            "lengthChange": false,--%>
<%--            "pageLength": 5--%>
<%--        } );--%>
<%--    } );--%>
<%--</script>--%>


<%--chọn customer type--%>
<%--<td><select name="customerTypeId">--%>
<%--    <c:forEach var="cusType" items="${customerTypeList}">--%>
<%--        <option value="${cusType.getId()}" ${cusType.getId() == customer.getCustomerType().getId() ? 'selected' : ''}>--%>
<%--                ${cusType.getName()}</option>--%>
<%--    </c:forEach>--%>
<%--</select></td>--%>

<%--<tr>--%>
<%--    <th>Giới Tính:</th>--%>
<%--    <td><input type="radio" name="gender" size="45" value="true" ${customer.isGender()==true?"checked":""} >Nam--%>
<%--        <input type="radio" name="gender" size="45" value="false" ${customer.isGender()==false?"checked":""} >Nữ--%>
<%--    </td>--%>
<%--</tr>--%>


<%------------------------------show modal-------------------------------------------------%>
<script>
    $(document).ready(function () {
        // Show the Modal on load
        $("#exampleModal").modal("show");

        // Hide the Modal
        $("#myBtn").click(function () {
            $("#exampleModal").modal("hide");
        });
    });
</script>
</html>
