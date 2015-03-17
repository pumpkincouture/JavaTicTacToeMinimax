package Java_TTT.games.setup;

import Java_TTT.ui.CommandLineInterface;

public class BoardSetUp implements Configurable {
    private CommandLineInterface ui;
    private int boardChoice;

    public BoardSetUp(CommandLineInterface ui) {
        this.ui = ui;
    }

    @Override
    public void getConfigurationChoice() {
        ui.promptForBoardSize();
        validateBoardSizeChoice(ui.captureChoice());
    }

    @Override
    public int getDesiredGameOptions() {
        return boardChoice;
    }

    public void validateBoardSizeChoice(String boardSizeChoice) {
        switch(boardSizeChoice) {
            case "3":
                boardChoice = convertAnswerToInteger(boardSizeChoice);
                break;
            case "4":
                boardChoice = convertAnswerToInteger(boardSizeChoice);
                break;
            default:
                ui.printError(boardSizeChoice);
                ui.promptForBoardSize();
                validateBoardSizeChoice(ui.captureChoice());
        }
    }

    private int convertAnswerToInteger(String answer) {
        return Integer.parseInt(answer);
    }
}
