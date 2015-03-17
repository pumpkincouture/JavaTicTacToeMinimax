package Java_TTT.games.setup;

import Java_TTT.ui.MockUserInterface;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class BoardSetUpTest {
    private BoardSetUp boardConfigurationTest;
    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in);
    private MockUserInterface mockUI = new MockUserInterface(output, input);

    @Before
    public void setUp() {
        boardConfigurationTest = new BoardSetUp(mockUI);
    }

    private void chooseBoardSize(String boardSizeChoice) {
        boardConfigurationTest.validateBoardSizeChoice(boardSizeChoice);
    }

    @Test
    public void validateBoardSizeUntilChoiceIs3() {
        mockUI.addNextMove("2");
        mockUI.addNextMove("p");
        mockUI.addNextMove("3");

        chooseBoardSize(mockUI.captureChoice());

        assertEquals(true, mockUI.isDisplayInvalidChoiceMessageCalled());
        assertEquals(true, mockUI.isBoardSizePromptCalled());
        assertEquals(3, boardConfigurationTest.getBoardSize());
        assertEquals("ThreeByThreeBoardRules", boardConfigurationTest.getBoardRules().getClass().getSimpleName());
        assertEquals(9, boardConfigurationTest.getBoard().getLength());
    }

    @Test
    public void validateBoardSizeUntilChoiceIs4() {
        mockUI.addNextMove("2");
        mockUI.addNextMove("p");
        mockUI.addNextMove("4");

        chooseBoardSize(mockUI.captureChoice());

        assertEquals(true, mockUI.isDisplayInvalidChoiceMessageCalled());
        assertEquals(true, mockUI.isBoardSizePromptCalled());
        assertEquals(4, boardConfigurationTest.getBoardSize());
        assertEquals("FourByFourBoardRules", boardConfigurationTest.getBoardRules().getClass().getSimpleName());
        assertEquals(16, boardConfigurationTest.getBoard().getLength());
    }
}
