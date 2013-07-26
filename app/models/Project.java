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
	public String uniqueName;
	
	public String description;
	
    @OneToMany(mappedBy="project", cascade=CascadeType.ALL)
	public List<Issue> issues;
	
	public Repository repository;
	
    public Project addIssue(Issue newIssue) {
        this.issues.add(newIssue);
        this.save();
        return this;
    }
}
