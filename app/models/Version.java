/*******************************************************************************
 *        File: Version.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Feb 26, 2014
 *     Project: ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package models;

import javax.persistence.Id;

import play.db.ebean.Model;
import play.data.validation.*;

public class Version extends Model {
	
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	
	@Constraints.Required
	public Project project;
	
	@Constraints.Required
	public String version;

}
