package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import play.libs.Json;
import play.mvc.*;

public class API extends Controller {

    public static Result index() {
    	JsonNode result = Json.newObject();
    	//result = request().body().asJson();
        return ok(result);
    }

}
