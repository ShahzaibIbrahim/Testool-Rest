package com.webster.rest.testool.dao;

import com.webster.rest.testool.entity.Project;

import java.util.List;

public interface ProjectDAO {

	public List<Project> findAll();
	
	public Project findById(int theId);
	
	public void save(Project theProject);
	
	public void deleteById(int theId);
	
}
