package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TASK_LISTS")
public class TaskList {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="TASK_LIST_NAME")
	private String taskListName;
	 
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="taskList")
	private List<Task> listOfTasks;
	
	public TaskList() {
		super();
	}

	public TaskList(String taskListName) {
		this.taskListName = taskListName;
	}
	
	public TaskList(String taskListName, List<Task> listOfTasks) {
		this.taskListName = taskListName;
		this.listOfTasks = listOfTasks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskListName() {
		return taskListName;
	}

	public void setTaskListName(String taskListName) {
		this.taskListName = taskListName;
	}
	
	public List<Task> getListOfTasks() {
		return listOfTasks;
	}

	public void setListOfTasks(List<Task> listOfTasks) {
		this.listOfTasks = listOfTasks;
	}

	@Override
	public String toString() {
		return "TaskList [id=" + id + ", taskListName=" + taskListName + ", listOfTasks=" + listOfTasks + "]";
	}
	
}