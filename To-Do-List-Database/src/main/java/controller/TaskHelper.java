package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Task;
import model.TaskList;

public class TaskHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("To-Do-List-Database");

	public void insertItem(Task t) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	public List<Task> showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		List<Task> allItems = em.createQuery("SELECT t FROM Task t").getResultList();
		return allItems;
	}

	public void deleteItem(Task toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Task> typedQuery = em.createQuery(
				"select t from Task t where t.taskDesc = :selectedTaskDesc and t.taskDueDate = :selectedTaskDueDate and t.taskCompleted = :selectedTaskCompleted",
				Task.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedTaskDesc", toDelete.getTaskDesc());
		typedQuery.setParameter("selectedTaskDueDate", toDelete.getTaskDueDate());
		typedQuery.setParameter("selectedTaskCompleted", toDelete.getTaskCompleted());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		Task result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Task searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Task found = em.find(Task.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(Task toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp(){
		emfactory.close();
	}

}
