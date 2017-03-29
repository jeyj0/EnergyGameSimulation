package com.github.jeyj0.energygame.cards;

import com.github.jeyj0.energygame.players.Player;

public abstract class Building extends Card {

	private String conditionText;
	private String conditionCode;
	private String effectText;
	private String effectCode;
	
	public Building(Player owner, String name, String conditionText, String conditionCode, String effectText, String effectCode) {
		super(owner, name);
		this.conditionText = conditionText;
		this.conditionCode = conditionCode;
		this.effectText = effectText;
		this.effectCode = effectCode;
	}

	public String getConditionText() {
		return conditionText;
	}

	public String getEffectText() {
		return effectText;
	}

}
