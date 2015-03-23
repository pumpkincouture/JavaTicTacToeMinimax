package Java_TTT.games.setup;

import Java_TTT.ui.MockUserInterface;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

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

        assertEquals(true, mockUI.areGameConfigOptionsCalled());
        assertEquals(true, mockUI.isDisplayInvalidChoiceMessageCalled());
    }

    @Test
    public void checkThatChoiceIs1() {
        Choice playerConfig = new ParticipantChoice(mockUI);

        mockUI.addNextMove("ppp");
        mockUI.addNextMove("1");

        playerConfig.getConfigurationChoice();

        assertEquals(1, playerConfig.getDesiredGameOptions());
    }

    @Test
    public void checkThatChoiceIs2() {
        Choice playerConfig = new ParticipantChoice(mockUI);

        mockUI.addNextMove("b");
        mockUI.addNextMove("9");
        mockUI.addNextMove("2");

        playerConfig.getConfigurationChoice();

        assertEquals(2, playerConfig.getDesiredGameOptions());
    }

    @Test
    public void checkThatChoiceIs3() {
        Choice playerConfig = new ParticipantChoice(mockUI);

        mockUI.addNextMove("---");
        mockUI.addNextMove("3");

        playerConfig.getConfigurationChoice();

        assertEquals(3, playerConfig.getDesiredGameOptions());
    }

    @Test
    public void geParticipantOption() {
        Choice playerConfig = new ParticipantChoice(mockUI);

        mockUI.addNextMove("4");

        playerConfig.getConfigurationChoice();

        assertEquals(4, playerConfig.getDesiredGameOptions());
    }
}
