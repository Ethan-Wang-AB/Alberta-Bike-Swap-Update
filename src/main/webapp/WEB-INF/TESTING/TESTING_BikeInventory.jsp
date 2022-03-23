<%-- 
    Document   : TESTING_BikeInventory
    Created on : Mar 17, 2022, 12:34:08 PM
    Author     : 845593
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import=" com.sun.org.apache.xerces.internal.impl.dv.util.Base64"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table class="table" cellspacing="0">
            <thead>
                <tr>
                    <th>Bike Index</th>
                    <th>Make</th>
                    <th>Model</th>
                    <th>Size</th>
                    <th>Photo</th>
                    <th>PhotoPath</th>


                </tr>
            </thead>
            <tbody>
                <c:forEach var="bike" items="${bikes}">
                <td>${bike.getBikeIndex()}</td>
                <td>${bike.getMaker()}</td>
                <td>${bike.getModel()}</td>
                <td>${bike.getSize()}</td>
                 <td><img style="width:150px;" src="data:image/jpg;base64,${Base64.encode(bike.getPhoto())}"</td>
                <td><img style="width:150px;" src="${bike.getPhotoPath()}"/></td>

            </c:forEach>>
            
        </tbody>
    </table>
</body>
</html>
