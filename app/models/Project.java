/*******************************************************************************
 *        File: Project.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jan 31, 2014
 *     Project: com.ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package models2;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import play.data.validation.InPast;
import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;

public class Project extends Model {
	
	@Required
	public Account owner;
	
	@Required
	public Project parent;
	
	@Required
	@Unique
	public String name;
	public String description;
	
	public Boolean isPrivate = false;
	
    @OneToMany(mappedBy="project", cascade=CascadeType.ALL)
	public List<Issue> issues;

	public Date registeredAt;	
	public Date updatedAt;
	public Date lastActivityAt;
}
