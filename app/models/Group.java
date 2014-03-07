/*******************************************************************************
 *        File: Group.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jan 31, 2014
 *     Project: ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package models;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Id;

import play.db.ebean.Model;
import play.data.validation.*;

public class Group extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	//TODO @Unique
	@Constraints.Required
	public String name;
	
	@Constraints.Required
	public Account owner;
	
	@ManyToMany
	public List<Account> members;
}
