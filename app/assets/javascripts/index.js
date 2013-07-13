$(document).ready(function () {
    $.get("/polls", function (data) {
        $.each(data, function (index, poll) {
            $("#polls").append('<li><a id="poll' + index + '" href="">' + poll.name + '</a></li>');
            $("#poll" + index).on("click", onPollClick);
        });
    });

    function onPollClick(e) {
        e.preventDefault();
        alert($(this).text());
    }
});