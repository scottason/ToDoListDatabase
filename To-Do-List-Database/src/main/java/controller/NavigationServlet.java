package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TaskList;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String act = request.getParameter("doThisToItem");
		TaskListHelper dao = new TaskListHelper();
		// after all changes, we should redirect to the viewAllItems servlet
		// The only time we don't is if they select to add a new item or edit
		String path = "/viewAllItemsServlet";
	

		if (act.equals("delete")) {
			try {
			String tempId = request.getParameter("taskListName");
			TaskList itemToDelete = dao.searchForTaskListByName(tempId);
			dao.deleteItem(itemToDelete);
			}
			catch(NumberFormatException e){
				System.out.println("Forgot to select an item");
				
			}
		} else if (act.equals("edit")) {
			try {
				String tempId = request.getParameter("taskListName");
			TaskList itemToEdit = dao.searchForTaskListByName(tempId);
			request.setAttribute("itemToEdit", itemToEdit);
			path = "/edit-item.jsp";
			}
			catch(NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}
		
		}
		else if(act.equals("view")) {
			try {
				String tempId =request.getParameter("id");
				request.setAttribute("currentItems",tempId);
				path="/view-task.jsp";
			}catch(NumberFormatException e) {
				System.out.println("forgot to select an item");
			}
		}else if (act.equals("add")) {
		path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request,response);
		
	}

}
