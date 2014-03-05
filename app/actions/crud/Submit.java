/*******************************************************************************
 *        File: Submit.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Feb 26, 2014
 *     Project: ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package actions.crud;

import play.Logger;
import play.libs.F.Promise;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.SimpleResult;

public class Submit extends Action.Simple {

	public Promise<SimpleResult> call(Http.Context ctx) throws Throwable {
		Logger.debug("Calling CRUD.submit()...");
		return delegate.call(ctx);
	}

}