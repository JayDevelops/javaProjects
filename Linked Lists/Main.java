/*
*
* Written by Jesus Perez Arias, CS 2013-01
*
*
* Makes a newTester instance and calls which type we want to test with
* */
package hw05;

public class Main {
    public static void main(String[] args) {
        //  Create a new tester instance here
        Array2DTester newTester = new Array2DTester();


        System.out.println("The data structure is zero-indexed, meaning all values are like a regular 2D array. Column Index 0 is column 1, etc.\n\n");

        //  Test with an Integer Array2D below
        newTester.testIntegerArray2D();

        //  Test with a blank Array2D below
        newTester.testWithBlankArray2D();

        //  Test with a double Array2D below
        newTester.testWithDoubleArray2D();

        //  Test with a character Array2D below
        newTester.testWithCharArray2D();

        //  Test with string Array2D below
        System.out.println("\n");
        System.out.println("Tested with professor keenan on zoom, below");
        newTester.testWithStringArray2D();

        newTester.testArr();
    }


}
