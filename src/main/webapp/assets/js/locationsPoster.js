
var locationsApp = locationsApp || {};  // namespace to prevent global variables

/**
 * Generates a poster in PDF format with the current event and a background picture set in the admin page
 * @returns {Promise<void>} The poster
 */
locationsApp.genPDF = async () => {
    let cityName
    let event
    let picture
    let pictureType

    // First we get the selected city name
    await fetch('?action=getCityName')
        .then(response => { //After promise is fulfilled
            return response.text() //Return its response as text
        }).then(data => { // And then log and stores its data into cityName
            console.log(data)
            cityName = data
            /* But before finishing, makes another promise and do the same thing as above, this time for the event
            information */
            return fetch('?action=getEvent')
        }).then(response => {
            return response.json()
        }).then(data => {
            event = data })// Stores response into event
//            return fetch('/images/posters/' + data) // Get current poster background image
//        }).then(response => {
//            return response.blob()
//        }).then(data => {
//            pictureType = data.type // Get current poster background image type
//            picture = URL.createObjectURL(data) // Generates url containing the poster image
//        })

    // PDF information
    let docTitle = "ALBERTA BIKE SWAP";
    let cityTitle = cityName + ", AB";
    let whereTitle = "Where: ";
    let whereInfo = event.address;
    let whenTitle = "When: ";
    let whenInfo = event.date;
    let consignTitle = "Consign: ";
    let consignInfo = event.consign;
    let buyTitle = "Buy: ";
    let buyInfo = event.buy;
    let donateTitle = "Donate: ";
    let donateInfo = event.donate;
    // Creates and image object from the image URL
    let imageBG = new Image();
    imageBG.src = picture;

    /**
     * After the image finishes loading, populate the PDF with event information and the background, and provides the
     * PDF for download
     */
    imageBG.onload = () => {
        var doc = new jsPDF({
            orientation: "p",
            unit: "mm",
            format: "a4"
        });
        doc.setFont('Times', 'Roman');
        doc.setFontSize(40);
        doc.addImage(imageBG, pictureType, 0, 0, 210, 297);
        doc.text(docTitle, 38, 40);
        doc.setFontSize(20);
        doc.text(whereTitle, 50, 70);
        doc.text(whereInfo, 85, 70);
        doc.text(cityTitle, 85, 80);
        doc.text(whenTitle, 50, 100);
        doc.text(whenInfo, 85, 100);
        doc.text(consignTitle, 50, 120);
        doc.text(consignInfo, 85, 120);
        doc.text(buyTitle, 50, 140);
        doc.text(buyInfo, 85, 140);
        doc.text(donateTitle, 50, 160);
        doc.text(donateInfo, 85, 160);
        doc.save("AlbertaBikeSwap.pdf");
    }
}
