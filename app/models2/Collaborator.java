/*******************************************************************************
 *        File: Collaborator.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jan 31, 2014
 *     Project: com.ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package models2;

import play.data.validation.Email;
import play.data.validation.Password;
import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;

public class Collaborator extends Model {
	
	public String fullName;
	
	@Unique
	@Required
	@Email
	public String email;
	
	@Required
	@Password
	public String hashedPassword;
	
	public Project project;
}
