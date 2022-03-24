<%-- 
    Document   : TestRestore
    Created on : Mar 18, 2022, 11:39:50 AM
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
        <form method="POST" action="TestRestore"  enctype='multipart/form-data'>
            
              <input type="file" id="restore" name="restore" value="upload" accept=".sql" ><br>

            <input type="submit" value="restore">
            
        </form>
    </body>
</html>
