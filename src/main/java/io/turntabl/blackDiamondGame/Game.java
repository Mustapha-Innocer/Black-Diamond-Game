package io.turntabl.blackDiamondGame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private  Deck deck;
    private List<Player> players;
    public Game() {
        deck = new Deck();
        players = List.of(new Player(1), new Player(2), new Player(3));
        deck.shuffle();
    }

    public void start(){
        initialDeal();

    }

    public void initialDeal(){
        for (Player player: players){
            player.collect(deck.dealCard(),deck.dealCard());
        }

    }
}
