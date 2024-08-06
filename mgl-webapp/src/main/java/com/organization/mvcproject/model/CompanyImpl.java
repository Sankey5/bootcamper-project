
package com.organization.mvcproject.model;

import com.organization.mvcproject.api.model.Company;

import java.util.List;

public class CompanyImpl implements Company {

	private Long id;
	private String name;
	private List<GameImpl> gamesMade;

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
	public List<GameImpl> getGamesMade() {
		return gamesMade;
	}

	@Override
	public void setGamesMade(List<GameImpl> gamesMade) {
		this.gamesMade = gamesMade;
	}
}