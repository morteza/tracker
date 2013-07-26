/*******************************************************************************
 *        File: Application.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Jul 26, 2013
 *     Project: Fuschia Tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/

package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
    	List<Story> stories;
    	stories = Story.findAll();
        render(stories);
    }

}