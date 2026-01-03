function validateForm() {
    let firstName=document.forms["regForm"]["firstName"].value;
    let lastName=document.forms["regForm"]["lastName"].value;
    let dateOfBirth=document.forms["regForm"]["dateOfBirth"].value;

    let grade=document.forms["regForm"]["grade"].value;

    if (sid===0){
        alert("Student Id is required");
        return false;
    }

    if (firstName===" "){
        alert("First name is required");
        return false;
    }

    if (lastName===" "){
        alert("Last name is required");
        return false;
    }

    if (grade<5){
        alert("Grade must be grater than 5");
        return false;
    }
}
