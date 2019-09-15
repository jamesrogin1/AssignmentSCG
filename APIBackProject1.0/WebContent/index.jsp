<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Food Bangsue</title>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
	    loadData();
	});
	
	var loadData = function() {
	    $.ajax({    //create an ajax request to load_page.php
	        type: "GET",
	        url: "SCG",             
	        dataType: "html",   //expect html to be returned                
	        success: function(response){                    
		    	$("body").html(response);
		    },
		    error: function(error){
	         	console.log("Error:");
	         	console.log(error);
		    }
	    });
	};
</script>

</head>
<body>

</body>
</html>