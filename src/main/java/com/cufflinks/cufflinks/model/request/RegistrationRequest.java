/**
 * 
 */
package com.cufflinks.cufflinks.model.request;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 5 Jul, 2020
 *
*/
public class RegistrationRequest {

	private String teamname;
	
	private String password;

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
