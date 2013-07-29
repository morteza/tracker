/*******************************************************************************
 *        File: Projects.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jul 28, 2013
 *     Project: Fuschia Tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/

package controllers;

import java.util.List;

import models.Issue;
import models.Project;
import play.data.validation.Required;
import play.mvc.Before;
import play.mvc.Controller;

public class Projects extends Controller {
	
	@Before
	public static void listAll() {
		List<Project> projects = Project.findAll();
		renderArgs.put("projects", projects);
	}
    
    public static void overview(Long projectId) {
    	Project project = Project.findById(projectId);
    	if (project==null) {
        	//FIXME use messages to show the flash message
    		flash.error("Invalid project!");
    		flash.keep();
    		Application.index();
    	}
    	render(project);
    }
    
    public static void add(
    		@Required(message="Title is required.") String title,
    		@Required(message="Unique identifier is required.") String identifier,
    		String description,
    		String repository) {
    	
    	// Only accept POST submissions
    	if ("GET".equalsIgnoreCase(request.method))
    		render();
    	
    	Project newProject = new Project(title, identifier, description, repository);
    	newProject.save();
    	
    	//FIXME use messages to show the flash message
    	flash.success("Project " + title + " created successfully!");
    	flash.keep();
    	overview(newProject.id);
    }
    
	public static void addIssue(
			@Required(message="Project is required to add an issue.") Long projectId,
			@Required(message="Title is required.") String title,
			String description) {
		
			// Only accept POST submissions
			if ("GET".equalsIgnoreCase(request.method))
				render();
			
			Project project = Project.findById(projectId);
			
			Issue issue = new Issue();
			issue.title = title;
			issue.description = description;
			
			project.addIssue(issue);
			
			//FIXME use messages to show the flash message
			flash.success("Issue created successfully!");
			flash.keep();
			Projects.overview(projectId);
		}
}
