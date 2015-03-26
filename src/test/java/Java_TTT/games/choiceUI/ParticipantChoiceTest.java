package Java_TTT.games.choiceUi;

import Java_TTT.messages.MockUserInterface;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParticipantChoiceTest {
    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in);
    private MockUserInterface mockUI = new MockUserInterface(output, input);

    @Test
    public void capturesUserChoiceForPlayerConfiguration() {
        Choice playerConfig = new ParticipantChoice(mockUI);
        mockUI.addNextMove("a");
        mockUI.addNextMove("1");

        playerConfig.getConfigurationChoice();

        assertTrue(mockUI.areGameConfigOptionsCalled());
        assertTrue(mockUI.isDisplayInvalidChoiceMessageCalled());
    }

    @Test
    public void checkThatChoiceIs1() {
        Choice playerConfig = new ParticipantChoice(mockUI);

        mockUI.addNextMove("ppp");
        mockUI.addNextMove("1");

        assertEquals(1, playerConfig.getConfigurationChoice());
    }

    @Test
    public void checkThatChoiceIs2() {
        Choice playerConfig = new ParticipantChoice(mockUI);

        mockUI.addNextMove("b");
        mockUI.addNextMove("9");
        mockUI.addNextMove("2");

        assertEquals(2, playerConfig.getConfigurationChoice());
    }

    @Test
    public void checkThatChoiceIs3() {
        Choice playerConfig = new ParticipantChoice(mockUI);

        mockUI.addNextMove("---");
        mockUI.addNextMove("3");

        assertEquals(3, playerConfig.getConfigurationChoice());
    }

    @Test
    public void geParticipantOption() {
        Choice playerConfig = new ParticipantChoice(mockUI);

        mockUI.addNextMove("4");

        assertEquals(4, playerConfig.getConfigurationChoice());
    }
}
