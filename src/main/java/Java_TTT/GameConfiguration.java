package Java_TTT;

public class GameConfiguration {
    private CommandLineInterface ui;
    private Board board;
    private Player player1;
    private Player player2;

    public GameConfiguration(CommandLineInterface ui, Board board) {
        this.ui = ui;
        this.board = board;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void chooseConfigurationsPrompt() {
        ui.chooseGameConfiguration();
    }

    public void getGameConfigurationChoice() {
        validateGameConfiguration(captureGameConfigurationChoice());
    }

    public String captureGameConfigurationChoice() {
        return ui.captureChoice();
    }

    public void validateGameConfiguration(String gameConfigurationChoice) {
        switch(gameConfigurationChoice) {
            case "1":
                player1 = new HumanPlayer("X", ui);
                player2 = new HumanPlayer("O", ui);
                break;
            case "2":
                player1 = new HumanPlayer("X", ui);
                player2 = new ComputerPlayer("O", board, ui);
                break;
            case "3":
                player1 = new HumanPlayer("X", ui);
                player2 = new AIComputerPlayer("O", board, ui);
                break;
            case "4":
                player1 = new ComputerPlayer("X", board, ui);
                player2 = new AIComputerPlayer("O", board, ui);
                break;
            default:
                ui.printError(gameConfigurationChoice);
                chooseConfigurationsPrompt();
                validateGameConfiguration(captureGameConfigurationChoice());
        }
    }
}
