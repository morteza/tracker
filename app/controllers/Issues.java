/*******************************************************************************
 *        File: Issues.java
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

public class Issues  extends Controller {

	@Before
	public static void listAllProjects() {
		List<Project> projects = Project.findAll();
		renderArgs.put("projects", projects);
	}
    
	public static void index() {
		todo();
	}
	
	public static void index(Long projectId) {
		todo();
	}

	public static void add(
		@Required(message="Project is required to add an issue.") Long projectId,
		@Required(message="Title is required.") String title,
		String description) {
	
		Project project = Project.findById(projectId);

		// Only accept POST submissions
		if ("GET".equalsIgnoreCase(request.method))
			render(project);
				
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
