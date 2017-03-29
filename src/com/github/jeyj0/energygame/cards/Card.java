package com.github.jeyj0.energygame.cards;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.github.jeyj0.energygame.players.Player;
import com.opencsv.CSVReader;

public abstract class Card {

	public static Card[] CARDS;

	private Player owner;
	private String name;

	public Card(String name) {
		this.owner = owner;
		this.name = name;
	}

	public static void loadCards() throws IOException {
		CSVReader reader = new CSVReader(new FileReader("res/cards.csv"));

		ArrayList<String[]> content = (ArrayList<String[]>) reader.readAll();
		CARDS = new Card[content.size() - 1];

		String[] line;
		for (int i = 1; i < content.size() - 1; i++) {
			line = content.get(i);

			// create card from line
			Card card;
			if (line[0] == "support")
				card = new Event(line[1], line[6], line[7]);
			else if (line[0] == "building")
				card = new Building(line[1], line[4], line[5], line[6], line[7]);
			else if (line[0] == "plan")
				card = new Plan(line[1], line[4], line[5], line[6], line[7]);
			else // if (line[0] == "event")
				card = new Support(line[1], line[6], line[7]);
			
			// add card to list
			CARDS[i - 1] = card;
		}
	}

}
