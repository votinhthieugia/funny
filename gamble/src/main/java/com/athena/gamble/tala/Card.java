package com.athena.gamble.tala;

public abstract class Card {
	public static final int TOTAL = 52;
	public static final int NUM_SUITS = 4;
	public static final int NUM_RANKS = 4;
	public static final int INVALID = -1;
	
	public enum Suit {
		SPADE,
		CLUB,
		DIAMOND,
		HEART
	};
	
	private int index;
	private int rank;
	private int suit;
	
	public Card() {
		index = INVALID;
		rank = INVALID;
		suit = INVALID;
	}
	
	public Card(int index) {
		this.index = index;
		this.rank = extractRank();
		this.suit = extractSuit();
	}
	
	public Card(String cardString) {
		index = INVALID;
		
		if (cardString != null && cardString.length() == 2) {
			index = charsToIndex(cardString.charAt(0), cardString.charAt(1));
			rank = extractRank();
			suit = extractSuit();
		}
	}
	
	private int extractRank() {
		return index % NUM_RANKS;
	}
	
	private int extractSuit() {
		return index / NUM_RANKS;
	}
	
	public boolean isEqual(Card another) {
		return index == another.getIndex();
	}
	
	public boolean hasSameRank(Card another) {
		return rank == another.getRank();
	}
	
	public boolean hasSameSuit(Card another) {
		return suit == another.getSuit();
	}
	
	public boolean hasSameColor(Card another) {
		return (suit < Suit.DIAMOND.ordinal() && another.suit < Suit.DIAMOND.ordinal()) || 
				(suit >= Suit.DIAMOND.ordinal() && another.suit >= Suit.DIAMOND.ordinal());
	}

	public int getIndex() {
		return index;
	}

	public int getRank() {
		return rank;
	}

	public int getSuit() {
		return suit;
	}
	
	@Override
	public String toString() {
		return toString(rank, suit);
	}
	
	protected String toString(int rank, int suit) {
		StringBuilder sb = new StringBuilder();
		String rankChar = getRankChar(rank, getRankOffset()).toString();
		sb.append(rankChar);
		
		switch (Suit.values()[suit]) {
		case SPADE: sb.append("S"); break;
		case CLUB: sb.append("C"); break;
		case DIAMOND: sb.append("D"); break;
		case HEART: sb.append("H"); break;
		}
		
		return sb.toString();
	}
	
	protected abstract int charsToIndex(char rank, char suit);
	protected abstract String getRankChar(int rank, int suit);
	
	protected int getRankOffset() {
		return 0;
	}
}
