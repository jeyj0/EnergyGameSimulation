package com.github.jeyj0.energygame.cards;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;

public abstract class Card {

	public static Card[] CARDS;
	public static ArrayList<Integer> NUCLEAR_DECK;
	public static ArrayList<Integer> FOSSIL_DECK;
	public static ArrayList<Integer> SOLAR_DECK;
	public static ArrayList<Integer> WIND_DECK;

	private String name;

	public Card(String name) {
		this.name = name;
	}

	public static void loadCards() throws IOException {
		CSVReader reader = new CSVReader(new FileReader("res/cards.csv"));

		ArrayList<String[]> content = (ArrayList<String[]>) reader.readAll();
		CARDS = new Card[content.size() - 1];

		String[] line;
		int cardID;
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
			cardID = i - 1;
			CARDS[cardID] = card;
			for (int n = 0; n < Integer.parseInt(line[8]); n++)
				NUCLEAR_DECK.add(cardID);
			for (int f = 0; f < Integer.parseInt(line[9]); f++)
				FOSSIL_DECK.add(cardID);
			for (int s = 0; s < Integer.parseInt(line[10]); s++)
				SOLAR_DECK.add(cardID);
			for (int w = 0; w < Integer.parseInt(line[11]); w++)
				WIND_DECK.add(cardID);
		}
	}

}
