/**
 * 
 */
package com.cufflinks.cufflinks.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 30 Jun, 2020
 *
*/
@Entity
@Table(name="cufflinks_member")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="member_id")
	private Long id;
	
	@Column(name = "member_name")
	private String name;
	
	@Column(name = "member_skill")
	private String skill;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "members")
	private List<Team> teams;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((skill == null) ? 0 : skill.hashCode());
		result = prime * result + ((teams == null) ? 0 : teams.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (skill == null) {
			if (other.skill != null)
				return false;
		} else if (!skill.equals(other.skill))
			return false;
		if (teams == null) {
			if (other.teams != null)
				return false;
		} else if (!teams.equals(other.teams))
			return false;
		return true;
	}

	public Member(Long id, String name, String skill, List<Team> teams) {
		super();
		this.id = id;
		this.name = name;
		this.skill = skill;
		this.teams = teams;
	}

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String name, String skill, List<Team> teams) {
		super();
		this.name = name;
		this.skill = skill;
		this.teams = teams;
	}

		
	
}
