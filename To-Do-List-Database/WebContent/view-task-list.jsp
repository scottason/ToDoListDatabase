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
<form method = "post" action = "viewTaskServerlet">
<table>
<c:forEach items="${requestScope.allItems}" var="currentitem">
<tr>
<td><input type="radio" name="id" value="${currentitem.id}"></td>
<td>${currentitem.taskListName}</td>

</tr>
</c:forEach>
</table>
<input type = "submit" value ="edit" name ="editThisToItem">
		<input type = "submit" value ="delete" name ="deleteThisToItem">
		<input type = "submit" value ="add" name ="deleteThisToItem">

<input type = "submit" value ="view" name ="viewThisToItem">
</form>
</body>
</html>