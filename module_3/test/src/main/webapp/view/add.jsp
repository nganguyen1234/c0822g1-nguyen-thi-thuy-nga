<%--
  Created by IntelliJ IDEA.
  User: Nga
  Date: 12/12/2022
  Time: 8:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Thêm mới</title>
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
                        <a href="/mat-bang">
                            <img src="https://img.icons8.com/offices/30/null/plus-2-math.png"/>
                        </a>
                    </div>
                    <div class="col-lg-3">
                        <p >${mess}</p>
                </div>
            </div>
        </nav>
    </div>
    <%-------------------------------------------------------------  main content--------------------------------------------------------%>
    <div class="row main vh-100">
        <%-------------------------------------------------------------      list-------------------------------------------------------------%>
        <div class="col-lg-3 overflow-scroll" style="border: 1px solid black">
            <ul class="list-group">
                <li class="list-group-item">An item</li>
                <li class="list-group-item">A second item</li>
                <li class="list-group-item">A third item</li>
                <li class="list-group-item">A fourth item</li>
                <li class="list-group-item">And a fifth one</li>
            </ul>
        </div>
        <%-----------------------------------------------------------  content-------------------------------------------------------------------%>
        <div class="col-lg-9">
            <form action="/mat-bang?action=themMoi" method="post">
                <div class="modal-body">
                    <form class="vh-100">
                        <div class="mb-3">
                            <label class="form-label">Mã mặt bằng</label>
                            <input type="text" pattern="[\dA-Z]{3}-[\dA-Z]{2}-[\dA-Z]{2}"  class="form-control" name="maMatBang" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Diện tích</label>
                            <input type="text"  class="form-control"
                                   name="dienTich" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Trạng thái</label>
                            <select class="form-select"
                                    aria-label="Example select with button addon" name="trangThai">
                                <c:forEach var="type" items="${trangThaiList}">
                                    <option value="${type.maTrangThai}">${type.trangThai}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Tầng</label>
                            <input type="text"  class="form-control" name="tang"
                                   required>
                            <%--                            <c:if test="${!errorMap.isEmpty}">--%>
                            <%--                                <p style="color: red">${errorMap.get("idCard")}</p>--%>
                            <%--                            </c:if>--%>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Loại văn phòng</label>
                            <select class="form-select"
                                    aria-label="Example select with button addon" name="loaiVanPhong">
                                <c:forEach var="type" items="${loaiMatBangList}">
                                    <option value="${type.maLoai}">${type.tenLoai}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Mô tả chi tiết</label>
                            <input type="text"
                                   class="form-control" name="moTa"
                                   required>
                            <%--                            <c:if test="${!errorMap.isEmpty}">--%>
                            <%--                                <p style="color: red">${errorMap.get("email")}</p>--%>
                            <%--                            </c:if>--%>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Gía cho thuê</label>
                            <input type="text" class="form-control" name="gia"
                                   required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Ngày bắt đầu</label>
                            <input type="date" class="form-control" name="ngayBatDau"
                                   required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Ngày kết thúc</label>
                            <input type="date" class="form-control" name="ngayKetThuc"
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
    <%-----------------------------------------------------------  footer-----------------------------------------------------------------------%>
    <div class="row " id="footer">@copyright by me</div>

</body>
</html>
