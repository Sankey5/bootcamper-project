package com.organization.mvcproject.model;

import com.organization.mvcproject.api.model.Game;
import org.springframework.stereotype.Component;

@Component
public class GameImpl implements Game {

	private Long id;
	private String name;
	private String genre;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getGenre() {
		return genre;
	}

	@Override
	public void setGenre(String genre) {
		this.genre = genre;
	}

}
