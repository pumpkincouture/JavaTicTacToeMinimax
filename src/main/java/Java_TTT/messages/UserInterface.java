package Java_TTT.messages;

import Java_TTT.boards.Board;
import Java_TTT.players.PlayerInterface;

public interface UserInterface {

    public void printMessage(String string);

    public String captureChoice();

    public void chooseGameConfiguration();

    public void promptForBoardSize();

    public void printChoice(PlayerInterface player, String choice);

    public void printWelcomeMessage(int boardSize);

    public void chooseStartingPlayer(int playerConfigChoice);

    public void printGamePieceAssignment(PlayerInterface player1, PlayerInterface player2);

    public void printBoard(Board board);

    public void printError(String choice);

    public void printWinner(String gamePiece);

    public void printCatsGame();
}