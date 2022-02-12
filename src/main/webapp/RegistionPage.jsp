<%-- 
    Document   : newjsp
    Created on : Feb 8, 2022, 5:53:39 PM
    Author     : aphks
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
        
         <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
     <link rel="stylesheet" type="text/css" href="assets/css/regisrationPageStyle.css">
        
    </head>
    <body>
    <div class="main-block">
    <form action="/">
      <h1>Bike Seller or / and Volunteer Registration</h1>
      <fieldset>
        <legend>
          <h3>Account Details</h3>
        </legend>
        <div  class="account-details">
          <div><label>First Name*</label><input type="text" name="name" required></div>
           <div><label>Last Name*</label><input type="text" name="name" required></div>
          <div><label>Phone*</label><input type="phone" name="name" required></div>  
          <div><label>Email*</label><input type="email" name="name" required></div> 
          <br/>
          <p><b>Are you a bike seller or / and volunteer?</b></p><br>
        
        <input type = "checkbox" id="Seller" name = "bikeSeller"/>
        <label for="bikeSeller" class="account-type">Bike Seller</label>
               
         <input type = "checkbox" id="volunteer" name = "volunteer" />
        <label for="volunteer" class="account-type">Volunteer</label>
        
        </div>
      </fieldset>
      
      <fieldset>
        <legend>
          <h3>Bike Details</h3>
        </legend>
        <div  class="personal-details">
            
             <div>
              <label>How many bike for sell?</label>              
              <select required>
                <option value=""></option>
                <option value="01">1</option>
                <option value="02">2</option>
                <option value="03">3</option>
                <option value="04">4</option>
                <option value="05">5</option>
               </select>
            </div>
            <br/>
            
          <div>
            <div><label>Bike Index</label><input type="text" name="bikeindex" required></div>
            <div><label>Bike Type</label><input type="text" name="biketype" required></div>
            <div><label>Size</label><input type="text" name="name"></div>
            <div><label>City*</label><input type="text" name="name" required></div>
            </div>
              
            </div>
      </fieldset>
      
      
       
      <fieldset>
        <legend>
          <h3>Volunteer Details</h3>
        </legend>
        <div  class="personal-details">
            
         <div>
            <div><label>Name*</label><input type="text" name="name" required></div>
            <div><label>Phone*</label><input type="text" name="name" required></div>
            <div><label>Street</label><input type="text" name="name"></div>
            <div><label>City*</label><input type="text" name="name" required></div>
        </div>
              
            </div>
      </fieldset>
      
      
      
      <fieldset>
        <legend>
          <h3>Terms and Mailing</h3>
        </legend>
        <div  class="terms-mailing">
          <div class="checkbox">
            <input type="checkbox" name="checkbox"><span>I accept the <a href="https://www.w3docs.com/privacy-policy">Privacy Policy for W3Docs.</a></span>
          </div>
          <div class="checkbox">
            <input type="checkbox" name="checkbox"><span>I want to recelve personallzed offers by your site</span>
          </div>
      </fieldset>
      <button type="submit" href="/">Submit</button>
    </form>
    </div> 
  </body>
</html>
        
        