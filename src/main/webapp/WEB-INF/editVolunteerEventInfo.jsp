<%-- 
    Document   : editVEventInfo
    Created on : Mar 22, 2022, 7:20:13 PM
    Author     : aphks
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags-->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Title Page-->
        <title>Alberta Bike Swap | Change Volunteer Event Information</title>

        <!-- Icons font CSS-->
        <link href="assets/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
        <link href="assets/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
        <!-- Font special for pages-->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

        <!-- Vendor CSS-->
        <link href="assets/vendor/select2/select2.min.css" rel="stylesheet" media="all">
        <link href="assets/vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

        <!-- Main CSS-->
        <link href="assets/css/RegistionPagemainStyle.css" rel="stylesheet" media="all">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

    </head>

    <body>
        <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
            <div class="wrapper wrapper--w790">
                <div class="card card-5">
                    <div class="card-heading">
                        <h2 class="title">Change Event Information</h2>
                    </div>
                    <div class="card-body">
                        <form method="POST" action="registration">
                            <!-- volunteer section -->
                            <div id="volunteersection" >
                                <div class="form-row">
                                    <div class="name">Choose T-shirt size</div>
                                    <div class="value">
                                        <div class="input-group">
                                            <div class="rs-select2 js-select-simple select--no-search">
                                                <select name="tshirtsize" >
                                                    <option disabled="disabled" selected="selected" >Choose T-shirt size</option>
                                                    <option value=""></option>
                                                    <option value="1">S</option>
                                                    <option value="2">M</option>
                                                    <option value="3">L</option>
                                                    <option value="4">XL</option>
                                                    <option value="5">XXL</option>
                                                </select>
                                                <div class="select-dropdown"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-row">
                                    <div class="name">Dietary Restrictions</div>
                                    <div class="value">
                                        <div class="input-group">
                                            <div class="rs-select2 js-select-simple select--no-search">
                                                <select name="diet" >
                                                    <option disabled="disabled" selected="selected" >Choose Dietary Restriction</option>
                                                    <option value=""></option>
                                                    <option value="1">Vegetarian</option>
                                                    <option value="2">Gluten free</option>
                                                    <option value="3">No-dairy</option>
                                                    <option value="4">Nut sensitive</option>
                                                    <option value="5">Other</option>
                                                </select>
                                                <div class="select-dropdown"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                               
                                <div class="form-row">
                                    <div class="name">First Position Choice</div>
                                    <div class="value">
                                        <div class="input-group">
                                            <div class="rs-select2 js-select-simple select--no-search">
                                                <select name="firstposition" >
                                                    <option disabled="disabled" selected="selected" >Choose Your First Position Choice</option>
                                                    <option value="1">Volunteer / Admin Desk (AM/PM)</option>
                                                    <option value="2">Food Volunteer (AM/PM)</option>
                                                    <option value="3">Safety / Security (AM/PM)</option>
                                                    <option value="4">Bike Receiver (AM/PM)</option>
                                                    <option value="5">Screener (AM/PM)</option>
                                                    <option value="6">Bike Tech (AM/PM)</option>
                                                    <option value="7">Scribe (AM/PM)</option>
                                                    <option value="8">Placer (AM/PM)</option>
                                                    <option value="9">Dream Fulfillment (Sales)(PM)</option>
                                                    <option value="10">Line Manager (PM)</option>
                                                    <option value="11">Gatekeeper  (PM)</option>
                                                    <option value="12">Data Tracker (AM/PM)</option>
                                                    <option value="13">Rack Admin (AM 8 AM - 2PM)</option>
                                                    <option value="14">Computer Op (AM/PM)</option>
                                                    <option value="15">Transaction Support (AM/PM)</option>
                                                    <option value="16">Floater (AM/PM)</option>
                                                    <option value="17">NEW! Day of the event social media wiz</option>
                                                </select>
                                                <div class="select-dropdown"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>


                                <div class="form-row">
                                    <div class="name">Second Position Choice</div>
                                    <div class="value">
                                        <div class="input-group">
                                            <div class="rs-select2 js-select-simple select--no-search">
                                                <select name="secondposition" >
                                                    <option disabled="disabled" selected="selected" >Choose Your Second Position Choice</option>
                                                    <option value=""></option>
                                                    <option value="1">Volunteer / Admin Desk (AM/PM)</option>
                                                    <option value="2">Food Volunteer (AM/PM)</option>
                                                    <option value="3">Safety / Security (AM/PM)</option>
                                                    <option value="4">Bike Receiver (AM/PM)</option>
                                                    <option value="5">Screener (AM/PM)</option>
                                                    <option value="6">Bike Tech (AM/PM)</option>
                                                    <option value="7">Scribe (AM/PM)</option>
                                                    <option value="8">Placer (AM/PM)</option>
                                                    <option value="9">Dream Fulfillment (Sales)(PM)</option>
                                                    <option value="10">Line Manager (PM)</option>
                                                    <option value="11">Gatekeeper  (PM)</option>
                                                    <option value="12">Data Tracker (AM/PM)</option>
                                                    <option value="13">Rack Admin (AM 8 AM - 2PM)</option>
                                                    <option value="14">Computer Op (AM/PM)</option>
                                                    <option value="15">Transaction Support (AM/PM)</option>
                                                    <option value="16">Floater (AM/PM)</option>
                                                    <option value="17">NEW! Day of the event social media wiz</option>
                                                </select>
                                                <div class="select-dropdown"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            <br/>
                            <br/>
                            <c:if test="${errorMessage != null}">
                                <div
                                    class="alert alert-danger alert-dismissible fade show pb-2 pt-2 mt-3"
                                    role="alert"
                                    >
                                    <i class="bi bi-x-circle me-2"></i>
                                    ${errorMessage}
                                    <button
                                        type="button"
                                        class="btn-close btn-sm pb-1"
                                        data-bs-dismiss="alert"
                                        aria-label="Close"
                                        ></button>
                                </div>
                            </c:if>


                            



                                <!--                                <div class="form-row">
                                                                    <div class="name">City & Shift</div>
                                                                    <div class="value">
                                                                        <div class="input-group">
                                                                            <div class="rs-select2 js-select-simple select--no-search">
                                                                                <select name="Shift" >
                                                                                    <option disabled="disabled" selected="selected" >Choose City & Shift</option>
                                                                                    <option value=""></option>
                                                                                    <option value="1">Lethbridge / 12 PM - 6 PM</option>
                                                                                    <option value="2">Edmonton / 7 AM - 6 PM</option>
                                                                                    <option value="3">Edmonton / 7 AM - 12 PM</option>
                                                                                    <option value="4">Edmonton / 12 PM - 6 PM</option>
                                                                                </select>
                                                                                <div class="select-dropdown"></div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                -->






                            </div>




                            <!-- submit box section -->
                            <div>
                                <button class="btn btn--radius-2 btn--red" type="submit">Change</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>


        <!-- Vendor JS-->
        <script src="assets/vendor/select2/select2.min.js"></script>
        <script src="assets/vendor/datepicker/moment.min.js"></script>
        <script src="assets/vendor/datepicker/daterangepicker.js"></script>

        <!-- Main JS-->
        <script src="assets/js/global.js"></script>

    </body>

</html>
<!-- end document-->