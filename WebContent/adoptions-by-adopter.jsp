<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adoption Details</title>
</head>
<body>

	<form method="post" action="">
		<table>
			<c:forEach items="${requestScope.allAdoptions}" var="currentlist">
				<tr>
					<td><input type="radio" name="id" value="${currentlist.id}"></td>
					<td><h2>${currentlist.coordinatorName}</h2></td>
				</tr>
				<tr>
					<td colspan="3">Adoption Date: ${currentlist.adoptionDate}</td>
				</tr>
				<tr>
					<td colspan="3">Adopter: ${currentlist.adopter.adopterName}</td>
				</tr>
				<c:forEach var="listVal" items="${currentlist.listOfPups}">
					<tr>
						<td></td>
						<td colspan="3">${listVal.name},${listVal.favToy},${listVal.status}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToItem"> <input
			type="submit" value="delete" name="doThisToItem"> <input
			type="submit" value="add" name="doThisToItem">
	</form>
	<a href="addAdopterForAdoptionServlet">Create Adoptions</a>
	<a href="index.html">Home</a>

</body>
</html>