<%--
  Created by IntelliJ IDEA.
  User: Nga
  Date: 12/1/2022
  Time: 12:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Contract list</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
        <div class="col-lg-9">
            <div class="row">
                <h4>Contract list</h4>
            </div>
            <div class="row justify-content-center">
                <div class="col-lg-4">
                    <form class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
                <div class="col-lg-4">
                    <button type="button" class="btn btn-light" data-bs-toggle="modal"
                            data-bs-target="#addDetailContract">
                        <img src="https://img.icons8.com/offices/30/null/plus-2-math.png"/>
                    </button>
                </div>
            </div>
            <div class="row">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Service</th>
                        <th scope="col">Customer</th>
                        <th scope="col">Start date</th>
                        <th scope="col">End date</th>
                        <th scope="col">Deposit</th>
                        <th scope="col">Total</th>
                        <th scope="col">Attach facility</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="detailContract" items="${detailContractList}" varStatus="stt">
                        <tr>
                            <td>${stt.count}</td>
                            <td>${detailContract.contract.facility.name}</td>
                            <td>${detailContract.contract.customer.name}</td>
                            <td>${detailContract.contract.startDate}</td>
                            <td>${detailContract.contract.endDate}</td>
                            <td>${detailContract.contract.deposit}</td>
                            <td></td>
                            <td>
                                <button type="button" class="btn btn-light" data-bs-toggle="modal"
                                        data-bs-target="#addAttachFacility">
                                    <img src="https://img.icons8.com/offices/30/null/plus-2-math.png"/>
                                </button>
                                <button type="button" onclick="getAttachFacilityInfo('${detailContract.attachFacility.name}','${detailContract.attachFacility.cost}','${detailContract.attachFacility.unit}','${detailContract.attachFacility.status}')" class="btn btn-light" data-bs-toggle="modal"
                                        data-bs-target="#dislayAttachFacility">
                                    Attach facility list
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="row " id="footer">@copyright by me</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<%--<c:import url="add_detail_ct_modal.jsp"></c:import>--%>
<%----------------------------------------------add detail contract modal----------------------------------------------%>
<div class="modal fade" id="addDetailContract" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add detail contract</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form class="vh-100" >
                    <div class="mb-3">
                        <label class="form-label">Start date</label>
                        <input type="text" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">End date</label>
                        <input type="text" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Deposit</label>
                        <input type="text" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Total</label>
                        <input class="form-control" type="text"  aria-label="Disabled input example" disabled readonly>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Customer</label>
                        <select class="form-select" aria-label="Default select example">
                            <option value="1">One</option>
                            <option value="2">Two</option>
                            <option value="3">Three</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Service</label>
                        <select class="form-select" aria-label="Default select example">
                            <option value="1">One</option>
                            <option value="2">Two</option>
                            <option value="3">Three</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Attach facility</label>
                        <button type="button" class="btn btn-light" data-bs-toggle="modal" data-bs-target="#addAttachFacility">
                            <img src="https://img.icons8.com/offices/30/null/plus-2-math.png"/>
                        </button>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
<%-----------------------------------------------------attach facility modal--------------------------------------------%>
<div class="modal fade" id="addAttachFacility" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" >Add attach facility</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form>

                    <select class="form-select" aria-label="Default select example">
                        <c:forEach var="attachFacility" items="${attachFacilityList}">
                        <option value="${attachFacility.id}">${attachFacility.name}</option>
                        </c:forEach>
                    </select>

                    <div class="mb-3">
                        <label class="form-label">Quantity</label>
                        <input type="number" class="form-control">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="dislayAttachFacility" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" >Attach facility</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Name</th>
                        <th scope="col">Cost</th>
                        <th scope="col">Unit</th>
                        <th scope="col">Status</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td id="name"></td>
                        <td id="cost"></td>
                        <td id="unit"></td>
                        <td id="status"></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<script>
    function getAttachFacilityInfo(name,cost,unit,status) {
document.getElementById("name").innerText = name;
document.getElementById("cost").innerText = cost;
document.getElementById("unit").innerText = unit;
document.getElementById("status").innerText = status;
    }
</script>
</body>
</html>