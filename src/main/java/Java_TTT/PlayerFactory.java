package Java_TTT;

public class PlayerFactory {
    private CommandLineInterface ui;
    private Player player;
    private Board board;

    public PlayerFactory(CommandLineInterface ui, Board board) {
        this.ui = ui;
        this.board = board;
    }

    public Object getChosenOpponent() {
        checkChoice(chooseOpponent());
        return getAssignedOpponent();
    }

    public Object getAssignedOpponent() {
        return player;
    }

    private String chooseOpponent() {
        ui.promptForOpponent();
        return ui.captureChoice();
    }

    private void checkChoice(String opponentChoice) {
        String capitalizedChoice = opponentChoice.toUpperCase();

        switch (capitalizedChoice) {
            case "I":
                player = new AIComputerPlayer("O", board, ui);
                ui.printChosenOpponent(player.getClass().getSimpleName());
                break;
            case "C":
                player = new ComputerPlayer("O", board, ui);
                ui.printChosenOpponent(player.getClass().getSimpleName());
                break;
            case "H":
                player = new HumanPlayer("O", ui);
                ui.printChosenOpponent(player.getClass().getSimpleName());
                break;
            default:
                ui.printError(opponentChoice);
                checkChoice(chooseOpponent());
        }
    }
}