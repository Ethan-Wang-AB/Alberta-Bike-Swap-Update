<%-- 
    Document   : volunteer.jst
    Created on : Feb 17, 2022, 1:30:54 PM
    Author     : 845593
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alberta Bike Swap | Volunteer Register Page</title> 
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="assets/css/volunteer.css">
        
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

        <!-- Bootstrap JS -->
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
             
    </head>
    <body>
        
      
        <%@include file="header.jsp"%>
         
        <div class="first_container container">
                <h3 id="title" style="background: url(../assets/img/header-bike-01.svg) no-repeat bottom center; background-size: 250px;">Volunteer. Make a difference.</h3>
                <h3>Thank you for choosing to help run one of our events. Choose a method below to register.</h3>
          
                        <form  method="POST">
                                    <button type="submit" class="btn btn-primary" >Standard Form</button>
                                    <input type="hidden" name="formType" value="S">
                                </form>
                        <!-- redirected to RegistrationPage.jsp -->
                        
                        <br>
                        <form method="POST">
                                    <button type="submit" class="btn btn-primary">Google Form</button>
                                    <input type="hidden" name="formType" value="G">
                                </form>
                        
                        <!-- redirected to VolunteerGoogleForm.jsp -->
                       
                     </div>
            
         
           </div>
         
         <%@include file="footer.jsp"%>
    </body>
</html>
