package com.github.jeyj0.energygame.cards.stack;

import java.util.ArrayList;
import java.util.Collections;

import com.github.jeyj0.energygame.Game;
import com.github.jeyj0.energygame.players.Player;

public class Stack {

	private Game game;
	private ArrayList<Integer> cards;
	
	public Stack(Player player) {
		this(player, new ArrayList<Integer>());
	}

	public Stack(Player player, ArrayList<Integer> cards) {
		this.game = player.getGame();
		this.cards = cards;
	}
	
	public ArrayList<Integer> getCards() {
		return cards;
	}
	
	public int drawTop() {
		if (getStackSize() <= 0)
			return -1;
		
		int card = cards.get(0);
		cards.remove(new Integer(card));
		return card;
	}
	
	public int drawBottom() {
		if (getStackSize() <= 0)
			return -1;
		
		int card = cards.get(cards.size() - 1);
		cards.remove(card);
		return card;
	}
	
	public int drawRandom() {
		if (getStackSize() <= 0)
			return -1;
		
		int card = cards.get(game.random.nextInt(cards.size()));
		cards.remove(card);
		return card;
	}
	
	public int drawRandomAndShuffle() {
		if (getStackSize() <= 0)
			return -1;
		
		int card = drawRandom();
		shuffle();
		return card;
	}
	
	public boolean shuffle() {
		Collections.shuffle(cards);
		return true;
	}
	
	public boolean addCardToBottom(int card) {
		cards.add(card);
		return true;
	}
	
	public boolean addCardToTop(int card) {
		cards.add(0, card);
		return true;
	}
	
	public boolean addCardAndShuffle(int card) {
		cards.add(card);
		return shuffle();
	}
	
	public int getStackSize() {
		return cards.size();
	}

}
