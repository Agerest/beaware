var studentId;

req.open('GET', 'api/student/current', false);
req.send();
console.log(req.status);
if (req.status === 200) {
    studentId = req.responseText;
    console.log(studentId)
} else {
    window.location.href = "/student";
}