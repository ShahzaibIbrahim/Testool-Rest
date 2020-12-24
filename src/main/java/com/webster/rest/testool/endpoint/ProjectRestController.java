package com.webster.rest.testool.endpoint;

import com.webster.rest.testool.entity.Project;
import com.webster.rest.testool.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectRestController {

	private com.webster.rest.testool.service.ProjectService ProjectService;
	
	@Autowired
	public ProjectRestController(ProjectService theProjectService) {
		ProjectService = theProjectService;
	}
	
	// expose "/Projects" and return list of Projects
	@GetMapping("/Projects")
	public List<Project> findAll() {
		return ProjectService.findAll();
	}

	// add mapping for GET /Projects/{ProjectId}
	
	@GetMapping("/Projects/{ProjectId}")
	public Project getProject(@PathVariable int ProjectId) {
		
		Project theProject = ProjectService.findById(ProjectId);
		
		if (theProject == null) {
			throw new RuntimeException("Project id not found - " + ProjectId);
		}
		
		return theProject;
	}
	
	// add mapping for POST /Projects - add new Project
	
	@PostMapping("/Projects")
	public Project addProject(@RequestBody Project theProject) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theProject.setId(0);
		
		ProjectService.save(theProject);
		
		return theProject;
	}
	
	// add mapping for PUT /Projects - update existing Project
	
	@PutMapping("/Projects")
	public Project updateProject(@RequestBody Project theProject) {
		
		ProjectService.save(theProject);
		
		return theProject;
	}
	
	// add mapping for DELETE /Projects/{ProjectId} - delete Project
	
	@DeleteMapping("/Projects/{ProjectId}")
	public String deleteProject(@PathVariable int ProjectId) {
		
		Project tempProject = ProjectService.findById(ProjectId);
		
		// throw exception if null
		
		if (tempProject == null) {
			throw new RuntimeException("Project id not found - " + ProjectId);
		}
		
		ProjectService.deleteById(ProjectId);
		
		return "Deleted Project id - " + ProjectId;
	}
	
}










