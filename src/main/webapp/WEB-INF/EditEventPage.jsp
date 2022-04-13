  
<%-- 
    Document   : EditEventPage
    Created on : Feb 3, 2022, 4:06:28 PM
    Author     : 845593
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.text.SimpleDateFormat" %>
<% SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");%>

<!DOCTYPE html>
<html>
    <head>

        <!-- Required meta tags -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


        <title>Admin Event Management page</title>
    </head>
    <body>

        <!-- Optional JavaScript -->
        <link rel="stylesheet" type="text/css" href="assets/css/EditEventPageStyle.css">
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>




        <div class="wrapper">
            <div class="box box2">
                <h1>Event page</h1>
                <a href="/admin">Back to main</a>
                <br/><br/>

                <%-- Add Event form--%>
                <div class="container">
                    <div class="item">
                        <h2>Add Event</h2>
                        <form action="" method="POST">
                            <input type="hidden" name="action" value="add">

                            <fieldset>
                                <label for="location">Choose a location:</label>
                                <select id="location" name="location">
                                    <option value="1">Calgary</option>
                                    <option value="3">Edmonton</option>
                                    <option value="2">Lethbridge</option>
                                </select>
                                <br/>
                                <label for="start">Event date:</label>

                                <input type="date" id="start" name="trip-start" value="2022-01-01" accept=""
                                       min="2018-01-01" max="2100-12-31">
                                <br/>
                                <label for="day1time">Input Day 1 Start Time to End Time:</label>
                                <input type="text" id="day1time" name="day1time"
                                       placeholder="8:00-17:00" required><br/>
                                <label for="day1time">Input Day 2 Start Time to End Time:</label>
                                <input type="text" id="day2time" name="day2time"
                                       placeholder="8:00-17:00" required><br/>
                                <label for="address">Address</label>
                                <input type="text" id="address" name="address" 
                                       placeholder="Calgary SunnySides" required>
                                <input type="submit" value="Add new event">       


                            </fieldset>
                        </form>
                    </div>

                    <%-- Edit Event form--%>
                    <div class="item">
                        <h2>Edit Event</h2>
                        <form action="" method="POST">
                            <fieldset>
                                <label for="fname">Event id:</label>
                                <input type="text" id="eventid" name="eventid"><br>

                                <label for="location">Choose a location:</label>
                                <select id="location" name="location">
                                    <option value="Calgary">Calgary</option>
                                    <option value="Edmonton">Edmonton</option>
                                    <option value="Lethbridge">Lethbridge</option>
                                </select>
                                <br/>
                                <label for="start">Event date:</label>

                                <input type="date" id="start" name="trip-start" value="2022-01-01" accept=""
                                       min="2018-01-01" max="2100-12-31">
                                <br/>
                                <label for="day1time">Input Day 1 Start Time to End Time:</label>
                                <input type="text" id="day1time" name="day1time"
                                       placeholder="8:00-17:00" required><br/>
                                <label for="day1time">Input Day 2 Start Time to End Time:</label>
                                <input type="text" id="day2time" name="day2time"
                                       placeholder="8:00-17:00" required><br/>
                                <label for="address">Address</label>
                                <input type="text" id="address" name="address" 
                                       placeholder="Calgary SunnySides" required>
                                <input type="submit" value="Edit event"> 
                            </fieldset>
                        </form>
                    </div>

                </div>

                <br/><br/>
            </div>
        </div>


        <%-- Even Information--%>
        <div class="container-fluid">
            <div class="container-position">
                <div class="container justify-content-center" >
                    <div class ="card" style="width: 900px;">
                        <div class="card-body bg-light">
                            <h5 class="card-header">Event Details</h5>
                            <div class="card-footer bg-transparent">
                                <p> Message: ${message}</p></div>

                            <table class="table table-striped">

                                <thead>
                                </thead>
                                <tbody>
                                <th>Event ID</th>
                                <th>Event Location</th>
                                <th>Day 1 </th>
                                <th>Time</th>
                                <th>Day 2</th>
                                <th>Time</th>
                                <th>Action Delete</th>
                                </tbody>
                                <c:forEach var="event" items="${eventdata}">
                                    <tr>
                                        <td>${event.eventDateId}</td>
                                        <td>${event.addressId.addressDetail}</td>
                                        <td align="center"> ${event.startDate.getYear()+1900}.${event.startDate.getMonth()+1}.${event.startDate.getDate()}</td>
                                        <td align="center">${event.scheduleDay1}</td>
                                        <td align="center">${event.endDate.getYear()+1900}.${event.endDate.getMonth()+1}.${event.endDate.getDate()}</td>
                                        <td align="center">${event.scheduleDay2}</td>
                                        <td align="center"><a href="EditEvent?delete&id=${event.eventDateId}">Delete</a></td>
                                    </tr>

                                </c:forEach>  
                            </table>
                        </div>
                    </div>

                </div>

            </div>
        </div>




    </body>
</html>
