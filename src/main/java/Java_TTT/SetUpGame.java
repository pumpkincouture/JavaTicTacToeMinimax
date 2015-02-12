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
    private int boardSize;

    public void startGame() {
        setUpAllObjects();
        game.start();
    }

    public void setUpAllObjects() {
        setUpCommandLine();
        setUpGameConfiguration();
        setUpBoard();
        getGame();
    }

    private void setUpCommandLine() {
        output = new PrintStream(System.out);
        input = new Scanner(System.in);
        ui = new CommandLineInterface(output, input);
    }

    private void setUpGameConfiguration() {
        gameOptions = new GameConfiguration((CommandLineInterface) ui, board);
        gameOptions.getGameConfigurationChoice();
        player1 = gameOptions.accessFirstAndSecondPlayers().get(0);
        player2 = gameOptions.accessFirstAndSecondPlayers().get(1);
        boardSize = gameOptions.getBoardSize();
    }

    private void setUpBoard() {
        board = new Board(boardSize);
        gameScorer = new GameScorer(board);
    }

    private void getGame() {
        game = new Game(player1, player2, board, (CommandLineInterface) ui, gameScorer);
    }
}
