package com.github.jeyj0.energygame.players;

import java.util.ArrayList;

import com.github.jeyj0.energygame.cards.Card;

public class Solar extends Player {

	public static final ArrayList<Card> STANDARD_DECK = new ArrayList<Card>();

	public Solar() {
		super(STANDARD_DECK);
	}

}
