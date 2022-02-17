
var locationsApp = locationsApp || {};  // namespace to prevent global variables

/**
 * Set the background according to the city ID with CSS properties
 * @param background The background to be set
 */
locationsApp.setBackground = background => {
    let parallax = $('.parallax')
    parallax.css("background", "url('assets/img/locations/" + background + "')")
    parallax.css("background-attachment", "fixed")
    parallax.css("background-position", "center")
    parallax.css("background-repeat", "no-repeat")
    parallax.css("background-size", "cover")
}

/**
 * Get the city from the city ID session and the list of all cities and populate the dropdown and the event information
 * accordingly. Async means this function will return a promise (kind of a request). The "async () =>" is an arrow
 * function. It is the same as "async function ()"
 * @returns {Promise<void>} Response containing a list with cities
 */
locationsApp.getCities = async () => {
    let cities, cityId

    /* Waits for a promise to be fulfilled and then stores the response in a variable. Fetch will send a get request
    with the "action" variable and value "getCity" to the servlet so it gets processed in the doGet section. The first
    one gets the cityID from the session variable in the servlet. This session variable was generated when we first
    clicked one of the cities in the landing page */
    await fetch('?action=getCity')
        .then(response => { //After promise is fulfilled
            return response.text() //Return its response as text
        }).then(data => { // And then log and stores its data into cityId
            console.log(data)
            cityId = data
            /* But before finishing, makes another promise and do the same thing as above, this time for the list of
            cities we have in the database */
            return fetch('?action=getCities')
        }).then(response => {
        
            return response.text();
        }).then(data => {
          
            console.log(data)
            
            cities = JSON.parse(data);
              console.log("cityname: "+cities[0].cityName);

    })
    let collapseDiv = $("#collapseOpen")
    let dropdown = $("<button></button>")
    dropdown.prop("type", "button")
    dropdown.prop("class", "btn btn-link city-drop shadow-none mb-0 selectedCity")
    dropdown.prop("id", "selectedCity")
    console.log("cityID: "+cityId)
    dropdown.text(cities[cityId - 1].cityName)
    dropdown.click(() => { // When clicked, display the the cities under the #collapseOpen div
        collapseDiv.collapse('show')
    })
    let caret = $("<i></i>")
    caret.prop("class", "bi bi-caret-down-fill city-caret float-end")
    dropdown.append(caret) // Adds a caret to the button
    $("#menu").append(dropdown) // Adds the dropdown to the #menu div

    // This is just the "Change your location" disabled option for the dropdown
    let option = $("<button>Change your location</button>")
    option.prop("type", "button")
    option.prop("class", "list-group-item list-group-item-action border-0 city-option city-disabled")
    option.prop("Change your location")
    option.prop("disabled", true)
    collapseDiv.append(option) // Adds it do the dropdown options

    // For each city we have in the cities variable, creates one of the options for the dropdown
    for(let city of cities) {
        option = $("<button></button>")
        option.prop("class", "list-group-item list-group-item-action border-0 city-option")
        option.prop("id", city.cityId) // The button ID is the number according to the city ID
        option.text(city.cityName) // This is what the user see as the option name, the city name
        option.click(() => { // When the user clicks the option, it will change some stuff
            $('#selectedCity').text(city.cityName) // Changes the text in the dropdown to the selected option
            dropdown.append(caret)
         //   locationsApp.setBackground(city.background) // Change the background using the function at the beginning of the script
            locationsApp.getEvent(city.cityId) // Get list of events for the clicked option
        })
        collapseDiv.append(option) // Add the option to the list
    }
    // Sets the background to the city we selected at the landing page
  //  locationsApp.setBackground(cities[cityId - 1].background)
    // If you click anything other than one of the options, it will close the dropdown
    $(document).click(() => {
        $('#collapseOpen').collapse('hide')
    })
    // Get events for the city from the landing page
    await locationsApp.getEvent(cityId)
    // Show stuff that was hidden while data was being fetched and hides the spinning wheels
}

/**
 * Similar to our getCities method, this time getting the most recent event for the city selected at the landing page,
 * or the one selected at the dropdown. This arrow function is the same as "async function (cityId)"
 * @param cityId The city to get the event from
 * @returns {Promise<void>} A response with the most recent event
 */
locationsApp.getEvent = async cityId => {
    // This is updating the cityId session variable to the one selected on the dropdown
    await fetch('?action=updateCity&cityId=' + cityId)

    // These set the gray background for the selected city
    $('.city-option').removeClass('optionActive')
    $('#' + cityId).addClass('optionActive')

    // This is the same as "fetch then", but since it is just one step we do not need "then". Getting the event from DB
    const response = await fetch('?action=getEvent')
    const event = await response.json()
    console.log("event: "+event.address)

    // Get the latest event from the list and populate the divs with data
    $("#address").text(event.address)
    if (event.date !== "null") { // If there is no date set, show a message
        $("#date").text(event.date)
        $("#consign").text(event.consign)
        $("#buy").text(event.buy)
        $("#donate").text(event.donate)
    } else {
        $("#date").text("TBA - but most likely in '22")
        $("#consign").text("TBA")
        $("#buy").text("TBA")
        $("#donate").text("TBA")
    }

    // Hide loading spinner and show event information
    $(".loading-event").hide()
    $(".city-info").show()
   $("#announcementBody").text(event.schedule)
}

/**
 * Similar to our getCities method, this time for an announcement
 * @returns {Promise<void>}  A response with the most recent announcement
 */
locationsApp.getAnnouncement = async () => {
    let announcement
    let picture

    await fetch('?action=getAnnouncement')
        .then(response => { //After promise is fulfilled
            return response.json() //Return its response as json
        }).then(data => { // And then log and stores its data into announcement
            console.log("Announcement"+data)   
        announcement = data
            console.log("announcement"+announcement);})
//            /* But before finishing, if there are announcements available, makes another promise and get a blob (object)
//            result. Then, converts the object to an URL we can use as image */
//            if (announcement.title !== "No Announcements") {
//                return fetch("/images/announcements/" + announcement.picture)
//            }
//            return fetch("")
//        }).then(response => {
//            return response.blob()
//        }).then(data => {
//            picture = URL.createObjectURL(data)
//        })

    $("#announcementTitle").text(announcement.title)

    if (announcement.title !== "No Announcements") {
        // Gets the picture from the path for the announcement and insert it do the #announcementPicture div
        let announcementPicture = $("<img></img>")
        announcementPicture.prop("src", picture)
        announcementPicture.prop("class", "post-pic img-fluid")
        $("#announcementPicture").append(announcementPicture)
        // Sets the other parts of the announcement
        // $("#announcementTitle").text(announcement.title)
        $("#announcementDate").text(announcement.date)

        // This next part converts any text in the announcement body between <l></l> to links before appending the body
        let body = announcement.body
        let regexStart = /<l>/g // Regex for all occurrences of <l>
        let regexEnd = /<\/l>/g // Regex for all occurrences of </l>
        let matchStart // Store temporary <l>
        let matchEnd // Store temporary </l>
        // While there are start tags, replace <l> tags with valid links
        while ((matchStart = regexStart.exec(body)) != null) {
            matchEnd = regexEnd.exec(body)
            let replace = body.substring(matchStart.index, matchEnd.index + 4)
            let link = body.substring(matchStart.index + 3, matchEnd.index)
            body = body.replace(replace, "<a href=" + link + ">" + link + "</a>")
        }
        $("#announcementBody").append(body)

        // Hide loading spinner and shows the announcement picture and body
        $(".loading-announcement").hide()
        $(".post-body").show()
        $(".post-pic-div").show()
        return
    }

    // These are in case there are no announcements to display
    $(".postedon").hide()
    $("#announcement").addClass("justify-content-end")
    $("#announcementTitle").css("margin-top", "120px")
    $(".loading-announcement").hide()
    $(".post-body").show()
}

// These will get the cities and announcements automatically when the page finishes loading
$(document).ready(locationsApp.getCities);
$(document).ready(locationsApp.getAnnouncement);