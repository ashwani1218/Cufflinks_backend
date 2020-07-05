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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Ashwani Pandey
 *
 *         createdAt 30 Jun, 2020
 *
 */
@Entity
@Table(name = "cufflinks_team")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")
	private Long id;

	@Column(name = "team_name", unique = true, nullable = false)
	private String teamname;

	
	@JsonIgnore
	@Column(name="team_password", nullable=false)
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "team_members", joinColumns = @JoinColumn(name = "team_id"), inverseJoinColumns = @JoinColumn(name = "member_id"))
	private List<Member> members;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamName) {
		this.teamname = teamName;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((members == null) ? 0 : members.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((teamname == null) ? 0 : teamname.hashCode());
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
		Team other = (Team) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (members == null) {
			if (other.members != null)
				return false;
		} else if (!members.equals(other.members))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (teamname == null) {
			if (other.teamname != null)
				return false;
		} else if (!teamname.equals(other.teamname))
			return false;
		return true;
	}

	public Team(String teamName, String password, List<Member> members) {
		super();
		this.teamname = teamName;
		this.password = password;
		this.members = members;
	}

	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
