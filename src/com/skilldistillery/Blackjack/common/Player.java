package com.skilldistillery.Blackjack.common;

import java.util.List;

import com.skilldistillery.common.cards.Card;
import com.skilldistillery.common.cards.Hand;

public class Player {

	BlackjackHand blackjackHand = new BlackjackHand();

	protected int playerHand() {
		return 0;

	}

	public BlackjackHand getBlackjackHand() {
		return blackjackHand;
	}

	public void setBlackjackHand(BlackjackHand blackjackHand) {
		this.blackjackHand = blackjackHand;
	}

	public int playerTotal() {
		
		

		return blackjackHand.getHandValue();

	}

	// player needs to have option to play the game
	public void takeCard(Card card) {
		blackjackHand.addCard(card);
		// gets the value of the cards
		blackjackHand.getHandValue();

	}

	public void takeHit() {
		// checks to see if value = blackjack
		blackjackHand.getCards();
		blackjackHand.getHandValue();

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player [blackjackHand=").append(blackjackHand).append("]");
		return builder.toString();
	}

}
