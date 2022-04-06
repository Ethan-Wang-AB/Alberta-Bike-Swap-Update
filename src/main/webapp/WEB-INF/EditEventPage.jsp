<%-- 
    Document   : EditEventPage
    Created on : Feb 3, 2022, 4:06:28 PM
    Author     : 845593
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.text.SimpleDateFormat" %>
<% SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="assets/css/EditEventPageStyle.css">
        <title>Admin Event Management page</title>
    </head>
    <body>
        <h1>Event page</h1>
        <%-- Add Event form--%>
        <div>
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
                    <label for="day1time">Choose Day 1 Time:</label>
                    <input type="time" id="day1time" name="day1time"
                           min="06:00" max="21:00" required><br/>
                    <label for="day1time">Choose Day 2 Time:</label>
                    <input type="time" id="day2time" name="day2time"
                           min="06:00" max="21:00" required><br/>
                     <label for="address">Address</label>
                    <input type="text" id="address" name="address" required>
                    <input type="submit" value="Add new event">       

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

        <%-- Edit Even form--%>
        <div>
            <h2>Edit Event</h2>
            <form action="" method="POST">
                <input type="hidden" name="action" value="edit">
                <fieldset>
                    <label for="fname">Event id:</label><br>
                    <input type="number" id="eventid" name="eventid"><br>

                    <label for="location">Choose a location:</label>
                    <select id="location_edit" name="location_edit">
                        <option value="1">Calgary</option>
                        <option value="3">Edmonton</option>
                        <option value="2">Lethbridge</option>
                    </select>
                    <br/>
                    <label for="start">Event date:</label>

                    <input type="date" id="start" name="trip-start_edit" value="2022-01-01" accept=""
                           min="2018-01-01" max="2100-12-31">
                    <br/>
                    <label for="day1time">Choose Day 1 Time:</label>
                    <input type="time" id="day1time" name="day1time_edit"
                           min="06:00" max="21:00" required><br/>
                    <label for="day1time">Choose Day 2 Time:</label>
                    <input type="time" id="day2time" name="day2time_edit"
                           min="06:00" max="21:00" required><br/>
                  
                    <label for="address">Address</label>
                    <input type="text" id="address" name="address_edit" required>
                      <input type="submit" value="Edit event"> 
                </fieldset>
            </form>

        </div>

        <%-- Even Information--%>
        <div class="wrapper">
            <div class ="box box2">
                <h2>Event Details</h2>
                <%-- operation message--%>
                Message: ${message}<br/><br/>
                <table border="1">
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



    </body>
</html>
