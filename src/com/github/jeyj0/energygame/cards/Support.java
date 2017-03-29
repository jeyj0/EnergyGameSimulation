package com.github.jeyj0.energygame.cards;

public class Support extends Card {

	private String effectText;
	private String effectCode;

	public Support(String name, String effectText, String effectCode) {
		super(name);
		this.effectText = effectText;
		this.effectCode = effectCode;
	}

	public String getEffectText() {
		return effectText;
	}

}
