var prawo = document.getElementsByClassName('ui-carousel-next-button');
var prawo_button = prawo[0];
var lewo = document.getElementsByClassName('ui-carousel-prev-button');
var lewo_button = lewo[0];


//var map = new google.maps.Map(document.getElementById('j_idt8:mapa'));

if(prawo){
	prawo_button.addEventListener('click', function() {
		
		console.log('prawo');
		//google.maps.event.trigger(map, 'resize');

	    
	}, false);
}

if(lewo){
	lewo_button.addEventListener('click', function() {
		console.log('lewo');
	  
		//google.maps.event.addDomListener(window, "load", initialize);
	    
	}, false);
}

