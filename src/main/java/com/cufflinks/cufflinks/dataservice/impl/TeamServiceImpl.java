/**
 * 
 */
package com.cufflinks.cufflinks.dataservice.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cufflinks.cufflinks.dataservice.TeamService;
import com.cufflinks.cufflinks.entity.Team;
import com.cufflinks.cufflinks.repository.TeamRepository;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 30 Jun, 2020
 *
*/
@Service
public class TeamServiceImpl implements TeamService {
	
	@Autowired
	private TeamRepository teamRepository;

	@Override
	public Optional<Team> findByTeamName(String teamname) {
		Optional<Team> team = teamRepository.findByTeamname(teamname);
		return team;
	}

	@Override
	public void save(Team team) {
		teamRepository.save(team);
		
	}

}
