$(function(){
    $('#registration').click(function () {
        let username = $("#username").val();
        let email = $("#email").val();
        let password = $("#password").val();
        let matchingPassword = $("#confirm").val();
        let body = {};
        body.username = username;
        body.email = email;
        body.password = password;
        body.matchingPassword = matchingPassword;
        console.log(body)
        req.open('POST', 'api/registration/new-user', false);
        req.setRequestHeader("Content-type", "application/json;charset=UTF-8");
        req.send(JSON.stringify(body));
        console.log(req.status);
        if (req.status === 200) {
            window.location.href="/main";
        }
        else {
            $('.check-info').remove();
            $('.last-item').append("<h5 class=\"red-text check-info center-align\">check input data</h5>");
        }
    });
    $('#personal').click(function () {
        let firstName = $("#firstName").val();
        let lastName = $("#lastName").val();
        let imageId;

        let photo = $('#photo1');
        console.log(photo)
        let formData = new FormData();
        let image = photo[0].files[0];
        console.log(image)
        formData.append("image", image)
        req.open('POST', 'api/image/create', false);
        req.setRequestHeader("Content-type", "application/json;charset=UTF-8");
        req.send(formData);
        console.log(req.status);
        if (req.status === 200) {
            imageId = req.responseText;
        } else {
            $('.check-info').remove();
            $('.last-item').append("<h5 class=\"red-text check-info center-align\">check input data</h5>");
            return;
        }

        let student = {};
        student.firstName = firstName;
        student.lastName = lastName;
        student.imageId = imageId;
        console.log(student)
        req.open('POST', 'api/student/create', false);
        req.send(JSON.stringify(student));
        console.log(req.status);
        if (req.status === 200) {
            window.location.href = "/main";
        } else {
            $('.check-info').remove();
            $('.last-item').append("<h5 class=\"red-text check-info center-align\">check input data</h5>");
        }
    });
    $('#server').click(function () {
        let name = $("#name").val();
        let description = $("#description").val();
        let ownerId = studentId;
        let body = {};
        body.name = name;
        body.description = description;
        body.ownerId = ownerId;
        console.log(body)
        req.open('POST', 'api/server/create', false);
        req.setRequestHeader("Content-type", "application/json;charset=UTF-8");
        req.send(JSON.stringify(body));
        console.log(req.status);
        if (req.status === 200) {
            window.location.href="/main";
        }
        else {
            $('.check-info').remove();
            $('.last-item').append("<h5 class=\"red-text check-info center-align\">check input data</h5>");
        }
    });
});