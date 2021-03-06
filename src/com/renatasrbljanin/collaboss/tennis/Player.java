package com.renatasrbljanin.collaboss.tennis;

import java.util.Arrays;
import java.util.List;




public class Player {

public static final List<String> pointsDescription = Arrays.asList("love","fifteen","thirty","forty");
	
	private int score;
	private String name;
	
	public int getScore(){
		return score;
	}
	
	public String getName(){
		return name;
	}
	
	public void winBall(){
		this.score ++;
	}
	
	public Player(String name){
		this.name = name;
	}
	
	public String getScoreDescription(){
		return pointsDescription.get(score);
	}	
	
	
	
}
