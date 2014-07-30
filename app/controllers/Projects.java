/*******************************************************************************
 *        File: Projects.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Feb 22, 2014
 *     Project: tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package controllers;

import java.io.File;
import java.util.Date;
import java.util.List;

import models.Project;
import models.Ticket;
import models.TicketState;
import play.data.Form;
import play.mvc.*;

@Security.Authenticated(Secured.class)
public class Projects extends Controller {
	
    public static Result index() {
    	return redirect(routes.Projects.list(0, "title", "asc", ""));
    }
    
    /**
     * List all projects that current user have access to.
     * @param page Current page number (starts from 0)
     * @param sortBy Column to be sorted
     * @param order Sort order (either asc or desc)
     * @param filter Filter applied on computer names
     */
    public static Result list(int page, String sortBy, String order, String filter) {
        //TODO find based on passed arguments!
        List<Project> projects = Project.find.all();
        return ok(views.html.projects.index.render(projects));
    }

    /**
     * Show project page.
     * @param project
     * @return
     */
    public static Result show(Project project) {
    	return TODO;
    }
  
    public static Result save() {
        Form<Project> projectForm = Form.form(Project.class).bindFromRequest();
        if(projectForm.hasErrors()) {
            return badRequest();
        }
        
        Project project = projectForm.get();
        
        File file = request().body().asMultipartFormData().getFile("avatarFile").getFile();
        
        project.avatarUrl = "/public/uploads/img/" + file.getName();
        project.createdAt = new Date();
        project.updatedAt = new Date();
        
        project.save();
        
        //FIXME redirect to index()
        return redirect("/");
    }

    public static Result update(Long id) {
    	return TODO;
    }

    public static Result edit(Long id) {
    	return TODO;
    }
    
    public static Result delete(Long id) {
        Project project = Project.find.byId(id);
        project.delete();
        //FIXME redirect to index()
    	return redirect("/");
    }

    public static Result board(Long id) {
        Project project = Project.find.byId(id);
        
        //FIXME fetch tickets that belongs to the passed id argument
        List<Ticket> proposals = Ticket.find.where().eq("state", TicketState.PROPOSAL).findList();
        List<Ticket> todos = Ticket.find.where().eq("state", TicketState.TODO).findList();
        List<Ticket> workings = Ticket.find.where().eq("state", TicketState.WORKING).findList();
        List<Ticket> dones = Ticket.find.where().eq("state", TicketState.DONE).findList();
        
        return ok(views.html.projects.board.render(project, proposals, todos, workings, dones));
    }
    
    
    /**
     * Manage project milestones
     * @param project
     * @return
     */
    public static Result milestones(Project project) {
    	return TODO;
    }
    
    public static Result help() {
    	return TODO;
    }
}
