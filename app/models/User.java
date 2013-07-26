/*******************************************************************************
 *        File: User.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jul 26, 2013
 *     Project: Fuschia Tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/

package models;

import play.*;
import play.data.validation.Email;
import play.data.validation.Password;
import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class User extends Model {

	@Required
	public String fullname;
	
	@Email
	@Unique
	@Required
	public String email;
	
	@Required
	@Password
	public String password;
    
}
