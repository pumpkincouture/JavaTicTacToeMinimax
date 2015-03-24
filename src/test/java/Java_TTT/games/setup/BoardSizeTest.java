package Java_TTT.games.setup;

import Java_TTT.ui.MockUserInterface;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BoardSizeTest {
    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in);
    private MockUserInterface mockUI = new MockUserInterface(output, input);

    @Test
    public void validateBoardSizeUntilChoiceIs3() {
        Choice boardConfig = new BoardSize(mockUI);

        mockUI.addNextMove("2");
        mockUI.addNextMove("p");
        mockUI.addNextMove("3");

        boardConfig.getConfigurationChoice();

        assertTrue(mockUI.isDisplayInvalidChoiceMessageCalled());
        assertTrue(mockUI.isBoardSizePromptCalled());
    }

    @Test
    public void validateBoardSizeUntilChoiceIs4() {
        Choice boardConfig = new BoardSize(mockUI);

        mockUI.addNextMove("2");
        mockUI.addNextMove("p");
        mockUI.addNextMove("4");

        boardConfig.getConfigurationChoice();

        assertTrue(mockUI.isDisplayInvalidChoiceMessageCalled());
        assertTrue(mockUI.isBoardSizePromptCalled());
    }

    @Test
    public void getBoardChoice() {
        Choice boardConfig = new BoardSize(mockUI);

        mockUI.addNextMove("2");
        mockUI.addNextMove("p");
        mockUI.addNextMove("4");

        boardConfig.getConfigurationChoice();

        assertTrue(mockUI.isBoardSizePromptCalled());
    }
}
