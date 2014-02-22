/*******************************************************************************
 *        File: Application.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jan 31, 2014
 *     Project: ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package controllers;

import play.i18n.Messages;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render(Messages.get("application.name")));
    }
    
    public static Result projects() {
    	return TODO;
    }

}
