package com.skilldistillery.Blackjack.common;

import java.util.Scanner;

public class BlackjackApp {
	
	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
		Dealer deal = new Dealer ();
		deal.startDeal();
		
		

		sc.close();
	}
}