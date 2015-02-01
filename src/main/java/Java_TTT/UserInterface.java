package Java_TTT;


public interface UserInterface {

    public void printMessage(String string);

    public String captureChoice();

    public void printChosenOpponent(String opponentName);

    public void printWelcomeMessage();

    public void printGamePieceAssignment(String onePiece, String playerOnePiece, String playerTwoPiece);

    public void printStartingPlayer(String gamePiece);

    public void promptForOpponent();

    public void printUserPrompt(String playerName);

    public void printBoard(String[] boardCells);

    public void printError(String choice);

    public void printWinner(String gamePiece);

    public void printCatsGame();
}