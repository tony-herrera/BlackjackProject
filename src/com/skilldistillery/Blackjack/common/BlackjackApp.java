package com.skilldistillery.Blackjack.common;

import java.util.Scanner;

public class BlackjackApp {

	public static void main(String[] args) {
		BlackjackTable table = new BlackjackTable();
		System.out.println("Welcome to Blackjack: ");

		table.dealsCards();
		table.displayCards();
		table.checkBJ();
		table.startGame();

	}
}
