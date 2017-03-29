package com.github.jeyj0.energygame.cards;

import com.github.jeyj0.energygame.players.Player;

public abstract class Card {
	
	public static Card[] CARDS;
	
	private Player owner;
	private String name;
	
	public Card(Player owner, String name) {
		this.owner = owner;
		this.name = name;
	}
	
	public static void loadCards() {
		
		
		
	}
	
}
