<%-- 
    Document   : BikeCheckPage
    Created on : Feb 3, 2022, 4:06:07 PM
    Author     : 845593
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        
        
           <style>
      html, body {
      display: flex;
      justify-content: center;
      font-family: Roboto, Arial, sans-serif;
      font-size: 15px;
      }
      form {
      border: 5px solid #f1f1f1;
      }
      input[type=text] {
      width: 100%;
      padding: 16px 8px;
      margin: 8px 0;
      display: inline-block;
      border: 1px solid #ccc;
      box-sizing: border-box;
      }
      button {
      background-color: #8ebf42;
      color: white;
      padding: 14px 0;
      margin: 10px 0;
      border: none;
      cursor: grabbing;
      width: 100%;
      }
      h1 {
      text-align:center;
      fone-size:18;
      }
      button:hover {
      opacity: 0.8;
      }
      .formcontainer {
      text-align: left;
      margin: 24px 50px 12px;
      }
      .container {
      padding: 16px 0;
      text-align:left;
      }
      span.phonenum {
      float: right;
      padding-top: 0;
      padding-right: 15px;
      }
      /* Change styles for span on extra small screens */
      @media screen and (max-width: 300px) {
      span.phonenum {
      display: block;
      float: none;
      }
    </style>
        
        
        
        
        
    </head>
     <form action="/" method="POST">
      <h1>Bike Check Page</h1>
      <div class="formcontainer">
      <hr/>
      <div class="container">
        <label for="ticketnum"><strong>Ticket Number</strong></label>
        <input type="text" placeholder="Enter Ticket Number" name="ticketnum" required>
        <label for="phonenum"><strong>Phone Number</strong></label>
        <input type="text" placeholder="Enter Phone Number" name="phonenum" required>
      </div>
      <button type="submit">Login</button>
      
    </form>
</html>
