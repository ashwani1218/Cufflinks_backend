/**
 * 
 */
package com.cufflinks.cufflinks.translator;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cufflinks.cufflinks.dataservice.TeamService;
import com.cufflinks.cufflinks.entity.Member;
import com.cufflinks.cufflinks.entity.Team;
import com.cufflinks.cufflinks.model.request.LoginRequest;
import com.cufflinks.cufflinks.model.request.RegistrationRequest;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 5 Jul, 2020
 *
*/
@Component
public class TeamTranslator {

	@Autowired 
	private TeamService teamService;
	/**
	 * @param req
	 * @return
	 */
	public Team translateLoginToTeam(LoginRequest req) {
		Optional<Team> team = teamService.findByTeamName(req.getTeamname());
		
		return team.get();
	}
	/**
	 * @param req
	 * @return
	 */
	public Team translateRegisterToTeam(RegistrationRequest req) {
		Team team = new Team(req.getTeamname(),req.getPassword(),new ArrayList<Member>());
		return team;
	}
	
	

}
