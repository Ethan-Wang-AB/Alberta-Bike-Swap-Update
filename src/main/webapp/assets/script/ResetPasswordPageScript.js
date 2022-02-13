/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function showDiv(divId, element)
{
    document.getElementById(divId).style.display = element.value == 0 ? 'block' : 'none';
    document.getElementById(divId).style.display = element.value == 1 ? 'block' : 'none';
}

function showDiv(select) {
    if (select.value == 0) {
        document.getElementById('hidden_bike').style.display = "block";
        document.getElementById('hidden_volunteer').style.display = "none";
        document.getElementById('hidden_user').style.display = "none";
    } else if (select.value == 1) {
        document.getElementById('hidden_volunteer').style.display = "block";
        document.getElementById('hidden_bike').style.display = "none";
        document.getElementById('hidden_user').style.display = "none";

    } else if (select.value == 2) {
        document.getElementById('hidden_user').style.display = "block";
        document.getElementById('hidden_bike').style.display = "none";
        document.getElementById('hidden_volunteer').style.display = "none";

    } else {
        document.getElementById('hidden_bike').style.display = "none";
        document.getElementById('hidden_volunteer').style.display = "none";
        document.getElementById('hidden_user').style.display = "none";
    }
} 