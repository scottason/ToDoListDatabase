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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String act = request.getParameter("doThisToItem");
		TaskListHelper tlh = new TaskListHelper();
		// after all changes, we should redirect to the viewAllItems servlet
		// The only time we don't is if they select to add a new item or edit
		String path = "/viewTaskItemsServlet";

		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				TaskList itemToDelete = tlh.searchForItemById(tempId);
				tlh.deleteItem(itemToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}
		} else if (act.equals("view/edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				TaskList itemToEdit = tlh.searchForItemById(tempId);
				request.setAttribute("itemToEdit", itemToEdit);
				path = "/edit-task-list.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}
		} else if (act.equals("add")) {
			path = "/create-list.jsp";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);

	}

}
