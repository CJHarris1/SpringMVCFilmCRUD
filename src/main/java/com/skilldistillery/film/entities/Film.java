package com.skilldistillery.film.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


public class Film {

	private int id;
	private String title;
	private String description;
	private int releaseYear;
	private int languageId;
	private String languageName;
	private String rating;
	private List<Actor> actors;

	public Film() {

	}

	public Film(int id, String title, String description, int releaseYear, int languageId, String languageName, String rating,
			List<Actor> actors) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.languageName = languageName;
		this.rating = rating;
		this.actors = actors;
	}

	
	
	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actors, description, id, languageId, languageName, rating, releaseYear, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(actors, other.actors) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(languageId, other.languageId)
				&& Objects.equals(languageName, other.languageName) && Objects.equals(rating, other.rating)
				&& Objects.equals(releaseYear, other.releaseYear) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		String movieDescription = "";

		movieDescription += "Film title: " + title + "\nDescription: " + description + "\nRelease year: " + releaseYear
				+ "\nLanguage: " + languageName + "\nRating: " + rating + "\nActors:\n" + listActors();
		
		
		return movieDescription;
	}
	
	public String listActors() {
		String actorList = "";
	
		if (actors != null) {
			for (Actor actor : actors) {
				actorList += actor;
			}
		}
		else {
			actorList += "No actors listed \n";
		}
		return actorList;
	}

}
