<%-- 
    Document   : reset
    Created on : Feb 17, 2022, 2:45:02 AM
    Author     : 845593
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alberta Bike Swap | Reset Password Page</title>


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alberta Bike Swap | Reset Password Page</title>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <link href="assets/css/ResetPasswordPageStyle.css" rel="stylesheet" />

    </head>

</head>
<body>

    <div class="container forget-password">
        <div class="row">
            <div class="col-md-12 col-md-offset-4">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="text-center">
                            
                             <img src="https://usa.afsglobal.org/SSO/SelfPasswordRecovery/images/send_reset_password.svg?v=3" alt="car-key" border="0">
                                <h2 class="text-center">Forgot Password?</h2>
                                <p>Please Enter your email address to reset your password</p>
                            
                            
                            
                            <form action="ResetPassword" method="post">
                                                               
                                <label>Your email address</label>
                                <input type="email" name="email" > <br/>
                                <button class="registerbtn" type="submit" name="submit" value="submit">Send Confirmation Email</button>

                            </form>
                                <br/>
                             
                                <div class="form-group">
                                        <input name="btnBack" class="btn btn-lg btn-primary btn-block btnBack" value="Back to Login" type="submit">
                                    </div>
                                
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>











</body>
</html>
