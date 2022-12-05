$(document).ready(function () {
    let isMenuHid = true;
    //open dropdown
    $(".customBtn").on("click", function () {
//        if (isMenuHid) {
//            isMenuHid = false;
//        }
        if (isMenuHid) {
            menuControl(true);
        } else {
            menuControl(false);
        }
    });
    //change page
    $("#consult").on("click", function () {
        $(".mainContent iframe").attr("src", "./consult-patient.html");
        menuControl(false);
    });
    $("#status").on("click", function () {
        $(".mainContent iframe").attr("src", "./healthstatus.html");
        menuControl(false);
    });
    $("#monitoring").on("click", function () {
        $(".mainContent iframe").attr("src", "./monitoring.html");
        menuControl(false);
    });
    $("#service").on("click", function () {
        $(".mainContent iframe").attr("src", "./services.html");
        menuControl(false);
    });
    $("#viewconsult").on("click", function () {
        $(".mainContent iframe").attr("src", "./viewconsult.html");
        menuControl(false);
    });
});
function menuControl(isHide) {
    if (isHide) {
        $('.sidepanel').width(250);
        $('.customBtn').css('left', 250);
        $('.customBtn').html('<i class="fa fa-chevron-left fa-lg" aria-hidden="true"></i>');
        isHide = false;
    } else {
        $('.sidepanel').width(0);
        $('.customBtn').css('left', 0);
        $('.customBtn').html('<i class="fa fa-chevron-right fa-lg" aria-hidden="true"></i>');
        isHide = true;
    }
}
;