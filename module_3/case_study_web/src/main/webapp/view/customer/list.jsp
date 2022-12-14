<%--
  Created by IntelliJ IDEA.
  User: Nga
  Date: 11/30/2022
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%--    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css" />--%>
<%--    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css" />--%>
<%--    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap5.min.css">--%>
<%--    <link rel="stylesheet" href="../../bootstrap520/css/bootstrap.css">--%>
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
<%---------------------------------------------------------header------------------------------------------------------%>
<div class="container-fluid">
    <div class="row" style="margin-top: 10px">
        <div class="col-auto col-sm-5 col-lg-3 d-flex align-items-center bestel-logo">
            <a href="https://furamavietnam.com/" class="header-logo"><img
                    src="https://furamavietnam.com/wp-content/uploads/2018/08/logo@2x.png" alt="logo " class="img-fluid"
                    width="50%" height="50%"></a>
        </div>
        <div class="col col-md-auto col-lg-2 d-flex" style="height: 50px">
            <div class="catalog-widget d-none d-sm-block">
                <div class="catalog-widget-inside" style="visibility: visible;">
                    <a href="https://www.tripadvisor.com/Hotel_Review-g298085-d302750-Reviews-Furama_Resort_Danang-Da_Nang_Quang_Nam_Province.html"
                       target="_blank">
                        <div class="widget-tripadvisor">
                            <div class="inside">
                                <div class="widget-tripadvisor-logo"><img
                                        src="https://smartdata.tonytemplates.com/bestel/wp-content/uploads/2018/05/widget-tripadvisor-logo.png"
                                        alt=""></div>
                                <div class="widget-tripadvisor-rating"><img
                                        src="https://furamavietnam.com/wp-content/uploads/2018/08/widget-tripadvisor-rating.png"
                                        alt=""></div>
                                <div class="widget-tripadvisor-text">2,746 Reviews</div>
                            </div>
                        </div>
                    </a>
                    <span class="catalog-widget-toggle js-catalog-widget-toggle"></span></div>
            </div>
            <div class="catalog-widget-mobile d-flex d-sm-none align-items-center mx-auto">
            </div>
        </div>

        <div class="col-sm-3 d-none d-lg-block col-lg-3">
            <div class="header-contact d-flex">
                <div class="header-contact-icon"><img
                        src="https://img.icons8.com/material-outlined/24/null/marker.png"/></div>
                <div class="header-contact-txt">
                    <p>
                        103 - 105 Vo Nguyen Giap Street, Khue My Ward, Ngu Hanh Son District, Danang City, Vietnam </p>
                    <p class="txt-sm">
                        <span>7,0 km</span> from Danang Airport </p>
                </div>
            </div>
        </div>
        <div class="col-sm-3 d-none d-lg-block col-lg-2">
            <div class="header-contact d-flex">
                <div class="header-contact-icon"><img src="https://img.icons8.com/ios-glyphs/30/null/phone--v1.png"/>
                </div>
                <div class="header-contact-txt">
                    <p class="txt-lg">
                        84-236-3847 333/888 </p>
                </div>
            </div>
            <div class="header-contact d-flex col-lg-2">
                <div class="header-contact-icon"><img
                        src="https://img.icons8.com/ios-glyphs/30/null/circled-envelope.png"/></div>
                <div class="header-contact-txt">
                    <a href="mailto:reservation@furamavietnam.com">
                        reservation@furamavietnam.com </a>
                </div>
            </div>
        </div>
        <div class="col-lg-2 text-center">
            <button type="button" class="btn btn-light">User Name</button>
        </div>
    </div>
    <div class="row">
        <%---------------------------------------------------------navbar------------------------------------------------------%>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page"
                               href="/index.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/employee">Employee</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link"
                               href="/customer">Customer</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/service">Service</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/contract">Contract</a>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
    </div>
    <%---------------------------------------------------------list------------------------------------------------------%>
    <div class="row main vh-100">
        <div class="col-lg-3 overflow-scroll" style="border: 1px solid black">
            <ul class="list-group">
                <li class="list-group-item">An item</li>
                <li class="list-group-item">A second item</li>
                <li class="list-group-item">A third item</li>
                <li class="list-group-item">A fourth item</li>
                <li class="list-group-item">And a fifth one</li>
            </ul>
        </div>
        <%---------------------------------------------------------display customer list------------------------------------------------------%>
        <div class="col-lg-9">
            <div class="row">
                <h4>Customer list</h4>
            </div>
            <div class="row justify-content-center">
                <form class="d-flex" action="/customer?action=search" method="post">
                    <div class="col-lg-3">
                        <input class="form-control me-2" name="searchName" type="search" placeholder="Search by name"
                               aria-label="Search">
                    </div>
                    <div class="col-lg-3">
                        <input class="form-control me-2" name="searchEmail" type="search" placeholder="Search by email"
                               aria-label="Search">
                    </div>
                    <div class="col-lg-3">

                        <input class="form-control me-2" name="searchPhoneNumber" type="search"
                               placeholder="Search by phone number" aria-label="Search">
                    </div>
                    <div class="col-lg-3">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </div>
                </form>
                <div class="col-lg-4">
                    <button type="button" class="btn btn-light" data-bs-toggle="modal"
                            data-bs-target="#addCustomer">
                        <img src="https://img.icons8.com/offices/30/null/plus-2-math.png"/>
                    </button>
                </div>
                <div class="col-lg-3">
                    <p style="color: red" id="message"></p>
                </div>
            </div>
<%--            <div class="row">--%>
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
                    <c:forEach var="customer" items="${customerList}" varStatus="stt">
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
            </div>
<%--        </div>--%>
    </div>
    <div class="row " id="footer">@copyright by me</div>
</div>
<%--------------------------------------------------------- add modal------------------------------------------------------%>
<div class="modal fade" id="addCustomer" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add customer information</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/customer?action=add" method="post">
                <div class="modal-body">
                    <form class="vh-100">
                        <div class="mb-3">
                            <label class="form-label">Name</label>
                            <input type="text" value="${errorCustomer.name}" class="form-control" name="name" required>
                            <c:if test="${!errorMap.isEmpty}">
                                <p style="color: red">${errorMap.get("name")}</p>
                            </c:if>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Birthday</label>
                            <input type="date" value="${errorCustomer.dateOfBirth}" class="form-control"
                                   name="dateOfBirth " required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Gender</label>
                            <input type="text" value="${errorCustomer.gender}" class="form-control" name="gender"
                                   required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">ID card</label>
                            <input type="text" value="${errorCustomer.idCard}" class="form-control" name="idCard"
                                   required>
                            <c:if test="${!errorMap.isEmpty}">
                                <p style="color: red">${errorMap.get("idCard")}</p>
                            </c:if>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Phone number</label>
                            <input type="text" value="${errorCustomer.phoneNumber}"
                                   pattern="(090\d{7})|(091\d{7})|(\(84\)\+90\d{7})|(\(84\)\+91\d{7})"
                                   class="form-control" name="phoneNumber" required>
                            <c:if test="${!errorMap.isEmpty}">
                                <p style="color: red">${errorMap.get("phoneNumber")}</p>
                            </c:if>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Email</label>
                            <input type="text" value="${errorCustomer.email}" pattern="[a-zA-Z]\w+@gmail\.com"
                                   class="form-control" name="email"
                                   required>
                            <c:if test="${!errorMap.isEmpty}">
                                <p style="color: red">${errorMap.get("email")}</p>
                            </c:if>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Customer type</label>
                            <select class="form-select" id="inputGroupSelect03"
                                    aria-label="Example select with button addon" name="customerTypeId">
                                <c:forEach var="type" items="${customerTypeList}">
                                    <option value="${type.id}">${type.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Address</label>
                            <input type="text" value="${errorCustomer.address}" class="form-control" name="address"
                                   required>

                        </div>
                    </form>
                    <div class="modal-footer">
                        <form action="/customer">
                            <button type="submit" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        </form>
                        <button type="Submit" class="btn btn-danger">Submit</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</div>
<%--------------------------------------------------------- edit modal------------------------------------------------------%>
<div class="modal fade" id="editCustomer" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Edit customer information</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/customer?action=edit" method="post">
                <div class="modal-body">
                    <input type="text" id="id" name="id" hidden>
                    <div class="mb-3">
                        <label class="form-label">New name</label>
                        <input type="text" class="form-control" name="newName" id="newName">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">New birthday</label>
                        <input type="text" class="form-control" name="newBirthday" id="newBirthday">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">New gender</label>
                        <input type="text" class="form-control" name="newGender" id="newGender">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">New ID card</label>
                        <input type="text" class="form-control" name="newIdCard" id="newIdCard">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">New phone number</label>
                        <input type="text" class="form-control" name="newPhoneNumber" id="newPhoneNumber">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">New email</label>
                        <input type="text" class="form-control" name="newEmail" id="newEmail">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">New customer type</label>
                        <select class="form-select"
                                aria-label="Example select with button addon" name="newCustomerType" id="customerType">
                            <c:forEach var="type" items="${customerTypeList}">
                                <option value="${type.id}">${type.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">New address</label>
                        <input type="text" class="form-control" name="newAddress" id="newAddress">
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-danger">Save changes</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%--------------------------------------------------------- delete modal------------------------------------------------------%>
<div class="modal fade" id="deleteCustomer" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete customer information</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/customer?action=delete" method="post">
                <div class="modal-body">
                    <input id="deleteId" type="text" name="deleteId" hidden>
                    <span>Are you sure that you want to delete information of </span><span id="deleteName"> ?</span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </div>
            </form>
        </div>
    </div>
</div>
<input id="flag" type="text" value="${isModal}" hidden>
<script>
    function getCustomerId(id, name) {
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteName").innerText = name;
    }

    function getCustomerInfo(id, name, dateOfBirth, gender, idCard, phoneNumber, email, address) {
        document.getElementById("id").value = id
        document.getElementById("newName").value = name;
        document.getElementById("newBirthday").value = dateOfBirth;
        document.getElementById("newGender").value = gender;
        document.getElementById("newIdCard").value = idCard;
        document.getElementById("newPhoneNumber").value = phoneNumber;
        document.getElementById("newEmail").value = email;
        document.getElementById("newAddress").value = address;
    }

    // show message after delete,add,edit
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    document.getElementById("message").innerText = urlParams.get('message');


    // show edit , add modal if have error
    if ($("#flag").val() == "true") {
        $(document).ready(function () {
            $("#addCustomer").modal("show");
        });
    }

    // setting for table paging sorting

</script>

<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function() {
        $('#tableStudent').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
</script>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>--%>
<%--&lt;%&ndash;<script src="../../jquery/jquery-3.5.1.min.js"></script>&ndash;%&gt;--%>
<%--&lt;%&ndash;<script src="../../datatables/js/dataTables.bootstrap5.js"></script>&ndash;%&gt;--%>
<%--&lt;%&ndash;<script src="jquery/jquery-3.5.1.min.js"></script>&ndash;%&gt;--%>
<%--&lt;%&ndash;<script src="datatables/js/jquery.dataTables.min.js"></script>&ndash;%&gt;--%>
<%--&lt;%&ndash;<script src="datatables/js/dataTables.bootstrap5.min.js"></script>&ndash;%&gt;--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"--%>
<%--        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--<script src="../../jquery/jquery-3.5.1.min.js"></script>--%>
<%--<script src="../../datatables/js/jquery.dataTables.min.js"></script>--%>
<%--<script src="../../datatables/js/dataTables.bootstrap5.js"></script>--%>
</body>
</html>
</body>
</html>
