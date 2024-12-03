import java.util.Scanner;

// Interface for game initialization
interface GameInit {
    void enterName(String name);
    void selectGameMode();
}

// Interface for game mechanics
interface GameMechanics {
    void startGame();
}

// Interface for displaying game messages
interface GameDisplay {
    void showWelcomeMessage();
    void showGameModeSelection();
    void showStartMessage(String name);
}

// Main class implementing all three interfaces
public class Game implements GameInit, GameMechanics, GameDisplay {
    private String playerName;
    private String gameMode;

    // Implementing GameInit methods
    @Override
    public void enterName(String name) {
        this.playerName = name;
    }

    @Override
    public void selectGameMode() {
        Scanner scanner = new Scanner(System.in);
        int mode = 0;

        // Loop until a valid mode is selected
        while (mode != 1 && mode != 2) {
            showGameModeSelection();
            mode = scanner.nextInt();
            if (mode == 1) {
                this.gameMode = "Story";
            } else if (mode == 2) {
                this.gameMode = "Survival";
            } else {
                System.out.println("Invalid input. Please press 1 or 2 to select your game mode.");
            }
        }
    }

    // Implementing GameMechanics method
    @Override
    public void startGame() {
        System.out.println("Press P to start playing, " + playerName + ".");
    }

    // Implementing GameDisplay methods
    @Override
    public void showWelcomeMessage() {
        System.out.println("Enter your name:");
    }

    @Override
    public void showGameModeSelection() {
        System.out.println("Press 1 or 2 to select your game mode.");
        System.out.println("1 - Story");
        System.out.println("2 - Survival");
    }

    @Override
    public void showStartMessage(String name) {
        System.out.println("Press P to start playing, " + name + ".");
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        // Welcome message
        game.showWelcomeMessage();
        String name = scanner.nextLine();
        game.enterName(name);

        // Game mode selection
        game.selectGameMode();

        // Start message
        System.out.println("You selected " + game.gameMode + ".");
        game.startGame();

        scanner.close();
    }
}
