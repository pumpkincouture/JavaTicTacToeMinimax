package Java_TTT;

import java.io.*;
import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) {
        PrintStream output = new PrintStream(System.out);
        Scanner input = new Scanner(System.in);
        UserInterface ui = new CommandLineInterface(output, input);
        Board board = new Board(3);
        PlayerFactory pickOpponent = new PlayerFactory((CommandLineInterface) ui, board);
        Player gameOpponent = (Player) pickOpponent.getChosenOpponent();
        Player HumanPlayer = new HumanPlayer("X", (CommandLineInterface) ui);
        GameScorer gameScorer = new GameScorer(board);
        PlayerOrder determinePlayerOrder = new PlayerOrder(HumanPlayer, gameOpponent, (CommandLineInterface) ui);
        determinePlayerOrder.chooseStartingPlayerPrompt();
        determinePlayerOrder.findStartingPlayer();
        Player player1 = determinePlayerOrder.accessFirstAndSecondPlayers().get(0);
        Player player2 = determinePlayerOrder.accessFirstAndSecondPlayers().get(1);

        Game game = new Game(player1, player2, board, (CommandLineInterface) ui, gameScorer);
        game.startGame();
    }
}
