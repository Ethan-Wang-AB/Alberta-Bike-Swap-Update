<%-- 
    Document   : EditEventPage
    Created on : Feb 3, 2022, 4:06:28 PM
    Author     : 845593
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="assets/css/EditEventPageStyle.css">
        <title>Admin Event Management page</title>
    </head>
    <body>

        <div class="wrapper">
            <div class="box box2">
                <h1>Event page</h1>
                <a href="#">Back to main</a>
                <br/><br/>
                <%-- Add Event form--%>
                <div class="container">
                    <div class="item">
                        <h2>Add Event</h2>
                        <form action="" method="POST">
                            <fieldset>
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
                                <label for="day1time">Choose Day 1 Time:</label>
                                <input type="time" id="day1time" name="day1time"
                                       min="06:00" max="21:00" required><br/>
                                <label for="day1time">Choose Day 2 Time:</label>
                                <input type="time" id="day2time" name="day2time"
                                       min="06:00" max="21:00" required><br/>
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
                                <label for="day1time">Choose Day 1 Time:</label>
                                <input type="time" id="day1time" name="day1time"
                                       min="06:00" max="21:00" required><br/>
                                <label for="day1time">Choose Day 2 Time:</label>
                                <input type="time" id="day2time" name="day2time"
                                       min="06:00" max="21:00" required><br/>
                                <input type="submit" value="Edit event"> 
                            </fieldset>
                        </form>
                    </div>

                </div>

                <br/><br/>

            </div>


        </div>


        <%-- Even Information--%>
        <div class="wrapper">
            <div class ="box box2">
                <h2>Event Details</h2>
                <%-- operation message--%>
                Message: ${message}<br/><br/>
                <table border="1">
                    <tr>
                        <th>Event ID</th>
                        <th>Location</th>
                        <th>Day1 Date</th>
                        <th>Day1 Time</th>
                        <th>Day2 Date</th>
                        <th>Day2 Time</th>
                        <th>Delete</th>

                    </tr>
                    <c:forEach var="event" items="${eventdata}">
                        <tr>
                            <td>${eventid}</td>
                            <td>${location}</td>
                            <td align="center">Day1Date ${employee[2]}</td>
                            <td align="center">$Day1Time{employee[3]}</td>
                            <td align="center">$Day2Date{employee[2]}</td>
                            <td align="center">$Day2Time{employee[3]}</td>
                            <td align="center">Delete $eventid</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>



    </body>
</html>
