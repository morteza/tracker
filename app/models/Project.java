/*******************************************************************************
 *        File: Project.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jan 31, 2014
 *     Project: ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Id;

import play.db.ebean.Model;
import play.data.validation.*;
import play.data.format.*;
import play.i18n.Messages;

@Entity
public class Project extends Model {

    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    //@Constraints.Required
    public Account owner;

    //	@Constraints.Required
    //	public Project parent;

    @Constraints.Required
    public String title;

    public String description = Messages.get("ratnic.tracker.not_available");

    public Boolean isPrivate = false;

    @OneToMany(mappedBy="project", cascade=CascadeType.ALL)
    public List<Ticket> tickets;

    @Formats.DateTime(pattern="MMM dd,yyyy")
    public Date createdAt;
    
    @Formats.DateTime(pattern="MMM dd,yyyy")
    public Date updatedAt;
    
    public String avatarUrl;

    /**
     * Generic query helper for entity Computer with id Long
     */
    public static Finder<Long,Project> find = new Finder<Long,Project>(Long.class, Project.class); 

    /**
     * Return a page of project
     *
     * @param page Page to display
     * @param pageSize Number of computers per page
     * @param sortBy Project property used for sorting
     * @param order Sort order (either or "asc" or "desc")
     * @param filter Filter applied on the name column
     */
    /*
    public static com.avaje.ebean.Page<Project> page(int page, int pageSize, String sortBy, String order, String filter) {
        return find.where()
                .ilike("name", "%" + filter + "%")
                .orderBy(sortBy + " " + order)
                .fetch("issues") // To fetch all related issues to this project too.
                .findPagingList(pageSize)
                .setFetchAhead(false)
                .getPage(page);
    }*/
}
