package com.skilldistillery.Blackjack.common;

import java.util.ArrayList;
import java.util.Scanner;
import com.skilldistillery.common.cards.Card;
import com.skilldistillery.common.cards.Deck;
import com.skilldistillery.common.cards.Rank;
import com.skilldistillery.common.cards.Suit;

public class Dealer extends Player {
	Deck deck = new Deck();
	protected int handvalue = 0;

	public void dealerShuffle() {
		deck.shuffle();
	}

	/*
	 * Determines if the dealer wants to hit according to classic Blackjack rules.
	 */
	public boolean wantsToHit(int handvalue) {
		if (handvalue < 17) {
//			blackjackHand.addCard(deal());

			return true;
		} else {
			return false;
		}
	}

	/*
	 * Returns true if the dealer has blackjack.
	 */
	public boolean hasBlackJack(int handvalue) {
		if (handvalue == 21) {
			System.out.println("The dealer has blackjack!");
			return false;
		}

		return true;
	}

	/*
	 * Prints the dealer's hand.
	 */
	public void showHand() {
		System.out.println(handvalue);
	}

	/*
	 * Returns the value of the dealer's hand.
	 */
	public int getHandValue() {
		return handvalue;
	}

	/*
	 * Determines if a dealer has busted.
	 */
	public boolean busted(int handvalue) {
		if (handvalue > 21) {
			System.out.println("The dealer busted!");
			return false;
		}
		return true;
	}

	public Card deal() {
		return deck.dealCard();
	}
}