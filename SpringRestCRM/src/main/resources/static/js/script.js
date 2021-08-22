let ticketsUrl = 'http://localhost:8080/data/tickets/';

fetch(ticketsUrl)
.then(res => res.json())
.then(
    data => {
        let ticketCount = document.querySelector("#ticket");
        let textToAdd = document.createTextNode(String(data.length));
        ticketCount.appendChild(textToAdd);
    }
)


/* Functionality primarily meant to be attached to onclick attribute that redirects to the remove Url path
   It uses two parameters:
   
   name - this first parameter must be passed on each template page to redirect to the right Url.
   
   id - this second parameter is dynamically created in thymeleaf and attached to the table data.
   this id will also be placed in the Url to complete it and finally delete the item.
*/

function deleteItem(name, id){
	location.href = 'http://localhost:8080/' + name + '/' + id + '/remove';
}


$(document).ready(function() {
    $('#mydata').DataTable({
    pageLength : 5,
    lengthMenu: [5, 10, 20]
  });
} );

