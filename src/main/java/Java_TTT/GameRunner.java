package Java_TTT;

import Java_TTT.games.Game;
import Java_TTT.games.choiceUi.MenuFactory;
import Java_TTT.games.choiceUi.GameFactory;
import Java_TTT.messages.CommandLineInterface;
import Java_TTT.messages.UserInterface;

import java.io.PrintStream;
import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) {
        PrintStream output = new PrintStream(System.out);
        Scanner input = new Scanner(System.in);
        UserInterface ui = new CommandLineInterface(output, input);

        MenuFactory menuFactory = new MenuFactory(ui);

        GameFactory gameFactory = new GameFactory(menuFactory.collectUserInput());
        gameFactory.setUpGame();
        Game game = new Game(gameFactory.getPlayerOne(), gameFactory.getPlayerTwo(), gameFactory.getBoard(), ui, gameFactory.getGameRules());
        game.start();
    }
}
