package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class ListItem {
	// Anthony Hamlin

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "TASK_DESCRIPTION")
	private String taskDesc;
	@Column(name = "TASK_DUE_DATE")
	private LocalDate task_due_date;
	@Column(name = "TASK_COMPLETED")
	private char taskCompleted;

	public ListItem() {
		super();
	}

	public ListItem(String newTask, String taskDescr, LocalDate newDate, char taskComp) {
		super();
		this.taskDesc = newTask;
		this.taskDesc = taskDescr;
		this.task_due_date = newDate;
		this.taskCompleted = taskComp;
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

	public LocalDate getTask_due_date() {
		return task_due_date;
	}

	public void setTask_due_date(LocalDate task_due_date) {
		this.task_due_date = task_due_date;
	}

	public char getTaskCompleted() {
		return taskCompleted;
	}

	public void setTaskCompleted(char taskCompleted) {
		this.taskCompleted = taskCompleted;
	}



}
