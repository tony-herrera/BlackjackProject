package com.skilldistillery.Blackjack.common;

import java.util.Scanner;

public class BlackjackTable {

	Dealer theDealer = new Dealer();
	Player player = new Player();

	public void welcome() {
		System.out.println("\n" + " __    __        _                                 _          \n"
				+ "/ / /\\ \\ \\  ___ | |  ___   ___   _ __ ___    ___  | |_   ___  \n"
				+ "\\ \\/  \\/ / / _ \\| | / __| / _ \\ | '_ ` _ \\  / _ \\ | __| / _ \\ \n"
				+ " \\  /\\  / |  __/| || (__ | (_) || | | | | ||  __/ | |_ | (_) |\n"
				+ "  \\/  \\/   \\___||_| \\___| \\___/ |_| |_| |_| \\___|  \\__| \\___/ \n"
				+ "   ___  _               _       _               _             \n"
				+ "  / __\\| |  __ _   ___ | | __  (_)  __ _   ___ | | __         \n"
				+ " /__\\//| | / _` | / __|| |/ /  | | / _` | / __|| |/ /         \n"
				+ "/ \\/  \\| || (_| || (__ |   <   | || (_| || (__ |   <          \n"
				+ "\\_____/|_| \\__,_| \\___||_|\\_\\ _/ | \\__,_| \\___||_|\\_\\         \n"
				+ "                             |__/                             \n");
	}

	public void dealsCards() {
		theDealer.dealerShuffle();
		player.takeCard(theDealer.deal());
		theDealer.takeCard(theDealer.deal());
		player.takeCard(theDealer.deal());
		theDealer.takeCard(theDealer.deal());
		checkBJ();

	}

	public void displayCards() {
		System.out.println("*******************************************************");
		System.out.println(player.getBlackjackHand().toString());
		System.out.println("Here is the dealer's hand" + " : " + theDealer.getBlackjackHand().getCards().get(0));
		System.out.println("-------------------------------------------------------");
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
			System.out.println("________________________");
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
					System.out.println("---------------------------------------------------------------------");
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
			System.out.println("Player wins!!");
			System.out.println("\"`-._,-'\"`-._,-'\"`-._,-'\"`-._,-'\n" + 
					"");

		} else if (player.playerTotal() < theDealer.playerTotal() || player.playerTotal() > 21) {
			System.out.println("Dealer wins");

		} else if (player.playerTotal() > theDealer.playerTotal() && player.playerTotal() < 22) {
			System.out.println("The player wins!!");
			System.out.println("\"`-._,-'\"`-._,-'\"`-._,-'\"`-._,-'\n" + 
					"");
		}

	}

}
