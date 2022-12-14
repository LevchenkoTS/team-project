package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfTwoGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Game1", "races");
        Game game2 = store.publishGame("Game2", "races");

        Player player = new Player("Player1");
        player.installGame(game);
        player.installGame(game2);
        player.play(game, 3);
        player.play(game2, 3);

        int expected = 6;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }
    @Test
    public void shouldExpectionTest() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Game 1", "Genre1");

        Player player = new Player("Player1");

        assertThrows(RuntimeException.class, () -> {
            player.play(game, 5);
        });
    }

    @Test
    public void mostPlayerByGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Game1", "Genre1");
        Game game2 = store.publishGame("Game2", "Genre1");
        Game game3 = store.publishGame("Game3", "Genre3");

        Player player = new Player("Player1");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);

        player.play(game1, 2);
        player.play(game2, 3);
        player.play(game3, 1);

        player.sumGenre("Genre1");
        player.sumGenre("Genre3");

        String expected = "Game2";
        String actual = player.mostPlayerByGenre("Genre1");
        assertEquals(expected, actual);
    }
    @Test
    public void shoudGameforGenreIfNotPlay() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Game1", "Genre1");
        Game game1 = store.publishGame("Game2", "Genre2");
        Game game2 = store.publishGame("Game3", "Genre3");

        Player player = new Player("Player1");
        player.installGame(game);
        player.play(game, 1);
        player.installGame(game1);
        player.play(game1, 2);
        player.installGame(game2);
        player.play(game2, 3);


        String expexted = null;
        String actual = player.mostPlayerByGenre("Genre4");
    }
    @Test
    public void shouldSumPlayTwoGameWhenPlayOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Game1", "Genre1");
        Game game1 = store.publishGame("Game2", "Genre2");

        Player player = new Player("Player1");
        player.installGame(game);
        player.play(game, 3);
        player.installGame(game1);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());

        assertEquals(expected, actual);
    }
}
