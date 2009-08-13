$(document).ready(function() {
    $('.buttonlink').hover(
            function() { $(this).addClass('ui-state-hover'); }, 
            function() { $(this).removeClass('ui-state-hover'); }
    );
    $('div.ui-widget-header > ul > li').click(
            function() { $('div.ui-widget-header > ul > li').removeClass('ui-state-active'); $(this).addClass('ui-state-active');},
            function() {  }
    );
    $('div.ui-widget-header > ul > li').hover(
            function() { $(this).addClass('ui-state-hover'); }, 
            function() { $(this).removeClass('ui-state-hover'); }
    );
});
