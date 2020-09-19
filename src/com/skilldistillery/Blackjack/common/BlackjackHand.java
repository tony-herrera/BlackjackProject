package com.skilldistillery.Blackjack.common;

import com.skilldistillery.common.cards.Card;
import com.skilldistillery.common.cards.Hand;

public class BlackjackHand extends Hand {

	public BlackjackHand() {
	}

	@Override
	public void addCard(Card card) {
		super.addCard(card);
	}

	@Override
	public void clear() {
		super.clear();
	}


	public int getHandValue() {
		return 0;

	}

	public boolean isBlackjack() {
		return false;

	}

	public boolean isBust() {
		return false;

	}

	@Override
	public String toString() {
		return super.toString();
	}
	
}
