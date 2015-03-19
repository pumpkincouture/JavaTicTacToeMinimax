package Java_TTT.games.setup;

import Java_TTT.boards.BoardInterface;
import Java_TTT.boards.TTTBoard;
import Java_TTT.games.Game;
import Java_TTT.participants.GameParticipants;
import Java_TTT.participants.ai.HardAI;
import Java_TTT.participants.ai.SimpleAI;
import Java_TTT.participants.human.Human;
import Java_TTT.rules.FourByFourBoardRules;
import Java_TTT.rules.TTTBoardRules;
import Java_TTT.rules.ThreeByThreeBoardRules;
import Java_TTT.ui.CommandLineInterface;
import Java_TTT.ui.UserInterface;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class SetUpTicTacToeGame {
    private List<Integer> userChoices;
    private BoardInterface board;
    private GameParticipants player1;
    private GameParticipants player2;
    private PrintStream output;
    private Scanner input;
    private UserInterface ui;
    private TTTBoardRules boardRules;
    private Game game;

    public SetUpTicTacToeGame(List<Integer> userChoices) {
        this.userChoices = userChoices;
    }

    public void setUpGame() {
        setUpCommandLine();
        setUpBoard();
        setUpRules();
        setUpPlayers();
        setUpOrder();
        getGame();
    }

    public void setUpCommandLine() {
        output = new PrintStream(System.out);
        input = new Scanner(System.in);
        ui = new CommandLineInterface(output, input);
    }

    public void setUpBoard() {
        board = new TTTBoard(userChoices.get(0));
    }

    public BoardInterface getBoard() {
        return board;
    }

    public void setUpRules() {
        switch(userChoices.get(0)) {
            case 3:
                boardRules = new ThreeByThreeBoardRules(board);
                break;
            case 4:
                boardRules = new FourByFourBoardRules(board);
        }
    }

    public TTTBoardRules getBoardRules() {
        return boardRules;
    }

    public void setUpPlayers() {
        switch(userChoices.get(1)) {
            case 1:
                player1 = new Human("X", (CommandLineInterface) ui);
                player2 = new Human("O", (CommandLineInterface) ui);
                break;
            case 2:
                player1 = new Human("X", (CommandLineInterface) ui);
                player2 = new SimpleAI("O", board);
                break;
            case 3:
                player1 = new Human("X", (CommandLineInterface) ui);
                player2 = new HardAI("O", boardRules, board);
                break;
            case 4:
                player1 = new SimpleAI("O", board);
                player2 = new HardAI("X", boardRules, board);
                break;
        }
    }

    public void setUpOrder() {
        GameParticipants switchedPlayer = player1;
        switch(userChoices.get(2)) {
            case 2:
                player1 = player2;
                player2 = switchedPlayer;
                break;
        }
    }

    public GameParticipants getPlayerOne() {
        return player1;
    }

    public GameParticipants getPlayerTwo() {
        return player2;
    }

    public void getGame() {
        game = new Game(player1, player2, board, ui, boardRules);
        game.start();
    }
}
