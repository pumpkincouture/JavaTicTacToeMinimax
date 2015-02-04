package Java_TTT;

import java.util.ArrayList;
import java.util.List;

public class PlayerOrder {
    private CommandLineInterface ui;
    private Player player1;
    private Player player2;
    private List<Player> positionsOfPlayers;

    public PlayerOrder(Player player1, Player player2, CommandLineInterface ui) {
        this.player1 = player1;
        this.player2 = player2;
        this.ui = ui;
    }

    public void chooseStartingPlayerPrompt() {
        ui.chooseStartingPlayer(player1.getClass().getSimpleName(), player2.getClass().getSimpleName());
    }

    public void findStartingPlayer() {
        chooseStartingPlayerPrompt();
        validateStartingPlayer(captureStartingPlayerChoice());
    }

    public List<Player> accessFirstAndSecondPlayers() {
        return positionsOfPlayers;
    }

    public String captureStartingPlayerChoice() {
        return ui.captureChoice();
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
                validateStartingPlayer(captureStartingPlayerChoice());
        }
    }
}
