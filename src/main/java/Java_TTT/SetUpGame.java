package Java_TTT;

import java.io.PrintStream;
import java.util.Scanner;

public class SetUpGame {
    private PrintStream output;
    private Scanner input;
    private UserInterface ui;
    private Board board;
    private GameScorer gameScorer;
    private GameConfiguration gameOptions;
    private PlayerInterface player1;
    private PlayerInterface player2;
    private Game game;

    public void startGame() {
        setUpAllObjects();
        game.start();
    }

    public void setUpAllObjects() {
        setUpCommandLine();
        setUpBoard();
        setUpGameConfiguration();
        getGame();
    }

    private void setUpCommandLine() {
        output = new PrintStream(System.out);
        input = new Scanner(System.in);
        ui = new CommandLineInterface(output, input);
    }

    private void setUpBoard() {
        board = new Board(3);
        gameScorer = new GameScorer(board);
    }

    private void setUpGameConfiguration() {
        gameOptions = new GameConfiguration((CommandLineInterface) ui, board);
        gameOptions.getGameConfigurationChoice();
        player1 = gameOptions.accessFirstAndSecondPlayers().get(0);
        player2 = gameOptions.accessFirstAndSecondPlayers().get(1);
    }

    private void getGame() {
        game = new Game(player1, player2, board, (CommandLineInterface) ui, gameScorer);
    }
}
