package Java_TTT.games.choiceUi;

import Java_TTT.messages.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class ParticipantOrder implements Choice {
    private UserInterface ui;
    private int playerOrder;
    private ChoiceValidator choiceValidator;

    public ParticipantOrder(UserInterface ui) {
        this.ui = ui;
    }

    @Override
    public int getConfigurationChoice() {
        validateStartingPlayer(ui.captureChoice());
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
