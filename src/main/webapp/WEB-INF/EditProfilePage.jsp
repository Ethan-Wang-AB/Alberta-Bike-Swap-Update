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


        <!-- Required meta tags -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <link rel="stylesheet" type="text/css" href="assets/css/admin.css">
    </head>

    <body>

        <!-- Optional JavaScript -->
        <link rel="stylesheet" type="text/css" href="assets/css/admin.css">
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <div class="container">
            <div class="container-position">
                <!-- Admin Bike Inventory Section -->
                <div class="card">
                    <h5 class="card-header">Volunteer Manager</h5>
                    <div class="card-footer text-muted">
                        <a href="/admin">Back to main</a>
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">Download Report</h5>
                        <form action="Report" method="get"> 
                            <input type="submit" value="Download Report">
                        </form>                      
                    </div>
                </div>
            </div>
        </div>

        <br/><br/>

        <%-- Volunteer Information--%>
        <div class="container-fluid">
            <div class="container-position">

                <div class="col d-flex justify-content-center">

                    <div class="card">
                        <h5 class="card-header">Volunteer Details</h5>
                        <div class="card-footer text-muted">
                            Message :${message}</a>
                        </div>

                        <div class="card-body bg-light">
                            <table class="table table-striped">
                                <thead>
                                </thead>
                                <tbody>
                                <th>Volunteer ID</th>
                                <th>Name</th>
                                <th>Phone</th>
                                <th>Email</th>
                                <th>T-shirt Size</th>
                                <th>Assigned</th>
                                <th>1st Choice</th>
                                <th>2nd Choice</th>
                                <th>Assign Role</th>
                                </tbody>
                                <c:forEach var="user" items="${users}">

                                    <tr>
                                        <td align="center">${user.userId}</td>
                                        <td align="center">${user.name}</td>
                                        <td align="center">${user.cellNumber}</td>
                                        <td align="center">${user.email}</td>
                                        <td align="center">${user.shirtSize}</td>
                                        <td align="center">${user.roleId.roleName}</td>
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
                                                </datalist></td>
                                        <td>
                                            <input class="btn btn--radius-1 btn--green" type="submit">
                                        </td>
                                        </form>
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
<!-- end document-->
