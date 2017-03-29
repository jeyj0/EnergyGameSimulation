package com.github.jeyj0.energygame.players;

import java.util.ArrayList;

import com.github.jeyj0.energygame.cards.Card;

public class Nuclear extends Player {

	public static final ArrayList<Card> STANDARD_DECK = new ArrayList<Card>();
	
	public Nuclear() {
		super(STANDARD_DECK);
	}

}
