/*******************************************************************************
 *        File: Account.java
 *      Author: Morteza Ansarinia <morteza@ratnic.se>
 *  Created on: Jan 31, 2014
 *     Project: ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Constraint;

import play.db.ebean.Model;
import play.data.validation.*;
import play.data.format.*;


@Entity
@Table(name="account")
public class Account extends Model {
	
	// Groups
	
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	
	
	@Constraints.Required
	public String fullname;
	
	/**
	 * Email address, rather than username, is used for authentication/authorization/etc.
	 */
	@Constraints.Required
	@Constraints.Email
	public String email;
	
	/** Encrypted using play.libs.Crypto.encryptAES. */
	//TODO: @Password
	@Constraints.Required
	public String hashedPassword;
	
	//TODO: @Unique
	@Constraints.Required
	public String username;

	public AccountRole role = AccountRole.GUEST;
	
	public Boolean isGroupAccount = false;
	public Boolean isRemoved = false;
	public Boolean isConfirmed = false;
	
	//TODO: @URL
	public String homepage;
	
	public Date registeredAt;
	public Date updatedAt;
	public Date lastLoginAt;
	
	// Path to the profile image
	public String image;
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(fullname)
			.append(" (")
			.append(email)
			.append("");
		return sb.toString();
	}
	
	public Boolean isAdmin() {
		return (this.role == AccountRole.ADMIN);
	}
	
	public static Account authenticate(String email, String password) {
	    try {
		Account account = find.where("email = :e").setParameter("e", email).findUnique();
		if (account!=null) {
		    if (account.hashedPassword.equals(play.libs.Crypto.encryptAES(password))) {
			return account;
		    }
		}
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
            return null;
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
