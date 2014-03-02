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

import models.*;

public class Accounts extends Controller {
    
    final static Form<Account> signupForm = form(Account.class, Account.SIGNUP_FORM.class);
  
    public static Result blank() {
        return TODO;
    }
  
    public static Result singup() {
        return TODO;
    }
  
    public static Result save() {
    	return TODO;
    }
  
}