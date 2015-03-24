package Java_TTT.rules;

public interface GameRulesInterface {

    public boolean isGameOver();

    public String getOpponentPiece(String gamePiece);

    public String getBoardWinner();
}
