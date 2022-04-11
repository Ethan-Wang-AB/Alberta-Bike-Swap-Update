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

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

        <!-- Optional stylesheet -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Varela+Round&display=swap" rel="stylesheet">

        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link rel="stylesheet" type="text/css" href="assets/css/locations.css">

        <title>Calgary | Alberta Bike Swap</title>


    </head>
    <body >

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        
        <!-- Optional JavaScript -->
        <script type="text/javascript">$('#home').addClass('active')</script>
        <script type="text/javascript" src="../assets/js/locationJS.js"></script>
        <script type="text/javascript" src="../assets/js/locationsPoster.js"></script>
                <%@include file="header.jsp"%>

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
                    <div class="col-sm"><h4 id="donate"></h4></div><br>
                    <div class="col-sm"> <button type="button" class="btn btn-info city-info hidden" id="goFaq" onclick="window.location.href = '/Faq'">Want to know more?</button>
                    </div>
                    <div class="col-sm"> <button type="button" class="btn btn-info city-info hidden" id="download" onclick="locationsApp.genPDF()">Download Poster</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="container pb-3" >
            <h4 class="header">Announcement</h4>
            <div class="card mb-3 post shadow">
                <div class="container">
                    <div class="card row flex-row">
<!--                        <img class="col-sm-4 card-img-start img-fluid p-0" src="https://albertabikeswap.ca/wp-content/uploads/2019/01/image.png" />-->
                        <div class="col-sm-8 card-body">

                            <div class="card-header">
                                <h5 class="card-title" id="announcementTitle"> Have you seen this video?</h5>
                            </div>
                            <div class="card-body">
                                <blockquote class="blockquote mb-0">
                                    <p class="card-text postedon"><small class="text-muted">Posted on </small><small id="announcementDate"></small> 2022-01-01</p>
                                    <p class="card-text" id="announcementBody">AMA's video about our co-founder Chris and Laura Grant and the Alberta Bike Swap Event!</p>

                                    <!-- Button trigger modal -->
                                    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModal">
                                        Click me to view the video!
                                    </button>

                                    <!-- Modal -->
                                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog modal-xl" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">This is AMA | Chris and Laura Grant</h5>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body text-center">
<!--                                                    <iframe width="560" height="315" src="https://www.youtube.com/embed/ZntnXr1p2p0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>-->

                                                </div>

                                            </div>
                                        </div>
                                    </div>

                                </blockquote>
                            </div>

                        </div>
                    </div>

                </div>




            </div>
        </div>

        <%@include file="footer.jsp"%>
    </body>
</html>
