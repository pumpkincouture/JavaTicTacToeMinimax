package Java_TTT.games.setup;

import Java_TTT.ui.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class BoardSize implements Choice {
    private UserInterface ui;
    private int boardChoice;
    private ChoiceValidator choiceValidator;

    public BoardSize(UserInterface ui) {
        this.ui = ui;
    }

    @Override
    public int getConfigurationChoice() {
        ui.promptForBoardSize();
        validateBoardSizeChoice(ui.captureChoice());
        return boardChoice;
    }

    public List<String> addValidChoices() {
        List<String> validChoices = new ArrayList<>();
        validChoices.add("3");
        validChoices.add("4");
        return validChoices;
    }

    public void validateBoardSizeChoice(String boardSizeChoice) {
        choiceValidator = new ChoiceValidator();

        if (choiceValidator.validUserChoice(boardSizeChoice, addValidChoices()) == 0) {
            getBoardOption(boardSizeChoice);
        } else {
            boardChoice = choiceValidator.validUserChoice(boardSizeChoice, addValidChoices());
        }
    }

    public void getBoardOption(String boardSizeChoice) {
        ui.printError(boardSizeChoice);
        ui.promptForBoardSize();
        validateBoardSizeChoice(ui.captureChoice());
    }
}
