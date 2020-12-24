package com.webster.rest.testool.service;

import com.webster.rest.testool.dao.ProjectDAO;
import com.webster.rest.testool.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

	private ProjectDAO ProjectDAO;
	
	@Autowired
	public ProjectServiceImpl(com.webster.rest.testool.dao.ProjectDAO theProjectDAO) {
		ProjectDAO = theProjectDAO;
	}
	
	@Override
	@Transactional
	public List<Project> findAll() {
		return ProjectDAO.findAll();
	}

	@Override
	@Transactional
	public Project findById(int theId) {
		return ProjectDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Project theProject) {
		ProjectDAO.save(theProject);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		ProjectDAO.deleteById(theId);
	}

}






