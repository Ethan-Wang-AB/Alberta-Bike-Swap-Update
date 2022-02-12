<%-- 
    Document   : EditUserPage
    Created on : Feb 3, 2022, 4:06:18 PM
    Author     : 845593
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit User | Alberta Bike Swap</title>
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
    <body>
        <!--field: Name, Email, Password, Photo_Path, Role_id, Call_Number, End_date, Address, Diet, Shirt Size, Affiliation, Ticket-->
        
      <form action="EditUserServlet" method="POST">
      <h1>Edit User Page</h1>
      <div class="formcontainer">
        <br/>
        <div class="container">
            <label for="Name"><strong>Name</strong></label>
            <input type="text" value="Sanggil Lee(Example)" name="name" required>
            <label for="Name"><strong>Email</strong></label>
            <input type="text" value="${requestScope.userEmail}" name="name" required>
            <label for="phonenum"><strong>Phone Number</strong></label>
            <input type="text" value="${requestScope.userPhone}" name="phonenum" required>
            <label for="address"><strong>Address</strong></label>
            <input type="text" value="${requestScope.userAddress}" name="name" required>
            <label for="diet"><strong>Allergies(Will be changed to checkbox)</strong></label>
            <select name="diet" id="diet">
                <option value="volvo">a</option>
                <option value="saab">b</option>
                <option value="mercedes">c</option>
                <option value="audi">d</option>
            </select>
            
            </div>
      <button type="submit">Change</button>
      
     <br/>
          
     ${requestScope.message}
     <br/>
      
    </form>
    </body>
</html>
