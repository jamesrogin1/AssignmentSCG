<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Food Bangsue</title>
</head>
<body class="d-flex flex-column">

<jsp:include page="/assets/header.jsp" />

<div id="page-content">
	<div class="table-responsive-sm">
		<table class="table table-hover" style="width:100%">
			<thead>
				<tr>
			      <th scope="col">#</th>
			      <th scope="col">Name</th>
			      <th scope="col">Vicinity</th>
			      <th scope="col">UserRatingsTotal</th>
			      <th scope="col">Rating</th>
			    </tr>
		  	</thead>
		  	
		  	<tbody>
		  	<c:forEach items="${resultList}" var = "reL" varStatus="status">
			    <tr>
			      <th scope="row">${status.count}</th>
			      <td>${reL.name}</td>
			      <td>${reL.vicinity}</td>
			      <td>${reL.userRatingsTotal}</td>
			      <td>${reL.rating}</td>
			    </tr>
			</c:forEach>
		  	</tbody>
		</table>
	</div>
</div>

<jsp:include page="/assets/footer.jsp" />

</body>
</html>