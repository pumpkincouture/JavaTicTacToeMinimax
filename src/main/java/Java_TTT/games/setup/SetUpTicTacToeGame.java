package Java_TTT.games.setup;

import java.util.List;

public class SetUpTicTacToeGame {

    public void setUpGame(List<Configurable> setupItems) {
        for (int i= 0; i < setupItems.size(); i++) {
            setupItems.get(i).getConfigurationChoice();
        }
    }
}
