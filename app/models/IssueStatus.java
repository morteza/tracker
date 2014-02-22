/*******************************************************************************
 *        File: IssueStatus.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Feb 7, 2013
 *     Project: com.ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/

package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
import play.data.validation.*;

@Entity
public class IssueStatus extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@Constraints.Required
	public String name;

	public IssueStatus(String name) {
		this.name = name;
	}
	
}
