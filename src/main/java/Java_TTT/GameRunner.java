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

        Game game = new Game((new HumanPlayer("X", (CommandLineInterface) ui)), (Player) pickOpponent.getChosenOpponent(), board, (CommandLineInterface) ui, new GameScorer(board));
        game.startGame();
    }
}
