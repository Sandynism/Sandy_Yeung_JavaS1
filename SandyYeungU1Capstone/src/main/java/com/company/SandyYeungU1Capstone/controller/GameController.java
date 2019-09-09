package com.company.SandyYeungU1Capstone.controller;

import com.company.SandyYeungU1Capstone.exception.NotFoundException;
import com.company.SandyYeungU1Capstone.service.InvoiceServiceLayer;
import com.company.SandyYeungU1Capstone.viewModel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GameController {

    @Autowired
    InvoiceServiceLayer invoiceService;

    @RequestMapping(value = "/games/add", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public GameViewModel createGame(@RequestBody @Valid GameViewModel game) {
        GameViewModel existing = invoiceService.findGame(game.getGameId());
        if (existing != null)
            throw new IllegalArgumentException("Game " + game.getGameId() + " already exists!");
        invoiceService.saveGame(game);
        return game;
    }

    @RequestMapping(value = "/games", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<GameViewModel> getAllGames() {
        return invoiceService.findAllGames();
    }

    @RequestMapping(value = "/game/{gameId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public GameViewModel getGame(@PathVariable(name = "gameId") int gameId) {
        GameViewModel game = invoiceService.findGame(gameId);
        if (game == null)
            throw new NotFoundException("Game could not be retrieved for id " + gameId);
        return game;
    }

    @RequestMapping(value = "/game/{gameId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable(name = "gameId") int gameId) {
        invoiceService.deleteGame(gameId);
    }

    @RequestMapping(value = "/game/{gameId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateGame(@RequestBody @Valid GameViewModel game) {
        GameViewModel notExisting = invoiceService.findGame(game.getGameId());
        if (notExisting == null)
            throw new IllegalArgumentException("Game " + game.getGameId() + " does not exist.");
        invoiceService.updateGame(game);
    }

    @RequestMapping(value = "/games/rating/{esrbRating}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<GameViewModel> getGamesByEsrbRating(@PathVariable(name = "esrbRating") String esrbRating) {
        List<GameViewModel> games = invoiceService.getGamesByEsrbRating(esrbRating);
        if (games != null && games.size() == 0)
            throw new NotFoundException("Games could not be found for " + esrbRating);
        return games;
    }

    @RequestMapping(value = "/games/title/{title}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<GameViewModel> getGamesByTitle(@PathVariable(name = "title") String title) {
        List<GameViewModel> games = invoiceService.getGamesByTitle(title);
        if (games != null && games.size() == 0)
            throw new NotFoundException("Games could not be found for " + title);
        return games;
    }

    @RequestMapping(value = "/games/studio/{studio}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<GameViewModel> getGamesByStudio(@PathVariable(name = "studio") String studio) {
        List<GameViewModel> games = invoiceService.getGamesByStudio(studio);
        if (games != null && games.size() == 0)
            throw new NotFoundException("Games could not be found for " + studio);
        return games;
    }
}
