package com.github.jeyj0.energygame.players;

import java.util.ArrayList;

import javax.script.ScriptException;

import com.github.jeyj0.energygame.Game;
import com.github.jeyj0.energygame.cards.Card;
import com.github.jeyj0.energygame.cards.Support;
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
	
	private boolean hasLost;

	public Player(ArrayList<Integer> deck) {
		this.deck = new Stack(this, deck);
		this.graveyard = new Stack(this);
		this.hand = new Stack(this);
		this.buildings = new LimitedStack(this, BUILDING_LIMIT);
		this.plans = new LimitedStack(this, PLAN_LIMIT);
	}

	public void init(Game game) {
		this.game = game;
		deck.shuffle();
		hasLost = false;
	}

	public void turn() {
		draw(drawAmount);
		
		if (hasLost)
			return;

		// TODO improve AI
		try {
			((Support) Card.CARDS[hand.getCards().get(0)]).executeEffect();
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println(this.getClass().getSimpleName() + " has no card");
		}
	}

	public void draw() {
		draw(1);
	}

	public void draw(int amount) {
		System.out.println(this.getClass().getSimpleName() + " drawing " + amount);

		for (int i = 0; i < amount; i++) {
			int card = deck.drawTop();
			if (card == -1) {
				loose();
				break;
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

	public Stack getHand() {
		return hand;
	}

	public void setDrawAmount(int amount) {
		drawAmount = amount;
	}

	public void loose() {
		System.err.println(this.getClass().getSimpleName() + " lost");
		hasLost = true;
		game.playerLoose(this);
	}

	public void win() {
		game.playerWin(this);
	}

	public Game getGame() {
		return game;
	}

}
