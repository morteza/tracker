/*******************************************************************************
 *        File: Account.java
 *      Author: Morteza Ansarinia <morteza@ratnic.se>
 *  Created on: Jan 31, 2014
 *     Project: com.ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import play.db.ebean.Model;
import play.data.validation.*;

@Entity
public class Account extends Model {
	
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	
	public String fullName;
	
	/**
	 * Email address, rather than username, is used for authentication/authorization/etc.
	 */
	@Constraints.Required
	@Constraints.Email
	public String email;
		
	//TODO: @Password
	@Constraints.Required
	public String hashedPassword;
	
	//TODO: do users really need unique url? for what? It's under investigation! So it's private and transient for now.
	//TODO: @Unique
	@Transient
	private String userName;

	public Boolean isAdmin = false;
	public Boolean isGroupAccount = false;
	public Boolean isRemoved = false;
	public Boolean isConfirmed = false;
	
	//TODO: @URL
	public String homepage;
	
	//TODO: @InPast
	public Date registeredDate;
	
	//TODO: @InPast
	public Date updatedDate;
	
	//TODO: @InPast
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
	
	public static Finder<Long,Account> find = new Finder<Long, Account>(Long.class, Account.class);
	
	// CRUD operations
	public static List<Account> all() {
		return find.all();
	}

	public static void create(Account account) {
		account.save();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}
	
}
