/**
 * 
 */
package com.cufflinks.cufflinks.dataservice;

import java.util.Optional;

import com.cufflinks.cufflinks.entity.Team;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 30 Jun, 2020
 *
*/
public interface TeamService {

	/**
	 * @param teamName
	 * @return
	 */
	public Optional<Team> findByTeamName(String teamname);

	/**
	 * @param team
	 */
	public void save(Team team);

}
