package com.github.jeyj0.energygame.cards;

import com.github.jeyj0.energygame.players.Player;

public abstract class Support extends Card {

	private String effect;
	
	public Support(Player owner, String name, String effect) {
		super(owner, name);
		this.effect = effect;
	}
	
	public String getEffectText() {
		return effect;
	}

}
