/*******************************************************************************
 *        File: Collaborator.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jan 31, 2014
 *     Project: com.ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package models;

import javax.persistence.Id;

import play.db.ebean.Model;
import play.data.validation.*;


public class Collaborator extends Model {
	
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	
	public String fullName;
	
	//TODO @Unique
	@Constraints.Required
	@Constraints.Email
	public String email;
	
	@Constraints.Required
	//TODO @Password
	public String hashedPassword;
	
	public Project project;
}
