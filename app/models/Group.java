/*******************************************************************************
 *        File: Group.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jan 31, 2014
 *     Project: com.ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package models2;

import java.util.List;

import javax.persistence.ManyToMany;

import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;

public class Group extends Model {
	
	@Unique
	@Required
	public String name;
	
	@Required
	public Account account;
	
	@ManyToMany
	public List<Account> members;
}
