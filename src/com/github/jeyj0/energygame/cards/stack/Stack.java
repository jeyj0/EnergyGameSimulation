package com.github.jeyj0.energygame.cards.stack;

import java.util.ArrayList;
import java.util.Collections;

import com.github.jeyj0.energygame.Game;
import com.github.jeyj0.energygame.cards.Card;
import com.github.jeyj0.energygame.players.Player;

public class Stack {

	private Game game;
	private ArrayList<Card> cards;
	
	public Stack(Player player) {
		this(player, new ArrayList<Card>());
	}

	public Stack(Player player, ArrayList<Card> cards) {
		this.game = player.getGame();
		this.cards = cards;
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public Card drawTop() {
		Card card = cards.get(0);
		cards.remove(card);
		return card;
	}
	
	public Card drawBottom() {
		Card card = cards.get(cards.size() - 1);
		cards.remove(card);
		return card;
	}
	
	public Card drawRandom() {
		Card card = cards.get(game.random.nextInt(cards.size()));
		cards.remove(card);
		return card;
	}
	
	public Card drawRandomAndShuffle() {
		Card card = drawRandom();
		shuffle();
		return card;
	}
	
	public boolean shuffle() {
		Collections.shuffle(cards);
		return true;
	}
	
	public boolean addCardToBottom(Card card) {
		cards.add(card);
		return true;
	}
	
	public boolean addCardToTop(Card card) {
		cards.add(0, card);
		return true;
	}
	
	public boolean addCardAndShuffle(Card card) {
		cards.add(card);
		return shuffle();
	}
	
	public int getStackSize() {
		return cards.size();
	}

}
