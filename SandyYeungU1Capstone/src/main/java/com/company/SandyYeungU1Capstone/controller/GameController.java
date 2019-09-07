package com.company.SandyYeungU1Capstone.controller;

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
        return invoiceService.saveGame(game);
    }

    @RequestMapping(value = "/games", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<GameViewModel> getAllGames() {
        return invoiceService.findAllGames();
    }

    @RequestMapping(value = "/game/{gameId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public GameViewModel getGame(@PathVariable(name="gameId") int gameId) {
        return invoiceService.findGame(gameId);
    }

    @RequestMapping(value = "/game/{gameId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteGame(@PathVariable(name="gameId") int gameId) {
        invoiceService.deleteGame(gameId);
    }

    @RequestMapping(value = "/game/{gameId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateGame(@RequestBody @Valid GameViewModel game) {
        invoiceService.updateGame(game);
    }

    @RequestMapping(value = "/games/rating/{esrbRating}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<GameViewModel> getGamesByEsrbRating(@PathVariable(name="esrbRating") String esrbRating) {
        return invoiceService.getGamesByEsrbRating(esrbRating);
    }

    @RequestMapping(value = "/games/title/{title}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<GameViewModel> getGamesByTitle(@PathVariable(name="title") String title) {
        return invoiceService.getGamesByTitle(title);
    }

    @RequestMapping(value = "/games/studio/{studio}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<GameViewModel> getGamesByStudio(@PathVariable(name="studio") String studio) {
        return invoiceService.getGamesByStudio(studio);
    }
}
