/*******************************************************************************
 *        File: Issue.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jan 31, 2014
 *     Project: com.ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package models2;

import java.util.Date;

import javax.persistence.ManyToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

public class Issue extends Model {
	@Required
	public IssueType type;
	
	@Required
	public Date createAt;
	
	public Date modifiedAt;
	
	@Required
	@ManyToOne
	public Project project;
	
	@Required
	public String title;
	
	public String description;
}
