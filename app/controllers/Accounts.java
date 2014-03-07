/*******************************************************************************
 *        File: Accounts.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Feb 26, 2014
 *     Project: ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package controllers;

import models.Account;
import play.mvc.Controller;
import play.mvc.Result;

public class Accounts extends Controller {
      
    public static Result blank() {
        return TODO;
    }
  
    public static Result singup() {
        return TODO;
    }
  
    public static Result save() {
    	return TODO;
    }
    
    public static Result login(){
        return ok(views.html.login.render());
    }
    
    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out.");
        return redirect(routes.Accounts.login());
    }
    
    public static Result authenticate(){
        String username = request().body().asFormUrlEncoded().get("username")[0];
        String password = request().body().asFormUrlEncoded().get("password")[0];
        
        boolean authenticated = false;
        
        //TODO Check username and password and set authenticated value to true if it is validated
        Account account = Account.authenticate(username, password);
        
        if (account != null) {
            session().clear();
            session("email", username);
            //FIXME redirect to the Projects.index()
            return redirect("/");
        }
    
        return badRequest(views.html.login.render());
    }
  
}