package Java_TTT.games.setup;

import java.util.ArrayList;
import java.util.List;

public class InputCollector {
    private List<Integer> gameValues = new ArrayList<>();

    public void collectUserInput(List<Configurable> gameOptions) {
        for (Configurable configurable : gameOptions) {
            configurable.getConfigurationChoice();
            gameValues.add(configurable.getDesiredGameOptions());
        }
    }

    public List<Integer> getUserValues() {
        return gameValues;
    }
}
