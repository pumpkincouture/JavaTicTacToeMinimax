package Java_TTT.games.setup;

import Java_TTT.ui.CommandLineInterface;

import java.util.ArrayList;
import java.util.List;

public class ParticipantOrder implements Choice {
    private CommandLineInterface ui;
    private int playerOrder;
    private ChoiceValidator choiceValidator;

    public ParticipantOrder(CommandLineInterface ui) {
        this.ui = ui;
    }

    @Override
    public void getConfigurationChoice() {
        validateStartingPlayer(ui.captureChoice());
    }

    @Override
    public int getDesiredGameOptions() {
        return playerOrder;
    }

    public List<String> addValidChoices() {
        List<String> validChoices = new ArrayList<>();
        validChoices.add("1");
        validChoices.add("2");
        return validChoices;
    }
    public void validateStartingPlayer(String startingPlayerChoice) {
        choiceValidator = new ChoiceValidator();

        if (choiceValidator.validUserChoice(startingPlayerChoice, addValidChoices()) == 0) {
            getOrderOption(startingPlayerChoice);
        } else {
            playerOrder = choiceValidator.validUserChoice(startingPlayerChoice, addValidChoices());
        }
    }

    public void getOrderOption(String startingPlayerChoice) {
        ui.printError(startingPlayerChoice);
        validateStartingPlayer(ui.captureChoice());
    }

}
