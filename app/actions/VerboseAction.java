/*******************************************************************************
 *        File: VerboseAction.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Feb 26, 2014
 *     Project: ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package actions;

import annotations.Verbose;
import play.Logger;
import play.libs.F.Promise;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.SimpleResult;

public class VerboseAction extends Action<Verbose> {

	@Override
	public Promise<SimpleResult> call(Http.Context ctx) throws Throwable {
		if(configuration.value()) {
			Logger.info("Calling action for " + ctx);  
			}
	    return delegate.call(ctx);
	}
}