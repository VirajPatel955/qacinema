movieTitle = document.getElementById("bookedMovie");
movieDate = document.getElementById("dates")
numberOfTickets = document.getElementById("numberOfTickets");
bookerName = document.getElementById("name");
ticketType = document.getElementById("ticketType");

let booking;
let listings;

function calculateTotal(ticketType, quant) {
    if(ticketType.includes("adult")) {
        return 10*quant;
    }
    return 5*quant;
}

function submitForm() {
    booking = {
        "id": 1,
        "movieTitle": movieTitle.value,
        "movieDate": movieDate.value,
        "bookerName": bookerName.value,
        "numberOfSeats": numberOfTickets.value,
        "ticketType": ticketType.value,
        "total": calculateTotal(ticketType.value, numberOfTickets.value)
    };

    alert(JSON.stringify(booking));

    fetch('http://localhost:8080/Booking/createBooking', {
    //fetch('http://18.170.36.93:8080/Booking/createBooking', {
        method: 'POST',
        headers: {
            'accept': 'application/json, text/plane, */*',
            'content-type': 'application/json'
        },
        body: JSON.stringify(booking)
    })
        .then((res) => res.json())
        .then(data => document.getElementById('output').innerText = JSON.stringify(data))
}

function getListings() {
    //listings =

    fetch('http://18.170.36.93:8080/Listing/getAllMovies')
        .then((res) => res.json())
        .then((data) => {
            //whatever with the data
            //data.forEach might be useful in this case
        })
}


