let servers;

$(function () {
    req.open('GET', 'api/server/list', false);
    req.send();
    console.log(req.status);
    servers = JSON.parse(req.responseText);
    console.log(servers);
    for (let i = 0; i < servers.length; i++) {
        $('.cards').append(
            "        <div id=\"" + servers[i].id + "\" class=\"card hoverable small col s3\">\n" +
            "            <div class=\"card-image\">\n" +
            "                <img src=\"../images/server.jpg\">\n" +
            "                <span class=\"card-title black-text\">" + servers[i].name + "</span>\n" +
            "            </div>\n" +
            "            <div class=\"card-content\">\n" +
            "                <p>" + servers[i].description + "</p>\n" +
            "            </div>\n" +
            "        </div>");
    }
});