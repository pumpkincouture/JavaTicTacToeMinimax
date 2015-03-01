package Java_TTT;

import java.util.ArrayList;
import java.util.List;

public class GameConfiguration {
    private CommandLineInterface ui;
    private Board board;
    private PlayerInterface player1;
    private PlayerInterface player2;
    private List<PlayerInterface> positionsOfPlayers;
    private int boardSize;


    public GameConfiguration(CommandLineInterface ui) {
        this.ui = ui;
    }

    public PlayerInterface getPlayer1() {
        return player1;
    }

    public PlayerInterface getPlayer2() {
        return player2;
    }

    public Board getBoard() {
        return board;
    }

    public List<PlayerInterface> accessFirstAndSecondPlayers() {
        return positionsOfPlayers;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void getGameConfigurationChoice() {
        ui.promptForBoardSize();
        validateBoardSizeChoice(ui.captureChoice());
        ui.chooseGameConfiguration();
        validateGameConfiguration(ui.captureChoice());
        ui.chooseStartingPlayer(player1.getName(), player2.getName());
        validateStartingPlayer(ui.captureChoice());
    }

    public void validateBoardSizeChoice(String boardSizeChoice) {
        switch(boardSizeChoice) {
            case "3":
                boardSize = convertAnswerToInteger(boardSizeChoice);
                break;
            case "4":
                boardSize = convertAnswerToInteger(boardSizeChoice);
                break;
            default:
                ui.printError(boardSizeChoice);
                ui.promptForBoardSize();
                validateBoardSizeChoice(ui.captureChoice());
        }
    }

    public void validateGameConfiguration(String gameConfigurationChoice) {
        board = new Board(boardSize);
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
                player2 = new HardAI("O", board);
                break;
            case "4":
                player1 = new SimpleAI("X", board);
                player2 = new HardAI("O", board);
                break;
            default:
                ui.printError(gameConfigurationChoice);
                ui.chooseGameConfiguration();
                validateGameConfiguration(ui.captureChoice());
        }
    }

    public void validateStartingPlayer(String startingPlayerChoice) {
        String capitalizedChoice = startingPlayerChoice.toUpperCase();
        List<PlayerInterface> playerPositions = new ArrayList<>();

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