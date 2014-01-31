/*******************************************************************************
 *        File: Activity.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jan 31, 2014
 *     Project: com.ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package models2;

import java.util.Date;

import play.data.validation.InPast;
import play.data.validation.Required;
import play.db.jpa.Model;

public class Activity extends Model {

	@Required
	public Account account;
	
	@Required
	public Project project;
	
	@Required
	public ActivityType type;
	
	@Required
	public String message;
	
	public String additionalInfo;
	
	@InPast
	public Date timestamp;
}
