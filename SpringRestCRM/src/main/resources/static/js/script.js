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

// Grab the URL and parse to String
function getUrlString(){
	let pageUrl = String($(location).attr("href"));
	return pageUrl;
}

// Get the Id from the Url
function getUrlId() {
	let url = getUrlString();
	let id = url.slice(url.length - 1, url.length);
	return id;
}

// Get the Url string before the Id
function getRootUrl() {
	let url = getUrlString();
	let rootUrl = url.slice(0, url.length - 1);
	return rootUrl;
}



// Create the wrapper to get the data
const wrapperUrl = {
	url: getRootUrl,
	id: getUrlId
}


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

// Builds a form by grabbing data from a specified element
function formBuilder(dataKey, selector){
	let formData = new FormData();
	formData.append(dataKey, $(selector).text());
	return formData;
}

// Create a new form
function ticketForm(){
	let data = new FormData();
	data.append('description', $('#description').text());
	data.append('diagnostic', $('#diagnostic').text());
	
	// Dynamically creates form data for each of the ticketUpdates present.
	for (var i = 0; i < ticket.updates.length; i ++){
		
		/*
		First param is building the data Key name. It will start with the first element in the ticket.updates array
		
		Second param is grabbing the text inside the specified #ticket[id], in this case the id is the tuid
		of the specified update element
		*/
		data.append('updates[' + i + '].ticketUpdate', $('#update' + (ticket.updates[i].tuid)).text());
		console.log($('#update' + (ticket.updates[i].tuid)).text());
	}
	return data;
}

// function that sends a single post request
function httpPostRequest(form, url, id) {
	let request = new XMLHttpRequest();
	console.log(url + id);
	request.open("POST", url + id)
	request.send(form);
}

/*
This function utilizes formBuilder and HttpPostRequest. It takes 4 params: 

selectorId - A string representation of id you are selecting.
dataKey - The key name for the data to be sent to the database.
dataUrlLink - A string representation of the url path the data is being sent to.
UrlId - The Id to complete the url path for the POST method.

*/

function editButtonPost(selectorId, dataKey, dataUrlLink, UrlId){
	let content = $(selectorId).attr('contenteditable');
	
	if (content == 'false') {
		$(selectorId).attr('contenteditable', 'true');
		$(selectorId).focus();
		$(selectorId).focusout(function(){
			$(selectorId).attr('contenteditable', 'false');
			
			// This chunk right here is responsible for sending the data to the database
			let data = formBuilder(dataKey, selectorId);
			console.log(data.get(dataKey));
			httpPostRequest(data, dataUrlLink, UrlId);
		});
	} 
	else {
		$(selectorId).attr('contenteditable', 'false');
	}
}

// Function with a static form attached
function editButtonPostStaticForm(selectorId, dataUrlLink, UrlId){
	let content = $(selectorId).attr('contenteditable');
	
	if (content == 'false') {
		$(selectorId).attr('contenteditable', 'true');
		$(selectorId).focus();
		$(selectorId).focusout(function(){
			$(selectorId).attr('contenteditable', 'false');
			
			// This chunk right here is responsible for sending the data to the database
			let data = ticketForm();
			httpPostRequest(data, dataUrlLink, UrlId);
		});
	} 
	else {
		$(selectorId).attr('contenteditable', 'false');
	}
}

$('#buttonDesc').click(function() {
	editButtonPostStaticForm('#description', wrapperUrl.url(), wrapperUrl.id());
});

$('#buttonDiag').click(function() {
	editButtonPostStaticForm('#diagnostic', wrapperUrl.url(), wrapperUrl.id());
});

// Function to be called to add click methods dynamically
function addClick(k) {
	$('#buttonUpdate' + k).click(function(){
		editButtonPostStaticForm('#update' + k, wrapperUrl.url(), wrapperUrl.id());
	});
}

// Implementation for adding the click methods. the iteration size is based on the size of the updates based on the ticket JSON object
for (var i = 0; i < ticket.updates.length; i++){
	addClick(ticket.updates[i].tuid);
}


// Checking to see if the root URL was saved
console.log(getRootUrl());

// Checking to see if the right URL id was saved
console.log(getUrlId());

// Checking the length of the ticket updates
console.log(ticket.updates.length);

