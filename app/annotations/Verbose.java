/*******************************************************************************
 *        File: Verbose.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Feb 26, 2014
 *     Project: tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package annotations;

import java.lang.annotation.*;

import actions.VerboseAction;
import play.mvc.With;


/**
 * User this annotation like this:
 * <code>
 *	@Verbose(false)
 *	public static Result index() {
 *		return ok("It works!");
 *	}
 * </code>
 */
@With(VerboseAction.class)
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Verbose {
   boolean value() default true;
}
