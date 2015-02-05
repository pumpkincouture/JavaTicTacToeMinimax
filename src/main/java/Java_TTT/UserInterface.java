package Java_TTT;


public interface UserInterface {

    public void printMessage(String string);

    public String captureChoice();

    public void chooseGameConfiguration();

    public void printChosenOpponent(String opponentName);

    public void printChoice(Player player, String choice);

    public void printComputerThinking();

    public void printWelcomeMessage();

    public void chooseStartingPlayer(String player1, String player2);

    public void printGamePieceAssignment(String firstPlayer, String playerOnePiece, String secondPlayer, String playerTwoPiece);

    public void printStartingPlayer(String gamePiece);

    public void promptForOpponent();

    public void printUserPrompt();

    public void printBoard(String[] boardCells);

    public void printError(String choice);

    public void printWinner(String gamePiece);

    public void printCatsGame();
}