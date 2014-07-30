/*******************************************************************************
 *        File: Tag.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Feb 7, 2013
 *     Project: tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/

package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
import play.data.validation.*;

@Entity
public class Tag extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@Constraints.Required
	public String name;
	
	//TODO check HEX pattern
	public String color;
	
	public Tag(String name, String color) {
		this.name = name;
		this.color = color;
	}
	
}
