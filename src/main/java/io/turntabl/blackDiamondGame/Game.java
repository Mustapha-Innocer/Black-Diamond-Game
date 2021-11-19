package io.turntabl.blackDiamondGame;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Scanner;


public class Game {
    private  Deck deck;
    private List<Player> players;
    private Player winner;
    private Strategy strategy;

    public Game() {
        deck = new Deck();
        players = new ArrayList<>();
//        players.addAll(Arrays.asList(new Player(1), new Player(2), new Player(3)));
        createPlayers();
        deck.shuffle();
        strategy = new Strategy(deck);
    }

    public void createPlayers(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of players to create: ");
        int numberOfPlayer = sc.nextInt();

        if (numberOfPlayer > 6 || numberOfPlayer < 1){
            System.out.println("Player less than 1 or greater than 6 can't be created " +
                    "\nThe default number of player is now 3" +
                    "\n----------------------------------");
            numberOfPlayer = 3;
        }
        for (int i = 0; i < numberOfPlayer; i++){
            players.add(new Player(i+1));
        }
    }

    public void start(){

        initialDeal();

        while (true){
           List<Player> stickPlayers = players.stream().filter(player -> player.getStatus().equals(Status.STICK))
                   .collect(Collectors.toList());
           List<Player> playerTotalIs21 = players.stream().filter(player -> player.total() == 21).collect(Collectors.toList());
           if (stickPlayers.size() == players.size()){
               winner = players.stream().max(Comparator.comparingInt(Player::total)).get();
               for(Player player: players){
                   if (player.total() == winner.total()){
                       System.out.println("Winner " + player);
                   }
               }
               System.out.println(winner.total());
               break;
           }else if (playerTotalIs21.size() > 0){
               playerTotalIs21.forEach(System.out::println);
               break;
           }else if(players.size() == 1){
               System.out.println("Winner " + players.get(0));
               break;
           }else {
               nextMove();
               System.out.println("\n------------------------");
           }
        }

    }

    public void initialDeal(){
        for (Player player: players){
            player.collect(deck.dealCard(),deck.dealCard());
        }

    }

    public void nextMove(){
        List<Player> toBeBusted = new ArrayList<>();
        for (Player player: players){
            if (player.total() < 17){
                strategy.hit(player);
            }else if(player.total() > 21 ){
                toBeBusted.add(player);
                strategy.goBust(player);
            }else {
                strategy.stick(player);
            }
        }
        players.removeAll(toBeBusted);


    }


}
