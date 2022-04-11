<%-- 
    Document   : AdminPage
    Created on : Feb 3, 2022, 4:07:22 PM
    Author     : 845593
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
        <link rel="stylesheet" type="text/css" href="assets/css/admin.css">


        <title>JSP Page</title>
    </head>
    <body>
        <!-- Header -->

        <header>
            <!-- Navbar -->
            <nav class="navbar navbar-expand-lg navbar-light bg-danger">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <span class="navbar-text">
                            <b>ADMIN PAGE</b>
                        </span>
                    </div>
                    <a href="/Welcome?logout" class="btn btn-success navbar-btn">Logout</a>

                </div>
                </div>
            </nav>
            <!-- Navbar -->

        </header>





        <div class="container-fluid">
            <div class="container-position">
                <!-- Admin Function Menu Section -->
                <div class="col d-flex justify-content-center">

                    <div class="card bg-light mb-3" style="width: 900px;">

                        <!-- Top Section -->
                        <div class="card bg-light mb-3">
                            <h5 class="card-header">Admin Function Menu</h5>
                            <div class="card-group">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">Event Management Page</h5>
                                        <p class="card-text">ADD New Event, EDIT Existed Event, DELETE Event</p>
                                        <a href="/EditEvent" class="btn btn-success">Edit Event</a>
                                    </div>
                                </div>
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">Volunteer Management Page</h5>
                                        <p class="card-text">EDIT Volunteer Shift , Download Volunteer Report</p>
                                        <a href="/EditProfile" class="btn btn-primary">Edit Volunteer</a>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <!-- Backup and Restore Section -->
                        <div class="card bg-light mb-3">
                            <h5 class="card-header">Backup and Restore Section</h5>
                            <div class="card-group">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">Backup Section</h5>
                                        <p class="card-text"> Click the "BACKUP" button to backup the database information</p>

                                        <form class="btn btn-danger" method="POST" action="TESTINGBackup">
                                            <input type="submit" value="backup">
                                        </form>
    <p>
                ${backupMessage}
            </p>

                                    </div>
                                </div>
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">Restore Section</h5>
                                        <p class="card-text">Click the "RESTORE" button to backup the database information</p>


                                        <form class="btn btn-danger" method="GET" action="TestRestore" >


                                            <input type="submit" value="restore">

                                        </form>
    <p>
                ${restoreMessage}
            </p>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                </div>


            </div>




        



            <br/>

        </div>



    </body>
</html>
