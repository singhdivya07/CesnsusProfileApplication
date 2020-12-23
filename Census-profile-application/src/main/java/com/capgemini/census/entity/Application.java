package com.capgemini.census.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="application")
public class Application {
	
	@Id
	@Column(name="application_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer applicationId;

	
	@OneToMany(mappedBy = "application")
	private Set<MemberInformation> members;

	@ManyToOne//(cascade=CascadeType.ALL)
	@JsonIgnore
    @JoinColumn(name="user_id")
    private User user;

	public Application() {
		super();
	}

	public Application(Integer applicationId, Set<MemberInformation> members, User user) {
		super();
		this.applicationId = applicationId;
		this.members = members;
		this.user = user;
	}

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public Set<MemberInformation> getMembers() {
		return members;
	}

	public void setMembers(Set<MemberInformation> members) {
		this.members = members;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", members=" + members + ", user=" + user + "]";
	}
	
	

}
