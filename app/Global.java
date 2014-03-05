/*******************************************************************************
 *        File: Global.java
 *      Author: Morteza Ansarinia <morteza@ratnic.se>
 *  Created on: Feb 22, 2014
 *     Project: ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/

import java.lang.reflect.Method;

import play.*;
import play.mvc.*;
import play.mvc.Http.Request;

public class Global extends GlobalSettings {
	
	@Override
	public void onStart(Application app) {
		Logger.info("$ratnic.tracker.title$ is starting...");
	}
	
	@Override
	public void onStop(Application app) {
		Logger.info("$ratnic.tracker.title$ is stopping...");
	}

	@Override
    @SuppressWarnings("rawtypes")
    public Action onRequest(Request request, Method actionMethod) {
        System.out.println("Processing request to \"" + request.uri() + "\"...");
        return super.onRequest(request, actionMethod);
    }
    
    //public Promise<SimpleResult> onBadRequest(RequestHeader request, String error) {
    //    return Promise.<SimpleResult>pure(badRequest("Don't try to hack the karaoke machine!"));
    //}

}