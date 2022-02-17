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
        <title>JSP Page</title>
    </head>
    <body>
            <form action="ResetPassword" method="post">


                <h1>Reset Password</h1>
          

               <h3>Please Enter your email address to reset your password</h3>
                <label Address</label>
                <input type="email" name="email" >
                <button class="registerbtn" type="submit" name="submit" value="submit">Send Confirmation Email</button>

            </form>
    </body>
</html>
