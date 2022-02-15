<%-- 
    Document   : newjsp
    Created on : Feb 8, 2022, 5:53:39 PM
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
        <title>Alberta Bike Swap | Registration Page</title>

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

        <!-- javascript-->        
        <script type="text/javascript" src="assets/script/regitrationPage.js"></script>
    </head>

    <body>
        <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
            <div class="wrapper wrapper--w790">
                <div class="card card-5">
                    <div class="card-heading">
                        <h2 class="title">Event Registration Form</h2>
                    </div>
                    <div class="card-body">
                        <form method="POST">
                            <div class="form-row m-b-55">
                                <div class="name">Name</div>
                                <div class="value">
                                    <div class="row row-space">
                                        <div class="col-2">
                                            <div class="input-group-desc">
                                                <input class="input--style-5" type="text" name="first_name">
                                                <label class="label--desc">first name</label>
                                            </div>
                                        </div>
                                        <div class="col-2">
                                            <div class="input-group-desc">
                                                <input class="input--style-5" type="text" name="last_name">
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
                                        <input class="input--style-5" type="email" name="email">
                                    </div>
                                </div>
                            </div>
                            <div class="form-row m-b-55">
                                <div class="name">Phone</div>
                                <div class="value">
                                    <div class="row row-refine">
                                        <div class="col-3">
                                            <div class="input-group-desc">
                                                <input class="input--style-5" type="text" name="area_code">
                                                <label class="label--desc">Area Code</label>
                                            </div>
                                        </div>
                                        <div class="col-9">
                                            <div class="input-group-desc">
                                                <input class="input--style-5" type="text" name="phone">
                                                <label class="label--desc">Phone Number</label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Event Location</div>
                                <div class="value">
                                    <div class="input-group">
                                        <div class="rs-select2 js-select-simple select--no-search">
                                            <select name="location">
                                                <option disabled="disabled" selected="selected">Choose your location</option>
                                                <option value="1">Edmonton</option>
                                                <option value="2">Calgary</option>
                                                <option value="3">Lethbridge</option>
                                            </select>
                                            <div class="select-dropdown"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row p-t-20">
                                <label class="label label--block">Do you want to register as a bike seller or / and volunteer?</label>
                                <div class="p-t-15">
                                    <label class="radio-container m-r-55">Bike Seller
                                        <input type="checkbox" id="Seller" name = "bikeSeller" onclick="myBfunction()">
                                        <span class="checkmark"></span>
                                    </label>
                                    <label class="radio-container">volunteer
                                        <input type="checkbox" id="volunteer" name = "volunteer" onclick="myVfunction()">
                                        <span class="checkmark"></span>
                                    </label>
                                </div>
                            </div>
                            <br/>
                            <br/>


                            <!-- bike section-->  
                            <div id="bikesection" style="display:none">
                            <h2> Bike Information Section</h2>
                            <br/> <br/>

                                <div class="form-row">
                                    <div class="name">How many bike you want to sell?</div>
                                    <div class="value">
                                        <div class="input-group">
                                            <div class="rs-select2 js-select-simple select--no-search">
                                                <select name="location"  onchange="displayDivDemo('hideValuesOnSelect', this)" >
                                                    <option disabled="disabled" selected="selected" >Choose the amount of bike</option>
                                                    <option value=""></option>
                                                    <option value="01">1</option>
                                                    <option value="02">2</option>
                                                    <option value="03">3</option>
                                                    <option value="04">4</option>
                                                    <option value="05">5</option>
                                                </select>
                                                <div class="select-dropdown"></div>
                                            </div>
                                        </div>
                                    </div>

                                    <div id="hideValuesOnSelect">
                                        <div class="form-row p-t-20">
                                            <div id="value">
                                                <div class="form-row">
                                                    <div class="name">Bike Index</div>
                                                    <div class="value">
                                                        <div class="input-group">
                                                            <input class="input--style-5" type="text" name="bikeindex">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-row">
                                                    <div class="name">Bike Make</div>
                                                    <div class="value">
                                                        <div class="input-group">
                                                            <input class="input--style-5" type="email" name="bikemake">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-row">
                                                    <div class="name">Bike Type</div>
                                                    <div class="value">
                                                        <div class="input-group">
                                                            <input class="input--style-5" type="email" name="biketype">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-row">
                                                    <div class="name">What is the bike's size?</div>
                                                    <div class="value">
                                                        <div class="input-group">
                                                            <div class="rs-select2 js-select-simple select--no-search">
                                                                <select name="bikesize" >
                                                                    <option disabled="disabled" selected="selected" >Choose the bike size</option>
                                                                    <option value=""></option>
                                                                    <option value="01">S</option>
                                                                    <option value="02">M</option>
                                                                    <option value="03">L</option>

                                                                </select>
                                                                <div class="select-dropdown"></div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>    
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- volunteer section -->
                            <div id="volunteersection" style="display:none">
                             <h2> Volunteer Section</h2>
                            <br/> <br/>

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
                                                    <option value=""></option>
                                                    <option value="1">Volunteer / Admin Desk - Supports volunteers and is central point for emergency services (AM/PM)</option>
                                                    <option value="2">Food Volunteer – Calgary Only - Manages volunteer food and drinks in the break area (AM/PM)</option>
                                                    <option value="3">Safety / Security - manages safe access to the venue and monitors for emergency situations (AM/PM)</option>
                                                    <option value="4">Bike Receiver - stationed at curb and is the first point of contact for bike Sellers and Donators (AM/PM)</option>
                                                    <option value="5">Screener - knows bikes and is able to identify bikes that will not pass the tech check (AM/PM)</option>
                                                    <option value="6">Bike Tech - follows the Swap checklist to ensure bikes are safe and not worn out (AM/PM)</option>
                                                    <option value="7">Scribe - touches nearly every bike at the swap by recording serial numbers, makes, models, colour (AM/PM)</option>
                                                    <option value="8">Placer - moves bikes from the staging racks to the sales racks and places them by type (AM/PM)</option>
                                                    <option value="9">Dream Fulfillment (Sales) - helps people find their perfect bike (PM)</option>
                                                    <option value="10">Line Manager - chats with happy people who found their perfect bike, directs people to the cash-only line. (PM)</option>
                                                    <option value="11">Gatekeeper - keeps the checkout line near the computers moving (PM)</option>
                                                    <option value="12">Data Tracker - loves to organize paper and understands efficiency and data completeness (AM/PM)</option>
                                                    <option value="13">Rack Admin - manages / collects rack fees and AMA data (AM 8 AM - 2PM)</option>
                                                    <option value="14">Computer Op - inputs seller data, processes sales data for receipts (AM/PM)</option>
                                                    <option value="15">Transaction Support - reviews paperwork with Seller & Buyers (AM/PM)</option>
                                                    <option value="16">Floater - Gets to do a little of everything (AM/PM)</option>
                                                    <option value="17">NEW! Day of the event social media wiz in Facebook, Twitter, and Instagram (must pass splleing tst)</option>
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
                                                    <option value="1">Volunteer / Admin Desk - Supports volunteers and is central point for emergency services (AM/PM)</option>
                                                    <option value="2">Food Volunteer – Calgary Only - Manages volunteer food and drinks in the break area (AM/PM)</option>
                                                    <option value="3">Safety / Security - manages safe access to the venue and monitors for emergency situations (AM/PM)</option>
                                                    <option value="4">Bike Receiver - stationed at curb and is the first point of contact for bike Sellers and Donators (AM/PM)</option>
                                                    <option value="5">Screener - knows bikes and is able to identify bikes that will not pass the tech check (AM/PM)</option>
                                                    <option value="6">Bike Tech - follows the Swap checklist to ensure bikes are safe and not worn out (AM/PM)</option>
                                                    <option value="7">Scribe - touches nearly every bike at the swap by recording serial numbers, makes, models, colour (AM/PM)</option>
                                                    <option value="8">Placer - moves bikes from the staging racks to the sales racks and places them by type (AM/PM)</option>
                                                    <option value="9">Dream Fulfillment (Sales) - helps people find their perfect bike (PM)</option>
                                                    <option value="10">Line Manager - chats with happy people who found their perfect bike, directs people to the cash-only line. (PM)</option>
                                                    <option value="11">Gatekeeper - keeps the checkout line near the computers moving (PM)</option>
                                                    <option value="12">Data Tracker - loves to organize paper and understands efficiency and data completeness (AM/PM)</option>
                                                    <option value="13">Rack Admin - manages / collects rack fees and AMA data (AM 8 AM - 2PM)</option>
                                                    <option value="14">Computer Op - inputs seller data, processes sales data for receipts (AM/PM)</option>
                                                    <option value="15">Transaction Support - reviews paperwork with Seller & Buyers (AM/PM)</option>
                                                    <option value="16">Floater - Gets to do a little of everything (AM/PM)</option>
                                                    <option value="17">NEW! Day of the event social media wiz in Facebook, Twitter, and Instagram (must pass splleing tst)</option>
                                                </select>
                                                <div class="select-dropdown"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>


                                
                                 <div class="form-row">
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
                                





                            </div>




                            <!-- submit box section -->
                            <div>
                                <button class="btn btn--radius-2 btn--red" type="submit">Register</button>
                            </div>
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