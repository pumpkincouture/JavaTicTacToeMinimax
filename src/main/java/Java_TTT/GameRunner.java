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
        PlayerInterface player1 = gameOptions.accessFirstAndSecondPlayers().get(0);
        PlayerInterface player2 = gameOptions.accessFirstAndSecondPlayers().get(1);

        Game game = new Game(player1, player2, board, (CommandLineInterface) ui, gameScorer);
        game.startGame();
    }
}
