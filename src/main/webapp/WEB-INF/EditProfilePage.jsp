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
            <h2>Download Report</h2>
            <form action="Report" method="get"> 
                <input type="submit" value="Download Report">
                </form>
           
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
                     <th>Assigned</th>
                    <th>1st Choice</th>
                    <th>2st Choice</th>
                    <th>Final Assign</th>
                </tr>
                               <c:forEach var="user" items="${users}">
                               
                    <tr>
                        <td>${user.userId}</td>
                        <td>${user.name}</td>
                        <td>${user.cellNumber}</td>
                        <td>${user.email}</td>
                        <td>${user.shirtSize}</td>
                        <td>${user.roleId.roleName}</td>
                        <td align="center">${user.roleIdFirst.roleName}</td>
                        <td align="center">${user.roleIdSecond.roleName}</td>
                        <td align="center">
                            <form action="EditProfile" method="get">
                            <input type="hidden" name="userEmail" value="${user.email}">
                                <input list="finalshift" name="finalshift">
                             <datalist id="finalshift" >
                                  <c:forEach var="role" items="${roles}">

                                <option value="${role.roleId}">${role.roleName},${role.roleDescription}</option>
                                  </c:forEach>                 
                            </datalist>
                            <input type="submit">
                            </form></td>
                    </tr>
                  </c:forEach>
            </table>

        </div> <br/>

        <%-- operation message--%>
        Message :${message}

        <c:forEach var="event" items="${volunteerdata}">
            </c:forEach>

    </body>

</html>
<!-- end document-->