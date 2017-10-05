package com.renatasrbljanin.collaboss.tennis;

import java.util.stream.IntStream;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void addingPoints(){
		
		Player p1 = new Player("Monika");
		Player p2 = new Player("Novak");
		
		IntStream.rangeClosed(1,2).forEach((Integer) ->{
			p1.winBall();
		});
		
		IntStream.rangeClosed(1, 4).forEach((Integer) ->{
			p2.winBall();
		});
		
		assertThat(p1, hasProperty("score", is(2)));
		assertThat(p2, hasProperty("score", is(4)));
		
		assertThat(p1.getScoreDescription(),is(equalTo("thirty")));
		assertThat(p2.getName(), is(equalTo("Novak")));
	//	assertThat(actual, is(equalTo(expected)));
	}
	
	
	
	
}
