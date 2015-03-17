package Java_TTT.games.setup;

import Java_TTT.boards.Board;
import Java_TTT.participants.GameParticipants;
import Java_TTT.participants.ai.HardAI;
import Java_TTT.participants.ai.SimpleAI;
import Java_TTT.participants.human.Human;
import Java_TTT.rules.TTTBoardRules;
import Java_TTT.ui.CommandLineInterface;

import java.util.ArrayList;
import java.util.List;

public class ParticipantSetUp implements Configurable {
    private CommandLineInterface ui;
    private GameParticipants player1;
    private GameParticipants player2;
    private Board board;
    private TTTBoardRules boardRules;
    private List<Object> positionsOfPlayers;

    public ParticipantSetUp(CommandLineInterface ui, TTTBoardRules boardRules, Board board) {
        this.ui = ui;
        this.boardRules = boardRules;
        this.board = board;
    }

    @Override
    public void getConfigurationChoice() {
        ui.chooseGameConfiguration();
        validatePlayerConfiguration(ui.captureChoice());
        ui.chooseStartingPlayer(player1.getName(), player2.getName());
        validateStartingPlayer(ui.captureChoice());
    }

    @Override
    public List<Object> getDesiredGameOptions() {
        return accessFirstAndSecondPlayers();
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
        List<Object> playerPositions = new ArrayList<>();

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

    public GameParticipants getPlayer1() {
        return player1;
    }

    public GameParticipants getPlayer2() {
        return player2;
    }

    public List<Object> accessFirstAndSecondPlayers() {
        return positionsOfPlayers;
    }
}
