package com.webster.rest.testool.dao;

import com.webster.rest.testool.entity.Project;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

	// define field for entitymanager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public ProjectDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Project> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Project> theQuery =
				currentSession.createQuery("from Project", Project.class);
		
		// execute query and get result list
		List<Project> Projects = theQuery.getResultList();
		
		// return the results		
		return Projects;
	}


	@Override
	public Project findById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the Project
		Project theProject =
				currentSession.get(Project.class, theId);
		
		// return the Project
		return theProject;
	}


	@Override
	public void save(Project theProject) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save Project
		currentSession.saveOrUpdate(theProject);
	}


	@Override
	public void deleteById(int theId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery(
						"delete from Project where id=:ProjectId");
		theQuery.setParameter("ProjectId", theId);
		
		theQuery.executeUpdate();
	}

}







