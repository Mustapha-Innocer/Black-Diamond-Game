package io.turntabl.blackDiamondGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Suit> suits =  List.of(Suit.SPADE,Suit.CLUB,Suit.HEART,Suit.DIAMOND);
    private List<Label> labels = List.of(Label.TWO,Label.THREE,Label.FOUR
            ,Label.FIVE,Label.SIX,Label.SEVEN,Label.EIGHT,Label.NINE
            ,Label.TEN,Label.JACK,Label.QUEEN,Label.KING,Label.ACE);
    private final List<Card> cards = new ArrayList<>();
    public Deck(){
        for(Suit suit : suits){
            for(Label label : labels){
                cards.add(new Card(suit,label));
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }
}
