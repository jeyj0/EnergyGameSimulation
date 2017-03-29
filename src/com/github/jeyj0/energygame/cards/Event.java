package com.github.jeyj0.energygame.cards;

public class Event extends Card {

	private String effectText;
	private String effectCode;

	public Event(String name, String effectText, String effectCode) {
		super(name);
		this.effectText = effectText;
		this.effectCode = effectCode;
	}

	public String getEffectText() {
		return effectText;
	}

}
