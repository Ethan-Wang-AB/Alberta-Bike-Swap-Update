<%--
  Created by IntelliJ IDEA.
  User: 806509
  Date: 5/20/2021
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Varela+Round&display=swap" rel="stylesheet">

    <title>Calgary | Alberta Bike Swap</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.0.272/jspdf.debug.js"></script>

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" type="text/css" href="../assets/css/locations.css">
</head>
<body >
    <%@include file="header.jsp"%>
    <script type="text/javascript">$('#home').addClass('active')</script>
    <script type="text/javascript" src="../assets/js/locationJS.js"></script>
  <script type="text/javascript" src="../assets/js/locationsPoster.js"></script>
    <div class="container-fluid parallax" id="cityPage">
        <div class="row city" >
            <div class="row justify-content-center">
                <div class="col-md-7 offset-md-4" id="menu">
                    <div class="list-group col collapse" id="collapseOpen"></div>
                </div>
            </div>

            <div class="row justify-content-center loading-event">
                <div class="col-sm-auto spinner-border text-light" style="width: 3rem; height: 3rem;" role="status">
                    <span class="visually-hidden">Loading...</span>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-1 offset-md-3 city-info hidden"><h5>Where:</h5></div>
                <div class="col-sm"><h4 id="address"></h4></div>
                <div class="w-100"></div>
                <div class="col-sm-1 offset-md-3 city-info hidden"><h5>When:</h5></div>
                <div class="col-sm"><h4 id="date"></h4></div>
                <div class="w-100"></div>
                <div class="col-sm-1 offset-md-3 city-info hidden"><h5>Consign:</h5></div>
                <div class="col-sm"><h4 id="consign"></h4></div>
                <div class="w-100"></div>
                <div class="col-sm-1 offset-md-3 city-info hidden"><h5>Buy:</h5></div>
                <div class="col-sm"><h4 id="buy"></h4></div>
                <div class="w-100"></div>
                <div class="col-sm-1 offset-md-3 city-info hidden"><h5>Donate:</h5></div>
                <div class="col-sm"><h4 id="donate"></h4></div>
                <div class="col-sm"> <button type="button" class="btn btn-info city-info hidden" id="download" onclick="locationsApp.genPDF()">Download Poster</button>
                </div>
            </div>
        </div>
    </div>

    <div class="container pb-3" >
        <h4 class="header">Announcements</h4>
        <div class="card mb-3 post shadow">

<!--            <div class="row justify-content-center loading-announcement">
                <div class="col-sm-auto spinner-border m-5" style="width: 3rem; height: 3rem;" role="status">
                    <span class="visually-hidden">Loading...</span>
                </div>
            </div>-->

            <div class="row g-3" id="announcement">
<!--                <div class="col-md-4 post-pic-div hidden text-center" id="announcementPicture"></div>-->
                <div class="col-md-8 post-body ">
                    <div class="card-body">
                        <h5 class="card-title" id="announcementTitle"></h5>
                        <p class="card-text postedon"><small class="text-muted">Posted on </small><small id="announcementDate"></small></p>
                        <p class="card-text" id="announcementBody"></p>
<%--                        <button type="button" class="btn shadow-none read-more">READ MORE</button>--%>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@include file="footer.jsp"%>
</body>
</html>
