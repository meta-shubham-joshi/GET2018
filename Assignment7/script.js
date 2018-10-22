function myFunction() {

    var state = document.getElementById("select-state").value;

    var form = document.getElementById('registration-form');

    var formElementCount = form.getElementsByClassName('field').length;

    if (formElementCount > 8) {

        var element1 = form.getElementsByClassName('field')[7];
        var element2 = form.getElementsByClassName('field')[8];
        form.removeChild(element1);
        form.removeChild(element2);

    }

    switch (state) {

        case "Rajasthan":
            addWebsite();
            addProjectDescription();
            break;

        case "Haryana":
            addZipCode();
            addHosting();
            break;

        case "Maharashtra":
            addZipCode();
            addProjectDescription();
            break;

    }

}

function addWebsite() {

    var form = document.getElementById("registration-form");

    var outerDiv = document.createElement('div');
    outerDiv.className = 'field';

    var innerDiv1 = document.createElement('div');
    innerDiv1.className = 'field-label'
    innerDiv1.innerHTML = "Website:";

    var innerDiv2 = document.createElement('div');
    innerDiv2.className = 'field-inputs';

    var innerDiv2Icon = document.createElement('i');
    innerDiv2Icon.id = 'icons';
    innerDiv2Icon.className = 'fas fa-globe-asia';

    var innerDiv2Input = document.createElement('input');
    innerDiv2Input.type = 'text';

    innerDiv2Input.name = "website";

    innerDiv2Input.placeholder = 'Website or domain name';
    innerDiv2Input.className = 'field-values';

    innerDiv2.appendChild(innerDiv2Icon);
    innerDiv2.appendChild(innerDiv2Input);

    outerDiv.appendChild(innerDiv1);
    outerDiv.appendChild(innerDiv2);

    form.insertBefore(outerDiv, document.getElementById("submit-button-div"));

}

function addProjectDescription() {

    var form = document.getElementById("registration-form");

    var outerDiv = document.createElement('div');
    outerDiv.className = 'field';

    var innerDiv1 = document.createElement('div');
    innerDiv1.className = 'field-label'
    innerDiv1.innerHTML = "Project Description:";

    var innerDiv2 = document.createElement('div');
    innerDiv2.className = 'field-inputs';

    var innerDiv2Icon = document.createElement('i');
    innerDiv2Icon.id = 'icons';
    innerDiv2Icon.className = 'fas fa-pen';

    var innerDiv2Input = document.createElement('input');
    innerDiv2Input.type = 'text';

    innerDiv2Input.name = "project-description";

    innerDiv2Input.placeholder = 'Project Description';
    innerDiv2Input.className = 'field-values';

    innerDiv2.appendChild(innerDiv2Icon);
    innerDiv2.appendChild(innerDiv2Input);

    outerDiv.appendChild(innerDiv1);
    outerDiv.appendChild(innerDiv2);

    form.insertBefore(outerDiv, document.getElementById("submit-button-div"));
}

function addZipCode() {

    var form = document.getElementById("registration-form");

    var outerDiv = document.createElement('div');
    outerDiv.className = 'field';

    var innerDiv1 = document.createElement('div');
    innerDiv1.className = 'field-label'
    innerDiv1.innerHTML = "ZipCode:";

    var innerDiv2 = document.createElement('div');
    innerDiv2.className = 'field-inputs';

    var innerDiv2Icon = document.createElement('i');
    innerDiv2Icon.id = 'icons';
    innerDiv2Icon.className = 'fas fa-home';

    var innerDiv2Input = document.createElement('input');
    innerDiv2Input.type = 'text';
    innerDiv2Input.id = "zipcode";

    innerDiv2Input.name = "zipcode";

    innerDiv2Input.placeholder = 'ZipCode';
    innerDiv2Input.className = 'field-values';

    innerDiv2.appendChild(innerDiv2Icon);
    innerDiv2.appendChild(innerDiv2Input);

    outerDiv.appendChild(innerDiv1);
    outerDiv.appendChild(innerDiv2);

    form.insertBefore(outerDiv, document.getElementById("submit-button-div"));

}

function addHosting() {

    var form = document.getElementById("registration-form");

    var outerDiv = document.createElement('div');
    outerDiv.className = 'field';

    var innerDiv1 = document.createElement('div');
    innerDiv1.className = 'field-label'
    innerDiv1.innerHTML = "Do You Have Hosting?:";

    var innerDiv2 = document.createElement('div');
    innerDiv2.className = 'field-inputs';

    var innerDiv2Label1 = document.createElement('label');
    var innerDiv2Button1 = document.createElement('input');
    innerDiv2Button1.name = "hosting";
    innerDiv2Button1.type = 'radio';
    innerDiv2Button1.value = 'Yes';
    var yesLabel = document.createTextNode("Yes");
    innerDiv2Label1.appendChild(innerDiv2Button1);
    innerDiv2Label1.appendChild(yesLabel);

    var innerDiv2Label2 = document.createElement('label');
    var innerDiv2Button2 = document.createElement('input');
    innerDiv2Button2.name = "hosting";
    innerDiv2Button2.type = 'radio';
    innerDiv2Button2.value = 'No';
    var noLabel = document.createTextNode("No");
    innerDiv2Label2.appendChild(innerDiv2Button2);
    innerDiv2Label2.appendChild(noLabel);

    innerDiv2.appendChild(innerDiv2Label1);
    innerDiv2.appendChild(innerDiv2Label2);

    outerDiv.appendChild(innerDiv1);
    outerDiv.appendChild(innerDiv2);

    form.insertBefore(outerDiv, document.getElementById("submit-button-div"));

}

var errorMessage = "";

function validate() {

    validateFirstName()
    validateLastName()
    validateEmail()
    validatePhone()

    if (!(document.getElementById("select-state").value == "Rajasthan")) {
        validateZipCode()
    }

    if (!(errorMessage == "")) {
        alert(errorMessage);
        document.myform.focus();
        return false;
    }
    return true;
}

function validateFirstName() {

    var re = /^[A-Za-z]+$/;
    var firstName = document.getElementById("first-name").value;

    if ((firstName.length > 2 && re.test(firstName))) {
        return true;
    }
    else {
        errorMessage = errorMessage + "First Name : Please enter valid first name.\n";
        return false;
    }

}

function validateLastName() {

    var re = /^[A-Za-z]+$/;
    var lastName = document.getElementById("last-name").value;

    if ((lastName.length > 2 && re.test(lastName))) {
        return true;
    }
    else {
        errorMessage = errorMessage + "Last Name : Please enter valid last name.\n";
        return false;
    }

}

function validateEmail() {

    var re = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    var email = document.getElementById("email").value;

    if (re.test(email)) {
        return true;
    }
    else {
        errorMessage = errorMessage + "Email : Please enter valid email address.\n";
        return false;
    }

}

function validatePhone() {

    var contact = document.getElementById("phone").value;

    if (contact.length > 8 && (!isNaN(contact))) {
        return true;
    }
    else {
        errorMessage = errorMessage + "Contact : Please enter valid contact number.\n";
        return false;
    }

}

function validateZipCode() {

    var zipcode = document.getElementById("zipcode").value;

    if (zipcode.length == 6 && (!isNaN(zipcode))) {
        return true;
    }
    else {
        errorMessage = errorMessage + "ZipCode : Please enter valid ZipCode.\n";
        return false;
    }

}

function getProfileData() {
    var urlString = window.location;
    var url = new URL(urlString);
    var state = url.searchParams.get("state");

    document.getElementById("name").innerHTML = url.searchParams.get("FirstName") + " " + url.searchParams.get("LastName");
    document.getElementById("email").innerHTML = url.searchParams.get("Email");
    document.getElementById("city").innerHTML = url.searchParams.get("city");
    document.getElementById("phone").innerHTML = url.searchParams.get("phone");
    document.getElementById("address").innerHTML = url.searchParams.get("address");
    document.getElementById("state").innerHTML = state;

    if (state == "Haryana") {
        document.getElementById("label-1").innerHTML = "Zipcode:";
        document.getElementById("label-1-content").innerHTML = url.searchParams.get("zipcode");
        document.getElementById("label-2").innerHTML = "Have Hosting:";
        document.getElementById("label-2-content").innerHTML = url.searchParams.get("hosting");
    }
    else if (state == "Rajasthan") {
        document.getElementById("label-1").innerHTML = "Website:";
        document.getElementById("label-1-content").innerHTML = url.searchParams.get("website");
        document.getElementById("label-2").innerHTML = "Project Description:";
        document.getElementById("label-2-content").innerHTML = url.searchParams.get("project-description");
    }
    else {
        document.getElementById("label-1").innerHTML = "Zipcode:";
        document.getElementById("label-1-content").innerHTML = url.searchParams.get("zipcode");
        document.getElementById("label-2").innerHTML = "Project Description:";
        document.getElementById("label-2-content").innerHTML = url.searchParams.get("project-description");
    }
}


