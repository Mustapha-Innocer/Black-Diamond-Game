package io.turntabl.blackDiamondGame;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println(deck.getCards());
        deck.shuffle();
        System.out.println(deck.getCards());

    }
}
