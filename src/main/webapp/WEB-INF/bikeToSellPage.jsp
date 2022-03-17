<%-- 
    Document   : bikeToSellPage
    Created on : Feb 3, 2022, 4:05:41 PM
    Author     : 845593
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/bikeToSellStyle.css" rel="stylesheet" />
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <link href="https://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
       <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" />


       <div class="container bootdey">
    <div class="col-md-3">
        <section class="panel">
            <header class="panel-heading">
                Category
            </header>
            <div class="panel-body">
                <ul class="nav prod-cat">
                    <li>
                        <a href="#" class="active"><i class="fa fa-angle-right"></i> Bike Information Size</a>
                        <ul class="nav">
                            <li class="active"><a href="#">- L</a></li>
                            <li><a href="#">- M</a></li>
                            <li><a href="#">- S</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-angle-right"></i> Bike Information Type</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-angle-right"></i> Other</a>
                    </li>

                </ul>
            </div>
        </section>
            <div class="panel-body sliders">
                <div id="slider-range" class="slider"></div>
                <div class="slider-info">
                    <span id="slider-range-amount"></span>
                </div>
            </div>
        </section>
        <section class="panel">
            <header class="panel-heading">
                Filter
            </header>
            <div class="panel-body">
                <form role="form product-form">
                    <div class="form-group">
                        <label>Color</label>
                        <select class="form-control hasCustomSelect" style="-webkit-appearance: menulist-button; width: 231px; position: absolute; opacity: 0; height: 34px; font-size: 12px;">
                            <option>White</option>
                            <option>Black</option>
                            <option>Red</option>
                            <option>Green</option>
                        </select>
                        <span class="customSelect form-control" style="display: inline-block;"><span class="customSelectInner" style="width: 209px; display: inline-block;">White</span></span>
                    </div>
                    <div class="form-group">
                        <label>Type</label>
                        <select class="form-control hasCustomSelect" style="-webkit-appearance: menulist-button; width: 231px; position: absolute; opacity: 0; height: 34px; font-size: 12px;">
                            <option>Small</option>
                            <option>Medium</option>
                            <option>Large</option>
                            <option>Extra Large</option>
                        </select>
                        <span class="customSelect form-control" style="display: inline-block;"><span class="customSelectInner" style="width: 209px; display: inline-block;">Small</span></span>
                    </div>
                    <button class="button" type="submit">Filter</button>
                </form>
            </div>
        </section>
        
    </div>
    <div class="col-md-9">
        <section class="panel">
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
        </section>

        <div class="row product-list">
            <div class="col-md-4">
                <section class="panel">
                    <div class="pro-img-box">
                         <img src="assets/img/bike/mainBG.jpg" width="250" height="220" alt="" />
                    </div>

                    <div class="panel-body text-center">
                        <h4>
                            <a href="#" class="pro-title">
                                Bike Information
                            </a>
                        </h4>
                        <p class="price">Bike ID</p>
                        <p class="price">$300.00</p>
                    </div>
                </section>
            </div>
            <div class="col-md-4">
                <section class="panel">
                    <div class="pro-img-box">
                         <img src="assets/img/bike/mainBG.jpg" width="250" height="220" alt="" />
                    </div>

                    <div class="panel-body text-center">
                        <h4>
                            <a href="#" class="pro-title">
                                Bike Information
                            </a>
                        </h4>
                        <p class="price">Bike ID</p>
                        <p class="price">$300.00</p>
                    </div>
                </section>
            </div>
            <div class="col-md-4">
                <section class="panel">
                    <div class="pro-img-box">
                         <img src="assets/img/bike/mainBG.jpg" width="250" height="220" alt="" />
                    </div>

                    <div class="panel-body text-center">
                        <h4>
                            <a href="#" class="pro-title">
                                Bike Information
                            </a>
                        </h4>
                        <p class="price">Bike ID</p>
                        <p class="price">$300.00</p>
                    </div>
                </section>
            </div>
            <div class="col-md-4">
                <section class="panel">
                    <div class="pro-img-box">
                         <img src="assets/img/bike/mainBG.jpg" width="250" height="220" alt="" />
                    </div>

                    <div class="panel-body text-center">
                        <h4>
                            <a href="#" class="pro-title">
                                Bike Information
                            </a>
                        </h4>
                        <p class="price">Bike ID</p>
                        <p class="price">$300.00</p>
                    </div>
                </section>
            </div>
            <div class="col-md-4">
                <section class="panel">
                    <div class="pro-img-box">
                         <img src="assets/img/bike/mainBG.jpg" width="250" height="220" alt="" />
                    </div>

                    <div class="panel-body text-center">
                        <h4>
                            <a href="#" class="pro-title">
                                Bike Information
                            </a>
                        </h4>
                        <p class="price">Bike ID</p>
                        <p class="price">$300.00</p>
                    </div>
                </section>
            </div>
            <div class="col-md-4">
                <section class="panel">
                    <div class="pro-img-box">
                         <img src="assets/img/bike/mainBG.jpg" width="250" height="220" alt="" />
                    </div>

                    <div class="panel-body text-center">
                        <h4>
                            <a href="#" class="pro-title">
                                Bike Information
                            </a>
                        </h4>
                        <p class="price">Bike ID</p>
                        <p class="price">$300.00</p>
                    </div>
                </section>
            </div>
            <div class="col-md-4">
                <section class="panel">
                    <div class="pro-img-box">
                         <img src="assets/img/bike/mainBG.jpg" width="250" height="220" alt="" />
                    </div>

                    <div class="panel-body text-center">
                        <h4>
                            <a href="#" class="pro-title">
                                Bike Information
                            </a>
                        </h4>
                        <p class="price">Bike ID</p>
                        <p class="price">$300.00</p>
                    </div>
                </section>
            </div>
            <div class="col-md-4">
                <section class="panel">
                    <div class="pro-img-box">
                         <img src="assets/img/bike/mainBG.jpg" width="250" height="220" alt="" />
                    </div>

                    <div class="panel-body text-center">
                        <h4>
                            <a href="#" class="pro-title">
                                Bike Information
                            </a>
                        </h4>
                        <p class="price">Bike ID</p>
                        <p class="price">$300.00</p>
                    </div>
                </section>
            </div>
            <div class="col-md-4">
                <section class="panel">
                    <div class="pro-img-box">
                         <img src="assets/img/bike/mainBG.jpg" width="250" height="220" alt="" />
                    </div>

                    <div class="panel-body text-center">
                        <h4>
                            <a href="#" class="pro-title">
                                Bike Information
                            </a>
                        </h4>
                        <p class="price">Bike ID</p>
                        <p class="price">$300.00</p>
                    </div>
                </section>
            </div>
            <div class="col-md-4">
                <section class="panel">
                    <div class="pro-img-box">
                         <img src="assets/img/bike/mainBG.jpg" width="250" height="220" alt="" />
                    </div>

                    <div class="panel-body text-center">
                        <h4>
                            <a href="#" class="pro-title">
                                Bike Information
                            </a>
                        </h4>
                        <p class="price">Bike ID</p>
                        <p class="price">$300.00</p>
                    </div>
                </section>
            </div>
            <div class="col-md-4">
                <section class="panel">
                    <div class="pro-img-box">
                         <img src="assets/img/bike/mainBG.jpg" width="250" height="220" alt="" />
                    </div>

                    <div class="panel-body text-center">
                        <h4>
                            <a href="#" class="pro-title">
                                Bike Information
                            </a>
                        </h4>
                        <p class="price">Bike ID</p>
                        <p class="price">$300.00</p>
                    </div>
                </section>
            </div>
            <div class="col-md-4">
                <section class="panel">
                    <div class="pro-img-box">
                         <img src="assets/img/bike/mainBG.jpg" width="250" height="220" alt="" />
                    </div>

                    <div class="panel-body text-center">
                        <h4>
                            <a href="#" class="pro-title">
                                Bike Information
                            </a>
                        </h4>
                        <p class="price">Bike ID</p>
                        <p class="price">$300.00</p>
                    </div>
                </section>
            </div>
            <div class="col-md-4">
                <section class="panel">
                    <div class="pro-img-box">
                         <img src="assets/img/bike/mainBG.jpg" width="250" height="220" alt="" />
                    </div>

                    <div class="panel-body text-center">
                        <h4>
                            <a href="#" class="pro-title">
                                Bike Information
                            </a>
                        </h4>
                        <p class="price">Bike ID</p>
                        <p class="price">$300.00</p>
                    </div>
                </section>
            </div>
            <div class="col-md-4">
                <section class="panel">
                    <div class="pro-img-box">
                         <img src="assets/img/bike/mainBG.jpg" width="250" height="220" alt="" />
                    </div>

                    <div class="panel-body text-center">
                        <h4>
                            <a href="#" class="pro-title">
                                Bike Information
                            </a>
                        </h4>
                        <p class="price">Bike ID</p>
                        <p class="price">$300.00</p>
                    </div>
                </section>
            </div>
            <div class="col-md-4">
                <section class="panel">
                    <div class="pro-img-box">
                         <img src="assets/img/bike/mainBG.jpg" width="250" height="220" alt="" />
                    </div>

                    <div class="panel-body text-center">
                        <h4>
                            <a href="#" class="pro-title">
                                Bike Information
                            </a>
                        </h4>
                        <p class="price">Bike ID</p>
                        <p class="price">$300.00</p>
                    </div>
                </section>
            </div>
        </div>
    </div>
</div>
    </body>
</html>

