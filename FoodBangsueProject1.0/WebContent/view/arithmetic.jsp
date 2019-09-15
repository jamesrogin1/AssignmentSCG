<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="/FoodBangsueProject1.0/assets/css/arithmetic.css">
<title>Arithmetic Progression</title>
</head>
<body class="d-flex flex-column">

<jsp:include page="/assets/header.jsp" />

<div id="page-content">
	<div class="container text-center">
		<div class="row justify-content-md-center">
			<div class="col-md-auto">
				<h1>Function Arithmetic Progression</h1>
				<br>
				<h2>X , 5 , 9 , 15 , 23 , Y , Z</h2>
				<br>
				<button class="btn btn-outline-success" name="calculate" type="button" OnClick="JavaScript:calculate();">Calculate</button>
				<br>
			</div>
		</div>
		<div class="row justify-content-md-center" id="result">
			<div class="col-md-auto form-group">
				<label for="inputX">X = </label>
				<input id="inputX" type="text" value="0" disabled />
				<label for="inputY">Y = </label>
				<input id="inputY" type="text" value="0" disabled />
				<label for="inputZ">Z = </label>
				<input id="inputZ" type="text" value="0" disabled />
			</div>
		</div>
	</div>
</div>

<script src="/FoodBangsueProject1.0/assets/js/function.js"></script>

<jsp:include page="/assets/footer.jsp" />

</body>
</html>