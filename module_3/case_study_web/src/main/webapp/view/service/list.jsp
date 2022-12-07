<%--
  Created by IntelliJ IDEA.
  User: Nga
  Date: 11/30/2022
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Service</title>
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
                            <a class="/service">Service</a>
                        </li>
                        <li class="nav-item">
                            <a class="/contract">Contract</a>
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
                <h4>Service list</h4>
            </div>
            <div class="row justify-content-center">
                <div class="col-lg-4">
                    <form class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
                <div class="col-lg-4">
                    <button type="button" class="btn btn-light" data-bs-toggle="modal" data-bs-target="#addService">
                        <img src="https://img.icons8.com/offices/30/null/plus-2-math.png"/>
                    </button>
                </div>
            </div>
            <div class="row">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Name</th>
                        <th scope="col">Area</th>
                        <th scope="col">Cost</th>
                        <th scope="col">Max people</th>
                        <th scope="col">Rent type</th>
                        <th scope="col">Standard room</th>
                        <th scope="col">Description other convenience</th>
                        <th scope="col">Pool area</th>
                        <th scope="col">Number of floors</th>
                        <th scope="col">Facility free</th>
                        <th scope="col">Edit</th>
                        <th scope="col">Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="facility" items="${facilityList}" varStatus="stt">
                    <tr>
                        <th scope="row">${stt.count}</th>
                        <td>${facility.name}</td>
                        <td>${facility.area}</td>
                        <td>${facility.cost}</td>
                        <td>${facility.maxPeople}</td>
                        <td>${facility.rentType.name}</td>
                        <td>${facility.standardRoom}</td>
                        <td>${facility.descriptionOtherConvenience}</td>
                        <td>${facility.poolArea}</td>
                        <td>${facility.numberOfFloors}</td>
                        <td>${facility.facilityFree}</td>
                        <td>
                            <button type="button" class="btn btn-light" data-bs-toggle="modal" data-bs-target="#editService">
                                <img src="https://img.icons8.com/external-anggara-basic-outline-anggara-putra/24/null/external-create-social-media-interface-anggara-basic-outline-anggara-putra.png"/>
                            </button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-light" data-bs-toggle="modal"
                                    data-bs-target="#deleteService">
                                <img src="https://img.icons8.com/ios-glyphs/30/null/trash--v1.png"/>
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
<%--<c:import url="add_modal.jsp"></c:import>--%>
<%--add modal--%>
<div class="modal fade" id="addService" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" >Add service information</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="mb-3">
                        <label class="form-label">Facility type</label>
                        <button type="button" onclick="showVillaAddForm()"  >Villa</button>
                        <button type="button" onclick="showHouseAddForm()">House</button>
                        <button type="button" onclick="showRoomAddForm()">Room</button>
                    </div>
                    <div class="mb-3" >
                        <label class="form-label">Name</label>
                        <input type="text" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Area</label>
                        <input type="text" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Cost</label>
                        <input type="text" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Max people</label>
                        <input type="text" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Rent type</label>
                        <input type="text" class="form-control">
                    </div>
                    <div class="mb-3" id="standardRoom">
                        <label class="form-label">Standard room</label>
                        <input type="text" class="form-control">
                    </div>
                    <div class="mb-3" id="descriptionOtherConvenience">
                        <label class="form-label">Description other convenience</label>
                        <input type="text" class="form-control">
                    </div>
                    <div class="mb-3" id="poolArea">
                        <label class="form-label">Pool area</label>
                        <input type="text" class="form-control">
                    </div>
                    <div class="mb-3" id="numberOfFloors">
                        <label class="form-label">Number of floors</label>
                        <input type="text" class="form-control">
                    </div>
                    <div class="mb-3" id="facilityFree">
                        <label class="form-label">Facility free</label>
                        <input type="text" class="form-control">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-danger">Save changes</button>
            </div>
        </div>
    </div>
</div>

<c:import url="edit_modal.jsp"></c:import>

<%--modal xóa--%>
<div class="modal fade" id="deleteService" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete service information</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Are you sure that you want to delete information of this service ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-danger">Delete</button>
            </div>
        </div>
    </div>
</div>
<script>
    function showVillaAddForm() {
        var facilityFree = document.getElementById("facilityFree");
        var standardRoom = document.getElementById("standardRoom");
        var descriptionOtherConvenience = document.getElementById("descriptionOtherConvenience");
        var poolArea = document.getElementById("poolArea");
        var numberOfFloors = document.getElementById("numberOfFloors");
            facilityFree.style.display = "none";
        standardRoom.style.display = "block";
        descriptionOtherConvenience.style.display = "block";
        poolArea.style.display = "block";
        numberOfFloors.style.display = "block";
    }
    function showHouseAddForm() {
        var facilityFree = document.getElementById("facilityFree");
        var standardRoom = document.getElementById("standardRoom");
        var descriptionOtherConvenience = document.getElementById("descriptionOtherConvenience");
        var poolArea = document.getElementById("poolArea");
        var numberOfFloors = document.getElementById("numberOfFloors");
        facilityFree.style.display = "none";
        standardRoom.style.display = "block";
        descriptionOtherConvenience.style.display = "block";
        poolArea.style.display = "none";
        numberOfFloors.style.display = "block";
    }
    function showRoomAddForm() {
        var poolArea = document.getElementById("poolArea");
        var standardRoom = document.getElementById("standardRoom");
        var descriptionOtherConvenience = document.getElementById("descriptionOtherConvenience");
        var numberOfFloors =document.getElementById("numberOfFloors");
        var facilityFree = document.getElementById("facilityFree");
            poolArea.style.display = "none";
            standardRoom.style.display = "none";
            descriptionOtherConvenience.style.display = "none";
            numberOfFloors.style.display = "none";
        facilityFree.style.display = "none";
        }

</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>