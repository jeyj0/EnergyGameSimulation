package com.github.jeyj0.energygame.cards.stack;

import java.util.ArrayList;

import com.github.jeyj0.energygame.cards.Card;
import com.github.jeyj0.energygame.players.Player;

public class LimitedStack extends Stack {

	private int limit;

	public LimitedStack(Player player, int limit) {
		this(player, new ArrayList<Card>(), limit);
	}

	public LimitedStack(Player player, ArrayList<Card> cards, int limit) {
		super(player, cards);
		this.limit = limit;

		if (cards.size() > limit)
			System.err.println("Submitted card-list is bigger than stack limit.");
	}

	@Override
	public boolean addCardAndShuffle(Card card) {
		if (!(getStackSize() >= limit))
			return super.addCardAndShuffle(card);
		return false;
	}

}
