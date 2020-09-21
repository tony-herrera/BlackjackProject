package com.skilldistillery.Blackjack.common;

import java.util.Scanner;

public class BlackjackTable {

	Dealer theDealer = new Dealer();
	Player player = new Player();

	public void dealsCards() {
		theDealer.dealerShuffle();
		player.takeCard(theDealer.deal());
		theDealer.takeCard(theDealer.deal());
		player.takeCard(theDealer.deal());
		theDealer.takeCard(theDealer.deal());
		checkBJ();

	}

	public void displayCards() {
		System.out.println(player.getBlackjackHand().toString());
	
		System.out.println("Here is the dealer's hand" + " " + theDealer.getBlackjackHand().getCards().get(0));
		
		checkBJ();
	}

	public void playerTurn() {
		player.playerTotal();
		player.takeHit(theDealer.deal());

	}

	public void dealerTurn() {
		theDealer.takeHit(theDealer.deal());
	}

//	 check to see
//	 if player has blackjack
	public void checkBJ() {
		player.playerTotal();
		if (player.playerTotal() == 21 && theDealer.playerTotal() == 21) {
			System.out.println("It's a tie! We have a push!!");
			System.exit(player.playerTotal());

		} else if (theDealer.playerTotal() == 21) {
			System.out.println("Dealer wins!");
			System.exit(theDealer.playerTotal());
			
			
		} else if (player.playerTotal() == 21) {
			System.out.println("Player 1 wins!");
			System.exit(player.playerTotal());

		}

	}

	public void startGame() {
		Scanner sc = new Scanner(System.in);

		boolean keepGoing = true;
		while (keepGoing) {
			System.out.println("Keep going? yes or no ");
			String yes = sc.nextLine().toLowerCase();
			switch (yes) {

			case "yes":
			case "y":
				player.takeHit(theDealer.deal());
				player.playerTotal();
				System.out.println(player.getBlackjackHand().toString());
				keepGoing = player.blackjackHand.isBust();
				break;
			case "no":
			case "n":
				while (keepGoing) {
					System.out.println("Here is the dealer's hand" + theDealer.getBlackjackHand().getCards());
					int value = theDealer.playerTotal();
					keepGoing = theDealer.busted(value);
					keepGoing = theDealer.hasBlackJack(value);
					keepGoing = theDealer.wantsToHit(value);

					if (keepGoing) {
						theDealer.takeHit(theDealer.deal());
					}
				}
				keepGoing = false;
				break;
			default:
				System.out.println("invalid option");
				break;
			}
		}
		compareHands();

	}

	public void compareHands() {
		if (player.playerTotal() == theDealer.playerTotal()) {
			System.out.println("Both You and the Dealer tied.. We have a push!");

		} else if (theDealer.playerTotal() > 21
				|| theDealer.playerTotal() < player.playerTotal() && player.playerTotal() <= 21) {
			System.out.println("Player wins");

		} else if (player.playerTotal() < theDealer.playerTotal() || player.playerTotal() > 21) {
			System.out.println("Dealer wins");

		} else if (player.playerTotal() > theDealer.playerTotal() && player.playerTotal() < 22) {
			System.out.println("The player wins!");
		}

	}

}
