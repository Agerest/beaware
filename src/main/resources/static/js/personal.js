$(function () {
    req.open('GET', 'api/student/' + studentId, false);
    req.send();
    console.log(req.status);
    let student = JSON.parse(req.responseText);
    console.log(student);
    $('#avatar').attr("src","data:image/jpg;base64," + student.photo.photo);
    $('#info').append(
        "            <div class=\"row\">\n" +
        "                <div class=\"col s12\">\n" +
        "                    <h5>username: " + student.username + "</h5>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <div class=\"row\">\n" +
        "                <div class=\"col s12\">\n" +
        "                    <h5>first name: " + student.firstName + "</h5>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <div class=\"row\">\n" +
        "                <div class=\"col s12\">\n" +
        "                    <h5>last name: " + student.lastName + "</h5>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <div class=\"row\">\n" +
        "                <div class=\"col s12\">\n" +
        "                    <h5>email: " + student.email + "</h5>\n" +
        "                </div>\n" +
        "            </div>")
});