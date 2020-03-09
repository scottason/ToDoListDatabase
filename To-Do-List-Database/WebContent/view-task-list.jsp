<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link rel="stylesheet" href="css/toDoListApp.css" />
<style>
	.fieldGridWrapper {
		grid-template-columns: 13px auto;
	}
	.fieldGridWrapper input {
		justify-self: start;
	}
	.fieldGridWrapper label {
		justify-self: start;
	}
</style>
<title>To Do List App - All Lists</title>
</head>
<body>
	<h1>To Do Lists</h1>
	<form method="post" action="navigationServlet">
		<fieldset>
			<legend>Perform List Actions</legend>
			<div class="fieldGridWrapper">
			<c:set var="count" value="0" scope="page" />
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<c:set var="count" value="${count + 1}" scope="page" />
				<input id="taskList_${count}" type="radio" name="id" value="${currentitem.id}" />
				<label for="taskList_${count}">${currentitem.taskListName}</label>
			</c:forEach>
			</div>
		</fieldset>
		<input class="btn" type="submit" value="view/edit" name="doThisToItem" />
		<input class="btn" type="submit" value="delete" name="doThisToItem" />
		<input class="btn" type="submit" value ="add" name="doThisToItem" />
	</form>
	<a class="btn" href="index.html">Home</a>
</body>
</html>