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
