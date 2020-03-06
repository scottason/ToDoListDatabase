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
	<form action="editItemServlet" method="post">
		<c:forEach items="${requestScope.allItems}" var="currentitem">
			<tr>
				<td>Task Description: <input type="text" name="store"
					value="${itemToEdit.TASK_DESCRIPTION}">
				</td>
				<td><input type="datetime" name="item"
					value="${itemToEdit.TASK_DUE_DATE}"></td>
				<td><input type="checkbox" name="task_completed"
				
				value="${itemToEdit.TASK_COMPLETED }"></td>
				<TD><input type="hidden" name="id"
					value="${itemToEdit.TASK_LIST_ID}"> <input type="submit"
					value="Save Edited Item"></TD>
			</tr>
		</c:forEach>
	</form>
</body>
</html>