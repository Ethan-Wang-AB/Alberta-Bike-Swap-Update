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
         
 
        
                        <h2 class="title">Volunteer Registration methods</h2>
                    
                        <form action="NormalForm"  method="get">
                                    <button type="submit" class="btn btn-primary" >Standard Form</button>
                                </form>
                        <!-- redirected to RegistrationPage.jsp -->
                        
                        <br>
                        <form action="GoogleForm"  method="get">
                                    <button type="submit" class="btn btn-primary">Google Form</button>
                                </form>
                        
                        <!-- redirected to VolunteerGoogleForm.jsp -->
                       
                     </div>
            
         
           </div>
         
         <%@include file="footer.jsp"%>
    </body>
</html>
