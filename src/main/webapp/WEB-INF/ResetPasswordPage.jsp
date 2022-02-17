<%-- 
    Document   : ResetPasswordPage
    Created on : Feb 3, 2022, 4:07:31 PM
    Author     : 845593
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alberta Bike Swap | Reset Password Page</title>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <link href="assets/css/ResetPasswordPageStyle.css" rel="stylesheet" />
        <script type="text/javascript" src="assets/script/ResetPasswordPageScript.js"></script>
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
                                <p>You can reset your password here.</p>
                                <form id="register-form" role="form" autocomplete="off" class="form" method="post" action="ResetPassword">
                                    <div class="form-group">
                                        <div class="input-group">
                                           <%--        <select class="form-control" id="accountType" onchange="showDiv(this)">
                                                        <option selected="true" disabled="disabled">Please Select Your Account Type: </option>
                                                        <option value="0">Bike Seller</option>
                                                          <option value="1">Volunteer</option>
                                                            <option value="2">User</option>
                                                           </select>
                                            --%>
                                   
                                    

                                                    <h1>Enter a new password</h1>
                                                                                 
                                                    <input type="hidden" name="uuid" value="${uuid}">
                                                    <input type="password" name="password" >
                                                    <button class="registerbtn" type="submit" name="submit" value="submit"> Reset Password</button>>
                                             
                                        </div>
                                    </div>  


                                    <div id="hidden_bike">
                                        <div class="form-group" >
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                                                <input id="sellticket" name="sellticket" placeholder="Enter your ticket number" class="form-control"  type="text">
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                                                <input id="phone" name="phone" placeholder="Enter your phone number" class="form-control"  type="text">
                                            </div>
                                        </div>


                                    </div>


                                    <div id="hidden_volunteer">
                                        <div class="form-group" >
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                                                <input id="volunteerid" name="volunteerid" placeholder="Enter your volunteer ID" class="form-control"  type="text">
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                                                <input id="phone" name="phone" placeholder="Enter your phone number" class="form-control"  type="text">
                                            </div>
                                        </div>


                                    </div>


                                    <div id="hidden_user">
                                        <div class="form-group" >
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                                                <input id="username" name="username" placeholder="Enter your username" class="form-control"  type="text">
                                                </select>
                                            </div>
                                        </div>

                                    </div>






                                    <div class="form-group">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                                            <input id="newPassword" name="newPassword" placeholder="New Password" class="form-control"  type="text">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <input name="btnForget" class="btn btn-lg btn-primary btn-block btnForget" value="Reset Password" type="submit">
                                    </div>
                                    <div class="form-group">
                                        <input name="btnBack" class="btn btn-lg btn-primary btn-block btnBack" value="Back to Login" type="submit">
                                    </div>

                                    ${request.message}

                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
