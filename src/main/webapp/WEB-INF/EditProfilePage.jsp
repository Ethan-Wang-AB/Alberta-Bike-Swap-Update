<%-- 
    Document   : EditProfilePage
    Created on : Feb 15, 2022, 12:10:04 AM
    Author     : aphks
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- Title Page-->
        <title>Alberta Bike Swap | Admin Volunteer Management Page</title>

    </head>

    <body>

        <h1>Volunteer Manage</h1>

        <div>
            <h2>Download Volunteer Information Report</h2>
            <button type="submit" formaction="URL">Download Report</button>
           
        </div>


        <%-- Volunteer Information--%>
        <div>
            <h2>Volunteer Details</h2>
            <table border="1">
                <tr>
                    <th>Volunteer ID</th>
                    <th>Name</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>T-shirt Size</th>
                    <th>1st Position Choice</th>
                    <th>2st Position Choice</th>
                    <th>Final Assign position</th>
                </tr>
               
                    <tr>
                        <td>${volunteerid}</td>
                        <td>${name}</td>
                        <td>${phone}</td>
                        <td>${email}</td>
                        <td>${tshirtsize}</td>
                        <td align="center">1stPositionChoice${renameelement[2]}</td>
                        <td align="center">2ndPositionChoice${renameelement[3]}</td>
                        <td align="center">
                            <form action="action">
                            <input list="finalshift" name="finalshift">
                            <datalist id="finalshift">
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
                                                    <option value="17">Event social media wiz</option>
                            </datalist>
                            <input type="submit">
                            </form></td>
                    </tr>
                  
            </table>

        </div> <br/>

        <%-- operation message--%>
        Message :${message}

        <c:forEach var="event" items="${volunteerdata}">
            </c:forEach>

    </body>

</html>
<!-- end document-->