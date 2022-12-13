package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStoreTest {

    GameStore store = new GameStore();


    @Test
    public void shouldAddGame() {
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldContainLostGame() {

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Игра2", "Жанр2");
        Game game3 = store.publishGame("Игра3", "Жанр3");

        assertTrue(store.containsGame(game3));
    }

    @Test
    public void shouldContainGame() {

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Игра2", "Жанр2");
        Game game3 = store.publishGame("Игра3", "Жанр3");

        assertTrue(store.containsGame(game2));
    }

    @Test
    public void shouldContainNullGame() {
        Game game1 = new Game("Игра1", "Жанр1", store);
        assertFalse(store.containsGame(game1));
    }


    @Test
    public void sumOnePlayerTime() {

        store.addPlayTime("Игрок1", 2);
        store.addPlayTime("Игрок1", 5);
        store.addPlayTime("Игрок1", 1);
        store.addPlayTime("Игрок2", 4);


        String expected = "Игрок1";
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);

    }

    @Test
    public void mostPlayerTime() {

        store.addPlayTime("Игрок1", 2);
        store.addPlayTime("Игрок2", 7);
        store.addPlayTime("Игрок3", 5);

        String expected = "Игрок2";
        String actual = store.getMostPlayer();


        assertEquals(expected, actual);

    }

    @Test
    public void mostPlayerTimeWhenMoreOnePlayerBest() {

        store.addPlayTime("Игрок1", 2);
        store.addPlayTime("Игрок2", 7);
        store.addPlayTime("Игрок3", 7);

        String[] expected = {"Игрок2", "Игрок 3"};
        String[] actual = {store.getMostPlayer()};


        assertArrayEquals(expected, actual);

    }

    @Test
    public void nullMostPlayer() {
        Player player1 = new Player("Игрок1");

        String actual = store.getMostPlayer();
        assertNull(actual);

    }

    @Test
    public void mostPlayerTimeWhenPlayedOneOur() {

        store.addPlayTime("Игрок1", 2);
        store.addPlayTime("Игрок2", 1);

        String expected = "Игрок1";
        String actual = store.getMostPlayer();


        assertEquals(expected, actual);
    }

    @Test
    public void mostPlayerTimeWhenOnePlayer() {

        store.addPlayTime("Игрок1", 2);

        String expected = "Игрок1";
        String actual = store.getMostPlayer();


        assertEquals(expected, actual);
    }

    @Test
    public void sumPlayersTime() {

        store.addPlayTime("Игрок1", 3);
        store.addPlayTime("Игрок2", 2);
        store.addPlayTime("Игрок3", 7);


        int expected = 12;
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);

    }


}
