<%-- 
    Document   : BikeInfoPage
    Created on : Feb 3, 2022, 4:07:58 PM
    Author     : 845593
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bike Live Feed | Alberta Bike Swap</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" />
        <link href="https://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Varela+Round&display=swap" rel="stylesheet">
        <link href="assets/css/sellBikeStyle.css" rel="stylesheet" />
        
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="assets/script/regitrationPage.js"></script>
    </head>
    <body>
        <%@include file="header.jsp"%>
        
        <div class="container bootdey">
            <div class ="pagesetter">
                <div class="col-md-3">
                    <section style="margin-top: 150px"class="panel">
                        <header class="panel-heading">
                            <h4>Filter by Price</h4> 
                        </header>
                        <div class="panel-body">
                            <form method="get" action="BikeInventory" role="form product-form">
                                <div class="form-group">
                                    <label>Price</label>
                                    <input type="number" id="minPrice" name="minPrice" min="0" placeholder="min price" class="form-control" />
                                    <input type="number" id="maxPrice" name="maxPrice" placeholder="max price" class="form-control" />

                                </div>
                                <button class="btn btn-success" type="submit">Filter</button>
                            </form>
                        </div>
                        <p class="pro-title text-center">${message}</p>
                    </section>
                </div>
                
                <div class="col-md-9">
<!--                    <section class="panel">
                        <div class="panel-body">
                            <div class="pull-right">
                                <ul class="pagination pagination-sm pro-page-list">
                                    <li><a href="#">1</a></li>
                                    <li><a href="#">2</a></li>
                                    <li><a href="#">3</a></li>
                                    <li><a href="#">»</a></li>
                                </ul>
                            </div>
                        </div>
                    </section>-->

                    <div class="row product-list">
                        <c:forEach var="bike" items="${bikes}">
                            <div class="col-md-4">
                                <section class="panel">
                                    <div class="pro-img-box">
                                        <img src="${bike.getPhotoPath()}" width="250" height="220" alt="" />
                                    </div>

                                    <div class="panel-body text-center">
                                        <h4>
                                            <p class="pro-title">
                                                Bike Information
                                            <p>
                                        </h4>
                                        <p class="bikeInfo">Bike Index: ${bike.getBikeIndex()}</p>
                                        <p class="bikeInfo">Bike Make: ${bike.getMaker()}</p>
                                        <p class="bikeInfo">Bike Model: ${bike.getModel()}</p>
                                        <p class="price">Price: $${bike.getPrice()}</p>
                                        <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#bikeModal${bike.getBikeIndex()}">
                                                Details
                                        </button>
                                <!-- Modal -->
                                        <div class="modal" id="bikeModal${bike.getBikeIndex()}" role="dialog" aria-labelledby="exampleModalLongTitle">
                                            <div class="modal-dialog modal-lg" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="exampleModalLongTitle">Bike Information</h5>
                                                </div>
                                            <div class="modal-body">
                                                <div>
                                                    <img src="${bike.getPhotoPath()}"  class="img-rounded img-responsive" alt="" />
                                                </div>
                                                <p class="bikeInfo">Bike Index: ${bike.getBikeIndex()}</p>
                                                <p class="bikeInfo">Bike Make: ${bike.getMaker()}</p>
                                                <p class="bikeInfo">Bike Model: ${bike.getModel()}</p>
                                                <p class="price">Price: $${bike.getPrice()}</p>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal">Close</button>
                                                <form method="POST" action="">
                                                <input type="hidden" name="action" value="Buy${bike.getBikeId()}">
                                                <input type="submit" class="btn btn-primary btn-lg" value="Buy!">
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
                                    </div>
                                </section>
                            </div>
                        </c:forEach>
                    </div>
                        <form method="POST" action="">
                            <input type="hidden" name="action" value="Prev${page}" />
                            <input type="submit" value="Previous Page" style="display:${prevDisplay}"/>
                        </form>
                        <form method="POST" action="" >
                            <input type="hidden" name="action" value="Next${page}"/>
                            <input type="submit" value="Next Page" style="display:${nextDisplay}"/>
                        </form>
                            <p>${listMessage}</p>
                </div>
            </div>
        </div>
        
        <%@include file="footer.jsp"%>

    </body>
</html>
