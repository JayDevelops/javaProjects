/*
*
* DuplicateItemException.java written by Jesus Perez Arias
* If a duplicate item is found in the BinarySearchTree.java then it will stop the program
* in order for the user to delete the entered duplicate item in the Main.java or a Main class.
*
* */

package hw07;

public class DuplicateItemException extends RuntimeException {
    public DuplicateItemException(String errorMessage) {
        super(errorMessage);
    }
}
