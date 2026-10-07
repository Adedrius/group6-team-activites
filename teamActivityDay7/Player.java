/* From the previous exercise. 
 * If you want to run the TestClass, 
 * you'll need to paste the code for your Player class here.
 */
import java.util.Scanner;

public class Player {
    private String name;
    private String playerNumber;

  // create getter methods
    public Player(String name, String playerNumber) {
        this.name = name;
        this.playerNumber = playerNumber;
    }

    /*
    Accessor method to retrieve the player's name.
     */
    public String getName() {
        return this.name;
    }

    /*
    Accessor method to retrieve the player's number..
     */
    public String getPlayerNumber() {
        return this.playerNumber;
    }

    /*
    Accessor method to retrieve the player's number. (WE ADDED TWO BECAUSE CODIO WAS GIVEN ERRORS EXPECTING BOTH METHOD NAMES.)
     */
    public String getNumber() {
        return this.playerNumber;
    }

    /**
     * Prompts the player for which column they want to place their token in
     * and returns the column number.
     */
    // Question: should scanner be static or not? it should not. We got errors when we made it static
    // private static Scanner scanner = new Scanner(System.in); // complete line
    public int makeMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(this.name + ", enter column number to drop token: ");
        return scanner.nextInt();
    }

    /*
    This method identifies the player based on the given name.
     */
    @Override
    public String toString() {
        return "Player " + this.playerNumber + " is " + this.name;
    }
}

 