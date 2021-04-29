function postFunc(){
    var Name  = document.getElementById("name").value;
    var mob_no = document.getElementById("num").value;
    var email = document.getElementById("mail").value;
    var addr = document.getElementById("address").value;
    var ag = document.getElementById("Age").value;
    var httpreq = new XMLHttpRequest();
    httpreq.open("POST","http://localhost:8080/addUser",true);
    if (this.readyState == 4 && this.status == 200) {
        alert(this.responseText)
        if(this.responseText==="false")
        {
            alert("UserInvalid");
            window.location="http://localhost:8080/"
            return
        }
        else{
            Window.alert("USER ADDED");
        }

    }
    var jdata={
        "emailId": email,
        "name": Name,
        "address": addr,
        "phone": mob_no,
        "age": ag

    };

document.getElementById("text").innerHTML="added, go to next page by clicking User info";
    httpreq.send(JSON.stringify(jdata));
}
