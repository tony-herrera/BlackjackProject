package com.skilldistillery.Blackjack.common;

import com.skilldistillery.common.cards.Card;
import com.skilldistillery.common.cards.Hand;

public class BlackjackHand extends Hand {

	public BlackjackHand() {
	}

	@Override
	public void addCard(Card card) {
		// at beginning of the game both the dealer and player are given 2 cards. One
		// face down and one face up. Player sees
		// dealers one up card and chooses to hit or stay. If player hits, another card
		// is added.

		super.addCard(card);
	}

	@Override
	public int getHandValue() {
		// this will get the sum of the values within each players hand to include rank.
		int cardValue = 0;
		for (Card card : cards) {
			cardValue += card.getValue();
			
		}

		return cardValue;

	}

	public boolean isBust() {
		// a player receives bust if they go over 21
		return false;

	}

}
