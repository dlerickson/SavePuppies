<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="navServlet">

		<table>
			<c:forEach items="${requestScope.allDogs}" var="currentitem">
				<tr>
					<td><input type="radio" name="id" value="${currentitem.id}"></td>
					<td>${currentitem.name}</td>
					<td>${currentitem.favToy}</td>
					<td>${currentitem.status}</td>
				</tr>
			</c:forEach>
		</table>

		<input type="submit" value="edit" name="doThisToDog">
		<input type="submit" value="delete" name="doThisToDog"> 
		<input type="submit" value="add" name="doThisToDog">
		
	</form>

</body>
</html>