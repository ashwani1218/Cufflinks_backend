/**
 * 
 */
package com.cufflinks.cufflinks.model.response;

import com.cufflinks.cufflinks.entity.Team;
import com.cufflinks.cufflinks.model.BaseResponse;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 5 Jul, 2020
 *
*/
public class RegistrationResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6746922253029424700L;
	
	private Team team;

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
