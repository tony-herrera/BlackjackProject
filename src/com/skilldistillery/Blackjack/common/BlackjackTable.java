package com.skilldistillery.Blackjack.common;

import java.util.Scanner;

public class BlackjackTable {

	Scanner sc = new Scanner(System.in);
	Dealer theDealer = new Dealer();
	Player player = new Player();

	public void dealsCards() {
		theDealer.dealerShuffle();
		player.takeCard(theDealer.deal());
		theDealer.takeCard(theDealer.deal());
		player.takeCard(theDealer.deal());
		theDealer.takeCard(theDealer.deal());

	}

	public void displayCards() {
		player.getBlackjackHand();
		theDealer.getBlackjackHand().getCards().get(0);
	}

	public void playerTurn() {
		player.playerTotal();
		player.takeHit();
	}

	public void dealerTurn() {
		theDealer.takeHit();
	}

	// check to see if player has blackjack
	public void checkBJ() {
		player.playerTotal();
		if (player.playerTotal() == 21) {
			System.out.println("You won!");

		} else if (player.playerTotal() > 21) {
			System.out.println("You lose");
		}
	}

	public void startGame() {
		System.out.println("Keep going? yes or no ");
		String yes = sc.nextLine().toLowerCase();

		boolean keepGoing = true;
		while (true)
			switch (yes) {

			case "yes":
				player.takeHit();
				player.playerTotal();
				break;
			case "no":
				theDealer.takeHit();
				keepGoing = false;
				break;
			default:
				System.out.println("invalid option");
			}

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BlackjackTable [sc=").append(sc).append(", theDealer=").append(theDealer).append(", player=")
				.append(player).append("]");
		return builder.toString();
	}
}
