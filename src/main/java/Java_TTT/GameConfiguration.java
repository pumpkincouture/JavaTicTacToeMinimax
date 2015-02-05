package Java_TTT;

import java.util.ArrayList;
import java.util.List;

public class GameConfiguration {
    private CommandLineInterface ui;
    private Board board;
    private Player player1;
    private Player player2;
    private List<Player> positionsOfPlayers;


    public GameConfiguration(CommandLineInterface ui, Board board) {
        this.ui = ui;
        this.board = board;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public List<Player> accessFirstAndSecondPlayers() {
        return positionsOfPlayers;
    }

    public void getGameConfigurationChoice() {
        chooseConfigurationsPrompt();
        validateGameConfiguration(captureGameConfigurationChoice());
        chooseStartingPlayerPrompt();
        validateStartingPlayer(captureGameConfigurationChoice());
    }

    public void validateGameConfiguration(String gameConfigurationChoice) {
        switch(gameConfigurationChoice) {
            case "1":
                player1 = new HumanPlayer("X", ui);
                player2 = new HumanPlayer("O", ui);
                break;
            case "2":
                player1 = new HumanPlayer("X", ui);
                player2 = new ComputerPlayer("O", board, ui);
                break;
            case "3":
                player1 = new HumanPlayer("X", ui);
                player2 = new AIComputerPlayer("O", board, ui);
                break;
            case "4":
                player1 = new ComputerPlayer("X", board, ui);
                player2 = new AIComputerPlayer("O", board, ui);
                break;
            default:
                ui.printError(gameConfigurationChoice);
                chooseConfigurationsPrompt();
                validateGameConfiguration(captureGameConfigurationChoice());
        }
    }

    public void validateStartingPlayer(String startingPlayerChoice) {
        String capitalizedChoice = startingPlayerChoice.toUpperCase();
        List<Player> playerPositions = new ArrayList<>();

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
                chooseStartingPlayerPrompt();
                validateStartingPlayer(captureGameConfigurationChoice());
        }
    }

    private String captureGameConfigurationChoice() {
        return ui.captureChoice();
    }

    private String getPlayerName(Player player) {
        return player.getClass().getSimpleName();
    }

    private void chooseConfigurationsPrompt() {
        ui.chooseGameConfiguration();
    }

    private void chooseStartingPlayerPrompt() {
        ui.chooseStartingPlayer(getPlayerName(player1), getPlayerName(player2));
    }
}