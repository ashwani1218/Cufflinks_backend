/**
 * 
 */
package com.cufflinks.cufflinks.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cufflinks.cufflinks.entity.Team;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 30 Jun, 2020
 *
*/
public interface TeamRepository extends JpaRepository<Team, Long>{

	/**
	 * @param teamName
	 * @return
	 */
	Optional<Team> findByTeamname(String teamname);

}
