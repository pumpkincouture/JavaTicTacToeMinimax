package Java_TTT;

import Java_TTT.boards.Board;
import Java_TTT.games.setup.BoardSetUp;
import Java_TTT.games.setup.Configurable;
import Java_TTT.games.setup.ParticipantSetUp;
import Java_TTT.games.setup.SetUpTicTacToeGame;
import Java_TTT.participants.GameParticipants;
import Java_TTT.rules.TTTBoardRules;
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
        List<Configurable> gameOptions= new ArrayList<>();
        TTTBoardRules boardRules;
        Board board;
        GameParticipants player1;
        GameParticipants player2;

        Configurable boardConfig = new BoardSetUp((CommandLineInterface) ui);
        gameOptions.add(boardConfig);


        SetUpTicTacToeGame setup = new SetUpTicTacToeGame();
        setup.setUpGame(gameOptions);

//        boardConfig.getConfigurationChoice();
//        boardRules = (TTTBoardRules) boardConfig.getDesiredGameOptions().get(0);
//        board = (Board) boardConfig.getDesiredGameOptions().get(1);
//        Configurable participantConfig = new ParticipantSetUp((CommandLineInterface) ui, boardRules, board);
//        participantConfig.getConfigurationChoice();
//        player1 = (GameParticipants) participantConfig.getDesiredGameOptions().get(0);
//        player2 = (GameParticipants) participantConfig.getDesiredGameOptions().get(1);


    }
}
