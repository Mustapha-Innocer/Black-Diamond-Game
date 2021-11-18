package io.turntabl.blackDiamondGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    private int id;
    List<Card> cards = new ArrayList<>();

    public int total (){
        return cards.stream().map(c -> c.value()).reduce(Integer::sum).get();
    }

    public void collect(Card card){
        cards.add(card);

    }
    public void collect(Card cardOne,Card cardTwo){
        cards.addAll(Arrays.asList(cardOne,cardTwo));
    }
}
