package com.github.jeyj0.energygame.cards.stack;

import java.util.ArrayList;

import com.github.jeyj0.energygame.players.Player;

public class LimitedStack extends Stack {

	private int limit;

	public LimitedStack(Player player, int limit) {
		this(player, new ArrayList<Integer>(), limit);
	}

	public LimitedStack(Player player, ArrayList<Integer> cards, int limit) {
		super(player, cards);
		this.limit = limit;

		if (cards.size() > limit)
			System.err.println("Submitted card-list is bigger than stack limit.");
	}

	@Override
	public boolean addCardAndShuffle(int card) {
		if (!(getStackSize() >= limit))
			return super.addCardAndShuffle(card);
		return false;
	}

}
