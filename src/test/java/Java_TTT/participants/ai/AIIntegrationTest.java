package Java_TTT.participants.ai;

import Java_TTT.ui.MockUserInterface;
import Java_TTT.boards.Board;
import Java_TTT.games.Game;
import Java_TTT.participants.GameParticipants;
import Java_TTT.rules.BoardRulesInterface;
import Java_TTT.rules.BoardRules;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class AIIntegrationTest {
    private Board board;
    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in);
    private MockUserInterface mockUi = new MockUserInterface(output, input);
    private GameParticipants player1;
    private GameParticipants player2;
    private BoardRulesInterface boardRules;
    private Game game;

    @Test
    public void gameWithTwoAIsFor4x4Board() {
        board = new Board(4);
        boardRules = new BoardRules(board);
        player1 = new HardAI("X", boardRules, board);
        player2 = new HardAI("O", boardRules, board);
        game = new Game(player1, player2, board, mockUi, boardRules);
        int gameCounter = 0;

        for (int i = 0; i < 1000; i++) {
            gameCounter +=1;
            game.start();
        }

        assertEquals(1000, gameCounter);
        assertEquals("", boardRules.getBoardWinner());
        assertEquals(true, boardRules.isGameOver());
    }

    @Test
    public void gameWithTwoAIsFor3x3Board() {
        board = new Board(3);
        boardRules = new BoardRules(board);
        player1 = new HardAI("X", boardRules, board);
        player2 = new HardAI("O", boardRules, board);
        game = new Game(player1, player2, board, mockUi, boardRules);
        int gameCounter = 0;

        for (int i = 0; i < 1000; i++) {
            gameCounter +=1;
            game.start();
        }

        assertEquals(1000, gameCounter);
        assertEquals("", boardRules.getBoardWinner());
        assertEquals(true, boardRules.isGameOver());
    }
}
