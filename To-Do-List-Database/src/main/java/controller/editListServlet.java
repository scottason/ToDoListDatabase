package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Task;
import model.TaskList;


/**
 * Servlet implementation class editListServlet
 */
@WebServlet("/editListServlet")
public class editListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String taskListName = request.getParameter("task_list_name");
		Integer taskListId = Integer.parseInt(request.getParameter("id"));
		TaskListHelper tlh = new TaskListHelper();
		TaskList listToUpdate = tlh.searchForItemById(taskListId);
		listToUpdate.setTaskListName(taskListName);
		/*
		 * Grab the list of tasks 
		 */
		
		TaskHelper th = new TaskHelper();
		List<Task> tasksToUpdate =  listToUpdate.getListOfTasks();
		int taskCounter = 1;
		for (Task task : tasksToUpdate) {
			char taskCompleted;
			if (request.getParameter("task_completed_" + taskCounter) != null) {
				taskCompleted = request.getParameter("task_completed_" + taskCounter).charAt(0);
			} else {
				taskCompleted = 0;
			}
			
			String taskDesc = request.getParameter("task_description_" + taskCounter);
			String taskDueMonth = request.getParameter("task_due_month_" + taskCounter);
			String taskDueDay = request.getParameter("task_due_day_" + taskCounter);
			String taskDueYear = request.getParameter("task_due_year_" + taskCounter);
			
			LocalDate ld;
			try {
				ld = LocalDate.of(Integer.parseInt(taskDueYear), Integer.parseInt(taskDueMonth), Integer.parseInt(taskDueDay));
			} catch (NumberFormatException ex) {
				ld = LocalDate.now();
			}

			
			task.setTaskCompleted(taskCompleted);
			task.setTaskDesc(taskDesc);
			task.setTaskDueDate(ld);
			task.setTaskList(listToUpdate);
			th.updateItem(task);
			
			taskCounter++;
		}
		
		tlh.updateItem(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewTaskItemsServlet").forward(request, response);
	}

}
