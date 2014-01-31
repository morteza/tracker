/*******************************************************************************
 *        File: Issue.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jan 31, 2014
 *     Project: com.ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package models;

import java.util.Date;

import javax.persistence.ManyToOne;
import javax.persistence.Id;

import play.db.ebean.Model;
import play.data.validation.*;

public class Issue extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@Constraints.Required
	public IssueType type;
	
	@Constraints.Required
	public Date createAt;
	
	public Date modifiedAt;
	
	@Constraints.Required
	@ManyToOne
	public Project project;
	
	@Constraints.Required
	public String title;
	
	public String description;
}
