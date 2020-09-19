package com.skilldistillery.Blackjack.common;

import java.util.Scanner;
import com.skilldistillery.common.cards.Card;
import com.skilldistillery.common.cards.Deck;
import com.skilldistillery.common.cards.Rank;
import com.skilldistillery.common.cards.Suit;

public class Dealer extends BlackjackTable {

	public String startDeal() {

		Rank[] ranks = Rank.values();
		for (int i = 0; i < ranks.length; i++) {
			System.out.println(ranks[i] + " " + ranks[i].getValue());
		}

		for (Suit s : Suit.values()) {
			System.out.println(s);
		}

		Deck deck = new Deck();
		deck.shuffle();

		Scanner sc = new Scanner(System.in);
		boolean userInput;

//	System.out.println("How many cards?");
		do {
			System.out.println("Hit?");
			try {
				String num = sc.next();
				num = num.toUpperCase();
				if (num.equals("N")) {
					System.out.println("OK");
				} else if (num.equals("Y")) {
					int value = 0;
					for (int i = 0; i < 1; i++) {
						Card c = deck.dealCard();
						value += c.getValue();
						System.out.println(c);
						System.out.println("your value is " + value);
						System.out.println("Hit?");
					}
				} else {

					throw new IllegalArgumentException("Input must be a number");

				}
			} catch (Exception e) {
				IllegalArgumentException iae = new IllegalArgumentException();
				System.out.println(iae);
			}
			sc.close();
		} 
		while ( userInput = "N" != null);
		return null;
	}
}
