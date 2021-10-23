// Goes to the Index Page

let ticketsUrl = 'http://localhost:8080/data/tickets/';


fetch(ticketsUrl)
.then(res => res.json())
.then(
    data => {
        let ticketCount = document.querySelector("#ticket");
        let textToAdd = document.createTextNode(String(data.length));
        ticketCount.appendChild(textToAdd);
    }
);