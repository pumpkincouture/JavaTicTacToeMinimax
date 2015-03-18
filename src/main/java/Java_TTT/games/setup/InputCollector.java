package Java_TTT.games.setup;

import java.util.ArrayList;
import java.util.List;

public class InputCollector {
    private List<Integer> gameValues = new ArrayList<>();

    public void collectUserInput(List<Configurable> gameOptions) {
        for (int i = 0; i < gameOptions.size(); i++) {
            gameOptions.get(i).getConfigurationChoice();
            gameValues.add(gameOptions.get(i).getDesiredGameOptions());
        }
    }

    public List<Integer> getUserValues() {
        return gameValues;
    }
}
