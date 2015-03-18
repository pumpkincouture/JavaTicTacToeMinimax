package Java_TTT.games.setup;

import java.util.List;

public class ChoiceValidator {

    public int validUserChoice(String userChoice, List<String> correctChoices) {
        if (correctChoices.contains(userChoice)) {
            return convertAnswerToInteger(userChoice);
        }
        return 0;
    }

    private int convertAnswerToInteger(String answer) {
        return Integer.parseInt(answer);
    }
}
