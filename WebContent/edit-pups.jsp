<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="editPupsServlet" method="post">
		Pup's Name: <input type="text" name="name" value="${pupToEdit.name}"><br>
		Fav Toy: <input type="text" name="favToy" value="${pupToEdit.favToy}"><br>
		Status: <input type="text" name="status" value="${pupToEdit.status}"><br>
		<input type = "hidden" name = "id" value="${pupToEdit.id}">
		<input type="submit" value="Save Pupdate"><br>
	</form>

</body>
</html>