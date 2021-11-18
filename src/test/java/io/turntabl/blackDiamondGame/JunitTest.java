package io.turntabl.blackDiamondGame;

import org.junit.jupiter.api.Test;
import org.junit.Assert;

class JunitTest {

    @Test
    void deckTest() {
        int expected_value = 52;
        Deck deck = new Deck();
        Assert.assertEquals(expected_value, deck.getCards().size() );
    }

    @Test
    void cardValueTest(){
        Card card = new Card(Suit.CLUB, Label.QUEEN);
        int expected_value = 10;
        Assert.assertEquals(expected_value, card.value() );
    }
}