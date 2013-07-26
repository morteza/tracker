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
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;

import models.Project;
import play.jobs.Job;

public class CreateProjectRepositories extends Job<Boolean> {

	private Git git;
	
	//FIXME move this to configuration
	public String TRACKER_BRANCH = "_tracker";
	
	public Boolean doJobWithResult() {
		List<Project> projects = Project.findAll();
		
		for (Project project : projects) {
			String repoPath = project.repository;
			
			File repoDir = new File(repoPath + "/.git");
			if (!repoDir.exists()) {
				// It's not a git repository
				break;
			}
			
			try {
				Repository repo = new FileRepository(repoDir.getAbsolutePath() + "/.git");
				git = new Git(repo);

				// Check if issues branch exists, otherwise create it
				List<Ref> branches = git.branchList().call();
				String[] bNames;
				boolean trackerInstalled = false;
				for (Ref branch : branches) {
					bNames = branch.getName().split("/");
					if (bNames[bNames.length-1].equalsIgnoreCase(TRACKER_BRANCH)) {
						trackerInstalled = true;
						break;
					}
				}
				
				// Checkout tracker branch (create if not setup before)
				String originalBranch = git.getRepository().getBranch();
				git.stashCreate().call();
				if (!trackerInstalled) {
					git.checkout()
						.setName(TRACKER_BRANCH)
						.setCreateBranch(true)
						.call();
				} else {
					git.checkout()
						.setName(TRACKER_BRANCH)
						.call();		
				}
				
				
				// Create tracker directory if necessary
				File trackerDir = new File(repoPath + "/.tracker");
				if (!trackerDir.exists())
					trackerDir.mkdirs();
				
				//TODO do the following for all the files added, and commit it
				/*
				git.add().addFilepattern("issues/."+fileName).call();
				git.commit()
					.setAuthor("Sandbox", "sandbox@localhost")
					.setMessage("Issue #" + id + " updated")
					.call();
				*/
				
				// Checkout original branch, and bring back stashes
				git.checkout().setName(originalBranch).call();
				git.stashApply().call();

			} catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
}
