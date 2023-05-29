$('#future-orders').css('display','none');
$('#cancel-orders').css('display','none');
$('#completed-orders').css('display','none');

$('#toggle-orders li').click(function () {
    $('#toggle-orders li').not(this).removeClass('selected');
    $(this).addClass('selected');
});


$('.fo').click(function () {
    $('#order-history').hide();
    $('#cancel-orders').hide();
    $('#completed-orders').hide();
    $('#future-orders').fadeIn('fast');
});

$('.oh').click(function () {
    $('#order-history').fadeIn('fast');
    $('#future-orders').hide();
    $('#cancel-orders').hide();
    $('#completed-orders').hide();
});
$('.ed').click(function () {
    $('#cancel-orders').fadeIn('fast');
    $('#future-orders').hide();
    $('#completed-orders').hide();
    $('#order-history').hide();
});
$('.com').click(function () {
    $('#completed-orders').fadeIn('fast');
    $('#future-orders').hide();
    $('#cancel-orders').hide();
    $('#order-history').hide();
});

//By default, selecting 'Past 6 months' on dropdown selector
// $(function () {
//     $('select option[value="6months"]').prop('selected', true);
// });



