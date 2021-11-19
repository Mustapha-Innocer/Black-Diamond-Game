package io.turntabl.blackDiamondGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    private int id;
    private Status status = Status.HIT;

    public Player(int id) {
        this.id = id;
    }

    List<Card> cards = new ArrayList<>();

    public int total (){
        return cards.stream().map(c -> c.getValue()).reduce(Integer::sum).get();
    }

    public void collect(Card card){
        cards.add(card);

    }
    public void collect(Card cardOne,Card cardTwo){
        cards.addAll(Arrays.asList(cardOne,cardTwo));
    }

    public List<Card> getCards() {
        return cards;
    }
    public void updateStatus(Status status){
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                " Total " + total() +
                '}';
    }
}
