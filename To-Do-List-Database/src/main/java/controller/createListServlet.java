package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TaskList;
import model.Task;

/**
 * Servlet implementation class createListServlet
 */
@WebServlet("/createListServlet")
public class createListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String taskListName = request.getParameter("task_list_name");
		if (request.getParameter("task_list_name") != null && !request.getParameter("task_list_name").contentEquals("")) {
			
			List<Task> tasksEntered = new ArrayList<Task>();
			int taskCounter = 1;
			while(request.getParameter("task_description_" + taskCounter) != null) {
				if (request.getParameter("task_due_month_" + taskCounter) != null && 
					!request.getParameter("task_due_month_" + taskCounter).equals("") &&
					request.getParameter("task_due_day_" + taskCounter) != null && 
					!request.getParameter("task_due_day_" + taskCounter).equals("") &&
					request.getParameter("task_due_year_" + taskCounter) != null && 
					!request.getParameter("task_due_year_" + taskCounter).equals("")) {
					
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
					
					Task task = new Task(taskDesc, ld);
					tasksEntered.add(task);
				}
				taskCounter++;
			}
			
			TaskList taskList = new TaskList(taskListName, tasksEntered);
			
			TaskListHelper tlh = new TaskListHelper();
			tlh.insertTaskList(taskList);
		}
		
		getServletContext().getRequestDispatcher("/create-list.jsp").forward(request, response);
	}

}
