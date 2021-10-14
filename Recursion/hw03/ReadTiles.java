/*
*
*
* Jesus Perez
* CS 2013-01
* This abstract class will have static methods to read tiles into the the program.
*
*
* */
package hw03;

import java.io.*;
import java.util.Scanner;

public abstract class ReadTiles {
    //  Create a private method to import the colors to return an array of each line of the filePath
    public static Hexagon[] importTiles(String filePath) {
        //  Create a new file and a hexagon array to return back
        File file = new File(filePath);
        Hexagon[] hexArr = new Hexagon[7];
        try {
            Scanner fir = new Scanner(file);

            //  Make a line array to hold the lines and make a color array to instantiate the hexagon array
            String[] lineArr = new String[7];
            char[] colorArr = new char[6];
            String[] splitArr;

            for(int i = 0; i < 7; i++) {
                //  Get the characters after the 'Tile #:'
                lineArr[i] = fir.nextLine().substring(8, 19);
            }


            //  Loop through the array to split the commas
            for(int i = 0; i < 7; i++) {
                //  Split the line array by each comma then temporarily store it in the split array
                splitArr = lineArr[i].split(",");
                //  Iterate through the color array and add the colors from the split array at the index
                for(int j = 0; j < 6; j++) {
                    colorArr[j] = splitArr[j].charAt(0);
                }
                //  Instantiate a new Hexagon instance and store it in the hexagon array index
                hexArr[i] = new Hexagon( i + 1, i +1, colorArr);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return hexArr;
    }

}
