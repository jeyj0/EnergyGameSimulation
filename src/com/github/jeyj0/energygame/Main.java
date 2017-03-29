package com.github.jeyj0.energygame;

import java.io.IOException;

import com.github.jeyj0.energygame.cards.Card;
import com.github.jeyj0.energygame.players.Fossil;
import com.github.jeyj0.energygame.players.Nuclear;
import com.github.jeyj0.energygame.players.Player;
import com.github.jeyj0.energygame.players.Solar;
import com.github.jeyj0.energygame.players.Wind;

public class Main {

	public static void main(String[] args) throws IOException {
		Card.loadCards();

		Player[] players = new Player[] { new Nuclear(), new Fossil(), new Solar(), new Wind() };

		Game game = new Game(players);
		game.init();
	}

}
