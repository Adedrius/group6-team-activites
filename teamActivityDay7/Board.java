/* From the previous exercise. 
 * If you want to run the TestClass, 
 * you'll need to paste the code for your Board class here.
 */
import java.util.Arrays;
import java.util.Scanner;

public class Board {
    // adding instance variables
    private String[][] board; //2D array is used because the board contains two rows and coulums

    private Scanner scanner = new Scanner(System.in); //Scanner is used to receive use input

    public void boardSetUp() {
        System.out.println("------ Board Set up -------");

        // Set up the board by prompting the user for the amount of rows and columns desired.
        System.out.print("Number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Number of cols: ");
        int columns = scanner.nextInt();


        this.board = new String[rows][columns]; // initialize a row by column array;

        // initialize empty board with dashes (-)
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = "-";
            }
        }
    }

    /*
    This method prints out the board.
     */
    public void printBoard() {
        for (String[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    /*
    This method checks to see if a column is full.
     */
    public boolean columnFull(int col) {
        if (col < 0 || col >= board[0].length) {
            return true;
        }
        // check if the column is full by just checking the 0'th row's value
        if (!board[0][col].equals("-")) {
            return true;
        }
        return false;
    }

    /*
    This method checks to see if the board is full.
     */
    public boolean boardFull() {
        // This is a check to see if the board is full..
        for (int i = 0; i < this.board[0].length; i++) {
            if (!columnFull(i)) {
                return false;
            }
        }
        return true;
    }

    /*
    This method adds a token to a column based on the player's desire.
     */
    public boolean addToken(int colToAddToken, String playerNumber) {
        if (colToAddToken < 0 || colToAddToken >= board[0].length || columnFull(colToAddToken)) {
            return false;
        }

        int rowToAddToken = board.length - 1;

        // condition to allow searching for the right row level of the board to place the token
        while (rowToAddToken >= 0) {
            if (board[rowToAddToken][colToAddToken].equals("-")) {
                // You now know the right row and column to place the token. Place it and then return true.
                board[rowToAddToken][colToAddToken] = playerNumber;
                return true;
            } else {
                rowToAddToken -= 1;
            }
        }

        return false;
    }

    /*
    This method checks if the player who's turn it is is the winner.
     */
    public boolean checkIfPlayerIsTheWinner(String playerNumber) {
        if (checkHorizontal(playerNumber)) {
            return true;
        } else if (checkVertical(playerNumber)) {
            return true;
        } else if (checkLeftDiagonal(playerNumber)) {
            return true;
        } else if (checkRightDiagonal(playerNumber)) {
            return true;
        }
        // what other conditions should we include here?
        return false;
    }

    /*
    This method checks for a game winning conditional vertically.
     */
    public boolean checkVertical(String playerNumber) {
        for (int col = 0; col < board[0].length; col++) {
            // length - 3 here because we are comparing 4 in a row items
            for (int row = 0; row < board.length - 3; row++) {
              
                if (board[row][col].equals(playerNumber)) {
                    if (board[row][col].equals(board[row + 1][col])
                            && board[row][col].equals(board[row + 2][col])
                            && board[row][col].equals(board[row + 3][col])) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /*
    This method checks for a game winning conditional horizontally.
     */
    public boolean checkHorizontal(String playerNumber) {
        // try implementing this by being inspired by the checkVertical logic. Note avoid off by 1 errors. Also remember that you are now checking across columns within each row this time.
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length - 3; col++) {

                if (board[row][col].equals(playerNumber)) {
                    if (board[row][col].equals(board[row][col + 1])
                            && board[row][col].equals(board[row][col + 2])
                            && board[row][col].equals(board[row][col + 3])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*
    This method checks for a game winning conditional in a left diagonal.
     */
    public boolean checkLeftDiagonal(String playerNumber) {
        for (int row = 0; row < board.length - 3; row++) {
            for (int col = 0; col < board[0].length - 3; col++) {
                if (board[row][col].equals(playerNumber)) {
                    if (board[row][col].equals(board[row + 1][col + 1])
                            && board[row][col].equals(board[row + 2][col + 2])
                            && board[row][col].equals(board[row + 3][col + 3])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*
    This method checks for a game winning conditional ina right diagonal.
     */
    public boolean checkRightDiagonal(String playerNumber) {
        // implment method and return an appropriate return type.
        for (int row = 0; row < board.length - 3; row++) {
            for (int col = 3; col < board[0].length; col++) {
                if (board[row][col].equals(playerNumber)) {
                    if (board[row][col].equals(board[row + 1][col - 1])
                            && board[row][col].equals(board[row + 2][col - 2])
                            && board[row][col].equals(board[row + 3][col - 3])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

    // TODO: Uncomment this to test your board class in isolation. 
    // This is just a small set of tests for our board class for now. We will
    // delete this when we have the TestClass and Game class created.
    // We should have only one "main" method in the program at the end of the entire
    // challenge otherwise Java will freak out if there are multiple main classes in
    // the different classes it looks into.
    // A main method acts as the Java entry point into your program and Java expects
    // only one entry point.
    
    //Uncomment below to see if you've done the job:
    // public static void main(String[] args) {
    //     Board board1 = new Board();
    //     board1.boardSetUp();
    //     board1.printBoard();

    //     board1.addToken(0, "x");
    //     board1.addToken(0, "x");
    //     board1.addToken(0, "x");
    //     board1.addToken(1, "y");
    //     board1.addToken(1, "z");
    //     board1.addToken(1, "w");
    //     board1.addToken(0, "x");

    //     System.out.println("Board for testing checkVertical");
    //     System.out.println("Board 1 check vertical with x returns -> " + board1.checkVertical("x"));
    //     System.out.println("Board 1 check vertical with y returns -> " + board1.checkVertical("y"));

    //     board1.printBoard();

    //     Board board2 = new Board();
    //     // Test with at least a 4-by-4 size board.
    //     board2.boardSetUp();
    //     board2.printBoard();

    //     board2.addToken(0, "x");
    //     board2.addToken(0, "x");
    //     board2.addToken(0, "w");
    //     board2.addToken(0, "w");
    //     board2.addToken(1, "y");
    //     board2.addToken(1, "x");
    //     board2.addToken(1, "w");
    //     board2.addToken(2, "y");
    //     board2.addToken(2, "w");
    //     board2.addToken(2, "x");
    //     board2.addToken(3, "w");
    //     board2.addToken(3, "w");
    //     board2.addToken(3, "w");
    //     board2.addToken(3, "x");

    //     System
 