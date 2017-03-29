package com.github.jeyj0.energygame.cards;

import com.github.jeyj0.energygame.players.Player;

public abstract class Plan extends Card {

	private String condition;
	private String effect;
	
	public Plan(Player owner, String name, String condition, String effect) {
		super(owner, name);
		this.condition = condition;
		this.effect = effect;
	}
	
	public String getConditionText() {
		return condition;
	}
	
	public String getEffectText() {
		return effect;
	}

}
