<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link rel="stylesheet" href="css/toDoListApp.css" />
<style>
	fieldset {
		padding-bottom: 15px;
	}
	.fieldGridWrapper {
		display: grid;
		grid-gap: 10px;
	}
	.fieldGridWrapper label {
		width: auto;
		white-space: nowrap;
	}
	.taskRow {
		display: grid;
		grid-template-columns: repeat(6, auto);
		grid-gap: 10px;
	}
	label[for=listNameFld] {
		margin-right: 10px;
	}
	.taskDueMMFld, .taskDueDDFld, .taskDueYYYYFld {
		width: 50px;
	}
</style>
<title>To Do List App - Create List</title>
</head>
<body>
<h1>Create List</h1>
<form action="createListServlet" method="post">
	<fieldset>
		<legend>Create List</legend>
		<div class="fieldGridWrapper">
			<div id="listNameRow">
				<label for="listNameFld">Name of your list:</label> <input id="listNameFld" type="text" name="task_list_name" maxlength="60" />
			</div>
			<div id="taskRow_1" class="taskRow">
				<label for="taskDescFld_1">Task 1:</label> <input id="taskDescFld_1" type="text" name="task_description_1" maxlength="280" />
				<label for="taskDueMMFld_1">Due Date:</label>
				<input id="taskDueMMFld_1" class="taskDueMMFld" type="number" name="task_due_month_1" placeholder="mm" maxlength="2" /> 
				<input id="taskDueDDFld_1" class="taskDueDDFld" type="number" name="task_due_day_1" placeholder="dd" maxlength="2" /> 
				<input id="taskDueYYYYFld_1" class="taskDueYYYYFld" type="number" name="task_due_year_1" placeholder="yyyy" maxlength="4" />
			</div>
			<div id="taskRow_2" class="taskRow">
				<label for="taskDescFld_2">Task 2:</label> <input id="taskDescFld_2" type="text" name="task_description_2" maxlength="280" />
				<label for="taskDueMMFld_2">Due Date:</label>
				<input id="taskDueMMFld_2" class="taskDueMMFld" type="number" name="task_due_month_2" placeholder="mm" maxlength="2" /> 
				<input id="taskDueDDFld_2" class="taskDueDDFld" type="number" name="task_due_day_2" placeholder="dd" maxlength="2" /> 
				<input id="taskDueYYYYFld_2" class="taskDueYYYYFld" type="number" name="task_due_year_2" placeholder="yyyy" maxlength="4" />
			</div>
			<div id="taskRow_3" class="taskRow">
				<label for="taskDescFld_3">Task 3:</label> <input id="taskDescFld_3" type="text" name="task_description_3" maxlength="280" />
				<label for="taskDueMMFld_3">Due Date:</label>
				<input id="taskDueMMFld_3" class="taskDueMMFld" type="number" name="task_due_month_3" placeholder="mm" maxlength="2" /> 
				<input id="taskDueDDFld_3" class="taskDueDDFld" type="number" name="task_due_day_3" placeholder="dd" maxlength="2" /> 
				<input id="taskDueYYYYFld_3" class="taskDueYYYYFld" type="number" name="task_due_year_3" placeholder="yyyy" maxlength="4" />
			</div>
		</div>
	</fieldset>
	
	<input class="btn" type="submit" value="Create List" />
</form>
<a class="btn" href="viewTaskItemsServlet">View all of your lists</a>
</body>
</html>