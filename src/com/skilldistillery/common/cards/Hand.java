package com.skilldistillery.common.cards;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	protected List<Card> cards = new ArrayList<Card>();

	public Hand() {
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public void clear() {
	}

	public abstract int getHandValue();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hand [cards=").append(cards).append("]");
		return builder.toString();
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

}
