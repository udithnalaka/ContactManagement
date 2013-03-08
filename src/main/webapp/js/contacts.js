$(document).ready(function(){

    //Start - jquery functionality for Menubar
	$('.dropdown').mouseenter(function(){
		$('.sublinks').stop(false, true).hide();

		var submenu = $(this).parent().next();

		submenu.css({
			position:'absolute',
			top: $(this).offset().top + $(this).height() + 'px',
			left: $(this).offset().left + 'px',
			zIndex:1000
		});

		submenu.stop().slideDown(300);

		submenu.mouseleave(function(){
			$(this).slideUp(300);
		});
	});
    //End - jquery functionality for Menubar
    

    //Start - jquery functionality for image slider
    $("#slides").slides();


    //Start - jquery functionality for home page image hover and ajax call
    $('#imageholder').hover(
      function(){
        getContactSummary();
        $('#contactsummary').css('visibility', 'visible');      
        $('#contactsummary').show('slow');
        //$('#contactsummary').html("My friend count is 2 <br> my family count is 3");
      },
      function(){      
        $('#contactsummary').hide('slow');
      });

    //End - jquery functionality for home page image hover and ajax call
    });

    function getContactSummary(){

      $.ajax({
        url : '/MyContacts/contactsummary.htm',
        type: 'POST',
        data: {name:'Udith'},
        dataType:'json',
        beforeSend:function(){
          //alert('inside beforeSend handler');
        },
        success: function(returnedData){          
          $('#contactsummary').html(  returnedData.friends + " - Friend Contacts <br> "+
                  returnedData.family + " - Family Contacts <br> " +
                  returnedData.business + " - Business Contacts");
        },
        error: function(jqXHR, exception){
          alert('inside error handler');
            if (jqXHR.status === 0) {
                alert('Connection error.\n Verify Network.');
            } else if (jqXHR.status == 404) {
                alert('Requested page not found. [404]');
            } else if (jqXHR.status == 500) {
                alert('Internal Server Error [500].');
            } else if (exception === 'parsererror') {
                alert('Requested JSON parse failed.');
            } else if (exception === 'timeout') {
                alert('Time out error.');
            } else if (exception === 'abort') {
                alert('Ajax request aborted.');
            } else {
                alert('Uncaught Error.\n' + jqXHR.responseText);
            }
        }
      });
    }