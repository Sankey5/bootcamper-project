package com.organization.mvcproject.api.model;

import com.organization.mvcproject.model.GameImpl;

import java.util.List;

public interface Company {
    Long getId();

    void setId(Long id);

    String getName();

    void setName(String name);

    List<GameImpl> getGamesMade();

    void setGamesMade(List<GameImpl> gamesMade);
}
