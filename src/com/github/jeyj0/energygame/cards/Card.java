package com.github.jeyj0.energygame.cards;

import java.io.FileReader;
import java.io.IOException;

import com.github.jeyj0.energygame.players.Player;
import com.opencsv.CSVReader;

public abstract class Card {

	public static Card[] CARDS;

	private Player owner;
	private String name;

	public Card(Player owner, String name) {
		this.owner = owner;
		this.name = name;
	}

	public static void loadCards() throws IOException {
		CSVReader reader = new CSVReader(new FileReader("res/cards.csv"));
		String[] nextLine;
		while ((nextLine = reader.readNext()) != null) {
			for (String s : nextLine)
				System.out.print(s + " | ");
			System.out.print("\n");
		}
	}

}
