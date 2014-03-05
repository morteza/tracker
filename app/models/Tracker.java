/*******************************************************************************
 *        File: Tracker.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Feb 7, 2013
 *     Project: ratnic.tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/

package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

/**
 * System-level configurations.
 *
 */
@Entity
public class Tracker extends Model {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    public Long id;
}
