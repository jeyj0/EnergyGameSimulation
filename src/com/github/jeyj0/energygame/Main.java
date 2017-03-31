package com.github.jeyj0.energygame;

import java.io.IOException;

import javax.script.ScriptException;

import com.github.jeyj0.energygame.cards.Card;
import com.github.jeyj0.energygame.players.Fossil;
import com.github.jeyj0.energygame.players.Nuclear;
import com.github.jeyj0.energygame.players.Player;
import com.github.jeyj0.energygame.players.Solar;
import com.github.jeyj0.energygame.players.Wind;

public class Main {

	public static final int ROUNDS = 3;
	
	public static void main(String[] args) throws IOException, ScriptException {
		System.out.println("Creating script executer");
		JavaScriptExecuter jsExec = new JavaScriptExecuter();
		System.out.println("Reading cards (compiling code)");
		Card.loadCards(jsExec);

		System.out.println("Initializing game");
		Player[] players = new Player[] { new Nuclear(), new Fossil(), new Solar(), new Wind() };
		Game game = new Game(players);
		game.init();
		jsExec.init(game);
		
		System.out.println("Start gameplay");
		int round = 1;
		while (!game.hasEnded()) {
			System.out.println("==============");
			System.out.println("Round " + round++);
			game.round();
		}
	}

}
