package io.turntabl.blackDiamondGame;

import java.util.ArrayList;
import java.util.List;

public class Strategy {
    private Deck deck;
    public Strategy(Deck deck) {
        this.deck = deck;
    }
    public void hit(Player player){
        player.updateStatus(Status.HIT);
        System.out.println("Player " + player.getId() +" score is  " + player.total());
        player.collect(deck.dealCard());
        //System.out.println("Player " + player.getId() +" got hit ");
    }
    public void stick(Player player){
        player.updateStatus(Status.STICK);
        System.out.println("Player " + player.getId() +" score is  " + player.total());
        //System.out.println(player.getId() +" Player got stick " + player.total());
    }
    public void goBust(Player player){
        player.updateStatus(Status.BUSTED);
        System.out.println("Player " + player.getId() +" score is  " + player.total());
        //System.out.println(player.getId() +" Player got busted " + player.total());
    }

}
