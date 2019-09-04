package com.company.SandyYeungU1Capstone.dao;

import com.company.SandyYeungU1Capstone.model.Game;

import java.util.List;

public class GameDaoJdbcTemplateImpl implements GameDao{
    @Override
    public List<Game> getAllGames() {
        return null;
    }

    @Override
    public Game getGame(int gameId) {
        return null;
    }

    @Override
    public Game addGame(Game game) {
        return null;
    }

    @Override
    public void deleteGame(int gameId) {

    }

    @Override
    public void updateGame(Game game) {

    }

    @Override
    public List<Game> getGamesByStudio(String studio) {
        return null;
    }

    @Override
    public List<Game> getGamesByEsrbRating(String esrbRating) {
        return null;
    }

    @Override
    public List<Game> getGamesByTitle(String title) {
        return null;
    }
}
