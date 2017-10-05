package com.renatasrbljanin.collaboss.tennis;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;



public class GameTest {

	
	Player p1;
	Player p2;
	Game game;
	
	@Before
    public void beforeGameTest() {
        p1 = new Player("Monika");
        p2 = new Player("Novak");
        game = new Game(p1,p2);
    }

    @Test
    public void loveAll() {
           assertThat(game, hasProperty("score", is("love - All")));
    }
	
    @Test
    public void loveFifteen() {
        p2.winBall();
        assertThat(game, hasProperty("score", is("love - fifteen")));
    }
	
    @Test
    public void thirtyFifteen() {
        p1.winBall();
        p1.winBall();
        p2.winBall();
        assertThat(game, hasProperty("score", is("thirty - fifteen")));
    }
    
    @Test
    public void fortyLove() {
        p1.winBall();
        p1.winBall();
        p1.winBall();
        assertThat(game, hasProperty("score", is("forty - love")));
    }

    @Test
    public void fortyLove1() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
                p1.winBall();
        });
        assertThat(game, hasProperty("score", is("forty - love")));
    }

    @Test
    public void advantageNovak() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            p1.winBall();
        });
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            p2.winBall();
        });
        assertThat(game, hasProperty("score", is("advantage Novak")));
    }
	
    @Test
    public void deuce() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            p1.winBall();
        });
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            p2.winBall();
        });
        assertThat(game, hasProperty("score", is("deuce")));
        p1.winBall();
        assertThat(game, hasProperty("score", is(not("deuce"))));
        p2.winBall();
        assertThat(game, hasProperty("score", is("deuce")));
    }
    
    @Test
    public void won() {
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            p1.winBall();
        });
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            p2.winBall();
        });
        assertThat(game, hasProperty("score", is(not("win for Monika"))));
        assertThat(game, hasProperty("score", is(not("win for Novak"))));
        p1.winBall();
        assertThat(game, hasProperty("score", is("win for Monika")));
    }

    
}
