package Java_TTT.games.setup;

import Java_TTT.ui.MockUserInterface;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParticipantOrderTest {
    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in);
    private MockUserInterface mockUI = new MockUserInterface(output, input);

    @Test
    public void validateStartingPlayerChoice() {
        Choice playerOrderConfig = new ParticipantOrder(mockUI);

        mockUI.addNextMove("ppp");
        mockUI.addNextMove("2");

        playerOrderConfig.getConfigurationChoice();

        assertTrue(mockUI.isDisplayInvalidChoiceMessageCalled());
    }
}
