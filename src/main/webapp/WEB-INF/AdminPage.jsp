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


        <title>Alberta Bike Swap | Admin Main Page</title>
    </head>
    <body>


        <!-- Header -->
        <div class="col d-flex justify-content-center">
            <div class="card text-white bg-danger mb-3" style="width: 800px;">
                <h5 class="card-header">Admin Function Menu</h5>
            </div>
            <div class="card-footer bg-success mb-3">
                <a href="#" class="btn btn-success">Logout</a>
            </div>

        </div>



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
                                <a href="#" class="btn btn-success">Edit Event</a>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Volunteer Management Page</h5>
                                <p class="card-text">EDIT Volunteer Shift , Download Volunteer Report</p>
                                <a href="#" class="btn btn-primary">Edit Volunteer</a>
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
                                <a href="#" class="btn btn-danger">Backup</a>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Restore Section</h5>
                                <p class="card-text">Click the "RESTORE" button to backup the database information</p>
                                <a href="#" class="btn btn-danger">Restore</a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

        <br/>

    </body>
</html>
