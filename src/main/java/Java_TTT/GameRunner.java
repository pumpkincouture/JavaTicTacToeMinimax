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
        List<ChoiceInterface> userChoices= new ArrayList<>();

        ChoiceInterface boardConfig = new BoardSize((CommandLineInterface) ui);
        ChoiceInterface playerConfig = new ParticipantChoice((CommandLineInterface) ui);
        ChoiceInterface orderConfig = new ParticipantOrder((CommandLineInterface) ui);

        userChoices.add(boardConfig);
        userChoices.add(playerConfig);
        userChoices.add(orderConfig);

        MenuFactory inputCollector = new MenuFactory();
        inputCollector.collectUserInput(userChoices);

        SetUpTicTacToeGame setup = new SetUpTicTacToeGame(inputCollector.getUserValues());
        setup.setUpGame();
    }
}
