package com.github.jeyj0.energygame.players;

import java.util.ArrayList;

import com.github.jeyj0.energygame.Game;
import com.github.jeyj0.energygame.cards.Card;
import com.github.jeyj0.energygame.cards.stack.LimitedStack;
import com.github.jeyj0.energygame.cards.stack.Stack;

public abstract class Player {

	public static final int BUILDING_LIMIT = 4;
	public static final int PLAN_LIMIT = 1;

	private Stack deck;
	private Stack graveyard;
	private Stack hand;
	private LimitedStack buildings;
	private LimitedStack plans;

	private int drawAmount = 1;

	private Game game;

	public Player(ArrayList<Card> deck) {
		this.deck = new Stack(this, deck);
		this.graveyard = new Stack(this);
		this.hand = new Stack(this);
		this.buildings = new LimitedStack(this, BUILDING_LIMIT);
		this.plans = new LimitedStack(this, PLAN_LIMIT);
	}

	public void init(Game game) {
		this.game = game;
	}

	public void turn() {
		for (int i = 0; i < drawAmount; i++) {
			Card card = deck.drawTop();
			if (card == null) {
				loose();
			}
			hand.addCardToTop(card);
		}
	}

	public void dropFromHand() {
		dropFromHand(1);
	}

	public void dropFromHand(int amount) {
		// TODO not random, tactical
		dropFromHandRandom(amount);
	}

	public void dropFromHandRandom() {
		dropFromHandRandom(1);
	}

	public void dropFromHandRandom(int amount) {
		graveyard.addCardToTop(hand.drawRandom());
	}

	public void setDrawAmount(int amount) {
		drawAmount = amount;
	}

	public void loose() {
		game.playerLoose(this);
	}

	public void win() {
		game.playerWin(this);
	}

	public Game getGame() {
		return game;
	}

}
