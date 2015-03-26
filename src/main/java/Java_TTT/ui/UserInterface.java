package Java_TTT.ui;

import Java_TTT.boards.Board;
import Java_TTT.participants.Participant;

public interface UserInterface {

    public void printMessage(String string);

    public String captureChoice();

    public void chooseGameConfiguration();

    public void promptForBoardSize();

    public void printChoice(Participant player, String choice);

    public void printWelcomeMessage(int boardSize);

    public void chooseStartingPlayer(int playerConfigChoice);

    public void printGamePieceAssignment(Participant player1, Participant player2);

    public void printBoard(Board board);

    public void printError(String choice);

    public void printWinner(String gamePiece);

    public void printCatsGame();
}