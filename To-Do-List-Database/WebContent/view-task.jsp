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
		<c:forEach items="${requestScope.certainItems}" var="currentitem">
			<tr><TD><input type="hidden" name="id"
					value="${currentitem.TASK_LIST_ID}"> <input type="submit"
					value="Save Edited Item"></TD>
				<td>${currentitem.TASK_DESCRIPTION}">
				</td>
				<td> ${currentitem.TASK_DUE_DATE}</td>
				<td> ${currentitem.TASK_COMPLETED }></td>
				
			</tr>
		</c:forEach>
		<input type = "submit" value ="edit" name ="editThisToItem">
		<input type = "submit" value ="delete" name ="deleteThisToItem">
		<input type = "submit" value ="add" name ="deleteThisToItem">
	</form>
</body>
</html>