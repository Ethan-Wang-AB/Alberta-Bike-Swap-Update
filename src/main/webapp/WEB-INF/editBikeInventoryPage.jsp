<%-- 
    Document   : editBikeInventoryPage
    Created on : Apr 11, 2022, 2:32:01 PM
    Author     : aphks
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <title>ADMIN PAGE | Bike Inventory </title>
    </head>
</head>
<body>

    <!-- Optional JavaScript -->
    <link rel="stylesheet" type="text/css" href="assets/css/admin.css">
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>



    <div class="container-fluid">
        <div class="container-position">
            
            
            <!-- Admin Bike Inventory Section -->
            <div class="col d-flex justify-content-center">
                <div class="card bg-light mb-3" style="width: 800px;">
                    <h5 class="card-header">Bike Inventory Menu</h5>
                    <div class="card-footer bg-transparent">
                        <a href="">Back to Admin Main Page</a></div>
                    <div class="card bg-light mb-3">  

                        <!-- Add Bike -->
                        <div class="card-group">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">Add New Bike</h5>
                                    <form>
                                        <div class="form-group">
                                            <label for="bikeMake">Bike Make</label>
                                            <input type="text" class="form-control" id="bikeMake" placeholder="Example input">
                                        </div>
                                        <div class="form-group">
                                            <label for="bikeModel">Bike Model</label>
                                            <input type="text" class="form-control" id="bikeModel" placeholder="Another input">
                                        </div>
                                        <div class="form-group">
                                            <label for="bikePrice">Bike Price</label>
                                            <input type="text" class="form-control" id="bikePrice" placeholder="Another input">
                                        </div>
                                        <button type="submit" class="btn btn-success">Add</button>
                                    </form>
                                </div>
                            </div>
                            <!-- End of Add Bike -->

                            <!-- Edit Bike form -->
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">Edit Bike</h5>
                                    <form>
                                        <div class="form-group">
                                            <label for="bikeid">Bike ID</label>
                                            <input type="text" class="form-control" id="bikeid" placeholder="Enter Bike ID">
                                        </div>
                                        <div class="form-group">
                                            <label for="bikeMake">Bike Make</label>
                                            <input type="text" class="form-control" id="bikeMake" placeholder="Example input">
                                        </div>
                                        <div class="form-group">
                                            <label for="bikeModel">Bike Model</label>
                                            <input type="text" class="form-control" id="bikeModel" placeholder="Enter Bike Model">
                                        </div>
                                        <div class="form-group">
                                            <label for="bikePrice">Bike Price</label>
                                            <input type="text" class="form-control" id="bikePrice" placeholder="Enter Price">
                                        </div>
                                        <button type="submit" class="btn btn-warning">Edit</button>
                                    </form>
                                </div>
                            </div>
                            
                            <!-- End of Edit Bike form -->
                            
                        </div>    
                    </div>
                </div>
            </div>
            <!-- End of Admin Bike Inventory Section -->

            <br/><br/>

            <!-- Bike Inventory Show Table -->
            <div class="container justify-content-center" >
                <div class="card-body bg-light">
                    <h5 class="card-header">Bike Inventory</h5>
                    <div class="card-footer bg-transparent">
                        <p>message:${Message}</p></div>

                    <table class="table table-striped">
                        <thead>
                        </thead>
                        <tbody>
                        <th>Bike ID</th>
                        <th>Bike Make</th>
                        <th>Bike Model</th>
                        <th>Bike Price</th>
                        <th>Action Delete</th>
                        </tbody>

                        <tr>
                            <td>Test${bike.getBikeIndex()}</td>
                            <td>Test${bike.getMaker()}</td>
                            <td>Test</td>
                            <td>$TestPrice ${oneItem.category}</td>
                            <td><a class="btn btn-danger"
                                   href="/deleteItem.action?itemName=${oneItem.name}&itemCategory=${oneItem.category}">Delete
                                </a></td>
                        </tr>
                    </table>
                </div>
            </div>
                                
           <!-- End of Bike Inventory Show Table -->  
           
        </div>
    </div>
   <!-- End of container -->     



</body>
</html>
