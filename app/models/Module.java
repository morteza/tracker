/*******************************************************************************
 *        File: Issue.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jan 31, 2014
 *     Project: ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package models;

import java.util.Date;

import javax.persistence.ManyToOne;
import javax.persistence.Id;

import play.db.ebean.Model;
import play.data.validation.*;

public class Module extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@Constraints.Required
	public String title;	

	@Constraints.Required
	public Account creator;
	
	public String description;
	
	@Constraints.Required
	public Date createdAt;
	
	public Date modifiedAt;
	
	@Constraints.Required
	@ManyToOne
	public Project project;	
}
