"use strict";
let data;
let btn;

function sendRequest(method, url, action, parameter = "") {
	let request = getRequest();
	request.overrideMimeType("test/json");

	request.open(method, url);
	request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	request.send(parameter);

	request.onreadystatechange = () => {

		if (request.readyState == 4 && request.status == 200) {
			action(request.responseText);
		}
	};
};

let showMessage = (jsonString) => {
	sendRequest("GET", "DatasDay?data=", printDay);
};


function getRequest() {
	var request;
	if (window.XMLHttpRequest) {
		request = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		try {
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}
	} else {
		request = false;
	}
	return request;
};


let printDay = (jsonString) => {

	let day = JSON.parse(jsonString);

	let html = "<div class='art_title'>";
	html += "<h2>" + day.name + "</h2>";
	html += "<h3>" + data + "</h3></div>";

	for (let t of day.tasksDay) {
		let id = t.id;
		html += "<div class='col-11 taskDay'><div class=''><h4>" + t.title + "<h4> </div>"
		html += "<p>" + t.description + "</p>"
		html += "<a class='de' href='#delete&id=" + id + "'>Delete</button> </a></div>"
	}
	html += "<a href=Planning>Modifications terminées</a>"
	document.getElementById("d").innerHTML = html;
	btn = document.getElementsByClassName("de");

	if (btn != undefined) {
		for (let b of btn) {
			b.addEventListener("click", (e) => {
				sendRequest("GET", "DatasDay?data=" + data.split("/").reverse().join("-") + "&action=" + b.hash.substring(1), printDay);
			});
		}
	}
};

function clickDay() {
	let art = document.getElementsByClassName("art");

	for (let a of art) {
		a.addEventListener("click", (e) => {
			data = (a.children[0].children[1].innerText);
			let d = data.split("/").reverse().join("-");
			sendRequest("GET", "DatasDay?data=" + d, printDay);
		})
	}

}

clickDay();


