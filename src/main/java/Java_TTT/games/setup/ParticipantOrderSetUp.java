package Java_TTT.games.setup;

import Java_TTT.ui.CommandLineInterface;

public class ParticipantOrderSetUp implements Configurable {
    private CommandLineInterface ui;
    private int playerConfigChoice;
    private int playerOrder;

    public ParticipantOrderSetUp(CommandLineInterface ui, int playerConfigChoice) {
        this.ui = ui;
        this.playerConfigChoice = playerConfigChoice;
    }

    @Override
    public void getConfigurationChoice() {
        ui.chooseStartingPlayer(playerConfigChoice);
        validateStartingPlayer(ui.captureChoice());
    }

    @Override
    public int getDesiredGameOptions() {
        return playerOrder;
    }

    public void validateStartingPlayer(String startingPlayerChoice) {
        switch (startingPlayerChoice) {
            case "1":
                playerOrder = convertAnswerToInteger(startingPlayerChoice);
                break;
            case "2":
                playerOrder = convertAnswerToInteger(startingPlayerChoice);
                break;
            default:
                ui.printError(startingPlayerChoice);
                ui.chooseStartingPlayer(playerConfigChoice);
                validateStartingPlayer(ui.captureChoice());
        }
    }

    private int convertAnswerToInteger(String answer) {
        return Integer.parseInt(answer);
    }
}
