/*******************************************************************************
 *        File: Project.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jan 31, 2014
 *     Project: com.ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.Id;

import play.db.ebean.Model;
import play.data.validation.*;

public class Project extends Model {
	
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@Constraints.Required
	public Account owner;
	
	@Constraints.Required
	public Project parent;
	
	@Constraints.Required
	//TODO @Unique
	public String name;
	public String description;
	
	public Boolean isPrivate = false;
	
    @OneToMany(mappedBy="project", cascade=CascadeType.ALL)
	public List<Issue> issues;

	public Date registeredAt;	
	public Date updatedAt;
	public Date lastActivityAt;
}
