/*******************************************************************************
 *        File: Accounts.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Feb 26, 2014
 *     Project: ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package controllers;

import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import views.html.accounts.*;

import models.*;

public class Accounts extends Controller {
    
    final static Form<Account> signupForm = form(Account.class, Account.SIGNUP_FORM.class);
  
    public static Result blank() {
        return ok(signup.render(signupForm));
    }
  
    public static Result singup() {
        Account account = new Account();
        return ok(Account.render(signupForm.fill(account)));
    }
  
    public static Result save() {
        Form<Account> filledForm = signupForm.bindFromRequest();
        
        // Check accept conditions
        if(!"true".equals(filledForm.field("accept").value())) {
            filledForm.reject("accept", "You must accept the terms and conditions");
        }
        
        // Check repeated password
        if(!filledForm.field("password").valueOr("").isEmpty()) {
            if(!filledForm.field("password").valueOr("").equals(filledForm.field("repeatPassword").value())) {
                filledForm.reject("repeatPassword", "Password don't match");
            }
        }
        
        // Check if the username is valid
        if(!filledForm.hasErrors()) {
        	// Check if it's unique
            if(filledForm.get().username.equals("admin") || filledForm.get().username.equals("guest")) {
                filledForm.reject("username", "This username is already taken");
            }
        }
        
        if(filledForm.hasErrors()) {
            return badRequest(form.render(filledForm));
        } else {
            Account created = filledForm.get();
            return ok(summary.render(created));
        }
    }
  
}