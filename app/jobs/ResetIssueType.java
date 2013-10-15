/*******************************************************************************
 *        File: ResetIssueType.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Aug 11, 2013
 *     Project: Fuschia Tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/

package jobs;

import models.IssueType;
import play.Logger;
import play.jobs.Job;

public class ResetIssueType extends Job {

	public void doJob() {
		int numofDeletedEntities = IssueType.deleteAll();
		Logger.debug("% IssueTypes deleted.", numofDeletedEntities);
		new IssueType("Product Backlog").save();
		new IssueType("Sprint Backlog").save();
		new IssueType("Bug").save();
		new IssueType("Feature").save();
		new IssueType("Task").save();
	}
}
