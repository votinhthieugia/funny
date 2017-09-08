package com.athena.gamble.tala;

import java.util.ArrayList;
import java.util.List;

public class CardSet<T extends Card> {
	public class Order {
		public final static int ASC = 1;
		public final static int DESC = -1;
	}
	
	public List<T> cards;
	public int numCards;
	
	public CardSet() {
		cards = new ArrayList<T>();
		numCards = 0;
	}
	
	public CardSet(List<T> cards) {
		this.cards = cards;
		numCards = cards.size();
	}
	
	public void addCard(T card) {
		cards.add(card);
		numCards++;
	}
}
