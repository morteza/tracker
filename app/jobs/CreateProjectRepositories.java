/*******************************************************************************
 *        File: CreateProjectRepositories.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jul 26, 2013
 *     Project: Fuschia Tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/

package jobs;

import java.io.File;
import java.util.List;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;

import models.Project;
import play.jobs.Job;

public class CreateProjectRepositories extends Job<Boolean> {

	private Git git;
	
	public Boolean doJobWithResult() {
		List<Project> projects = Project.findAll();
		
		for (Project project : projects) {
			String repoName = project.identifier;
			File repoDir = new File("repositories/" + repoName);
			if (repoDir.exists()) {
				//TODO remove it to create it again
			}
			
			// Create git repository inside the working directory
			repoDir.mkdirs();
			try {
				Repository repo = new FileRepository(repoDir.getAbsolutePath() + "/.git");
				repo.create();
				git = new Git(repo);
				
				//TODO create and fill project info file
				//TODO create issues directory
				//TODO serialized all issues of the project to the issues directory
				//TODO add the repository as submodule to the actual project repository
				
			} catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
}
