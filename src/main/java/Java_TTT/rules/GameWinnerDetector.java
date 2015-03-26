package Java_TTT.rules;

public abstract class GameWinnerDetector {

    protected String findBoardWinner(int boardLength) {

        for (int index = 0; index < boardLength; index++) {
            addGamePiecesToList(index);
        }
        return checkIfWinnerExists();
    }

    protected abstract void addGamePiecesToList(int index);
    protected abstract String checkIfWinnerExists();
}