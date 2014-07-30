/*******************************************************************************
 *        File: Issues.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Feb 16, 2014
 *     Project: tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package controllers;

import models.Project;
import models.Ticket;
import models.TicketState;
import play.data.Form;
import play.mvc.*;

@Security.Authenticated(Secured.class)
public class Tickets extends Controller {

	
    public static Result index() {
        return TODO;
    }
    
    public static Result save(Long projectId) {
        
        Form<Ticket> ticketForm = Form.form(Ticket.class).bindFromRequest();
        if(ticketForm.hasErrors()) {
            return badRequest();
        }
                
        Project project = Project.find.byId(projectId);
        
        Ticket ticket = ticketForm.get();
        ticket.project = project;
        ticket.save();
        
        project.save();
        
        //FIXME redirect to index()
        return redirect("/"+projectId);
    }
    
    
    /**
     * List your issues (or a project's issues)
     * @param project
     * @return
     */
    public static Result list() {
    	return TODO;
    }

    /**
     * Show an issue's details.
     * @param issue
     * @return
     */
    public static Result show(Long id) {
    	return TODO;
    }

    public static Result move(Long ticketId) {
        Ticket ticket = Ticket.find.byId(ticketId);
        
        int newValueIndex = (ticket.state.ordinal()+1)%TicketState.values().length;
        
        /**
         * Don't move back straight from done to proposal!
         */
        if (newValueIndex == 0)
            newValueIndex = TicketState.values().length - 1;

        ticket.state = TicketState.values()[newValueIndex];
        ticket.save();
        
    	return redirect("/"+ticket.project.id);
    }

    public static Result back(Long ticketId) {
        Ticket ticket = Ticket.find.byId(ticketId);
        
        int newValueIndex = (ticket.state.ordinal()-1)%TicketState.values().length;
        
        /**
         * Don't move to done from proposal state!
         */
        if (newValueIndex<0)
            newValueIndex = 0;
        
        ticket.state = TicketState.values()[newValueIndex];
        ticket.save();
        
        return redirect("/"+ticket.project.id);
    }

    public static Result delete(Long id) {
        Ticket ticket = Ticket.find.byId(id);
        Long projectId = ticket.project.id;
        
        ticket.delete();
        
        //FIXME redirect to index()
        return redirect("/" + projectId);
    }

    /**
     * Modify an existing issue.
     * @param issue
     * @return
     */
    public static Result edit(Long id) {
    	return TODO;
    }

    /**
     * Leave a comment on an issue.
     * @param issue
     * @return
     */
    public static Result comment(Long id) {
    	return TODO;
    }

    /**
     * Assign a label to an issue.
     * @param issue
     * @return
     */
    public static Result label(Long id) {
    	return TODO;
    }

    /**
     * Assign an issue to specific user
     * @param issue
     * @param account
     * @return
     */
    public static Result assign(Long issueId, Long accountId) {
    	return TODO;
    }

    /**
     * Unassigns an issue
     * TODO write "listAssigned", "listUnassigned", and "" actions. Or add them to the list somehow...
     * @param issue
     * @return
     */
    public static Result unassign(Long id) {
    	return TODO;
    }
    
    public static Result help() {
    	return TODO;
    }
}
