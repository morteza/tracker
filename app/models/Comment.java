/*******************************************************************************
 *        File: Comment.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jan 31, 2014
 *     Project: tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package models;

import java.util.Date;

import javax.persistence.Id;

import play.db.ebean.Model;
import play.data.validation.*;

public class Comment extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@Constraints.Required
	public Account author;
	
	@Constraints.Required
	public String content;
	
	@Constraints.Required
	public Date createdAt;
	
	@Constraints.Required
	public Date updatedAt;
}
