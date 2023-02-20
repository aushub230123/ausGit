/**
 * 
 */
package com.DSSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Tulip
 *This class holds the entity named actor
 */

@Entity
//ACTOR > ACTORS
@Table(name="ACTORS")
public class Actor {
	//	Uniqueness
	@Id
//	Auto gen Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ACTOR_ID")
	private Integer actorId;
	@Column(name="FIRST_NAME",nullable = false)
	private String firstName;
	
	@Column(name="LAST_NAME",nullable = false)
	private String lastName;
	
	@Column(name="ABOUT",nullable = false)
	private String about;
	
	@Column(name="AGE",nullable = false)
	private Integer age;
	
	@Column(name="GENDER",nullable = false)
	private String gender;
	
	@Column(name="ACTOR_URL",nullable = false)
	private String actorUrl;
	
	
	public Integer getActorId() {
		return actorId;
	}
	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String actorFirstName) {
		this.firstName = actorFirstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String actorLastName) {
		this.lastName = actorLastName;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String actorAbout) {
		this.about = actorAbout;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer actorAge) {
		this.age = actorAge;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String actorGender) {
		this.gender = actorGender;
	}
	
	
	public Actor(Integer actorId, String actorFirstName, String actorLastName, String actorAbout, Integer actorAge,
			String actorGender,String actorUrl) {
		super();
		this.actorId = actorId;
		this.firstName = actorFirstName;
		this.lastName = actorLastName;
		this.about = actorAbout;
		this.age = actorAge;
		this.gender = actorGender;
		this.actorUrl = actorUrl;
	}
	public String getActorUrl() {
		return actorUrl;
	}
	public void setActorUrl(String actorUrl) {
		this.actorUrl = actorUrl;
	}
	public Actor() {};
	
	
	
	

}
