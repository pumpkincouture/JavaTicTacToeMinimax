package Java_TTT.games.setup;

import Java_TTT.boards.Board;
import Java_TTT.participants.GameParticipants;
import Java_TTT.participants.ai.HardAI;
import Java_TTT.participants.human.Human;
import Java_TTT.participants.ai.SimpleAI;
import Java_TTT.rules.TTTBoardRules;
import Java_TTT.rules.FourByFourBoardRules;
import Java_TTT.rules.ThreeByThreeBoardRules;
import Java_TTT.ui.CommandLineInterface;

import java.util.ArrayList;
import java.util.List;

public class GameConfiguration {
    private CommandLineInterface ui;
    private TTTBoardRules boardRules;
    private Board board;
    private GameParticipants player1;
    private GameParticipants player2;
    private List<GameParticipants> positionsOfPlayers;
    private int boardSize;


    public GameConfiguration(CommandLineInterface ui) {
        this.ui = ui;
    }

    public GameParticipants getPlayer1() {
        return player1;
    }

    public GameParticipants getPlayer2() {
        return player2;
    }

    public Board getBoard() {
        return board;
    }

    public TTTBoardRules getBoardRules() {
        return boardRules;
    }

    public List<GameParticipants> accessFirstAndSecondPlayers() {
        return positionsOfPlayers;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void getGameConfigurationChoice() {
        ui.promptForBoardSize();
        validateBoardSizeChoice(ui.captureChoice());
        ui.chooseGameConfiguration();
        validatePlayerConfiguration(ui.captureChoice());
        ui.chooseStartingPlayer(player1.getName(), player2.getName());
        validateStartingPlayer(ui.captureChoice());
    }

    public void validateBoardSizeChoice(String boardSizeChoice) {
        switch(boardSizeChoice) {
            case "3":
                boardSize = convertAnswerToInteger(boardSizeChoice);
                board = new Board(boardSize);
                boardRules = new ThreeByThreeBoardRules(board);
                break;
            case "4":
                boardSize = convertAnswerToInteger(boardSizeChoice);
                board = new Board(boardSize);
                boardRules = new FourByFourBoardRules(board);
                break;
            default:
                ui.printError(boardSizeChoice);
                ui.promptForBoardSize();
                validateBoardSizeChoice(ui.captureChoice());
        }
    }

    public void validatePlayerConfiguration(String gameConfigurationChoice) {
        switch(gameConfigurationChoice) {
            case "1":
                player1 = new Human("X", ui);
                player2 = new Human("O", ui);
                break;
            case "2":
                player1 = new Human("X", ui);
                player2 = new SimpleAI("O", board);
                break;
            case "3":
                player1 = new Human("X", ui);
                player2 = new HardAI("O", boardRules, board);
                break;
            case "4":
                player1 = new SimpleAI("X", board);
                player2 = new HardAI("O", boardRules, board);
                break;
            default:
                ui.printError(gameConfigurationChoice);
                ui.chooseGameConfiguration();
                validatePlayerConfiguration(ui.captureChoice());
        }
    }

    public void validateStartingPlayer(String startingPlayerChoice) {
        String capitalizedChoice = startingPlayerChoice.toUpperCase();
        List<GameParticipants> playerPositions = new ArrayList<>();

        switch (capitalizedChoice) {
            case "1":
                playerPositions.add(player1);
                playerPositions.add(player2);
                positionsOfPlayers = playerPositions;
                break;
            case "2":
                playerPositions.add(player2);
                playerPositions.add(player1);
                positionsOfPlayers = playerPositions;
                break;
            default:
                ui.printError(capitalizedChoice);
                ui.chooseStartingPlayer(player1.getName(), player2.getName());
                validateStartingPlayer(ui.captureChoice());
        }
    }

    private int convertAnswerToInteger(String answer) {
        return Integer.parseInt(answer);
    }
}