var r=0;
var count=1;
    function Func0(){
        var httpreq = new XMLHttpRequest();
        //xhttp.open("PUT", "https://userdetailsbybal.herokuapp.com/allsers", true);
        var url = "http://localhost:8080/allusers";
var search=document.getElementById("search").value;
        httpreq.open("GET", url, true);
        httpreq.onreadystatechange = function () {
            if (this.status == 200 && this.readyState == 4) {
                var list = JSON.parse(this.responseText);
                console.log(list);
                if(search===""){
                    document.getElementById("table").innerHTML="";
                    r=0;
                for (var i = 0; i < list.length; i++) {
                    func1(list[i],r);
                    ++r;
                }
                }
                else{
                    document.getElementById("table").innerHTML="";
                    r=0;
                    for (var i = 0; i < list.length; i++) {
                        if(list[i].name===search){
                        func1(list[i],r);
                        ++r;
                        }
                    }
                }


            }
        };
        httpreq.send();
    }



function func1(list,r){
    var table=document.getElementById("table");
    var Name=list.name;
    var Age=list.age;
    var Email=list.emailId;
    var Address=list.address;
    var Mobile=list.phone;
    var Id=list.id;
    var row=table.insertRow(r);
    var cell1=row.insertCell(0);
    var cell2=row.insertCell(1);
    var cell3=row.insertCell(2);
    var cell4=row.insertCell(3);
    var cell5=row.insertCell(4);
    var cell6=row.insertCell(5);
    var cell7=row.insertCell(6);
    cell1.setAttribute('id','cel');
    cell2.setAttribute('id','cel');
    cell3.setAttribute('id','cel');
    cell4.setAttribute('id','cel');
    cell5.setAttribute('id','cel');
    cell6.setAttribute('id','cel');
    cell7.setAttribute('id','cel');
    cell1.innerHTML=Name;
    cell2.innerHTML=Age;
    cell3.innerHTML=Email;
    cell4.innerHTML=Address;
    cell5.innerHTML=Mobile;
    cell6.innerHTML='<button type="button" id="delbtn" onClick="editt()">Edit</button>';
    cell7.innerHTML='<button type="button" id="delbtn" onClick="removeRow(this)">Delete</button>';

}
    function removeRow(btnn) {
        var empTab = document.getElementById('table');
        var x=btnn.parentNode.parentNode.rowIndex;
        empTab.deleteRow(x); // buttton -> td -> tr
        var xhttp1 = new XMLHttpRequest();
       // xhttp1.open("DELETE", "https://userdetailsbybal.herokuapp.com/deleteuser", true);
         xhttp1.open("DELETE", "http://localhost:8080/deleteUser", true);
        xhttp1.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                alert("UserDeleted")

            }
        };
        xhttp1.send(table.rows[x].cells[2].innerHTML);
console.log(x,table.rows[x].cells[2].innerHTML);
        empTab.deleteRow(x+1); // buttton -> td -> tr

    }
    function editt()
    {
        let td_d = event.target.parentNode;
        let c = td_d.children;
        var  modal=document.getElementById("Modal")
        modal.style.display = "block";
    }
    function close()
    {
        var  modal=document.getElementById("Modal")
        modal.style.display = "none";
    }

    function updatedat() {
        let parent = document.getElementById("my_form");
        let name = document.getElementById("name").value;
        let age = document.getElementById("age").value;
        let email = document.getElementById("email").value;
        let address = document.getElementById("address").value;
        let ph_no = document.getElementById("ph_no").value;

        var xhttp = new XMLHttpRequest();
        //xhttp.open("PUT", "https://userdetailsbybal.herokuapp.com/updateUser", true);
         xhttp.open("PUT", "http://localhost:8080/updateUser", true);
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                alert(this.responseText)
                if (this.responseText === "false") {
                    alert("UserInvalid");
                    return
                } else {


                }

            }
        };
        var data = {
            "name": name,
            "age": age,
            "emailId": email,
            "address": address,
            "phone": ph_no
        };

        xhttp.send(JSON.stringify(data));


    }