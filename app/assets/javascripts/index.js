$(document).ready(function () {
    $.get("/polls", function (data) {
        $.each(data, function (index, poll) {
            $("#polls").append('<li>' + poll.name + '</li>');
        });
    });
});