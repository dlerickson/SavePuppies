<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Adopter</title>
</head>
<body>

	<form action="createNewAdoptionServlet" method="post">
		Coordinator Name: <input type="text" name="coordinatorName"><br />
		Adoption date: <input type="text" name="month" placeholder="mm" size="4">
		<input type="text" name="day" placeholder="dd" size="4">, <input
			type="text" name="year" placeholder="yyyy" size="4"> 
		Adopter Name: <input type="text" name="adopterName"><br /> 
		Puppy Details:<br /> <select name="allItemsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allDogs}" var="currentitem">
				<option value="${currentitem.id}">${currentitem.name}|
					${currentitem.favToy}|
					${currentitem.status}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Create List and Add Items">
	</form>
	<a href="index.html">Home.</a>

</body>
</html>