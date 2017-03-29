package com.github.jeyj0.energygame.cards;

import com.github.jeyj0.energygame.players.Player;

public abstract class Support extends Card {

	private String effectText;
	private String effectCode;

	public Support(Player owner, String name, String effectText, String effectCode) {
		super(owner, name);
		this.effectText = effectText;
		this.effectCode = effectCode;
	}

	public String getEffectText() {
		return effectText;
	}

}
