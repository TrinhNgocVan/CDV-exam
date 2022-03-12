var FormComponent = function() {
	
	var initForm = function() {
        if (!$().select2) {
            return;
        }
    	// select2
   	 	$('.select2').select2();
	}

    return {
        init: function() {
        	initForm();
        }
    }
}();


document.addEventListener('DOMContentLoaded', function() {
	FormComponent.init();
});


	
	
	
	
	
	
	
	