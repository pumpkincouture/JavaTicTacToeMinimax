package Java_TTT.games.setup;

import Java_TTT.ui.MockUserInterface;
import org.junit.Test;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class InputCollectorTest {
    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in);
    private MockUserInterface mockUI = new MockUserInterface(output, input);

    @Test
    public void checkIfAppropriateValuesAreCollected() {
        List<Configurable> userChoices= new ArrayList<>();
        List<Integer> inputValues = new ArrayList<>();

        Configurable boardConfig = new TTTBoardSetUp(mockUI);
        Configurable playerConfig = new ParticipantSetUp(mockUI);
        Configurable orderConfig = new ParticipantOrderSetUp(mockUI);

        userChoices.add(boardConfig);
        userChoices.add(playerConfig);
        userChoices.add(orderConfig);

        mockUI.addNextMove("3");
        mockUI.addNextMove("2");
        mockUI.addNextMove("pppp");
        mockUI.addNextMove("1");

        inputValues.add(3);
        inputValues.add(2);
        inputValues.add(1);

        InputCollector inputCollector= new InputCollector();
        inputCollector.collectUserInput(userChoices);

        assertEquals(inputValues, inputCollector.getUserValues());
    }
}
