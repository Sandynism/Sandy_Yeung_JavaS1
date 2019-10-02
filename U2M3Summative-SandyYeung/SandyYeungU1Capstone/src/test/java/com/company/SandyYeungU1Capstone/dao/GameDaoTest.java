package com.company.SandyYeungU1Capstone.dao;

import com.company.SandyYeungU1Capstone.model.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameDaoTest {

    @Autowired
    GameDao gameDao;

    @Before
    public void setUp() throws Exception {
        List<Game> gamesList = gameDao.getAllGames();
        for(Game g : gamesList) {
            gameDao.deleteGame(g.getGameId());
        }
    }

    @Test
    public void getAllGames() {
        Game game = new Game();
        game.setTitle("Rayman Raving Rabbids");
        game.setEsrbRating("E");
        game.setDescription("The series focuses on wild rabbit-like creatures known as Rabbids, who like to cause havoc and mischief, speak gibberish and yell.");
        game.setPrice(new BigDecimal("39.99"));
        game.setStudio("Ubisoft Motion Pictures");
        game.setQuantity(25);

        gameDao.addGame(game);

        game = new Game();
        game.setTitle("Dance Dance Revolution");
        game.setEsrbRating("E");
        game.setDescription("A dance party where you use arrows to match the beats.");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Konami");
        game.setQuantity(15);

        gameDao.addGame(game);

        List<Game> gamesList = gameDao.getAllGames();
        assertEquals(gamesList.size(), 2);
    }

    @Test
    public void addGetDeleteGame() {
        Game game = new Game();
        game.setTitle("Rayman Raving Rabbids");
        game.setEsrbRating("E");
        game.setDescription("The series focuses on wild rabbit-like creatures known as Rabbids, who like to cause havoc and mischief, speak gibberish and yell.");
        game.setPrice(new BigDecimal("39.99"));
        game.setStudio("Ubisoft Motion Pictures");
        game.setQuantity(25);

        gameDao.addGame(game);

        Game game1 = gameDao.getGame(game.getGameId());
        assertEquals(game, game1);

        gameDao.deleteGame(game.getGameId());
        game1 = gameDao.getGame(game.getGameId());
        assertNull(game1);
    }


    @Test
    public void updateGame() {
        Game game = new Game();
        game.setTitle("Rayman Raving Rabbids");
        game.setEsrbRating("E");
        game.setDescription("The series focuses on wild rabbit-like creatures known as Rabbids, who like to cause havoc and mischief, speak gibberish and yell.");
        game.setPrice(new BigDecimal("39.99"));
        game.setStudio("Ubisoft Motion Pictures");
        game.setQuantity(25);

        gameDao.addGame(game);

        game.setQuantity(30);

        gameDao.updateGame(game);

        Game game1 = gameDao.getGame(game.getGameId());
        assertEquals(game, game1);
    }

    @Test
    public void getGamesByStudio() {
        Game game = new Game();
        game.setTitle("Rayman Raving Rabbids");
        game.setEsrbRating("E");
        game.setDescription("The series focuses on wild rabbit-like creatures known as Rabbids, who like to cause havoc and mischief, speak gibberish and yell.");
        game.setPrice(new BigDecimal("39.99"));
        game.setStudio("Ubisoft Motion Pictures");
        game.setQuantity(25);

        gameDao.addGame(game);

        game = new Game();
        game.setTitle("Dance Dance Revolution");
        game.setEsrbRating("E");
        game.setDescription("A dance party where you use arrows to match the beats.");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Konami");
        game.setQuantity(15);

        gameDao.addGame(game);

        List<Game> gamesList = gameDao.getGamesByStudio("Ubisoft Motion Pictures");
        assertEquals(gamesList.size(), 1);

        gamesList = gameDao.getGamesByStudio("Konami");
        assertEquals(gamesList.size(), 1);

        gamesList = gameDao.getGamesByStudio("Studio");
        assertEquals(gamesList.size(), 0);
    }

    @Test
    public void getGamesByEsrbRating() {
        Game game = new Game();
        game.setTitle("Rayman Raving Rabbids");
        game.setEsrbRating("E");
        game.setDescription("The series focuses on wild rabbit-like creatures known as Rabbids, who like to cause havoc and mischief, speak gibberish and yell.");
        game.setPrice(new BigDecimal("39.99"));
        game.setStudio("Ubisoft Motion Pictures");
        game.setQuantity(25);

        gameDao.addGame(game);

        game = new Game();
        game.setTitle("Dance Dance Revolution");
        game.setEsrbRating("E");
        game.setDescription("A dance party where you use arrows to match the beats.");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Konami");
        game.setQuantity(15);

        gameDao.addGame(game);

        List<Game> gamesList = gameDao.getGamesByEsrbRating("E");
        assertEquals(gamesList.size(), 2);

        gamesList = gameDao.getGamesByEsrbRating("Esrb Rating");
        assertEquals(gamesList.size(), 0);
    }

    @Test
    public void getGamesByTitle() {
        Game game = new Game();
        game.setTitle("Rayman Raving Rabbids");
        game.setEsrbRating("E");
        game.setDescription("The series focuses on wild rabbit-like creatures known as Rabbids, who like to cause havoc and mischief, speak gibberish and yell.");
        game.setPrice(new BigDecimal("39.99"));
        game.setStudio("Ubisoft Motion Pictures");
        game.setQuantity(25);

        gameDao.addGame(game);

        game = new Game();
        game.setTitle("Dance Dance Revolution");
        game.setEsrbRating("E");
        game.setDescription("A dance party where you use arrows to match the beats.");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Konami");
        game.setQuantity(15);

        gameDao.addGame(game);

        List<Game> gamesList = gameDao.getGamesByTitle("Rayman Raving Rabbids");
        assertEquals(gamesList.size(), 1);

        gamesList = gameDao.getGamesByTitle("Title");
        assertEquals(gamesList.size(), 0);
    }
}


//    game_id int(11) not null auto_increment primary key,
//    title varchar(50) not null,
//    esrb_rating varchar(50) not null,
//    description varchar(255) not null,
//    price decimal(5, 2) not null,
//    studio varchar(50) not null,
//    quantity int(11)