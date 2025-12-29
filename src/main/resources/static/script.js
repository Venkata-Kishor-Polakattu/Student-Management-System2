function validateForm() {
    let sid = document.forms["regForm"]["sid"].value;
    let sname=document.forms["regForm"]["sname"].value;
    let sphone=document.forms["regForm"]["sphone"].value;
    let saddr=document.forms["regForm"]["saddr"].value;

    if (sid==0){
        alert("Student Id is required");
        return false;
    }

    if (sname===""){
        alert("Student name is required");
        return false;
    }

    if (sphone===""){
        alert("Phone number is required");
        return false;
    }

    if (saddr===""){
        alert("City or Village is required");
        return false;
    }
}
