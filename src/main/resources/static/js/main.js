let req = new XMLHttpRequest();
let studentId;

req.open('GET', 'api/student/current', false);
req.send();
console.log(req.status);
if (req.status === 200) {
    studentId = req.responseText;
}
else {
    window.location.href="/student";
}

$(function(){

});