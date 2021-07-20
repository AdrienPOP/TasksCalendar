"use strict";

function sendRequest(method, url, action, parameter = ""){
	let request = getRequest();
	request.overrideMimeType("test/json");
	
	request.open(method, url);
	request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	request.send(parameter);
	
	request.onreadystatechange = () => {
	
		if(request.readyState == 4 && request.status == 200) {
			action(request.responseText);
			console.log(request);
		}
	};
};

let showMessage = (jsonString) => {
	
	console.log("Tout est OK !!!");
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

let art = document.getElementsByClassName("art");
let data;
for(let a of art){
	a.addEventListener("click", (e)=> {
		data = (a.children[0].children[1].innerText);
		let d = data.split("/").reverse().join("-");
		sendRequest("GET", "DatasDay?data=" + d, printDay);
	})
}

let printDay = (jsonString) => {
	
	let day = JSON.parse(jsonString);
	console.log(day);
	
	let html = "<div class='art_title'>";
		html += "<h2>" + day.name + "</h2>";
		html += "<h3>" + data + "</h3></div>";
		for(let t of day.tasksDay){
			html += "<div class='taskDay'> <h4>" + t.title + "<h4> </div>"
		}
		console.log(html);
		/*html += "<h4>" + day.date[2] + "/" + day.date[1] + "/" + day.date[0] + "</h4>";*/
	
	
	document.getElementById("d").innerHTML = html;
};

