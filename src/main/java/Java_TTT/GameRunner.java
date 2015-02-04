package Java_TTT;

import java.io.*;
import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) {
        PrintStream output = new PrintStream(System.out);
        Scanner input = new Scanner(System.in);
        UserInterface ui = new CommandLineInterface(output, input);
        Board board = new Board(3);
        GameScorer gameScorer = new GameScorer(board);
        GameConfiguration gameOptions = new GameConfiguration((CommandLineInterface) ui, board);
        gameOptions.getGameConfigurationChoice();
        PlayerOrder determinePlayerOrder = new PlayerOrder(gameOptions.getPlayer1(), gameOptions.getPlayer2(), (CommandLineInterface) ui);
        determinePlayerOrder.findStartingPlayer();
        Player player1 = determinePlayerOrder.accessFirstAndSecondPlayers().get(0);
        Player player2 = determinePlayerOrder.accessFirstAndSecondPlayers().get(1);

        Game game = new Game(player1, player2, board, (CommandLineInterface) ui, gameScorer);
        game.startGame();
    }
}
