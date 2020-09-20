package com.skilldistillery.common.cards;

import java.util.Scanner;

public class CardTest {
public static void main(String [] args) {
	
	
	Deck deck = new Deck();
	deck.shuffle();
	
	Scanner sc = new Scanner (System.in);
	System.out.println("How many cards?");
	
	int num = sc.nextInt();
	
	}

}
