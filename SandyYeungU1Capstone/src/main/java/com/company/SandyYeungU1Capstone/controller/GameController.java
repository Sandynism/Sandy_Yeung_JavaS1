package com.company.SandyYeungU1Capstone.controller;

import com.company.SandyYeungU1Capstone.dao.GameDao;
import com.company.SandyYeungU1Capstone.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GameController {
    @Autowired
    GameDao gameDao;

    @RequestMapping(value = "/games", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Game createGame(@RequestBody @Valid Game game) {
        gameDao.addGame(game);
        return game;
    }

    @RequestMapping(value = "/games", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getAllGames() {
        return gameDao.getAllGames();
    }

    @RequestMapping(value = "/games/{gameId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Game getGame(@PathVariable(name="gameId") int gameId) {
        return gameDao.getGame(gameId);
    }

    @RequestMapping(value = "/games/{gameId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteGame(@PathVariable(name="gameId") int gameId) {
        gameDao.deleteGame(gameId);
    }

    @RequestMapping(value = "/games/{gameId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateGame(@RequestBody @Valid Game game) {
        gameDao.updateGame(game);
    }

    @RequestMapping(value = "/games/{esrbRating}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGamesByEsrbRating(@PathVariable(name="esrbRating") String esrbRating) {
        return gameDao.getGamesByEsrbRating(esrbRating);
    }

    @RequestMapping(value = "/games/{title}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGamesByTitle(@PathVariable(name="title") String title) {
        return gameDao.getGamesByTitle(title);
    }

    @RequestMapping(value = "/games/{studio}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGamesByStudio(@PathVariable(name="studio") String studio) {
        return gameDao.getGamesByStudio(studio);
    }
}
