let req = new XMLHttpRequest();

$(function(){
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
        req.send(formData);
        console.log(req.status);
        if (req.status === 200) {
            imageId = req.responseText;
        }
        else {
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
        req.setRequestHeader("Content-type", "application/json;charset=UTF-8");
        req.send(JSON.stringify(student));
        console.log(req.status);
        if (req.status === 200) {
            console.log("ok")
            /*window.location.href="/main";*/
        }
        else {
            $('.check-info').remove();
            $('.last-item').append("<h5 class=\"red-text check-info center-align\">check input data</h5>");
        }
    });
});