let ticketsUrl = 'http://localhost:8080/data/tickets/';

fetch(ticketsUrl)
.then(res => res.json())
.then(
    data => {
        let ticketCount = document.querySelector("#circle");
        let textToAdd = document.createTextNode(String(data.length));
        ticketCount.appendChild(textToAdd);
    }
)




