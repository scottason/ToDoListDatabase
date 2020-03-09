package model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import model.TaskList;

@Entity
@Table(name = "TASKS")
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "TASK_DESCRIPTION")
	private String taskDesc;
	@Column(name = "TASK_DUE_DATE")
	private LocalDate taskDueDate;
	@Column(name = "TASK_COMPLETED")
	private char taskCompleted;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="TASK_LIST_ID")
	private TaskList taskList;

	public Task() {
		super();
	}
	
	public Task(String taskDesc, LocalDate taskDueDate) {
		this.taskDesc = taskDesc;
		this.taskDueDate = taskDueDate;
	}

	public Task(String taskDesc, LocalDate taskDueDate, char taskCompleted) {
		this.taskDesc = taskDesc;
		this.taskDueDate = taskDueDate;
		this.taskCompleted = taskCompleted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public LocalDate getTaskDueDate() {
		return taskDueDate;
	}

	public void setTaskDueDate(LocalDate taskDueDate) {
		this.taskDueDate = taskDueDate;
	}
	
	public char getTaskCompleted() {
		return taskCompleted;
	}

	public void setTaskCompleted(char taskCompleted) {
		this.taskCompleted = taskCompleted;
	}

	public TaskList getTaskList() {
		return taskList;
	}

	public void setTaskList(TaskList taskList) {
		this.taskList = taskList;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", taskDesc=" + taskDesc + ", taskDueDate=" + taskDueDate + ", taskCompleted="
				+ taskCompleted + ", taskList=" + taskList + "]";
	}
}
