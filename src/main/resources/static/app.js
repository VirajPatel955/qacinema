
movieTitle = document.getElementById("bookedMovie");
movieDate = document.getElementById("dates")
numberOfTickets = document.getElementById("numberOfTickets");
bookerName = document.getElementById("name");
ticketType = document.getElementById("ticketType");
let total;

let booking;
let listings;

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
        fetch('http://18.170.36.93:8080'/Booking/deleteBooking/${data.length}`, { method: 'DELETE' })
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
    //document.getElementById("ticketCon").innerHTML = ticketType.value;

}


function movieChoice(chosenMovie) {
    if(chosenMovie === "") {

    }
    else if (chosenMovie ==="") {

    }

    else{

    }

}

/*function getListings() {
    //listings =

    fetch('http://18.170.36.93:8080/Listing/getAllMovies')
        .then((res) => res.json())
        .then((data) => {
            //whatever with the data
            //data.forEach might be useful in this case
        })
}
*/







// const listingURL = "http://http://18.170.36.93:8080/Listing"

// const readListing = () => {
//     fetch(`${listingURL}/getMovie`).then(function (response) {
//         return response.json();
//     })
//     .then(function (data) {
//         appendData(data);
//     })
//     .catch(function (err) {
//         console.log('error: ' + err);
//     });
//         function appendData(toDoTitleObject) {
//             var ToDoContainer = document.getElementById("ReadToDo");
//             ToDoContainer.textContent = '';
//             for (var i = 0; i < toDoTitleObject.length; i++) {
//                 var div = document.createElement("div");
//                 div.innerHTML = 'To Do Title: ' + toDoTitleObject[i].toDoTitle  + ' To Do Item: ' + toDoTitleObject[i].toDoItem + ' To Do Complete: ' + toDoTitleObject[i].toDoComplete;
//                 ToDoContainer.appendChild(div);
//                 }
//                 };

// }

