package com.company.SandyYeungU1Capstone.dao;

import com.company.SandyYeungU1Capstone.model.Game;

import java.util.List;

public interface GameDao {
    List<Game> getAllGames();

    Game getGame(int gameId);

    Game addGame(Game game);

    void deleteGame(int gameId);

    void updateGame(Game game);

    List<Game> getGamesByStudio(String studio);

    List<Game> getGamesByEsrbRating(String esrbRating);

    List<Game> getGamesByTitle(String title);

}
