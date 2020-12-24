package com.webster.rest.testool.service;


import com.webster.rest.testool.entity.Project;

import java.util.List;

public interface ProjectService {

	public List<Project> findAll();
	
	public Project findById(int theId);
	
	public void save(Project theProject);
	
	public void deleteById(int theId);
	
}
