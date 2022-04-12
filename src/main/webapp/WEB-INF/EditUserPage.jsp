<%-- 
    Document   : EditUserPage
    Created on : Feb 3, 2022, 4:06:18 PM
    Author     : 845593
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
        <title>Alberta Bike Swap | Change Personal Information</title>

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

              
        </head>

    <body>
        <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
            <div class="wrapper wrapper--w790">
                <div class="card card-5">
                    <div class="card-heading">
                        <h2 class="title">Change Personal Information</h2>
                    </div>
                    <div class="card-body">
                        <form method="POST" action="">
                            <div class="form-row m-b-55">
                                <div class="name">Name</div>
                                <div class="value">
                                    <div class="row row-space">
                                        <div class="col-2">
                                            <div class="input-group-desc">
                                                <input class="input--style-5" type="text" name="first_name" value="${firstName}">
                                                <label class="label--desc">first name</label>
                                            </div>
                                        </div>
                                        <div class="col-2">
                                            <div class="input-group-desc">
                                                <input class="input--style-5" type="text" name="last_name" value="${lastName}">
                                                <label class="label--desc">last name</label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Email</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-5" type="email" name="email" value="${email}">
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Password</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-5" type="password" name="password">
                                    </div>
                                </div>
                            </div>
                            <div class="form-row m-b-55">
                                <div class="name">Phone</div>
                                <div class="value">
                                    <div class="row row-refine">
                                        <div class="col-3">
                                            <div class="input-group-desc">
                                                <input class="input--style-5" type="number" name="area_code" value="${areaCode}">
                                                <label class="label--desc">Area Code</label>
                                            </div>
                                        </div>
                                        <div class="col-9">
                                            <div class="input-group-desc">
                                                <input class="input--style-5" type="phone" name="phone" value="${phone}">
                                                <label class="label--desc">Phone Number</label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">City</div>
                                <div class="value">
                                    <div class="input-group">
                                        <div class="rs-select2 js-select-simple select--no-search">
                                            <select name="location">
                                                <option disabled="disabled" selected="selected">Choose your location</option>
                                                <option value="3">Edmonton</option>
                                                <option value="1">Calgary</option>
                                                <option value="2">Lethbridge</option>
                                            </select>
                                            <div class="select-dropdown"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Address</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-5" type="text" name="address" value="${address}">
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

                            <!-- submit box section -->
                            <div>
                                <input type="hidden" name="action" value="Change">
                                <button class="btn btn--radius-2 btn--red" type="submit">Change</button>
                            </div>
                        </form>
                        <form action="" method="POST">
                                <input type="hidden" name="action" value="Profile">
                                <button class="btn btn--radius-2 btn--green" type="submit">Return to Profile</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Jquery JS-->
        <script src="assets/vendor/jquery/jquery.min.js"></script>
        <!-- Vendor JS-->
        <script src="assets/vendor/select2/select2.min.js"></script>
        <script src="assets/vendor/datepicker/moment.min.js"></script>
        <script src="assets/vendor/datepicker/daterangepicker.js"></script>

        <!-- Main JS-->
        <script src="assets/js/global.js"></script>

    </body>

</html>
<!-- end document-->