<%-- 
    Document   : eventPage
    Created on : Feb 3, 2022, 4:08:07 PM
    Author     : 845593
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Event Page for Alberta Bike Swap</title>
    <link rel="stylesheet" href="event.css">
</head>

<body>
    <Navbar>    Shared Navbar component among all pages goes here </Navbar>

    <div id="landingPage">
        <div id="landingBackground"></div>
        <div id="landingContentWrapper">
            <div id="cityDropdownWrapper">
                <select name="cities" id="cityDropdown" value="Choose your location">
                    <option value="calgary" default>Calgary</option>
                    <option value="edmonton">Edmonton</option>
                    <option value="lethbridge">Lethbridge</option>
                </select>
            </div>
            <div id="cityEventInfo">
                <p>Where: {location}</p>
                <p>When: {eventDate}</p>
                <p>Consign: {consignDate}</p>
                <p>Buy: {buyDate}</p>
                <p>Donate: {donateDate}</p>
            </div>
            <input type="button" value="Register" onclick="location.href='./register/calgary'" class="customButton">
            <input type="button" value="Questions?" onclick="location.href='./faq.html'" class="customButton">
        </div>
    </div>
    <div id="announcements">
        <div id="announcementsContentWrapper">
            <h1 id="announcementH1">Announcements</h1>
            <div id="announcementCard">
                <div id="announcementImage"></div>
                <div id="cardText">
                    <h2 id="announcementH2">Yup, we're this happy all the time. Have you seen this video?</h2>
                    <p id="anouncementPostDate">Posted on {date}</p>
                    <!-- Could make the header the link to the video rather than pasting a link onto the body of the post -->
                    <input type="button" value="READ MORE" onclick="location.href='./anouncements/thisanouncement'" class="customButton">
                </div>
            </div>
        </div>

        
    </div>

<!-- <Footer> Shared Footer component goes here </Footer> -->
</body>

</html>
