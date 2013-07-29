/*******************************************************************************
 *        File: Project.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jul 26, 2013
 *     Project: Fuschia Tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/

package models;

import play.*;
import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class Project extends Model {

	@Required
	public String title;
	
	@Unique
	@Required
	public String identifier;
	
	public String description;
	
    @OneToMany(mappedBy="project", cascade=CascadeType.ALL)
	public List<Issue> issues;
	
	public String repository;
	
	public Project(String title, String identifier, String description, String repositoryAddress) {
		this.title = title;
		this.identifier = identifier;
		this.description = description;
		this.repository = repositoryAddress.trim();
		
		if (this.repository.endsWith("/")) {
			this.repository = this.repository.substring(0, repositoryAddress.length()-1);
		}
	}
	
    public Project addIssue(Issue newIssue) {
    	newIssue.project = this;
        this.issues.add(newIssue);
        this.save();
        return this;
    }
}
