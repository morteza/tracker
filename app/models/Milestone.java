/*******************************************************************************
 *        File: Milestone.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jan 31, 2014
 *     Project: com.ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package models2;

import java.util.Date;

import play.data.validation.InFuture;
import play.data.validation.Required;
import play.db.jpa.Model;

public class Milestone extends Model {
	
	@Required
	public Account author;
	
	@Required
	public Project project;
	
	@Required
	public String title;
	public String description;

	@InFuture
	public Date due;
	
	public Date closedAt;
}
