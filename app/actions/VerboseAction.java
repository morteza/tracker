/*******************************************************************************
 *        File: VerboseAction.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Feb 26, 2014
 *     Project: tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package actions;

import annotations.Verbose;
import play.Logger;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;

public class VerboseAction extends Action<Verbose> {

  @Override
	public F.Promise<Result> call(Http.Context ctx) throws Throwable {
		if (configuration.value()) {
			Logger.info("Calling action for " + ctx);  
		}
	  return delegate.call(ctx);
	}
}