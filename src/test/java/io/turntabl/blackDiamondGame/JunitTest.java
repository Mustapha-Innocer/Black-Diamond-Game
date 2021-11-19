package io.turntabl.blackDiamondGame;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

class JunitTest {
    Player player;
    Deck deck;

    @BeforeEach
    public void setup(){
        player = new Player(1);
        deck = new Deck();
    }

    @Test
    void deckTest() {
        int expected_value = 52;
        Assert.assertEquals(expected_value, deck.getCards().size() );
    }

    @Test
    void cardValueTest(){
        Card card = new Card(Suit.CLUB, Label.QUEEN);
        int expected_value = 10;
        Assert.assertEquals(expected_value, card.getValue() );
    }

    @Test
    void dealCardTest(){
        Card expectedCard = deck.getCards().get(0);
        Assert.assertEquals(expectedCard, deck.dealCard());
    }

    @Test
    void cardsLeftAfterDealTest(){
        deck.dealCard();
        int expected = 51;
        Assert.assertEquals(expected, deck.getCards().size());
    }

    @Test
    public void collectTest(){
        player.collect(deck.dealCard(),deck.dealCard());
        int expectedValue = 2;
        Assert.assertEquals(expectedValue,player.getCards().size());
    }
    @Test
    public void collectTest2(){
        player.collect(deck.dealCard(),deck.dealCard());
        player.collect(deck.dealCard());
        int expectedValue = 3;
        Assert.assertEquals(expectedValue,player.getCards().size());
    }

    @Test
    public void correctSummingCardValues(){
        player.collect(deck.dealCard(), deck.dealCard());
        int expectValue = 5;
        int actualValue = player.total();
        Assert.assertEquals(expectValue,actualValue);

    }
}