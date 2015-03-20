package Java_TTT.boards;

import java.util.List;

public interface BoardInterface {

    public String[] getCells();

    public List<Integer> getOpenSpaces();

    public boolean isMoveValid(String answer);

    public boolean isFull();

    public void placeMove(String answer, String gamePiece);

    public void resetCell(int index);

    public int getLength();

    public int getCellsSquareRoot();
}
