package com.github.jeyj0.energygame;

import com.github.jeyj0.energygame.players.Fossil;
import com.github.jeyj0.energygame.players.Nuclear;
import com.github.jeyj0.energygame.players.Player;
import com.github.jeyj0.energygame.players.Solar;
import com.github.jeyj0.energygame.players.Wind;

public class Main {

	public static void main(String[] args) {
		Game game = new Game(null);

		Player nuclear = new Nuclear();
		Player fossil = new Fossil();
		Player solar = new Solar();
		Player wind = new Wind();

		Player[] players = new Player[] { nuclear, fossil, solar, wind };
		game.init();
	}

}
