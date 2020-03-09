import java.util.List;

import controller.TaskListHelper;
import model.Task;
import model.TaskList;

public class TaskTester {
	public static void main(String[] args) {

		TaskListHelper tlh = new TaskListHelper();
		TaskList taskListToView = tlh.searchForItemById(73);

		List<Task> tasks = taskListToView.getListOfTasks();

		for (Task t : tasks) {
			System.out.println(t.getTaskDueDate().plusDays(1));
		}	
	}
}
