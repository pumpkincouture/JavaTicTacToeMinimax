package Java_TTT;

import java.util.ArrayList;

public class GameScorer {
    private Board board;

    public GameScorer(Board board) {
        this.board = board;
    }

    public boolean isGameOver(String playerOne, String playerTwo) {
        return !getWinningPlayer(playerOne, playerTwo).isEmpty() || board.getOpenSpaces().isEmpty();
    }

    public boolean isThereAWinner (String gamePiece) {
        for (ArrayList<String> boardPart: getMatrix()) {
            if (checkBoardForWin(gamePiece, boardPart) == board.getCellsSquareRoot(board.getLength())) {
                return true;
            }
        }
        return false;
    }

    public String getWinningPlayer(String playerOne, String playerTwo) {
        String noWinner = "";
        for (ArrayList<String> boardPart: getMatrix()) {
            if (checkBoardForWin(playerOne, boardPart) == board.getCellsSquareRoot(board.getLength())) {
                return playerOne;
            } else if (checkBoardForWin(playerTwo, boardPart) == board.getCellsSquareRoot(board.getLength())) {
                return playerTwo;
            }
        }
        return noWinner;
    }

    public ArrayList<ArrayList<String>> getMatrix() {
        ArrayList<ArrayList<String>> boardMatrix = new ArrayList();

        if (board.getCells().length > 9) {
            boardMatrix.add(getColumn1());
            boardMatrix.add(getColumn2());
            boardMatrix.add(getColumn3());
            boardMatrix.add(getColumn4());
            boardMatrix.add(getRow1());
            boardMatrix.add(getRow2());
            boardMatrix.add(getRow3());
            boardMatrix.add(getRow4());
            boardMatrix.add(getDiagonal1());
            boardMatrix.add(getDiagonal2());
        } else {
            boardMatrix.add(getColumn1());
            boardMatrix.add(getColumn2());
            boardMatrix.add(getColumn3());
            boardMatrix.add(getRow1());
            boardMatrix.add(getRow2());
            boardMatrix.add(getRow3());
            boardMatrix.add(getDiagonal1());
            boardMatrix.add(getDiagonal2());
        }
        return boardMatrix;
    }


    private ArrayList<String> getDiagonal1() {
        int squareRoot = board.getCellsSquareRoot(board.getLength());
        ArrayList<String> diagonal = new ArrayList();
        int squareDoubled= squareRoot * 2;
        int squareTripled = squareRoot * 3;

          for (int i=0; i <  board.getLength(); i++) {
              if (board.getCells().length > 9) {
                  if (i == 0) {
                      diagonal.add(board.getCells()[i]);
                  }
                  if (i == squareRoot + 1) {
                      diagonal.add(board.getCells()[i]);
                  }
                  if (i == squareDoubled + 2) {
                      diagonal.add(board.getCells()[i]);
                  }
                  if (i == squareTripled + 3) {
                      diagonal.add(board.getCells()[i]);
                  }
              } else {
                  if (i == 0) {
                      diagonal.add(board.getCells()[i]);
                  }
                  if (i == squareRoot + 1) {
                      diagonal.add(board.getCells()[i]);
                  }
                  if (i == squareDoubled + 2) {
                      diagonal.add(board.getCells()[i]);
                  }
              }
          }
        return diagonal;
    }

    private ArrayList<String> getDiagonal2() {
        int squareRoot = board.getCellsSquareRoot(board.getLength());
        ArrayList<String> diagonal = new ArrayList();
        int squareDoubled= squareRoot * 2;
        int squareTripled = squareRoot * 3;

        for (int i=0; i <  board.getLength(); i++) {
            if (board.getCells().length > 9) {
                if (i == squareRoot - 1) {
                    diagonal.add(board.getCells()[i]);
                }
                if (i == squareRoot + 2) {
                    diagonal.add(board.getCells()[i]);
                }
                if (i == squareDoubled + 1) {
                    diagonal.add(board.getCells()[i]);
                }
                if (i == squareTripled) {
                    diagonal.add(board.getCells()[i]);
                }
            } else {
                if (i == squareRoot - 1) {
                    diagonal.add(board.getCells()[i]);
                }
                if (i == squareRoot + 1) {
                    diagonal.add(board.getCells()[i]);
                }
                if (i == squareDoubled) {
                    diagonal.add(board.getCells()[i]);
                }
            }
        }
        return diagonal;
    }

    private ArrayList<String> getRow1() {
        int squareRoot = board.getCellsSquareRoot(board.getLength());
        ArrayList<String> row = new ArrayList();

        for (int i=0; i < squareRoot; i++) {
            row.add(board.getCells()[i]);
        }
        return row;
    }

    private ArrayList<String> getRow2() {
        int squareRoot = board.getCellsSquareRoot(board.getLength());
        ArrayList<String> row = new ArrayList();
        int squareDoubled= squareRoot * 2;

        for (int i= squareRoot; i < squareDoubled; i++) {
            row.add(board.getCells()[i]);
        }
        return row;
    }

    private ArrayList<String> getRow3() {
        int squareRoot = board.getCellsSquareRoot(board.getLength());
        ArrayList<String> row = new ArrayList();
        int squareDoubled= squareRoot * 2;
        int squareTripled = squareRoot * 3;

        if (board.getCells().length > 9) {
            for (int i= squareDoubled; i < squareTripled; i++) {
                row.add(board.getCells()[i]);
            }
        } else {
                for (int i= squareDoubled; i < board.getLength(); i++) {
                    row.add(board.getCells()[i]);
                }
            }
        return row;
    }

    private ArrayList<String> getRow4() {
        int squareRoot = board.getCellsSquareRoot(board.getLength());
        ArrayList<String> row = new ArrayList();
        int squareTripled = squareRoot * 3;

        for (int i= squareTripled; i < board.getLength(); i++) {
            row.add(board.getCells()[i]);
        }
        return row;
    }

    private ArrayList<String> getColumn1() {
        int squareRoot = board.getCellsSquareRoot(board.getLength());
        ArrayList<String> column = new ArrayList();
        int squareDoubled= squareRoot * 2;

        if (board.getCells().length > 9) {
            column.add(board.getCells()[0]);
            column.add(board.getCells()[squareRoot]);
            column.add(board.getCells()[board.getLength() - squareDoubled]);
            column.add(board.getCells()[board.getLength() - squareRoot]);
        } else {
            column.add(board.getCells()[0]);
            column.add(board.getCells()[squareRoot]);
            column.add(board.getCells()[board.getLength() - squareRoot]);
        }
        return column;
    }

    private ArrayList<String> getColumn2() {
        int squareRoot = board.getCellsSquareRoot(board.getLength());
        ArrayList<String> column = new ArrayList();
        int squareDoubled= squareRoot * 2;

        if (board.getCells().length > 9) {
            column.add(board.getCells()[1]);
            column.add(board.getCells()[squareRoot + 1]);
            column.add(board.getCells()[board.getLength() - (squareDoubled + 1)]);
            column.add(board.getCells()[board.getLength() - (squareRoot - 1)]);
        } else {
            column.add(board.getCells()[1]);
            column.add(board.getCells()[squareRoot + 1]);
            column.add(board.getCells()[board.getLength() - (squareRoot - 1)]);
        }

        return column;
    }

    private ArrayList<String> getColumn3() {
        int squareRoot = board.getCellsSquareRoot(board.getLength());
        ArrayList<String> column = new ArrayList();
        int squareDoubled= squareRoot * 2;

        if (board.getCells().length > 9) {
            column.add(board.getCells()[2]);
            column.add(board.getCells()[squareRoot + 2]);
            column.add(board.getCells()[board.getLength() - (squareDoubled - 2)]);
            column.add(board.getCells()[board.getLength() - (squareRoot - 2)]);
        } else{
            column.add(board.getCells()[2]);
            column.add(board.getCells()[squareRoot + 2]);
            column.add(board.getCells()[board.getLength() - (squareRoot - 2)]);
        }

        return column;
    }

    private ArrayList<String> getColumn4() {
        int squareRoot = board.getCellsSquareRoot(board.getLength());
        ArrayList<String> column = new ArrayList();
        int squareDoubled= squareRoot * 2;

        column.add(board.getCells()[3]);
        column.add(board.getCells()[squareRoot + 3]);
        column.add(board.getCells()[board.getLength() - (squareDoubled - 3)]);
        column.add(board.getCells()[board.getLength() - (squareRoot - 3)]);

        return column;
    }

    private int checkBoardForWin(String gamePiece, ArrayList<String> boardPart) {
        int inARow = 0;

        for (int i=0; i < boardPart.size(); i++ ) {
            if (boardPart.get(i) == gamePiece) {
                inARow += 1;
            }
        }
        return inARow;
    }
}

