import java.util.Scanner;

public class Game {

    // Setting up the instance variables for the class
    private Player[] players; 
    private Board board;

    // Setting up the scanner for player input.
    private static Scanner scanner = new Scanner(System.in);

    public Game() {
        // Let's default it two players for now. Later, you can improve upon this to allow the game creator to choose how many players are involved.
        this.players = new Player[2];// complete line.
        this.board = new Board();// complete line
    }

    public void setUpGame() {
        System.out.println("Enter player 1's name: ");
        players[0] = new Player(scanner.nextLine(), "1"); // Creating Player 1.

        String playerTwoName;

        // adding logic to prevent a user from giving a second name that's equal to the first. Allow the user to try as long as the names are not different.
        // wrap the code in here with a conditional block that enables the check described above. 
        
        do {
          System.out.println("Enter player 2's name: ");
          playerTwoName = scanner.nextLine();

          if (playerTwoName.equals(players[0].getName())) {
            System.out.println("Error! Both Players cannot have the same name.");
          }
          
        } while (playerTwoName.equals(players[0].getName()));
        
        
        players[1] = new Player(playerTwoName, "2"); // Creating Player 2.

        board.boardSetUp();// setting up the board using the appropriate method
        board.printBoard();// printing the board the using appropriate method
    }

    public void printWinner(Player player) {
        System.out.println(player.getName() + " is the winner"); // Print the winner message once winner is decided.
    }

    public void playerTurn(Player currentPlayer) {
        int col = currentPlayer.makeMove();

        while (!board.addToken(col, currentPlayer.getPlayerNumber())) {
           col = currentPlayer.makeMove();// calling board method to add token.
        }
        board.printBoard();// print board after the move.
    }

    public void play() {
        boolean noWinner = true;

        this.setUpGame();
        int currentPlayerIndex = 0;

        while (noWinner) {
            if (board.boardFull()){ // If the board is full, end the game.
                System.out.println("Board is now full. Game Ends.");
                return;
            }

            Player currentPlayer = players[currentPlayerIndex];

            // Overriding the default tostring for Player class
            System.out.println("It is player " + currentPlayer.getPlayerNumber() + "'s turn. " + currentPlayer);

            playerTurn(currentPlayer);

            if (board.checkIfPlayerIsTheWinner(currentPlayer.getPlayerNumber())) { // Check if the current player is the winner before giving the next player their turn.
                printWinner(currentPlayer);
                noWinner = false;
            } else {
                currentPlayerIndex = (currentPlayerIndex + 1) % players.length;// reassign the variable to allow the game to continue. Note the index would wrap back to the first player if we are at the end. Think of using modulus (%).
            }
        }
    }

}
