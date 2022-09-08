movieTitle = document.getElementById("bookedMovie");
movieDate = document.getElementById("dates")
numberOfTickets = document.getElementById("numberOfTickets");
bookerName = document.getElementById("name");
ticketType = document.getElementById("ticketType");
let total;

let booking;

function calculateTotal(ticketType, quant) {
    if(ticketType === "Adult") {
        return total = 10*quant;
    }
    else if(ticketType === "Child" ||ticketType === "Senior") {
        return total = 5*quant;
    }
    return total = 8*quant;
}

function submitForm() {
    booking = {
        "movieTitle": movieTitle.value,
        "movieDate": movieDate.value,
        "bookerName": bookerName.value,
        "numberOfSeats": numberOfTickets.value,
        "ticketType": ticketType.value,
        "total": calculateTotal(ticketType.value, numberOfTickets.value)
    };


//      fetch('http://localhost:8080/Booking/createBooking', {
   fetch('http://18.170.36.93:8080/Booking/createBooking', {
        method: 'POST',
        headers: {
            'accept': 'application/json, text/plane, */*',
            'content-type': 'application/json'
        },
        body: JSON.stringify(booking)
    })
        .then((res) => res.json())
        .then(data => alert("SUCCESS! \n your ticket has been booked. check your email for your ticket"))

    printBooking();
}

function deleteBooking() {
    let book;
    fetch('http://18.170.36.93:8080/Booking/getBooking')
//     fetch('http://localhost:8080/Booking/getBooking')
        .then((res) => res.json())
        .then((data) => {
            console.log(data.length);
        fetch(`http://18.170.36.93:8080/Booking/deleteBooking/${data.length}`, { method: 'DELETE' })
//             fetch(`http://localhost:8080/Booking/deleteBooking/${data.length}`, { method: 'DELETE' })
                .then(() => console.log("deleted"));
        })
}

function printBooking() {
    document.getElementById("movieTitle").innerHTML = "Title: " + movieTitle.value;
    document.getElementById("movieData").innerHTML = "Showing: " + movieDate.value;
    document.getElementById("ticketquant").innerHTML = ticketType.value + " x" + numberOfTickets.value;
    document.getElementById("bookedName").innerHTML = " Booked under name: " + bookerName.value;
    document.getElementById("total").innerHTML = "£" + total;

}

function movieChoice(chosenMovie) {
    if(chosenMovie === "Nope") {
        document.getElementById("bookedMovie").innerHTML =
            "<select class=\"form-select\" aria-label=\"Default select example\" id=\"bookedMovie\" disabled>\n" +
            "          <option selected value=\"Nope\">Nope</option>\n" +
            "        </select>";
    }
    else if (chosenMovie ==="Dc League of Superpets") {
        document.getElementById("bookedMovie").innerHTML =
            "<select class=\"form-select\" aria-label=\"Default select example\" id=\"bookedMovie\" disabled>\n" +
            "          <option selected value=\"DC League of Superpets\">Dc League of Superpets</option>\n" +
            "        </select>";
    }

    else if(chosenMovie === "Gigi and Nate") {
        document.getElementById("bookedMovie").innerHTML =
            "<select class=\"form-select\" aria-label=\"Default select example\" id=\"bookedMovie\" disabled>\n" +
            "          <option selected value=\"Gigi and Nate\">Gigi and Nate</option>\n" +
            "        </select>";
    }

    else if(chosenMovie === "Bullet Train") {
        document.getElementById("bookedMovie").innerHTML =
            "<select class=\"form-select\" aria-label=\"Default select example\" id=\"bookedMovie\" disabled>\n" +
            "          <option selected value=\"Bullet Train\">Bullet Train</option>\n" +
            "        </select>";
    }

    else if(chosenMovie === "Fall") {
        document.getElementById("bookedMovie").innerHTML =
            "<select class=\"form-select\" aria-label=\"Default select example\" id=\"bookedMovie\" disabled>\n" +
            "          <option selected value=\"Fall\">Fall</option>\n" +
            "        </select>";
    }

    else if(chosenMovie === "Beast") {
        document.getElementById("bookedMovie").innerHTML =
            "<select class=\"form-select\" aria-label=\"Default select example\" id=\"bookedMovie\" disabled>\n" +
            "          <option selected value=\"Beast\">Beast</option>\n" +
            "        </select>";
    }

}