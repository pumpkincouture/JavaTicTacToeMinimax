package Java_TTT.boards;

import java.util.ArrayList;

public interface BoardInterface {

    public String[] getCells();

    public ArrayList<Integer> getOpenSpaces();

    public ArrayList<Integer> getOccupiedSpaces();

    public String getOpponentPiece(String gamePiece);

    public boolean isMoveValid(String answer);

    public boolean hasOpenSpaces();

    public boolean isEmpty();

    public String[] placeMove(String answer, String gamePiece);

    public void clearBoard(int index);

    public int getLength();

    public int getCellsSquareRoot(int boardLength);
}
