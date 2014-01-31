/*******************************************************************************
 *        File: Account.java
 *      Author: Morteza Ansarinia <morteza@ratnic.se>
 *  Created on: Jan 31, 2014
 *     Project: com.ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package models2;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Transient;

import play.data.validation.Email;
import play.data.validation.InPast;
import play.data.validation.Password;
import play.data.validation.Required;
import play.data.validation.URL;
import play.data.validation.Unique;
import play.db.jpa.Model;

@Entity
public class Account extends Model {
	
	public String fullName;
	
	/**
	 * Email address, rather than username, is used for authentication/authorization/etc.
	 */
	@Unique
	@Required
	@Email
	public String email;
		
	@Password
	@Required
	public String hashedPassword;
	
	//TODO: do users need unique url? for what? It's under investigation! So it's private and transient for now.
	@Unique
	@Transient
	private String userName;

	public Boolean isAdmin = false;
	public Boolean isGroupAccount = false;
	public Boolean isRemoved = false;
	public Boolean isConfirmed = false;
	
	@URL
	public String homepage;
	
	@InPast
	public Date registeredDate;
	
	@InPast
	public Date updatedDate;
	
	@InPast
	public Date lastLoginDate;
	
	public String imagePath;
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(fullName)
			.append(" (")
			.append(email)
			.append("");
		return sb.toString();
	}
}
