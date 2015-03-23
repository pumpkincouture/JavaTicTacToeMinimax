package Java_TTT.games.setup;

import Java_TTT.ui.CommandLineInterface;

import java.util.ArrayList;
import java.util.List;

public class ParticipantChoice implements ChoiceInterface {
    private CommandLineInterface ui;
    private int playerOption;
    private ChoiceValidator choiceValidator;

    public ParticipantChoice(CommandLineInterface ui) {
        this.ui = ui;
    }

    @Override
    public void getConfigurationChoice() {
        ui.chooseGameConfiguration();
        validatePlayerConfiguration(ui.captureChoice());
        ui.chooseStartingPlayer(playerOption);
    }

    @Override
    public int getDesiredGameOptions() {
        return playerOption;
    }

    public List<String> addValidChoices() {
        List<String> validChoices = new ArrayList<>();
        validChoices.add("1");
        validChoices.add("2");
        validChoices.add("3");
        validChoices.add("4");
        return validChoices;
    }

    public void validatePlayerConfiguration(String gameConfigurationChoice) {
        choiceValidator = new ChoiceValidator();

        if (choiceValidator.validUserChoice(gameConfigurationChoice, addValidChoices()) == 0) {
            getPlayerOption(gameConfigurationChoice);
        } else {
            playerOption = choiceValidator.validUserChoice(gameConfigurationChoice, addValidChoices());
        }
    }

    public void getPlayerOption(String gameConfigurationChoice) {
        ui.printError(gameConfigurationChoice);
        ui.chooseGameConfiguration();
        validatePlayerConfiguration(ui.captureChoice());
    }
}
