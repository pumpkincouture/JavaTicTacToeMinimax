package Java_TTT.games.setup;

import java.util.ArrayList;
import java.util.List;

public class MenuFactory {
    private List<Integer> gameValues = new ArrayList<>();

    public void collectUserInput(List<ChoiceInterface> gameOptions) {
        for (ChoiceInterface choice : gameOptions) {
            choice.getConfigurationChoice();
            gameValues.add(choice.getDesiredGameOptions());
        }
    }

    public List<Integer> getUserValues() {
        return gameValues;
    }
}
