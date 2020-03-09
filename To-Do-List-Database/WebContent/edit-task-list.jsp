<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link rel="stylesheet" href="css/toDoListApp.css" />
<title>To Do List App - Edit List</title>
</head>
<body>
<h1>Edit List</h1>
<form action="editListServlet" method="post">
	<input type="hidden" name="id" value="${itemToEdit.id}" />
	<fieldset>
		<legend>Edit List</legend>
		<div class="fieldGridWrapper">
			<div id="listNameRow">
				<label for="listNameFld">Name of your list:</label> 
				<input id="listNameFld" type="text" name="task_list_name" maxlength="60" value="${itemToEdit.taskListName}" />
			</div>
			<c:set var="count" value="0" scope="page" />
			<c:forEach items="${itemToEdit.listOfTasks}" var="currentitem">
				<c:set var="count" value="${count + 1}" scope="page" />
				
				<div id="taskRow_${count}" class="taskRow">
				<c:set var="taskCompleted" value="${currentitem.taskCompleted}" scope="page" />
				
					<input id="task" class="taskCompleted" type="checkbox" name="task_completed_${count}" value="Y" <c:if test="${taskCompleted eq 'Y'.charAt(0)}">checked</c:if> />
				
					<label for="taskDescFld_${count}">Task ${count}:</label> 
					<input id="taskDescFld_${count}" type="text" name="task_description_${count}" maxlength="280" value="${currentitem.taskDesc}" />
					<label for="taskDueMMFld_${count}">Due Date:</label>
					<input id="taskDueMMFld_${count}" class="taskDueMMFld" type="number" name="task_due_month_${count}" placeholder="mm" min="1" max="12" value="${currentitem.taskDueDate.getMonthValue()}" /> 
					<input id="taskDueDDFld_${count}" class="taskDueDDFld" type="number" name="task_due_day_${count}" placeholder="dd" min="1" max="31" value="${currentitem.taskDueDate.getDayOfMonth()}" /> 
					<input id="taskDueYYYYFld_${count}" class="taskDueYYYYFld" type="number" name="task_due_year_${count}" placeholder="yyyy" min="2020" max="9999" value="${currentitem.taskDueDate.getYear()}" />
				</div>
			</c:forEach>
		</div>
	</fieldset>
	
	<input class="btn" type="submit" value="Save Changes" />
</form>
<a class="btn" href="index.html">Home</a>
<a class="btn" href="viewTaskItemsServlet">View all of your lists</a>
</body>
</html>