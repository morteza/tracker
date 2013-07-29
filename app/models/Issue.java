/*******************************************************************************
 *        File: Issue.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jul 26, 2013
 *     Project: Fuschia Tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/

package models;

import play.*;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
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
