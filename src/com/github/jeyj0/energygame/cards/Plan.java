package com.github.jeyj0.energygame.cards;

public class Plan extends Card {

	private String conditionText;
	private String conditionCode;
	private String effectText;
	private String effectCode;

	public Plan(String name, String conditionText, String conditionCode, String effectText, String effectCode) {
		super(name);
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
	
	public boolean executeCondition() {
		// TODO
		return false;
	}
	
	public boolean executeEffect() {
		// TODO
		return false;
	}

}
