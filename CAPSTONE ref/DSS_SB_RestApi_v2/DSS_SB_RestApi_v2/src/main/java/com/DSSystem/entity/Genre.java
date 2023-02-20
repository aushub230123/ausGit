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
 *
 */
@Entity
@Table(name="GENREs")
public class Genre {
//	Uniqueness
	@Id
//	Auto gen Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="GENRE_ID")
	private Integer genreId;
	
	@Column(name="NAME", nullable = false)
	private String name;
	
public Genre(Integer genresId, String name) {
		super();
		this.genreId = genresId;
		this.name = name;
	}
	public Integer getGenreId() {
	return genreId;
}
public void setGenreId(Integer genresId) {
	this.genreId = genresId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
	public Genre() {};
	

	

}
