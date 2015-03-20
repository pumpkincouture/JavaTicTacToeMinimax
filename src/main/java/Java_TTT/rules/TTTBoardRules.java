package Java_TTT.rules;

public interface TTTBoardRules {

    public boolean isGameOver(String playerOne, String playerTwo);

    public boolean isThereAWinner(String gamePiece);

    public String checkForRowWinner(String playerOne, String playerTwo);

    public String getWinningPlayer(String playerOne, String playerTwo);

    public String getOpponentPiece(String gamePiece);
}
