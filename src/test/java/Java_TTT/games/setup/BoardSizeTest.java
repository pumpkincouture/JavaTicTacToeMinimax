package Java_TTT.games.setup;

import Java_TTT.ui.MockUserInterface;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class BoardSizeTest {
    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in);
    private MockUserInterface mockUI = new MockUserInterface(output, input);

    @Test
    public void validateBoardSizeUntilChoiceIs3() {
        ChoiceInterface boardConfig = new BoardSize(mockUI);

        mockUI.addNextMove("2");
        mockUI.addNextMove("p");
        mockUI.addNextMove("3");

        boardConfig.getConfigurationChoice();

        assertEquals(true, mockUI.isDisplayInvalidChoiceMessageCalled());
        assertEquals(true, mockUI.isBoardSizePromptCalled());
        assertEquals(3, boardConfig.getDesiredGameOptions());
    }

    @Test
    public void validateBoardSizeUntilChoiceIs4() {
        ChoiceInterface boardConfig = new BoardSize(mockUI);

        mockUI.addNextMove("2");
        mockUI.addNextMove("p");
        mockUI.addNextMove("4");

        boardConfig.getConfigurationChoice();

        assertEquals(true, mockUI.isDisplayInvalidChoiceMessageCalled());
        assertEquals(true, mockUI.isBoardSizePromptCalled());
        assertEquals(4, boardConfig.getDesiredGameOptions());
    }

    @Test
    public void getBoardChoice() {
        ChoiceInterface boardConfig = new BoardSize(mockUI);

        mockUI.addNextMove("2");
        mockUI.addNextMove("p");
        mockUI.addNextMove("4");

        boardConfig.getConfigurationChoice();

        assertEquals(4, boardConfig.getDesiredGameOptions());
    }
}
