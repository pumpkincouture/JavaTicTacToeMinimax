package Java_TTT.games.setup;

import Java_TTT.ui.CommandLineInterface;

public class ParticipantSetUp implements Configurable {
    private CommandLineInterface ui;
    private int playerOption;

    public ParticipantSetUp(CommandLineInterface ui) {
        this.ui = ui;
    }

    @Override
    public void getConfigurationChoice() {
        ui.chooseGameConfiguration();
        validatePlayerConfiguration(ui.captureChoice());
    }

    @Override
    public int getDesiredGameOptions() {
        return playerOption;
    }

    public void validatePlayerConfiguration(String gameConfigurationChoice) {
        switch(gameConfigurationChoice) {
            case "1":
                playerOption = convertAnswerToInteger(gameConfigurationChoice);
                break;
            case "2":
                playerOption = convertAnswerToInteger(gameConfigurationChoice);
                break;
            case "3":
                playerOption = convertAnswerToInteger(gameConfigurationChoice);
                break;
            case "4":
                playerOption = convertAnswerToInteger(gameConfigurationChoice);
                break;
            default:
                ui.printError(gameConfigurationChoice);
                ui.chooseGameConfiguration();
                validatePlayerConfiguration(ui.captureChoice());
        }
    }

    private int convertAnswerToInteger(String answer) {
        return Integer.parseInt(answer);
    }
}
