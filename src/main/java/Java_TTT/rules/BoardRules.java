package Java_TTT.rules;

public interface BoardRules {

    public boolean isGameOver(String playerOne, String playerTwo);

    public boolean isThereAWinner(String gamePiece);

    public String getWinningPlayer(String playerOne, String playerTwo);
}
