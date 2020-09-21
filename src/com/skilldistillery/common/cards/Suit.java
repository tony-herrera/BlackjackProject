package com.skilldistillery.common.cards;

public enum Suit {
  HEARTS("\u2764"), SPADES("\u2660"), CLUBS("\u2663"), DIAMONDS("\u2666");
  private String name;

  Suit(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}