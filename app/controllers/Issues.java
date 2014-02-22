/*******************************************************************************
 *        File: Issues.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Feb 16, 2014
 *     Project: ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package controllers;

import models.Account;
import models.Issue;
import models.Project;
import play.mvc.*;

public class Issues extends Controller {

    public static Result index() {
        return TODO;
    }
    
    
    /**
     * List your issues (or a project's issues)
     * @param project
     * @return
     */
    public static Result list(Project project) {
    	return TODO;
    }

    /**
     * Show an issue's details.
     * @param issue
     * @return
     */
    public static Result show(Issue issue) {
    	return TODO;
    }

    /**
     * Open (or reopen) an issue.
     * @param issue
     * @return
     */
    public static Result open(Issue issue) {
    	return TODO;
    }

    /**
     * Close an issue.
     * @param issue
     * @return
     */
    public static Result close(Issue issue) {
    	return TODO;
    }

    /**
     * Modify an existing issue.
     * @param issue
     * @return
     */
    public static Result edit(Issue issue) {
    	return TODO;
    }

    /**
     * Leave a comment on an issue.
     * @param issue
     * @return
     */
    public static Result comment(Issue issue) {
    	return TODO;
    }

    /**
     * Assign a label to an issue.
     * @param issue
     * @return
     */
    public static Result label(Issue issue) {
    	return TODO;
    }

    /**
     * Assign an issue to specific user
     * @param issue
     * @param account
     * @return
     */
    public static Result assign(Issue issue, Account account) {
    	return TODO;
    }

    /**
     * Unassigns an issue
     * TODO write "listAssigned", "listUnassigned", and "" actions. Or add them to the list somehow...
     * @param issue
     * @return
     */
    public static Result unassign(Issue issue) {
    	return TODO;
    }
    
    public static Result help() {
    	return TODO;
    }
}
