/*******************************************************************************
 *        File: WebHook.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jan 31, 2014
 *     Project: ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package models;

import javax.persistence.Id;

import play.db.ebean.Model;
import play.data.validation.*;

public class WebHook extends Model {
	
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@Constraints.Required
	public Account account;
	
	@Constraints.Required
	public Project project;
	
	@Constraints.Required
	//TODO @URL
	public String url;
}
