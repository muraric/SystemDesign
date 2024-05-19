package org.example.snakenladder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Queue;

@Getter
@Setter
@AllArgsConstructor
public class Game {
    private Board board;
    private Queue<Player> players;
    private Dice dice;
    private Map<String, Integer> playerPosition;

    public void gamePlay() {
        int targetPosition = 0;
        while (players.size() > 1) {
            System.out.println();

            Player player = players.poll();
            String playerName = player.getName();
            int luckyCounter = dice.rollDice();
            if (luckyCounter + playerPosition.get(playerName) <= 100) {
                targetPosition = luckyCounter + playerPosition.get(playerName);
                System.out.print(playerName + " " + luckyCounter + " " + targetPosition);
            } else {
                System.out.print(playerName + " " + luckyCounter + " " + targetPosition);
                System.out.print(" Wait for next turn!!!");
                targetPosition = playerPosition.get(playerName);
            }
            if (board.getLadderMap().containsKey(targetPosition)) {
                playerPosition.put(playerName, board.getLadderMap().get(targetPosition));
                System.out.print(" going up with LADDER");
            } else {
                if (board.getSnakeMap().containsKey(targetPosition)) {
                    System.out.print(" bitten by SnAkE");
                    playerPosition.put(playerName, board.getSnakeMap().get(targetPosition));
                } else {
                    playerPosition.put(playerName, targetPosition);
                }
            }
            if (targetPosition == 100) {
                System.out.print(" Congratulations!!! " + playerName);
                players.remove(player);
            } else {
                players.remove(player);
                players.offer(new Player(playerName));
            }

        }
    }
}
