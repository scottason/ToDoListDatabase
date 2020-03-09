package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.TaskList;

public class TaskListHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("To-Do-List-Database");
	
	public void insertTaskList(TaskList tl) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(tl);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<TaskList> showAllTaskLists() {
		EntityManager em = emfactory.createEntityManager();
		List<TaskList> allTaskLists = em.createQuery("SELECT tl FROM TaskList tl").getResultList();
		return allTaskLists;
	}
	
	public TaskList searchForTaskListByName(String taskListName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<TaskList> typedQuery = em.createQuery("select tl from TaskList tl where tl.taskListName = :selectedName", TaskList.class);
		typedQuery.setParameter("selectedName", taskListName);
		typedQuery.setMaxResults(1);

		TaskList found = typedQuery.getSingleResult();
		em.close();
		return found;
	}	
	public TaskList searchForTaskListByID(int taskListID) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<TaskList> typedQuery = em.createQuery("select tl from TaskList tl where tl.id = :selectedID", TaskList.class);
		typedQuery.setParameter("selectedID", taskListID);
		typedQuery.setMaxResults(1);

		TaskList found = typedQuery.getSingleResult();
		em.close();
		return found;
	}
	
	public void deleteItem(TaskList toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<TaskList> typedQuery = em.createQuery(
				"select	li	from TaskList li where li.taskListName = :selectedSpecias",
				TaskList.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedSpecias", toDelete.getTaskListName());
		//typedQuery.setParameter("selectedPopulation", toDelete.getAmount());
		
		// we only want one result
		typedQuery.setMaxResults(1);
		//get the result and save it into a new list item
		TaskList result = typedQuery.getSingleResult();
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
  
	}
}