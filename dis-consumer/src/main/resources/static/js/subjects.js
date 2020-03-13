function fetchdata() {
    $.ajax({
        url: 'localhost:8989/subjects',
        type: 'get',
        dataType : 'json',
        success: function (response) {
            $.each(response, function (k, v) {
                $("#subjects").append('<tr><td>' + v.name + '</td><td>' + v.mark + '</td><td>' + v.localDateTime + '</td></tr>')
            });
        }
    });
}

$(document).ready(function () {
    setInterval(fetchdata, 1000);
});