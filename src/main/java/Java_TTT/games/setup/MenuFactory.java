package Java_TTT.games.setup;

import Java_TTT.ui.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class MenuFactory {
    private UserInterface userInterface;

    public MenuFactory(UserInterface ui) {
        this.userInterface = ui;
    }

    public List<Integer> collectUserInput() {
        List<Integer> gameValues = new ArrayList<>();
        for (Choice choice : getUserChoices()) {
            gameValues.add(choice.getConfigurationChoice());
        }
        return gameValues;
    }

    public List<Choice> getUserChoices() {
        List<Choice> userChoices= new ArrayList<>();

        Choice boardConfig = new BoardSize(userInterface);
        Choice playerConfig = new ParticipantChoice(userInterface);
        Choice orderConfig = new ParticipantOrder(userInterface);

        userChoices.add(boardConfig);
        userChoices.add(playerConfig);
        userChoices.add(orderConfig);

        return userChoices;
    }

}
