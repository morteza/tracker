/*******************************************************************************
 *        File: Delete.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Feb 26, 2014
 *     Project: tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package actions.crud;

import play.Logger;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;

public class Delete extends Action.Simple {

  @Override
	public F.Promise<Result> call(Http.Context ctx) throws Throwable {
		Logger.debug("Calling CRUD.delete()...");
		return delegate.call(ctx);
	}

}
