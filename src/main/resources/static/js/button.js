var serverId;
var channelId;

$(function () {
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
            window.location.href = "/main";
        } else {
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
            window.location.href = "/main";
        } else {
            $('.check-info').remove();
            $('.last-item').append("<h5 class=\"red-text check-info center-align\">check input data</h5>");
        }
    });
    $('.servers').on("click", "a", function () {
        serverId = $(this).attr('id');
        console.log(serverId);
        $('.servers').remove();
        $('h1').text('CHANNELS');
        $('.main').append('<div class="channels cards row center-align"></div>')
        req.open('GET', 'api/server/' + serverId + '/get-channels', false);
        req.send();
        console.log(req.status);
        let channels = JSON.parse(req.responseText);
        console.log(channels);
        for (let i = 0; i < channels.length; i++) {
            $('.cards').append(
                "        <div class=\"card hoverable medium col s3\">\n" +
                "            <div class=\"card-image\">\n" +
                "                <img src=\"data:image/jpg;base64," + channels[i].photo.photo + "\">\n" +
                "            </div>\n" +
                "            <div class=\"card-content\">\n" +
                "                <span class=\"card-title black-text\">" + channels[i].name + "</span>\n" +
                "                <p>" + channels[i].description + "</p>\n" +
                "            </div>\n" +
                "            <div class=\"card-action\">\n" +
                "                <a class='btn goChannel' id=\"" + channels[i].id + "\">go</a>\n" +
                "            </div>" +
                "         </div>");
        }
        $('.main').append(
            '        <div class="row main center-align">\n' +
            '            <a class="btn channelForm waves-effect waves-light">create channel\n' +
            '                <i class="material-icons right">add</i></a>\n' +
            '        </div>')
    });
    $('body').on("click", ".channelForm", function () {
        $('#index').empty();
        $('#index').append(
            '    <div class="container">\n' +
            '        <h2 class="center-align">CREATE CHANNEL</h2>\n' +
            '        <form class="col12">\n' +
            '            <div class="row">\n' +
            '                <div class="input-field col s12">\n' +
            '                    <i class="material-icons prefix">info</i>\n' +
            '                    <input id="name" name="name" type="text" autofocus required>\n' +
            '                    <label for="name">name</label>\n' +
            '                </div>\n' +
            '            </div>\n' +
            '            <div class="row">\n' +
            '                <div class="input-field col s12">\n' +
            '                    <i class="material-icons prefix">info</i>\n' +
            '                    <input id="description" name="description" type="text" required>\n' +
            '                    <label for="description">description</label>\n' +
            '                </div>\n' +
            '            </div>\n' +
            '            <div class="row last-item">\n' +
            '                <div class="file-field input-field col s12">\n' +
            '                    <div class="btn">\n' +
            '                        <span>Browse</span>\n' +
            '                        <input id="photo1" type="file" name="photo" accept="Image/*">\n' +
            '                        <label for="photo1"></label>\n' +
            '                    </div>\n' +
            '                    <div class="file-path-wrapper">\n' +
            '                        <input id="photo2" class="file-path validate" type="text" name="photo" placeholder="photo" >\n' +
            '                        <label for="photo2"></label>\n' +
            '                    </div>\n' +
            '                </div>\n' +
            '            </div>\n' +
            '            <div class="center-align">\n' +
            '                <button type="button" id="channel" class="btn waves-effect waves-light">Submit\n' +
            '                    <i class="material-icons right">send</i>\n' +
            '                </button>\n' +
            '            </div>\n' +
            '        </form>\n' +
            '    </div>');
    });
    $('body').on("click", "#channel", function () {
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
        } else {
            $('.check-info').remove();
            $('.last-item').append("<h5 class=\"red-text check-info center-align\">check input data</h5>");
            return;
        }

        let channelId;

        let name = $("#name").val();
        let description = $("#description").val();
        let body = {};
        body.name = name;
        body.description = description;
        body.imageId = imageId;
        console.log(body)
        req.open('POST', 'api/channel/create', false);
        req.setRequestHeader("Content-type", "application/json;charset=UTF-8");
        req.send(JSON.stringify(body));
        console.log(req.status);
        if (req.status === 200) {
            channelId = req.responseText;
            console.log(channelId);
        } else {
            $('.check-info').remove();
            $('.last-item').append("<h5 class=\"red-text check-info center-align\">check input data</h5>");
            return;
        }

        req.open('POST', 'api/server/' + serverId + '/add-channel?channelId=' + channelId, false);
        req.send();
        console.log(req.status);
        if (req.status === 200) {
            window.location.href = "/main";
        } else {
            $('.check-info').remove();
            $('.last-item').append("<h5 class=\"red-text check-info center-align\">check input data</h5>");
            return;
        }
    });
    $('body').on("click", ".goChannel", function () {
        channelId = $(this).attr('id');
        $('#index').empty();
        $('#index').append(
            '    <div class="row center-align">\n' +
            '        <h1>TIMETABLE</h1>\n' +
            '    </div>\n' +
            '    <div class="row">\n' +
            '        <table>\n' +
            '            <thead>\n' +
            '            <tr>\n' +
            '                <th>Date</th>\n' +
            '                <th>Type</th>\n' +
            '                <th>Classroom</th>\n' +
            '                <th>Teacher</th>\n' +
            '            </tr>\n' +
            '            </thead>\n' +
            '            <tbody>\n' +
            '            <tr>\n' +
            '                <td>Monday 11:40</td>\n' +
            '                <td>Lecture</td>\n' +
            '                <td>2-10</td>\n' +
            '                <td>Ed Sheeran</td>\n' +
            '            </tr>\n' +
            '            </tbody>\n' +
            '        </table>\n' +
            '        <div class="row main center-align">\n' +
            '            <a class="btn timetableForm waves-effect waves-light">change timetable\n' +
            '                <i class="material-icons right">create</i></a>\n' +
            '        </div>\n' +
            '    </div>' +
            '    <div class="row center-align">\n' +
            '        <h1>NEWS</h1>\n' +
            '    </div>' +
            '        <div class="row">\n' +
            '           <ul class="collection"></ul>\n' +
            '    </div>');

        req.open('GET', 'api/channel/' + channelId + '/messages', false);
        req.send();
        console.log(req.status);
        let messages = JSON.parse(req.responseText);
        for (let i = 0; i < messages.length; i++) {
            $('.collection').append(
                '            <li class="collection-item avatar">\n' +
                '                <i class="material-icons circle red">book</i>\n' +
                '                <p>' + messages[i].message + '</p>\n' +
                '                <div class="top30 images center-align">\n' +
                "                   <img src=\"data:image/jpg;base64," + messages[i].image.photo + "\">\n" +
                '                </div>\n' +
                '            </li>');
        }
        $('.main').append(
            '    <div class="row main center-align">\n' +
            '        <a class="btn messageForm waves-effect waves-light">new message\n' +
            '            <i class="material-icons right">add</i></a>\n' +
            '    </div>')
    });
    $('body').on("click", ".messageForm", function () {
        $('#index').empty();
        $('#index').append(
            '    <div class="container">\n' +
            '        <h2 class="center-align">NEW MESSAGE</h2>\n' +
            '        <form class="col12">\n' +
            '            <div class="row">\n' +
            '                <div class="input-field col s12">\n' +
            '                    <i class="material-icons prefix">mode_edit</i>\n' +
            '                    <textarea id="icon_prefix2" class="message materialize-textarea"></textarea>\n' +
            '                    <label for="icon_prefix2">message</label>\n' +
            '                </div>\n' +
            '            </div>\n' +
            '            <div class="row last-item">\n' +
            '                <div class="file-field input-field col s12">\n' +
            '                    <div class="btn">\n' +
            '                        <span>Browse</span>\n' +
            '                        <input id="photo1" type="file" name="photo" accept="Image/*">\n' +
            '                        <label for="photo1"></label>\n' +
            '                    </div>\n' +
            '                    <div class="file-path-wrapper">\n' +
            '                        <input id="photo2" class="file-path validate" type="text" name="photo" placeholder="photo">\n' +
            '                        <label for="photo2"></label>\n' +
            '                    </div>\n' +
            '                </div>\n' +
            '            </div>\n' +
            '            <div class="center-align">\n' +
            '                <button type="button" id="newMessage" class="btn waves-effect waves-light">Submit\n' +
            '                    <i class="material-icons right">send</i>\n' +
            '                </button>\n' +
            '            </div>\n' +
            '        </form>\n' +
            '    </div>');
    });
    $('body').on("click", "#newMessage", function () {
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
        } else {
            $('.check-info').remove();
            $('.last-item').append("<h5 class=\"red-text check-info center-align\">check input data</h5>");
            return;
        }

        let messageId;

        let text = $(".message").val();
        let message = {};
        message.imageId = imageId;
        message.message = text;
        console.log(message)
        req.open('POST', 'api/message/create', false);
        req.setRequestHeader("Content-type", "application/json;charset=UTF-8");
        req.send(JSON.stringify(message));
        console.log(req.status);
        if (req.status === 200) {
            messageId = req.responseText;
            console.log(channelId);
        } else {
            $('.check-info').remove();
            $('.last-item').append("<h5 class=\"red-text check-info center-align\">check input data</h5>");
            return;
        }

        req.open('POST', 'api/channel/' + channelId + '/add-message?messageId=' + messageId, false);
        req.send();
        console.log(req.status);
        if (req.status === 200) {
            window.location.href = "/main";
        } else {
            $('.check-info').remove();
            $('.last-item').append("<h5 class=\"red-text check-info center-align\">check input data</h5>");
            return;
        }
    });
    $('body').on("click", ".timetableForm", function () {
        $('#index').empty();
        $('#index').append(
            '    <div class="container">\n' +
            '        <h2 class="center-align">CHANGE TIMETABLE</h2>\n' +
            '        <form class="col12">\n' +
            '            <div class="row">\n' +
            '                <div class="input-field col s12">\n' +
            '                    <i class="material-icons prefix">mode_edit</i>\n' +
            '                    <input id="date" name="date" type="text" autofocus required>\n' +
            '                    <label for="date">date</label>\n' +
            '                </div>\n' +
            '            </div>\n' +
            '            <div class="center-align">\n' +
            '                <button type="button" id="newTimetable" class="btn waves-effect waves-light">Submit\n' +
            '                    <i class="material-icons right">send</i>\n' +
            '                </button>\n' +
            '            </div>\n' +
            '        </form>\n' +
            '    </div>');
    });
});