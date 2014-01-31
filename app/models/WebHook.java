/*******************************************************************************
 *        File: WebHook.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jan 31, 2014
 *     Project: com.ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package models2;

import play.data.validation.Required;
import play.data.validation.URL;
import play.db.jpa.Model;

public class WebHook extends Model {
	
	@Required
	public Account account;
	
	@Required
	public Project project;
	
	@Required
	@URL
	public String url;
}
