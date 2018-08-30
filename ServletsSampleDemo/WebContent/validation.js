function validate() {
	if (validateName() && validateEmail() && validateAge()) {
		document.getElementById("addemployeeform").submit();
	}
}

function validateName() {
	var re = /^[A-Za-z]+$/;
	var firstName = document.getElementById("firstname").value;
	var lastName = document.getElementById("lastname").value;
	if ((firstName.length > 2 && re.test(firstName))
			&& (lastName.length > 2 && re.test(lastName))) {
		return true;
	} else {
		alert("Invalid Name Entered");
		return false;
	}
}

function validateEmail() {
	var re = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	var email = document.getElementById("email").value;
	if (re.test(email)) {
		return true;
	} else {
		alert("Invalid Email Id");
		return false;
	}
}

function validateAge() {
	var age = document.getElementById("age").value;
	if (!isNaN(age)) {
		return true;
	} else {
		alert("Inavlid contact Entered");
		return false;
	}
}
