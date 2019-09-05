package com.company.SandyYeungU1Capstone.controller;

import com.company.SandyYeungU1Capstone.service.InvoiceServiceLayer;
import com.company.SandyYeungU1Capstone.viewModel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    InvoiceServiceLayer invoiceService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public GameViewModel createGame(@RequestBody @Valid GameViewModel game) {
        invoiceService.saveGame(game);
        return game;
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<GameViewModel> getAllGames() {
        return invoiceService.findAllGames();
    }

    @GetMapping(value="/{gameId}")
    @ResponseStatus(value = HttpStatus.OK)
    public GameViewModel getGame(@PathVariable(name="gameId") int gameId) {
        return invoiceService.findGame(gameId);
    }

    @DeleteMapping(value="/{gameId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteGame(@PathVariable(name="gameId") int gameId) {
        invoiceService.deleteGame(gameId);
    }

    @PutMapping(value="/{gameId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateGame(@RequestBody @Valid GameViewModel game) {
        invoiceService.updateGame(game);
    }

    @GetMapping(value="/{esrbRating}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<GameViewModel> getGamesByEsrbRating(@PathVariable(name="esrbRating") String esrbRating) {
        return invoiceService.getGamesByEsrbRating(esrbRating);
    }

    @GetMapping("/{title}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<GameViewModel> getGamesByTitle(@PathVariable(name="title") String title) {
        return invoiceService.getGamesByTitle(title);
    }

    @GetMapping("/{studio}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<GameViewModel> getGamesByStudio(@PathVariable(name="studio") String studio) {
        return invoiceService.getGamesByStudio(studio);
    }
}
