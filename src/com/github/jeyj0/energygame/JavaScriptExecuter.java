package com.github.jeyj0.energygame;

import java.io.IOException;

import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleBindings;

public class JavaScriptExecuter {

	private ScriptEngine engine;
	private Game game;

	public JavaScriptExecuter(Game game) throws ScriptException, IOException {
		ScriptEngineManager manager = new ScriptEngineManager();
		engine = manager.getEngineByName("js");
		
		this.game = game;
	}
	
	public ScriptEngine getEngine() {
		return engine;
	}
	
	public Object runWithStandardParams(JavaScript jscript) throws ScriptException {
		SimpleBindings bindings = new SimpleBindings();
		bindings.put("game", game);
		return jscript.runWithParams(bindings);
	}

	// ======================================================================================

	public class JavaScript {

		public String script;
		public CompiledScript compiled;

		public JavaScript(String script, ScriptEngine engine) throws ScriptException {
			this.script = script;
			compiled = ((Compilable) engine).compile(script);
		}

		public Object run() throws ScriptException {
			return compiled.eval();
		}

		public Object runWithParams(SimpleBindings bindings) throws ScriptException {
			return compiled.eval(bindings);
		}

	}

}
