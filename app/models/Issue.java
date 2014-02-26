/*******************************************************************************
 *        File: Issue.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jan 31, 2014
 *     Project: ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package models;

import java.util.Date;
import java.util.List;

import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.validation.Constraint;

import play.db.ebean.Model;
import play.data.validation.*;

public class Issue extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@Constraints.Required
	public String title;		
	public String description;

	@Constraints.Required
	public Account creator;
	public Account assignee;
	
	@Constraints.Required
	public IssueType type;
	
	//TODO temporary. Use status instead!
	@Constraints.Required
	public Boolean closed = false;
	
	public List<Tag> tags;

	public List<Comment> comments;
	
	public Milestone milestone;
	
	@Constraints.Required
	public Date createdAt;
	public Date closedAt;
	public Date updatedAt;
	
	@Constraints.Required
	@ManyToOne
	public Project project;
	
	public void close() {
		this.closedAt = new Date();
		this.closed = true;
		this.updatedAt = new Date();
		this.save();
	}
	
	public int getNumOfComments() {
		return (comments==null)?0:comments.size();
	}
	
	public void addTag(Tag tag) {
		this.tags.add(tag);
		this.save();
	}

	public void addComment(Comment comment) {
		this.comments.add(comment);
		this.save();
	}
}
