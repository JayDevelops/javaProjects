import java.util.Random;

public class ArrayMethods {
    //  Method to initialize the array
    public static int[][] initArray(int nRows, int nCols) {
        int[][] data = new int[nRows][nCols];
        Random ranNum = new Random();

        //  REMEMBER, rows are horizontal and columns are vertical

        //  Populate data to the columns and rows
        for (int row = 0; row < data.length; row++) {
            //  Column needs to be less than specific looped data row
            for (int col = 0; col < data[row].length; col++) {
                data[row][col] = ranNum.nextInt(100);
            }
        }
        return data;
    }

    //  Method to print array to the user
    public static void printArr(int[][] data) {
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                System.out.print(data[row][col] + " ");
            }
            System.out.println();
        }
    }


    //  Method to count how many elements are in the 2D array
    public static double countAllElements(int[][] data) {
        double elementCounter = 0.0;

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                elementCounter++;
            }
        }
        return elementCounter;
    }


    //  Method to add all the elements of any 2D array
    public static double addEachElement(int[][] data) {
        double result = 0.0;

        for (int row = 0; row < data.length; row++) {
            for(int col = 0; col < data[row].length; col++) {
                result += data[row][col];
            }
        }
        return result;
    }



    //  Method to print out the calculation of each row and columns of 2D array
    public static int[] calculateRowSumAvg(int[][] data, int rows, int cols) {
        //  Save which is the higher or lower rowAvg below
        double highRowAvg = 0, lowRowAvg = 0, tempRowAvg;
        int highRowAvgIndex = 0, lowRowAvgIndex = 0;

        //  Init the eachRowSum and eachColSum below
        double eachRowSum, avgOfRowElements, counterOfElements;


        //  TODO: Calculate eachRowSum, eachRowAvg and find low-high of rows
        for (int i = 0; i < rows; i++) {
            eachRowSum = 0; //  Set the sum to 0 once the outer loop starts again
            counterOfElements = 0;  // Set the counter to 0 once outer loop starts again
            for (int j = 0; j < cols; j++) {
                eachRowSum = eachRowSum + data[i][j];  //  Add the each element to rowSum
                counterOfElements++;    // Increment
            }

            // Get the average of each row
            avgOfRowElements = calculateAvg(eachRowSum, counterOfElements);


            //  If the current avgOfRowElements is higher than temp value, assign to the temp value
            if(avgOfRowElements > highRowAvg) {
                highRowAvg = avgOfRowElements;
                highRowAvgIndex = i + 1;    // Add 1 to the current index 'i' cause index start at 0
            }

            //  If the current tempRowAvg is lower than temp value, assign to temp value
            if(avgOfRowElements < highRowAvg || lowRowAvg > avgOfRowElements) {
                tempRowAvg = avgOfRowElements;
                lowRowAvg = tempRowAvg;

                lowRowAvgIndex = i + 1;

                if (i == 0) {
                    lowRowAvgIndex = 1;
                }
            }


            //  Print out the row sums and avg of elements
            System.out.println("Row " + (i + 1) + " sum: " + BasicMethods.roundDouble(eachRowSum));
            System.out.println("Row " + (i + 1) + " avg: " + BasicMethods.roundDouble(avgOfRowElements) + "\n");
        }

        //  Initiate Return the lowRowAvgIndex and the highRowAvgIndex
        int results[] = {lowRowAvgIndex, highRowAvgIndex};
        return results;
    }

    //  Method to calculate the columns
    public static int[] calculateColsSumAvg(int[][] data, int rows, int cols) {
        //  Initiate the low and high avg col index to track them
        int highColAvgIndex = 0, lowColAvgIndex = 0;

        //  Initiate eachColSum, how many elements, and the avgOfColumnElements
        double eachColSum, counterOfElements, avgOfColElements;

        //  Initiate the highColAvg, lowColAvg, and the tempAvg to compare with avgColElements
        double highColAvg = 0, lowColAvg = 0, tempColAvg;


        for(int i = 0; i < cols; i++){
            eachColSum = 0; // Set the eachColumn Sum to 0 once outer loop starts again
            counterOfElements = 0; // Set the counter to 0 once outer loop starts again

            for(int j = 0; j < rows; j++){
                eachColSum = eachColSum + data[j][i];   //  Add each column element to total sum
                counterOfElements++;    // Increment
            }

            avgOfColElements = calculateAvg(eachColSum, counterOfElements); //  Calculate the avg of eachCol


            //  If the current avgOfRowElements is higher than temp value, assign to the temp value
            if(avgOfColElements > highColAvg) {
                highColAvg = avgOfColElements;
                highColAvgIndex = i + 1;    // Add 1 to the current index 'i' cause index start at 0
            }

            //  If the current tempRowAvg is lower than temp value, assign to temp value
            if(avgOfColElements < highColAvg || lowColAvg > avgOfColElements) {
                tempColAvg = avgOfColElements;
                lowColAvg = tempColAvg;

                lowColAvgIndex = i + 1;

                if (i == 0) {
                    lowColAvgIndex = 1;
                }
            }

            //  Print out the column sums and avg of elements
            System.out.println("Col " + (i + 1) +" sum: " + BasicMethods.roundDouble(eachColSum));
            System.out.println("Col " + (i + 1) + " avg: " + BasicMethods.roundDouble(avgOfColElements) + "\n");
        }

        //  Initiate Return the lowColAvgIndex and the highColAvgIndex
        int results[] = {lowColAvgIndex, highColAvgIndex};
        return results;
    }



    //  Method to calculate an average of one single data set
    public static double calculateAvg(double totalSum, double totalElements) {
        return totalSum / totalElements;
    }



    /*  TODO: Methods to add major and minor diagonals */
    public static void majorAndMinorSum(int[][] data, int rows, int cols) {
        double majorDiagonal = 0, minorDiagonal = 0, majorAvg = 0, minorAvg = 0;
        int currColumn = 0;
        int currRow = 0;

        //  For loop for Calculate the major diagonal below
        for (int i = 0, j =0; i < rows && j < cols; i++, j++){
            if (currColumn >= cols){
                break;
            }
            majorDiagonal += data[i][j];
            currColumn++;
        }
        //  Set the avg of the major diagonal below
        majorAvg = majorDiagonal / currColumn;

        System.out.println("Major Diagonal Sum: " + majorDiagonal);
        System.out.println("Major Diagonal Average: " + BasicMethods.roundDouble(majorAvg) + "\n");


        //  For loop to calculate the minor diagonal below
        for(int i = 0,j = cols - 1 ; i < rows && j>=0 ; i++, j--) {
            if(currRow >= rows) {
                break;
            }
            minorDiagonal += data[i][j];
            currRow++;
        }
        //  Set the avg of the minor diagonal below
        minorAvg = minorDiagonal / currRow;

        System.out.println("Minor Diagonal Sum: " + minorDiagonal);
        System.out.println("Minor Diagonal Average: " + BasicMethods.roundDouble(minorAvg) + "\n");
    }

}
