/*******************************************************************************
 *        File: API.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jan 31, 2014
 *     Project: tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import play.libs.Json;
import play.mvc.*;

@Security.Authenticated(Secured.class)
public class API extends Controller {

    public static Result index() {
    	JsonNode result = Json.newObject();
    	//result = request().body().asJson();
        return ok(result);
    }

}
