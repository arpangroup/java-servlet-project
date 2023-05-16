var alertDiv = document.getElementsByClassName("alert")[0];
var errorMessage = "";
alertDiv.innerHTML  = "";
alertDiv.style.display = "none";

document.getElementById("loginForm").addEventListener("submit", function (e) {
  	e.preventDefault();
    const formData = getData(e.target);
	console.log("FORM_DATA: ", formData);
	const isValid = validateRequest (formData);
	if (isValid === true) {
		e.target.submit();
	} else {
		alertDiv.innerHTML  = errorMessage;
		alertDiv.style.display = "block";
	}
});

function getData(form) {
	let formData = new FormData(form);
	//formData.entries().forEach(pair => console.log(pair[0] + ": " + pair[1]));
	return Object.fromEntries(formData);
}

function validateRequest(formData) {
	const {username, password} = formData;
	
	if (!username) errorMessage = "username shouldn't be null";
	else if (parseInt(username)) errorMessage = "username must be a valid name";
	else if (username.length < 4) errorMessage = "username should be atleast 4 characters long";	
	else if (!password) errorMessage = "paswsword shouldn't be null";
	else if (password.length < 4) errorMessage = "paswsword should be atleast 4 characters long";	
	else return true;
}
