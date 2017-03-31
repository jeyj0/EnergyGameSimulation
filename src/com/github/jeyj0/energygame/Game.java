package com.github.jeyj0.energygame;

import java.util.ArrayList;
import java.util.Random;

import com.github.jeyj0.energygame.players.Player;

public class Game {

	/**
	 * The random object everything randomized is being based on, if possible.
	 * 
	 * TODO: Shuffling
	 */
	public Random random;

	/**
	 * An array of all players playing in this game
	 */
	private Player[] players;

	/**
	 * A list of all players that lost in the game
	 */
	private ArrayList<Player> playersLost;

	/**
	 * The current weather. true: good weather; false: bad weather
	 */
	private boolean weather;

	/**
	 * If bigger than one, the weather will not be changed for that many rounds.
	 */
	private int weatherLock;

	/**
	 * Currently playing player. Loops through all players each rounds. For API.
	 */
	private Player current;

	/**
	 * An array of all players that are not playing and have not lost yet. For
	 * API.
	 */
	private Player[] opponents;

	/**
	 * Whether the game as ended. Meaning all players except one lost.
	 */
	private boolean hasEnded;

	/**
	 * Generic constructor.
	 * 
	 * @param players
	 *            An array of all players that are supposed to play.
	 */
	public Game(Player[] players) {
		this.players = players;

		random = new Random();
		weatherLock = 0;
		playersLost = new ArrayList<Player>(players.length - 1);

		hasEnded = false;
	}

	/**
	 * Initialize the game. Needed because classes require two-way saving.
	 */
	public void init() {
		for (Player player : players)
			player.init(this);
	}

	/**
	 * Plays out one round.
	 */
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

	/**
	 * Updates the weather to a random value, if no weather lock is enabled. If
	 * it is enabled, it subtracts one round.
	 */
	private void updateWeather() {
		if (weatherLock-- == 0)
			weather = random.nextBoolean();
	}

	/**
	 * @return true: good weather; false: bad weather
	 */
	public boolean isGoodWeather() {
		return weather;
	}

	/**
	 * @return true: bad weather; false: good weather
	 */
	public boolean isBadWeather() {
		return !weather;
	}

	/**
	 * @return The player who's turn it currently is.
	 */
	public Player getCurrent() {
		return current;
	}

	/**
	 * @return The players who have not lost and whose turn it is not
	 */
	public Player[] getOpponents() {
		return opponents;
	}

	/**
	 * Calls necessary functions that need to be called when a player looses.
	 * 
	 * @param player
	 *            The player that lost.
	 */
	public void playerLoose(Player player) {
		playersLost.add(player);
		if (playersLost.size() == players.length - 1) {
			for (Player currentPlayer : players)
				if (!playersLost.contains(currentPlayer))
					currentPlayer.win();
			end();
		}
	}

	/**
	 * Calls necessary function that need to be called when a player wins.
	 * 
	 * @param player
	 *            The player that won.
	 */
	public void playerWin(Player player) {
		System.err.println(player.getClass().getSimpleName() + " won!");
	}

	/**
	 * Sets the game's status to ended and calls necessary functions.
	 */
	public void end() {
		hasEnded = true;
		System.out.println("Game ended.");
	}

	/**
	 * @return true: the game's over; false: the game's still going / supposed
	 *         to go on
	 */
	public boolean hasEnded() {
		return hasEnded;
	}

}
