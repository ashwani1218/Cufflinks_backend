/**
 * 
 */
package com.cufflinks.cufflinks.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cufflinks.cufflinks.dataservice.TeamService;
import com.cufflinks.cufflinks.entity.Team;
import com.cufflinks.cufflinks.model.request.RegistrationRequest;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 30 Jun, 2020
 *
*/
@Component
public class DbValidator {

	
	@Autowired
	private TeamService teamService;
	/**
	 * @param req
	 * @return
	 */
	public boolean isAlreadyAUser(RegistrationRequest req) {
		
		Optional<Team> team = teamService.findByTeamName(req.getTeamname());
		
		if(team.isPresent()) {
			return true;
		}else {
			return false;
		}
	}

}
