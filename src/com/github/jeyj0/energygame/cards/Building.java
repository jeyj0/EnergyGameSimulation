package com.github.jeyj0.energygame.cards;

import javax.script.ScriptException;

import com.github.jeyj0.energygame.JavaScriptExecuter;
import com.github.jeyj0.energygame.JavaScriptExecuter.JavaScript;

public class Building extends Card {

	private String conditionText;
	private JavaScript condition;
	private String effectText;
	private JavaScript effect;

	public Building(String name, String conditionText, String conditionCode, String effectText, String effectCode,
			JavaScriptExecuter jsExec) throws ScriptException {
		super(name, jsExec);
		this.conditionText = conditionText;
		this.effectText = effectText;

		condition = new JavaScript(conditionText, jsExec.getEngine());
		effect = new JavaScript(effectText, jsExec.getEngine());
	}

	public String getConditionText() {
		return conditionText;
	}

	public String getEffectText() {
		return effectText;
	}

	public boolean executeCondition() throws ScriptException {
		jsExec.runWithStandardParams(condition);
		return false;
	}

	public boolean executeEffect() throws ScriptException {
		jsExec.runWithStandardParams(effect);
		return false;
	}

}
