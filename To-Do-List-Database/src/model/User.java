package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TASK_LIST")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="TASK_LIST-NAME")
	private String taskListName;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String shopperName) {
		super();
		this.id = id;
		this.taskListName = shopperName;
	}
	public User(String shopperName) {
		super();
		this.taskListName = shopperName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShopperName() {
		return taskListName;
	}
	public void setShopperName(String shopperName) {
		this.taskListName = shopperName;
	}
	@Override
	public String toString() {
		return "Shopper [id=" + id + ", shopperName=" +
				taskListName + "]";
	}

}