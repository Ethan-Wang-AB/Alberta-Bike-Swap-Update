/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function myBfunction() {
  var checkBox = document.getElementById("Seller");
  var text = document.getElementById("bikesection");
  if (checkBox.checked == true){
    text.style.display = "block";
  } else {
     text.style.display = "none";
  }
}

function myVfunction() {
  var checkBox = document.getElementById("volunteer");
  var text = document.getElementById("volunteersection");
  if (checkBox.checked == true){
    text.style.display = "block";
  } else {
     text.style.display = "none";
  }
}

function displayDivDemo(id, elementValue) {
      document.getElementById(id).style.display = elementValue.value == 1 ? 'block' : 'none';
   }