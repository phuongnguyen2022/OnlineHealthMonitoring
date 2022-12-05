$(document).ready(function () {
    let isMenuHid = true;
    //open dropdown
    $(".btn").on("click", function () {
        if (isMenuHid) {
            $('.sidepanel').width(250);
            $('.btn').css('left', 250);
            $('.btn').html('<i class="fa fa-chevron-left fa-lg" aria-hidden="true"></i>');
            isMenuHid = false;
        } else {
            $('.sidepanel').width(0);
            $('.btn').css('left', 0);
            $('.btn').html('<i class="fa fa-chevron-right fa-lg" aria-hidden="true"></i>');
            isMenuHid = true;
        }
    });
});