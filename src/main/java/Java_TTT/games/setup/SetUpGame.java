package Java_TTT.games.setup;

import Java_TTT.boards.Board;
import Java_TTT.games.Game;
import Java_TTT.participants.GameParticipants;
import Java_TTT.rules.TTTBoardRules;
import Java_TTT.ui.CommandLineInterface;
import Java_TTT.ui.UserInterface;

import java.io.PrintStream;
import java.util.Scanner;

public class SetUpGame {
    private PrintStream output;
    private Scanner input;
    private UserInterface ui;
    private Board board;
    private TTTBoardRules boardRules;
    private GameConfiguration gameOptions;
    private GameParticipants player1;
    private GameParticipants player2;
    private Game game;

    public void startGame() {
        setUpAllObjects();
        game.start();
    }

    public void setUpAllObjects() {
        setUpCommandLine();
        setUpGameConfiguration();
        getGame();
    }

    private void setUpCommandLine() {
        output = new PrintStream(System.out);
        input = new Scanner(System.in);
        ui = new CommandLineInterface(output, input);
    }

    private void setUpGameConfiguration() {
        gameOptions = new GameConfiguration((CommandLineInterface) ui);
        gameOptions.getGameConfigurationChoice();
        board = gameOptions.getBoard();
        player1 = gameOptions.accessFirstAndSecondPlayers().get(0);
        player2 = gameOptions.accessFirstAndSecondPlayers().get(1);
        boardRules = gameOptions.getBoardRules();
    }

    private void getGame() {
        game = new Game(player1, player2, board, (CommandLineInterface) ui, boardRules);
    }
}
