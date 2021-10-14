/*
*
*
* Written by Jesus Perez, CS 2013-01
*
*
* This method tests my Array2D data structure with Integers, Doubles, Characters and Strings and also tests a blank 2DArray linked lists (nulls).
*
* Each method will have the appropriate "testWith" followed by the data type and the after each test,
* it will initialize the Array2D again by calling the appropriate return type to initialize the Array2D once again.
*
* */
package hw05;

import java.util.ArrayList;

public final class Array2DTester {
    //  Default constructor, doesn't do anything here
    public Array2DTester() { }

    /*  TODO: Test Methods Will Be Written Below   */

    //  Test with an integer array below
    public void testIntegerArray2D() {
        System.out.println("----------TESTING WITH INTEGER ARRAY2D BELOW----------");

        //  Before testing, print out the original array
        Array2D<Integer> arr = initIntArray();
        System.out.println("Here is the original array below");
        printArray2D(arr);
        System.out.println(""); //  Spacer

        //  First test with addFirstRow
        arr.addFirstRow();
        printTest("addFirstRow", arr);
        arr = initIntArray();  //  Get the original Integer array

        //  Now test with the addFirstCol
        arr.addFirstCol();
        printTest("addFirstCol", arr);
        arr = initIntArray();

        //  Now test with the addLastRow method
        arr.addLastRow();
        printTest("addLastRow", arr);
        arr = initIntArray();

        //  Now test with the addLastCol method
        arr.addLastCol();
        printTest("addLastCol", arr);
        arr = initIntArray();

        //  Now test with insertRow method
        arr.insertRow(2);
        printTest("insertRow with index 2", arr);
        arr = initIntArray();

        //  Now test with insertCol method
        arr.insertCol(2);
        printTest("insertCol with index 2", arr);
        arr = initIntArray();

        //  Now test with deleteFirstRow method
        arr.deleteFirstRow();
        printTest("deleteFirstRow method", arr);
        arr = initIntArray();

        //  Now test with deleteFirstCol method
        arr.deleteFirstCol();
        printTest("deleteFirstCol method", arr);
        arr = initIntArray();

        //  Now test with deleteLastRow method
        arr.deleteLastRow();
        printTest("deleteLastRow method", arr);
        arr = initIntArray();

        //  Now test with deleteLastCol method
        arr.deleteLastCol();
        printTest("deleteLastCol method", arr);
        arr = initIntArray();

        //  Now test with deleteRow(index) method
        arr.deleteRow(3);
        printTest("deleteRow(int index) with index of 3", arr);
        arr = initIntArray();

        //  Now test with deleteCol(index) method
        arr.deleteCol(3);
        printTest("deleteCol(int index) with index of 3", arr);
        arr = initIntArray();

        //  Now test get(row, col) method
        Integer num = arr.get(2, 3);
        System.out.println("Get value at row" + (2 - 1) + " and column" + (3 - 1) + ": " + num + "\n");


        //  Now test getCol(index) method below
        ArrayList<Integer> colList = returnArrayList(arr, 1, "getCol");
        printArrayList("colList(index) with index of 1", colList);

        //  Now test getRow(index) method below
        ArrayList<Integer> rowList = returnArrayList(arr, 3, "rowList");
        printArrayList("rowList(index) with index of 3", rowList);

        //  Now test with set(row, col, item) method below
        arr.set(2, 3, 124);
        printTest("set the value 124 at row " + (2 - 1) + " and column " + (3 - 1) + ": " + "using arr.set()", arr);
        arr = initNullArray();

        //  Finally, test the colSize() and rowSize()
        printColRow(arr);

        System.out.println("----------TEST CASES FOR INTEGER ARRAY2D CONCLUDED----------\n\n");
    }

    //  Below we will test with doubles below
    public void testWithDoubleArray2D() {
        System.out.println("----------TESTING WITH DOUBLE ARRAY2D BELOW----------");

        //  Before testing, print out the original array
        Array2D<Double> arr = initDoubleArray();
        System.out.println("Here is the original array below");
        printArray2D(arr);
        System.out.println(""); //  Spacer

        //  First test with addFirstRow
        arr.addFirstRow();
        printTest("addFirstRow", arr);
        arr = initDoubleArray();  //  Get the original Double array

        //  Now test with the addFirstCol
        arr.addFirstCol();
        printTest("addFirstCol", arr);
        arr = initDoubleArray();

        //  Now test with the addLastRow method
        arr.addLastRow();
        printTest("addLastRow", arr);
        arr = initDoubleArray();

        //  Now test with the addLastCol method
        arr.addLastCol();
        printTest("addLastCol", arr);
        arr = initDoubleArray();

        //  Now test with insertRow method
        arr.insertRow(2);
        printTest("insertRow with index 2", arr);
        arr = initDoubleArray();

        //  Now test with insertCol method
        arr.insertCol(3);
        printTest("insertCol with index 3", arr);
        arr = initDoubleArray();

        //  Now test with deleteFirstRow method
        arr.deleteFirstRow();
        printTest("deleteFirstRow method", arr);
        arr = initDoubleArray();

        //  Now test with deleteFirstCol method
        arr.deleteFirstCol();
        printTest("deleteFirstCol method", arr);
        arr = initDoubleArray();

        //  Now test with deleteLastRow method
        arr.deleteLastRow();
        printTest("deleteLastRow method", arr);
        arr = initDoubleArray();

        //  Now test with deleteLastCol method
        arr.deleteLastCol();
        printTest("deleteLastCol method", arr);
        arr = initDoubleArray();

        //  Now test with deleteRow(index) method
        arr.deleteRow(2);
        printTest("deleteRow(int index) with index of 2", arr);
        arr = initDoubleArray();

        //  Now test with deleteCol(index) method
        arr.deleteCol(2);
        printTest("deleteCol(int index) with index of 2", arr);
        arr = initDoubleArray();

        //  Now test get(row, col) method
        Double num = arr.get(1, 2);
        System.out.println("Get value at row" + (0) + " and column " + (2 - 1) + ": " + num + "\n");


        //  Now test getCol(index) method below
        ArrayList<Double> colList = returnArrayList(arr, 2, "getCol");
        printArrayList("colList(index) with index of 2", colList);

        //  Now test getRow(index) method below
        ArrayList<Double> rowList = returnArrayList(arr, 3, "rowList");
        printArrayList("rowList(index) with index of 3", rowList);


        //  Now test with set(row, col, item) method below
        arr.set(2, 3, 159.28);
        printTest("set the value 159.28 at row " + (2 - 1) + " and column " + (3 - 1) + ": " + "using arr.set()", arr);
        arr = initDoubleArray();

        //  Finally, test the colSize() and rowSize()
        printColRow(arr);

        System.out.println("----------TEST CASES FOR DOUBLE ARRAY2D CONCLUDED----------\n\n");
    }

    //  Here we will test the blank Array2D and output to the console
    public void testWithBlankArray2D() {
        System.out.println("----------TESTING WITH BLANK ARRAY2D BELOW----------");

        //  Before testing, print out the original array
        Array2D<Integer> arr = initNullArray();
        System.out.println("Here is the original array below");
        printArray2D(arr);
        System.out.println(""); //  Spacer

        //  First test with addFirstRow
        arr.addFirstRow();
        printTest("addFirstRow", arr);
        arr = initNullArray();  //  Get the original null array

        //  Now test with the addFirstCol
        arr.addFirstCol();
        printTest("addFirstCol", arr);
        arr = initNullArray();

        //  Now test with the addLastRow method
        arr.addLastRow();
        printTest("addLastRow", arr);
        arr = initNullArray();

        //  Now test with the addLastCol method
        arr.addLastCol();
        printTest("addLastCol", arr);
        arr = initNullArray();

        //  Now test with insertRow method
        arr.insertRow(2);
        printTest("insertRow with index 2", arr);
        arr = initNullArray();

        //  Now test with insertCol method
        arr.insertCol(2);
        printTest("insertCol with index 2", arr);
        arr = initNullArray();

        //  Now test with deleteFirstRow method
        arr.deleteFirstRow();
        printTest("deleteFirstRow method", arr);
        arr = initNullArray();

        //  Now test with deleteFirstCol method
        arr.deleteFirstCol();
        printTest("deleteFirstCol method", arr);
        arr = initNullArray();

        //  Now test with deleteLastRow method
        arr.deleteLastRow();
        printTest("deleteLastRow method", arr);
        arr = initNullArray();

        //  Now test with deleteLastCol method
        arr.deleteLastCol();
        printTest("deleteLastCol method", arr);
        arr = initNullArray();

        //  Now test with deleteRow(index) method
        arr.deleteRow(2);
        printTest("deleteRow(int index) with index of 2", arr);
        arr = initNullArray();

        //  Now test with deleteCol(index) method
        arr.deleteCol(2);
        printTest("deleteCol(int index) with index of 2", arr);
        arr = initNullArray();

        //  Now test get(row, col) method
        Integer num = arr.get(1, 2);
        System.out.println("Get value at row 1 and column 2: " + num + "\n");


        //  Now test getCol(index) method below
        ArrayList<Integer> colList = returnArrayList(arr, 2, "getCol");
        printArrayList("colList(index) with index of 2", colList);

        //  Now test getRow(index) method below
        ArrayList<Integer> rowList = returnArrayList(arr, 1, "rowList");
        printArrayList("rowList(index) with index of 1", rowList);


        //  Now test with set(row, col, item) method below
        arr.set(1, 2, 20);
        printTest("set the value 20 at row 1, column 2 using set() ", arr);
        arr = initNullArray();

        //  Finally, test the colSize() and rowSize()
        printColRow(arr);

        System.out.println("----------TEST CASES FOR BLANK ARRAY2D CONCLUDED----------\n\n");
    }

    //  Here we will test the blank Array2D and output to the console
    public void testWithCharArray2D() {
        System.out.println("----------TESTING WITH CHARACTER ARRAY2D BELOW----------");

        //  Before testing, print out the original array
        Array2D<Character> arr = initCharArray();
        System.out.println("Here is the original array below");
        printArray2D(arr);
        System.out.println(""); //  Spacer

        //  First test with addFirstRow
        arr.addFirstRow();
        printTest("addFirstRow", arr);
        arr = initCharArray();  //  Get the original null array

        //  Now test with the addFirstCol
        arr.addFirstCol();
        printTest("addFirstCol", arr);
        arr = initCharArray();

        //  Now test with the addLastRow method
        arr.addLastRow();
        printTest("addLastRow", arr);
        arr = initCharArray();

        //  Now test with the addLastCol method
        arr.addLastCol();
        printTest("addLastCol", arr);
        arr = initCharArray();

        //  Now test with insertRow method
        arr.insertRow(2);
        printTest("insertRow with index 2", arr);
        arr = initCharArray();

        //  Now test with insertCol method
        arr.insertCol(2);
        printTest("insertCol with index 2", arr);
        arr = initCharArray();

        //  Now test with deleteFirstRow method
        arr.deleteFirstRow();
        printTest("deleteFirstRow method", arr);
        arr = initCharArray();

        //  Now test with deleteFirstCol method
        arr.deleteFirstCol();
        printTest("deleteFirstCol method", arr);
        arr = initCharArray();

        //  Now test with deleteLastRow method
        arr.deleteLastRow();
        printTest("deleteLastRow method", arr);
        arr = initCharArray();

        //  Now test with deleteLastCol method
        arr.deleteLastCol();
        printTest("deleteLastCol method", arr);
        arr = initCharArray();

        //  Now test with deleteRow(index) method
        arr.deleteRow(2);
        printTest("deleteRow(int index) with index of 2", arr);
        arr = initCharArray();

        //  Now test with deleteCol(index) method
        arr.deleteCol(2);
        printTest("deleteCol(int index) with index of 2", arr);
        arr = initCharArray();

        //  Now test get(row, col) method
        Character c = arr.get(1, 2);
        System.out.println("Get the value at row " + (0) + "and column " + (2 - 1) + c + "\n");


        //  Now test getCol(index) method below
        ArrayList<Character> colList = returnArrayList(arr, 1, "getCol");
        printArrayList("colList(index) with index of 1", colList);

        //  Now test getRow(index) method below
        ArrayList<Character> rowList = returnArrayList(arr, 2, "rowList");
        printArrayList("rowList(index) with index of 2", rowList);


        //  Now test with set(row, col, item) method below
        arr.set(1, 2, 'l');
        printTest("set the value 124 at row " + (0) + " and column " + (2 - 1) + ": " + "using arr.set()", arr);
        arr = initCharArray();

        //  Finally, test the colSize() and rowSize()
        printColRow(arr);

        System.out.println("----------TEST CASES FOR Character ARRAY2D CONCLUDED----------\n\n");
    }

    //  Herew we will test the String Array2D and output to the console
    public void testWithStringArray2D() {
        System.out.println("----------TESTING WITH STRING ARRAY2D BELOW----------");

        //  Before testing, print out the original array
        Array2D<String> arr = initStringArray();
        System.out.println("Here is the original array below");
        printArray2D(arr);
        System.out.println(""); //  Spacer

        //  First test with addFirstRow
        arr.addFirstRow();
        printTest("addFirstRow", arr);
        arr = initStringArray();  //  Get the original null array

        //  Now test with the addFirstCol
        arr.addFirstCol();
        printTest("addFirstCol", arr);
        arr = initStringArray();

        //  Now test with the addLastRow method
        arr.addLastRow();
        printTest("addLastRow", arr);
        arr = initStringArray();

        //  Now test with the addLastCol method
        arr.addLastCol();
        printTest("addLastCol", arr);
        arr = initStringArray();

        //  Now test with insertRow method
        arr.insertRow(2);
        printTest("insertRow with index 2", arr);
        arr = initStringArray();

        //  Now test with insertCol method
        arr.insertCol(2);
        printTest("insertCol with index 2", arr);
        arr = initStringArray();

        //  Now test with deleteFirstRow method
        arr.deleteFirstRow();
        printTest("deleteFirstRow method", arr);
        arr = initStringArray();

        //  Now test with deleteFirstCol method
        arr.deleteFirstCol();
        printTest("deleteFirstCol method", arr);
        arr = initStringArray();

        //  Now test with deleteLastRow method
        arr.deleteLastRow();
        printTest("deleteLastRow method", arr);
        arr = initStringArray();

        //  Now test with deleteLastCol method
        arr.deleteLastCol();
        printTest("deleteLastCol method", arr);
        arr = initStringArray();

        //  Now test with deleteRow(index) method
        arr.deleteRow(2);
        printTest("deleteRow(int index) with index of 2", arr);
        arr = initStringArray();

        //  Now test with deleteCol(index) method
        arr.deleteCol(2);
        printTest("deleteCol(int index) with index of 2", arr);
        arr = initStringArray();

        //  Now test get(row, col) method
        String str = arr.get(1, 2);
        System.out.println("Get the value at row " + 0 + " and column " + str + "\n");


        //  Now test getCol(index) method below
        ArrayList<String> colList = returnArrayList(arr, 2, "getCol");
        printArrayList("colList(index) with index of 2", colList);

        //  Now test getRow(index) method below
        ArrayList<String> rowList = returnArrayList(arr, 1, "rowList");
        printArrayList("rowList(index) with index of 1", rowList);


        //  Now test with set(row, col, item) method below
        arr.set(1, 2, "emoji");
        printTest("set the value 'emoji' at row " + 0 + " and column " + (2 - 1) + ": " + "using arr.set()", arr);
        arr = initStringArray();

        //  Finally, test the colSize() and rowSize()
        printColRow(arr);

        System.out.println("----------TEST CASES FOR STRING ARRAY2D CONCLUDED----------\n\n");
    }

    public void testArr() {
        Array2D<Integer> arr = initIntArray();

        printArray2D(arr);

        System.out.println("\n");

        for (int i = 0; i < arr.colSize(); i++) {
            System.out.println(arr.getCol(i));
        }
        System.out.println("\n");
        for (int i = 0; i < arr.rowSize(); i++) {
            System.out.println(arr.getRow(i));
        }
    }


    /*  TODO: Methods Below Create New Array2D Linked Lists and Return Them */

    //  Returns a null Array2D linked list
    private <E> Array2D<E> initNullArray() {
        return new Array2D<E>(3, 2);
    }

    //  Returns an integer Array2D linked list, may be initialized again and again
    private Array2D<Integer> initIntArray() {
        Integer[][] intArray = {
                {75, 96, 3, 38},
                {15, 47, 93, 22},
                {61, 45, 37, 51},
                {77, 22, 16, 39}
        };
        return new Array2D<Integer>(intArray);
    }

    //  Returns a Double Array2D Linked List
    private Array2D<Double> initDoubleArray() {
        Double[][] doubleArray = {
                {11.25, 56.45, 77.20, 111.45},
                {18.29, 15.21, 12.91, 89.58},
                {69.42, 43.12, 40.29, 29.48},
                {83.14, 55.25, 18.24, 36.21}
        };

        return new Array2D<Double>(doubleArray);
    }

    //  Returns a Character Array2D Linked List
    private Array2D<Character> initCharArray() {
        Character[][] charArray = {
                {'c', 'z', 'w'},
                {'i', 'q', 'x'},
                {'f', 'h', 'b'}
        };

        return new Array2D<Character>(charArray);
    }

    //  Returns a String Array2D Linked List
    private Array2D<String> initStringArray() {
        String[][] strArray = {
                {"Pizza", "Anime", "World"},
                {"Mate", "Kirito", "Cool Beans"},
                {"Megumin", "Crafty Dude", "Hello"}
        };
        return new Array2D<String>(strArray);
    }


    /*  TODO: Private Helper Methods Below, Such as Printing the Array2D Linked List    */

    //  Will get the passed test case being tested and call printArray2DList
    private <E> void printTest(String str, Array2D<E> Array2D) {
        //  Will print what we are testing to the console and print it out to the console
        System.out.println("Now we shall test with " + str + " and print it out below");

        printArray2D(Array2D);  //  Prints out the passed array

        System.out.println("");  //  Spacer
    }

    //  Method to print out an ArrayList, formatted the exact same way as the printTest
    private <E> void printArrayList(String str, ArrayList<E> list) {
        //  Will print what we are testing to the console and print it out to the console
        System.out.println("Now we shall test with " + str + " and print the ArrayList below");

        //  Print out the items in the ArrayList
        for(E item: list) {
            System.out.print(item + " ");
        }

        System.out.println("\n");  //  Spacer
    }

    //  Method to print out the passed Array2D Linked List in a nice format
    private <E> void printArray2D(Array2D<E> Array2D) {
        for (int i = 0; i < Array2D.rowSize(); i++) {
            for(int j = 0; j < Array2D.colSize(); j++) {
                System.out.print(Array2D.get(i, j) + " ");
            }
            System.out.println();   //  Line spacer to create the next row on a new line
        }
    }

    //  Method to return an ArrayList<E> below with the passed Array2D
    private <E> ArrayList<E> returnArrayList(Array2D<E> Array2D, int index, String testCase) {
        ArrayList<E> arrayList = new ArrayList<E>();

        //  If the passed testCase is getCol then call Array2D.getCol, else call Array2D.getRow
        if(testCase.equals("getCol")) {
            arrayList = Array2D.getCol(index);
        } else {
            arrayList = Array2D.getRow(index);
        }
        return arrayList;
    }

    //  Method to print the column and rowSize below
    private <E> void printColRow(Array2D<E> Array2D) {
        System.out.println("Column size is " + Array2D.colSize() + " and row size is " + Array2D.rowSize());
    }


}
