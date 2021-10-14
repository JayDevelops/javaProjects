/*
*
*
* Jesus Perez Arias
* CS 2013-01
*
*
* Class will initiate the arraylist to be used with the sorting algorithms and time how long they take to run.
*
* My computer could only handle the first two sets but I left the other sets here to run on your own Professor,
* each test"Number"DataSet has created 7 different array lists and calls my testGenericWithAlgorithm or testIntegerWithAlgorithm
* depending if the algorithm is only integer or generics as well.
*
* The files do run and take a long time to run on my machine.
* */
package hw06;

import java.util.ArrayList;
import java.time.Duration;
import java.time.Instant;

public class Main {

    public static void main(String[] args) {
        testFirstDataSet();

        System.out.println(""); //  Spacer

        testSecondDataSet();

        System.out.println(""); //  Spacer

        testThirdDataSet();

        System.out.println("");

        testFourthDataSet();

        System.out.println("");

        testFifthDataset();
    }

    //  Method to test the first data set 50000.txt file data with,below
    public static void testFirstDataSet() {
        //  TODO: Init seven different arraylists below to use for testing
        InitArrayList firstSetListOne = new InitArrayList("50000.txt");
        InitArrayList firstSetListTwo = new InitArrayList("50000.txt");
        InitArrayList firstSetListThree = new InitArrayList("50000.txt");
        InitArrayList firstSetListFour = new InitArrayList("50000.txt");
        InitArrayList firstSetListFive = new InitArrayList("50000.txt");
        InitArrayList firstSetListSix= new InitArrayList("50000.txt");
        InitArrayList firstSetListSeven= new InitArrayList("50000.txt");

        System.out.println("-- TESTING WITH THE FIRST DATA SET KNOWN AS 50000.txt BELOW ---");

        //  TODO: Call the testGenericWithAlgorithm functions with different array lists to display to the console
        System.out.println("Testing with Insertion Sort. Time Below");
        testGenericWithAlgorithm(firstSetListOne, "insertionSort");

        System.out.println("Testing with Bubble Sort. Time Below");
        testGenericWithAlgorithm(firstSetListTwo, "bubbleSort");

        System.out.println("Testing with Selection Sort. Time Below");
        testGenericWithAlgorithm(firstSetListThree, "selectionSort");

        System.out.println("Testing with Merge Sort. Time Below");
        testGenericWithAlgorithm(firstSetListFour, "mergeSort");

        System.out.println("Testing with Quick Sort. Time Below");
        testGenericWithAlgorithm(firstSetListFive, "quickSort");

        System.out.println("Testing with Counting Sort. Time Below");
        testIntegerWithAlgorithm(firstSetListSix, "countingSort", 50000);

        System.out.println("Testing with Radix Sort. Time Below");
        testIntegerWithAlgorithm(firstSetListSeven, "radixSort", 0);

        System.out.println("-- TESTING WITH THE FIRST DATA SET KNOWN AS 50000.txt HAS CONCLUDED ---");
    }

    //  Method to test the second data set 100000.txt file data with, below
    public static void testSecondDataSet() {
        //  TODO: Init seven different arraylists below to use for testing
        InitArrayList firstSetListOne = new InitArrayList("100000.txt");
        InitArrayList firstSetListTwo = new InitArrayList("100000.txt");
        InitArrayList firstSetListThree = new InitArrayList("100000.txt");
        InitArrayList firstSetListFour = new InitArrayList("100000.txt");
        InitArrayList firstSetListFive = new InitArrayList("100000.txt");
        InitArrayList firstSetListSix= new InitArrayList("100000.txt");
        InitArrayList firstSetListSeven= new InitArrayList("100000.txt");

        System.out.println("-- TESTING WITH THE SECOND DATA SET KNOWN AS 100000.txt BELOW ---");

        //  TODO: Call the testGenericWithAlgorithm functions with different array lists to display to the console
        System.out.println("Testing with Insertion Sort. Time Below");
        testGenericWithAlgorithm(firstSetListOne, "insertionSort");

        System.out.println("Testing with Bubble Sort. Time Below");
        testGenericWithAlgorithm(firstSetListTwo, "bubbleSort");

        System.out.println("Testing with Selection Sort. Time Below");
        testGenericWithAlgorithm(firstSetListThree, "selectionSort");

        System.out.println("Testing with Merge Sort. Time Below");
        testGenericWithAlgorithm(firstSetListFour, "mergeSort");

        System.out.println("Testing with Quick Sort. Time Below");
        testGenericWithAlgorithm(firstSetListFive, "quickSort");

        System.out.println("Testing with Counting Sort. Time Below");
        testIntegerWithAlgorithm(firstSetListSix, "countingSort", 100000);

        System.out.println("Testing with Radix Sort. Time Below");
        testIntegerWithAlgorithm(firstSetListSeven, "radixSort", 0);

        System.out.println("-- TESTING WITH THE SECOND DATA SET KNOWN AS 100000.txt HAS CONCLUDED ---");
    }

    //  Method to test the third data set 150000.txt file data with, below
    public static void testThirdDataSet() {
        //  TODO: Init seven different arraylists below to use for testing
        InitArrayList firstSetListOne = new InitArrayList("150000.txt");
        InitArrayList firstSetListTwo = new InitArrayList("150000.txt");
        InitArrayList firstSetListThree = new InitArrayList("150000.txt");
        InitArrayList firstSetListFour = new InitArrayList("150000.txt");
        InitArrayList firstSetListFive = new InitArrayList("150000.txt");
        InitArrayList firstSetListSix= new InitArrayList("150000.txt");
        InitArrayList firstSetListSeven= new InitArrayList("150000.txt");

        System.out.println("-- TESTING WITH THE THIRD DATA SET KNOWN AS 150000.txt BELOW ---");

        //  TODO: Call the testGenericWithAlgorithm functions with different array lists to display to the console
        System.out.println("Testing with Insertion Sort. Time Below");
        testGenericWithAlgorithm(firstSetListOne, "insertionSort");

        System.out.println("Testing with Bubble Sort. Time Below");
        testGenericWithAlgorithm(firstSetListTwo, "bubbleSort");

        System.out.println("Testing with Selection Sort. Time Below");
        testGenericWithAlgorithm(firstSetListThree, "selectionSort");

        System.out.println("Testing with Merge Sort. Time Below");
        testGenericWithAlgorithm(firstSetListFour, "mergeSort");

        System.out.println("Testing with Quick Sort. Time Below");
        testGenericWithAlgorithm(firstSetListFive, "quickSort");

        System.out.println("Testing with Counting Sort. Time Below");
        testIntegerWithAlgorithm(firstSetListSix, "countingSort", 150000);

        System.out.println("Testing with Radix Sort. Time Below");
        testIntegerWithAlgorithm(firstSetListSeven, "radixSort", 0);

        System.out.println("-- TESTING WITH THE THIRD DATA SET KNOWN AS 150000.txt HAS CONCLUDED ---");
    }

    //  Method to test the fourth data set 200000.txt file data with, below
    public static void testFourthDataSet() {
        //  TODO: Init seven different arraylists below to use for testing
        InitArrayList firstSetListOne = new InitArrayList("200000.txt");
        InitArrayList firstSetListTwo = new InitArrayList("200000.txt");
        InitArrayList firstSetListThree = new InitArrayList("200000.txt");
        InitArrayList firstSetListFour = new InitArrayList("200000.txt");
        InitArrayList firstSetListFive = new InitArrayList("200000.txt");
        InitArrayList firstSetListSix= new InitArrayList("200000.txt");
        InitArrayList firstSetListSeven= new InitArrayList("200000.txt");

        System.out.println("-- TESTING WITH THE FOURTH DATA SET KNOWN AS 200000.txt BELOW ---");

        //  TODO: Call the testGenericWithAlgorithm functions with different array lists to display to the console
        System.out.println("Testing with Insertion Sort. Time Below");
        testGenericWithAlgorithm(firstSetListOne, "insertionSort");

        System.out.println("Testing with Bubble Sort. Time Below");
        testGenericWithAlgorithm(firstSetListTwo, "bubbleSort");

        System.out.println("Testing with Selection Sort. Time Below");
        testGenericWithAlgorithm(firstSetListThree, "selectionSort");

        System.out.println("Testing with Merge Sort. Time Below");
        testGenericWithAlgorithm(firstSetListFour, "mergeSort");

        System.out.println("Testing with Quick Sort. Time Below");
        testGenericWithAlgorithm(firstSetListFive, "quickSort");

        System.out.println("Testing with Counting Sort. Time Below");
        testIntegerWithAlgorithm(firstSetListSix, "countingSort", 200000);

        System.out.println("Testing with Radix Sort. Time Below");
        testIntegerWithAlgorithm(firstSetListSeven, "radixSort", 0);

        System.out.println("-- TESTING WITH THE FOURTH DATA SET KNOWN AS 200000.txt HAS CONCLUDED ---");
    }

    //  Method to test the fourth data set 250000.txt file data with, below
    public static void testFifthDataset() {
        //  TODO: Init seven different arraylists below to use for testing
        InitArrayList firstSetListOne = new InitArrayList("250000.txt");
        InitArrayList firstSetListTwo = new InitArrayList("250000.txt");
        InitArrayList firstSetListThree = new InitArrayList("250000.txt");
        InitArrayList firstSetListFour = new InitArrayList("250000.txt");
        InitArrayList firstSetListFive = new InitArrayList("250000.txt");
        InitArrayList firstSetListSix= new InitArrayList("250000.txt");
        InitArrayList firstSetListSeven= new InitArrayList("250000.txt");

        System.out.println("-- TESTING WITH THE FIFTH DATA SET KNOWN AS 250000.txt BELOW ---");

        //  TODO: Call the testGenericWithAlgorithm functions with different array lists to display to the console
        System.out.println("Testing with Insertion Sort. Time Below");
        testGenericWithAlgorithm(firstSetListOne, "insertionSort");

        System.out.println("Testing with Bubble Sort. Time Below");
        testGenericWithAlgorithm(firstSetListTwo, "bubbleSort");

        System.out.println("Testing with Selection Sort. Time Below");
        testGenericWithAlgorithm(firstSetListThree, "selectionSort");

        System.out.println("Testing with Merge Sort. Time Below");
        testGenericWithAlgorithm(firstSetListFour, "mergeSort");

        System.out.println("Testing with Quick Sort. Time Below");
        testGenericWithAlgorithm(firstSetListFive, "quickSort");

        System.out.println("Testing with Counting Sort. Time Below");
        testIntegerWithAlgorithm(firstSetListSix, "countingSort", 250000);

        System.out.println("Testing with Radix Sort. Time Below");
        testIntegerWithAlgorithm(firstSetListSeven, "radixSort", 0);

        System.out.println("-- TESTING WITH THE FOURTH DATA SET KNOWN AS 200000.txt HAS CONCLUDED ---");
    }

    //  Test the passed generic array list with the type of sorting algorithm desired
    public static <E extends Comparable<E>> void testGenericWithAlgorithm(ArrayList<E> list, String type) {
        Instant start = Instant.now();  //  Checks when the function was fired

        switch (type) {
            case "insertionSort":
                Sorting.insertionSort(list);
                Instant end = Instant.now();
                System.out.println(Duration.between(start, end));
                break;
            case "bubbleSort":
                Sorting.bubbleSort(list);
                Instant endTwo = Instant.now();
                System.out.println(Duration.between(start, endTwo));
                break;
            case "selectionSort":
                Sorting.selectionSort(list);
                Instant endThree = Instant.now();
                System.out.println(Duration.between(start, endThree));
                break;
            case "mergeSort":
                Sorting.mergeSort(list);
                Instant endFour = Instant.now();
                System.out.println(Duration.between(start, endFour));
                break;
            case "quickSort":
                Sorting.quickSort(list);
                Instant endFive = Instant.now();
                System.out.println(Duration.between(start, endFive));
                break;
                default:
                    System.out.println("You shouldn't be here, thrown error. Came from testGenericWithAlgorithm() method");
                    break;
        }

    }

    //  Test the passed ONLY INTEGER Array List with the type of sorting algorithm desired
    public static void testIntegerWithAlgorithm(ArrayList<Integer> list, String type, int k) {
        Instant start = Instant.now();  //  Checks when the function was fired

        //  Note, only k is passed to counting sort algorithm. It isn't passed to radix sort
        switch (type) {
            case "countingSort":
                Sorting.countingSort(list, k);
                Instant end = Instant.now();
                System.out.println(Duration.between(start, end));
                break;
            case "radixSort":
                Sorting.radixSort(list);
                Instant endTwo = Instant.now();
                System.out.println(Duration.between(start, endTwo));
                break;
            default:
                System.out.println("You shouldn't be here, thrown error. Came from testIntegerWithAlgorithm() method.");
                break;
        }
    }
}
