$(document).ready(function () {
    $.get("/poll", function (data) {
        $.each(data, function (index, poll) {
            $("#polls").append('<li>' + poll.name + '</li>');
            console.log(index + ": " + $(this).text());
        });
    });
});