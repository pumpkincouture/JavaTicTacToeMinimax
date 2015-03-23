package Java_TTT.games.setup;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SetUpTicTacToeGameTest {
    private SetUpTicTacToeGame setupTest;

    @Test
    public void checkThatAllObjectsAreInitialized() {
        List<Integer> userChoices= new ArrayList<>();
        userChoices.add(3);
        userChoices.add(2);
        userChoices.add(1);

        setupTest = new SetUpTicTacToeGame(userChoices);

        setupTest.setUpBoard();
        setupTest.setUpRules();
        setupTest.setUpPlayers();
        setupTest.setUpOrder();

        assertEquals(9, setupTest.getBoard().getLength());
        assertEquals("BoardRules", setupTest.getBoardRules().getClass().getSimpleName());
        assertEquals("Human", setupTest.getPlayerOne().getClass().getSimpleName());
        assertEquals("SimpleAI", setupTest.getPlayerTwo().getClass().getSimpleName());
    }

    @Test
    public void checkThatObjectsAreInitializedTestTwo() {
        List<Integer> userChoices= new ArrayList<>();
        userChoices.add(4);
        userChoices.add(3);
        userChoices.add(2);

        setupTest = new SetUpTicTacToeGame(userChoices);

        setupTest.setUpBoard();
        setupTest.setUpRules();
        setupTest.setUpPlayers();
        setupTest.setUpOrder();

        assertEquals(16, setupTest.getBoard().getLength());
        assertEquals("BoardRules", setupTest.getBoardRules().getClass().getSimpleName());
        assertEquals("HardAI", setupTest.getPlayerOne().getClass().getSimpleName());
        assertEquals("Human", setupTest.getPlayerTwo().getClass().getSimpleName());
    }
}
