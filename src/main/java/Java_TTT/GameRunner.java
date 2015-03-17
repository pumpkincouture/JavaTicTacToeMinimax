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
        List<Integer> userChoices= new ArrayList<>();

        Configurable boardConfig = new BoardSetUp((CommandLineInterface) ui);
        Configurable playerConfig = new ParticipantSetUp((CommandLineInterface) ui);
        boardConfig.getConfigurationChoice();
        playerConfig.getConfigurationChoice();
        int playerChoice = playerConfig.getDesiredGameOptions();
        Configurable orderConfig = new ParticipantOrderSetUp((CommandLineInterface) ui, playerChoice);
        orderConfig.getConfigurationChoice();

        userChoices.add(boardConfig.getDesiredGameOptions());
        userChoices.add(playerConfig.getDesiredGameOptions());
        userChoices.add(orderConfig.getDesiredGameOptions());

        SetUpTicTacToeGame setup = new SetUpTicTacToeGame(userChoices);
        setup.setUpGame();

    }
}
