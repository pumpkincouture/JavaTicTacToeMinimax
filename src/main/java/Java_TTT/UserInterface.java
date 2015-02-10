package Java_TTT;


public interface UserInterface {

    public void printMessage(String string);

    public String captureChoice();

    public void chooseGameConfiguration();

    public void printChosenOpponent(String opponentName);

    public void printChoice(PlayerInterface player, String choice);

    public void printComputerThinking();

    public void printWelcomeMessage();

    public void chooseStartingPlayer(String player1, String player2);

    public void printGamePieceAssignment(PlayerInterface player1, PlayerInterface player2);

    public void printStartingPlayer(String gamePiece);

    public void promptForOpponent();

    public void printUserPrompt();

    public void printBoard(Board board);

    public void printError(String choice);

    public void printWinner(String gamePiece);

    public void printCatsGame();
}