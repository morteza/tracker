/*******************************************************************************
 *        File: Application.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jul 26, 2013
 *     Project: Fuschia Tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/

package controllers;

import play.*;
import play.data.validation.Required;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

	@Before
	public static void listProjects() {
		List<Project> projects = Project.findAll();
		renderArgs.put("projects", projects);
	}
	
    public static void index() {
    	List<Issue> stories;
    	stories = Issue.findAll();
        render(stories);
    }
    
    public static void overview(Long projectId) {
    	Project project = Project.findById(projectId);
    	if (project==null) {
        	//FIXME use messages to show the flash message
    		flash.error("Invalid project!");
    		flash.keep();
    		index();
    	}
    	render(project);
    }
    
    public static void newProjectPage() {
    	renderTemplate("Application/newProject.html");
    }
    
    public static void newProject(
    		@Required(message="Title is required.") String title,
    		@Required(message="Unique identifier is required.") String identifier,
    		String description,
    		String repository) {
    	
    	Project newProject = new Project(title, identifier, description, repository);
    	newProject.save();
    	
    	//FIXME use messages to show the flash message
    	flash.success("Project " + title + " created successfully!");
    	flash.keep();
    	overview(newProject.id);
    }
}