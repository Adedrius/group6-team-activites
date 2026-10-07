/* 
 * A custom exception for when an invalid move is entered. 
 * This can help with handling erroneous behaviour.
 */

 public class InvalidMoveException extends ArrayIndexOutOfBoundsException {

    public InvalidMoveException(String errMessage) {
        super(errMessage);
    }
}