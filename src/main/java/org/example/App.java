package org.example;

import org.example.snakenladder.Board;
import org.example.snakenladder.Dice;
import org.example.snakenladder.Game;
import org.example.snakenladder.Player;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Map<Integer, Integer> snakeMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> ladderMap = new HashMap<Integer, Integer>();
        snakeMap.put(25,5);
        snakeMap.put(45,12);
        snakeMap.put(99,1);
        ladderMap.put(5,37);
        ladderMap.put(24,56);
        ladderMap.put(39,67);
        Dice dice = new Dice(1,12);
        Board board = new Board(snakeMap,ladderMap);
        Queue<Player> players = new LinkedList<>();
        Player player1 = new Player("Aneesh");
        Player player2 = new Player("Shobha");
        Player player3 = new Player("Murari");
        players.offer(player1);
        players.offer(player2);
        players.offer(player3);

        Map<String, Integer> playerPosition = new HashMap<>();
        playerPosition.put("Aneesh", 0);
        playerPosition.put("Shobha", 0);
        playerPosition.put("Murari", 0);
        Game game = new Game(board, players, dice,playerPosition);
        game.gamePlay();
    }
}
