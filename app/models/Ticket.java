/*******************************************************************************
 *        File: Ticket.java
 *    Revision: 2
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jan 31, 2014
 *     Project: ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Id;

import play.db.ebean.Model;
import play.data.validation.*;

@Entity
public class Ticket extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@Constraints.Required
	public String title;	
	public String description;

	//@Constraints.Required
//	public Account creator;
	
	public Account assignee;
	
	@Constraints.Required
	public TicketState state = TicketState.PROPOSAL;
	
	//TODO temporary. Use status instead!
	//@Constraints.Required
	public Boolean closed = false;
	
	//public List<Tag> tags;

	//public List<Comment> comments;
	
	public Milestone milestone;
	
	//@Constraints.Required
	public Date createdAt;
	public Date closedAt;
	public Date updatedAt;
	
	//FIXME @Constraints.Required
	@ManyToOne
	public Project project;
	
	/**
	 * Generic query helper for entity Computer with id Long
	 */
	public static Finder<Long, Ticket> find = new Finder<Long, Ticket>(Long.class, Ticket.class); 

	    
	public void close() {
		this.closedAt = new Date();
		this.closed = true;
		this.updatedAt = new Date();
		this.save();
	}
	
}
