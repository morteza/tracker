/*******************************************************************************
 *        File: Comment.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jan 31, 2014
 *     Project: com.ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package models2;

import java.util.Date;

import play.data.validation.Required;
import play.db.jpa.Model;

public class Comment extends Model {
	@Required
	public Account author;
	
	@Required
	public Issue issue;
	
	@Required
	public String content;
	
	@Required
	public Date writtenAt;
	
	@Required
	public Date updatedAt;
}
