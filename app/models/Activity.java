/*******************************************************************************
 *        File: Activity.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jan 31, 2014
 *     Project: com.ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package models;

import java.util.Date;

import javax.persistence.Id;

import play.db.ebean.Model;
import play.data.validation.*;

public class Activity extends Model {
	
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	
	@Constraints.Required
	public Account account;
	
	@Constraints.Required
	public Project project;
	
	@Constraints.Required
	public ActivityType type;
	
	@Constraints.Required
	public String message;
	
	public String additionalInfo;
	
	//TODO: @InPast
	public Date timestamp;
}
