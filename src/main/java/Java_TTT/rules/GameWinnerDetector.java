package Java_TTT.rules;

abstract class GameWinnerDetector {

    abstract String checkColumns();
    abstract String checkRows();
    abstract String checkRightDiagonal();
    abstract String checkLeftDiagonal();
}

