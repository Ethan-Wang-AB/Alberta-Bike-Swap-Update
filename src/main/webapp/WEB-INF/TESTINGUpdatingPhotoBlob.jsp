<%-- 
    Document   : TESTINGUpdatingPhotoBlob
    Created on : Mar 17, 2022, 12:40:37 PM
    Author     : 845593
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<form action="TestUpdatingPhoto" method="post" enctype='multipart/form-data'>
                <label>bike Photo</label>
                
                <input type="file" id="photoUp" name="photo" value="upload" accept="image/*" ><br>
           
                <br>
         
                <button class="registerbtn" type="submit" name="submit" value="submit">Submit</button>
                <input class="registerbtn" style="background-color: graytext"type="reset" name="reset" value="Cancel">
            </form><br>
            
    </body>
</html>
