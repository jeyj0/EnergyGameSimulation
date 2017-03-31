package com.github.jeyj0.energygame;

import java.util.ArrayList;
import java.util.Random;

import com.github.jeyj0.energygame.players.Player;

public class Game {

	public Random random;

	private Player[] players;
	private ArrayList<Player> playersLost;
	
	private boolean weather;
	private int weatherLock;
	private Player current;
	private Player[] opponents;
	
	private boolean hasEnded;

	public Game(Player[] players) {
		this.players = players;

		random = new Random();
		weatherLock = 0;
		playersLost = new ArrayList<Player>(players.length - 1);
		
		hasEnded = false;
	}
	
	public void init() {
		for (Player player : players)
			player.init(this);
	}

	public void round() {
		updateWeather();

		for (int i = 0; i < players.length && !hasEnded; i++) {
			current = players[i];

			// skip players that lost
			if (playersLost.contains(current))
				continue;
			
			// reconfigure opponent list
			opponents = new Player[players.length - 1 - playersLost.size()];
			int opIndex = 0;
			for (int pIndex = 0; opIndex < opponents.length; pIndex++)
				if (!playersLost.contains(players[pIndex]) && players[pIndex] != current)
					opponents[opIndex++] = players[pIndex];

			current.turn();
		}
	}

	private void updateWeather() {
		if (weatherLock-- == 0)
			weather = random.nextBoolean();
	}

	public boolean isGoodWeather() {
		return weather;
	}

	public boolean isBadWeather() {
		return !weather;
	}
	
	public Player getCurrent() {
		return current;
	}
	
	public Player[] getOpponents() {
		return opponents;
	}

	public void playerLoose(Player player) {
		playersLost.add(player);
		if (playersLost.size() == players.length - 1) {
			for (Player currentPlayer : players)
				if (!playersLost.contains(currentPlayer))
					currentPlayer.win();
			end();
		}
	}

	public void playerWin(Player player) {
		System.err.println(player.getClass().getSimpleName() + " won!");
	}

	public void end() {
		hasEnded = true;
		System.out.println("Game ended.");
	}
	
	public boolean hasEnded() {
		return hasEnded;
	}

}
