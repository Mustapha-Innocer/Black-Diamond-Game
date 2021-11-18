package io.turntabl.blackDiamondGame;

public class Card {
    private Suit suit;
    private Label label;

    Card(Suit suit, Label label){
        this.suit =suit;
        this.label = label;
    }
    int value(){
        return label.getValue();    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", label=" + label +
                '}';
    }
}
