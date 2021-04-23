import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //  Initiate scanner and ask user for input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter dimensions of the array (row, col): ");

        //  Init the rows, columns, array, and validInput below
        int rowNum, colNum, arr[][];
        boolean validInput = false;   //  Boolean to exit the while loop


        //  While validInput is false, keep running the loop
        while (!validInput) {
            //  Take each input and assign to rows and cols
            System.out.print("Enter the dimensions of the array (row, col): ");

            rowNum = input.nextInt();
            colNum = input.nextInt();

            //  Check if the rows and cols meet the conditions
            if ((rowNum > 0 && colNum > 0) && (rowNum <= 99 && colNum <= 99)) {
                validInput = true;  //  Change validInput to true to stop running the while loop

                arr = ArrayMethods.initArray(rowNum, colNum);  //  Init a new array to arr variable
                generateOutput(arr); //  Call the generateOutput method here

                input.close();  // To prevent memory leaks
            } else {
                System.out.println("Please pick numbers greater than 0 and up to 99 inclusive.");
            }
        }
    }

    //  TODO: Method to generate all the required outputs, will be called in validated call
    public static void generateOutput(int[][] passedArray) {
        //  PRE-STEP: Find how many elements are in the 2D array
        double elements = ArrayMethods.countAllElements(passedArray);

        //  PRE-STEP: Find how many columns and rows are in the array
        int rows = passedArray.length;
        int cols = passedArray[0].length;


        //  PART ONE: First print the array to the user
        System.out.println("\nDisplay Array: ");
        ArrayMethods.printArr(passedArray);


        //  PART TWO(a): Add all elements in the array
        System.out.println("\nTable Statistics:\n");
        double totalSum = ArrayMethods.addEachElement(passedArray);
        System.out.println("Sum of Table: " + BasicMethods.roundDouble(totalSum));


        //  PART TWO(b): Find the average of the elements in the array
        double averageSumOfElements = ArrayMethods.calculateAvg(totalSum, elements);
        System.out.println("Avg of table: " + BasicMethods.roundDouble(averageSumOfElements) + "\n");


        //  PART THREE(a): Find each row sum and the average in the array and store the results for later use
        int[] lowAndHighRowAvg = ArrayMethods.calculateRowSumAvg(passedArray, rows, cols);

        //  PART THREE (b): Find each col sum and the average in the array and store the results for later use
        int[] lowAndHighColAvg = ArrayMethods.calculateColsSumAvg(passedArray, rows, cols);


        //  PART FOUR: Print the major and minor diagonal sums and the averages
        ArrayMethods.majorAndMinorSum(passedArray, rows, cols);

        //  PART FIVE: Print the high and low avg row number indeces from saved results
        System.out.println("Highest Avg Row: " + lowAndHighRowAvg[1]); //  The second element is the highestRowAvg
        System.out.println("Lowest Avg Row: " + lowAndHighRowAvg[0] + "\n");  //  The first element is the lowestColAvg

        //  PART SIX: Print the high and low avg col number indeces from saved results
        System.out.println("Highest Avg Col: " + lowAndHighColAvg[1]);  //  The second element is the highestColAvg
        System.out.println("Lowest Avg Col: " + lowAndHighColAvg[0]);   //  The second element is the lowestColAvg
    }

}
