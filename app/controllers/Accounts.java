/*******************************************************************************
 *        File: Accounts.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Feb 26, 2014
 *     Project: ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package controllers;

import java.io.File;
import java.util.Date;
import java.util.List;

import models.Account;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Accounts extends Controller {

    public static Result index() {
    	return redirect(routes.Projects.list(0, "email", "asc", ""));
    }

    /**
     * List all accounts to the admin.
     * @param page Current page number (starts from 0)
     * @param sortBy Column to be sorted
     * @param order Sort order (either asc or desc)
     * @param filter Filter applied on computer names
     */
    public static Result list(int page, String sortBy, String order, String filter) {
        //TODO find based on passed arguments!
        List<Account> accounts = Account.find.all();
        return ok(views.html.accounts.index.render(accounts));
    }
    
    public static Result show(Long id) {
        return TODO;
    }
  
    public static Result singup() {
    	//TODO show a signup page including fullname, email, and password
        return TODO;
    }
  
    public static Result save() {
    	    	
        Form<Account> accountForm = Form.form(Account.class).bindFromRequest();
        if(accountForm.hasErrors()) {
        	return badRequest();
        }


        Account account = accountForm.get();
        
        //File file = request().body().asMultipartFormData().getFile("avatarFile").getFile();
        
        //account.avatarUrl = "/public/uploads/img/" + file.getName();
        account.createdAt = new Date();
        account.updatedAt = new Date();
        
        //FIXME remove, and add a button instead
        //account.isConfirmed = true;
        
        account.save();
        
        //FIXME redirect to index() via Call
        return redirect("/accounts");
    }

    public static Result update(Long id) {
    	return TODO;
    }

    public static Result delete(Long id) {
        Account account = Account.find.byId(id);
        account.delete();
        //FIXME redirect to index() via Call
    	return redirect("/accounts");
    }

    public static Result confirm(Long id) {
        Account account = Account.find.byId(id);
        account.isConfirmed = true;
        account.save();
        //FIXME redirect to index() via Call
        return redirect("/accounts");
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