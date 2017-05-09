$(document).ready(function() {
	$(".del").click(function(){
		var id = $(this).attr('id');
		var result = confirm("Are you sure?");
		if(!result){
			return false;
		}
	});
});