package com.github.jeyj0.energygame.cards;

import javax.script.ScriptException;

import com.github.jeyj0.energygame.JavaScriptExecuter;
import com.github.jeyj0.energygame.JavaScriptExecuter.JavaScript;

public class Event extends Card {

	private String effectText;
	private JavaScript effect;

	public Event(String name, String effectText, String effectCode, JavaScriptExecuter jsExec) throws ScriptException {
		super(name, jsExec);
		this.effectText = effectText;

		effect = new JavaScript(effectCode, jsExec.getEngine());
	}

	public String getEffectText() {
		return effectText;
	}

	public boolean executeEffect() throws ScriptException {
		jsExec.runWithStandardParams(effect);
		return false;
	}

}
