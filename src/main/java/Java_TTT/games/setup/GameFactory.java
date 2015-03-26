package Java_TTT.games.setup;

import Java_TTT.boards.Board;
import Java_TTT.participants.HardAI;
import Java_TTT.participants.Participant;
import Java_TTT.participants.SimpleAI;
import Java_TTT.participants.Human;
import Java_TTT.rules.GameRules;
import Java_TTT.ui.CommandLineInterface;
import Java_TTT.ui.UserInterface;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class GameFactory {
    private List<Integer> userChoices;
    private Board board;
    private Participant player1;
    private Participant player2;
    private PrintStream output;
    private Scanner input;
    private UserInterface ui;
    private GameRules gameRules;

    public GameFactory(List<Integer> userChoices) {
        this.userChoices = userChoices;
    }

    public void setUpGame() {
        setUpCommandLine();
        setUpBoard();
        setUpRules();
        setUpPlayers();
        setUpOrder();
    }

    public void setUpCommandLine() {
        output = new PrintStream(System.out);
        input = new Scanner(System.in);
        ui = new CommandLineInterface(output, input);
    }

    public void setUpBoard() {
        board = new Board(userChoices.get(0));
    }

    public void setUpRules() {
        switch(userChoices.get(0)) {
            case 3:
                gameRules = new GameRules(board);
                break;
            case 4:
                gameRules = new GameRules(board);
        }
    }

    public void setUpPlayers() {
        switch(userChoices.get(1)) {
            case 1:
                player1 = new Human("X", ui);
                player2 = new Human("O", ui);
                break;
            case 2:
                player1 = new Human("X", ui);
                player2 = new SimpleAI("O", board);
                break;
            case 3:
                player1 = new Human("X", ui);
                player2 = new HardAI("O", gameRules, board);
                break;
            case 4:
                player1 = new SimpleAI("O", board);
                player2 = new HardAI("X", gameRules, board);
                break;
        }
    }

    public void setUpOrder() {
        Participant switchedPlayer = player1;
        switch(userChoices.get(2)) {
            case 2:
                player1 = player2;
                player2 = switchedPlayer;
                break;
        }
    }

    public Participant getPlayerOne() {
        return player1;
    }

    public Participant getPlayerTwo() {
        return player2;
    }

    public Board getBoard() {
        return board;
    }

    public GameRules getGameRules() {
        return gameRules;
    }
}
