package Java_TTT.games.setup;

import Java_TTT.ui.MockUserInterface;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ParticipantSetUpTest {
    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in);
    private MockUserInterface mockUI = new MockUserInterface(output, input);

    @Test
    public void capturesUserChoiceForPlayerConfiguration() {
        Configurable playerConfig = new ParticipantSetUp(mockUI);
        mockUI.addNextMove("a");
        mockUI.addNextMove("1");

        playerConfig.getConfigurationChoice();

        assertEquals(true, mockUI.areGameConfigOptionsCalled());
        assertEquals(true, mockUI.isDisplayInvalidChoiceMessageCalled());
    }

    @Test
    public void checkThatChoiceIs1() {
        Configurable playerConfig = new ParticipantSetUp(mockUI);

        mockUI.addNextMove("ppp");
        mockUI.addNextMove("1");

        playerConfig.getConfigurationChoice();

        assertEquals(1, playerConfig.getDesiredGameOptions());
    }

    @Test
    public void checkThatChoiceIs2() {
        Configurable playerConfig = new ParticipantSetUp(mockUI);

        mockUI.addNextMove("b");
        mockUI.addNextMove("9");
        mockUI.addNextMove("2");

        playerConfig.getConfigurationChoice();

        assertEquals(2, playerConfig.getDesiredGameOptions());
    }

    @Test
    public void checkThatChoiceIs3() {
        Configurable playerConfig = new ParticipantSetUp(mockUI);

        mockUI.addNextMove("---");
        mockUI.addNextMove("3");

        playerConfig.getConfigurationChoice();

        assertEquals(3, playerConfig.getDesiredGameOptions());
    }

    @Test
    public void geParticipantOption() {
        Configurable playerConfig = new ParticipantSetUp(mockUI);

        mockUI.addNextMove("4");

        playerConfig.getConfigurationChoice();

        assertEquals(4, playerConfig.getDesiredGameOptions());
    }
}
