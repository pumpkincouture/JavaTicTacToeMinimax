package Java_TTT;

import Java_TTT.games.setup.*;
import Java_TTT.ui.CommandLineInterface;
import Java_TTT.ui.UserInterface;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) {
        PrintStream output = new PrintStream(System.out);
        Scanner input = new Scanner(System.in);
        UserInterface ui = new CommandLineInterface(output, input);
        List<Configurable> userChoices= new ArrayList<>();

        Configurable boardConfig = new TTTBoardSetUp((CommandLineInterface) ui);
        Configurable playerConfig = new ParticipantSetUp((CommandLineInterface) ui);
        Configurable orderConfig = new ParticipantOrderSetUp((CommandLineInterface) ui);

        userChoices.add(boardConfig);
        userChoices.add(playerConfig);
        userChoices.add(orderConfig);

        InputCollector inputCollector = new InputCollector();
        inputCollector.collectUserInput(userChoices);

        SetUpTicTacToeGame setup = new SetUpTicTacToeGame(inputCollector.getUserValues());
        setup.setUpGame();
    }
}
