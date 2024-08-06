package com.organization.mvcproject.dao;

import com.google.common.collect.ImmutableList;
import com.organization.mvcproject.api.dao.GameDAO;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.model.GameImpl;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class MockDAOImpl implements GameDAO {

    private static Long gameId = new Long(0);
    private static Long companyId = new Long(0);
    private static List<GameImpl> games = new ArrayList<GameImpl>();

    static {
        games = populateGames();
    }

    private static List<GameImpl> populateGames() {

        GameImpl game1 = new GameImpl();
        game1.setId(++gameId);
        game1.setGenre("Sport");
        game1.setName("Rocket League");

        GameImpl game2 = new GameImpl();
        game2.setId(++gameId);
        game2.setGenre("Shooter");
        game2.setName("Halo 3");

        GameImpl game3 = new GameImpl();
        game3.setId(++gameId);
        game3.setGenre("MMORPG");
        game3.setName("Runescape");

        games.add(game1);
        games.add(game2);
        games.add(game3);

        return games;
    }

    @Override
    public List<Game> retrieveAllGames() {
        return ImmutableList.copyOf(games);
    }

    @Override
    public Game saveGame(Game game) {
        game.setId(++gameId);
        games.add((GameImpl) game);
        return game;
    }

    @Override
    public Game addOrUpdateGame(Game newGame) {
        for(int i = 0; i < games.size(); i++) {
            if(Objects.equals(newGame.getName(), games.get(i).getName())) {
                games.set(i, (GameImpl) newGame);
                return newGame;
            }
        }

        games.add((GameImpl) newGame);
        return null;
    }

    @Override
    public Game deleteGame(Game game) {
        for(int i = 0; i < games.size(); i++) {
            if(Objects.equals(game.getName(), games.get(i).getName())) {
                games.remove(i);
                return game;
            }
        }

        return null;
    }


}
