/*
* Position.java Written By Jesus Perez Arias, CS 2012-01
* December 10, 2020
*
* This class is only a final class to create a random position[] with given GameGrid constraints
*/
package cs2012final;

import java.util.Random;

public final class Position {

    //  Method to create a random position within the bounds a Grid instance rows and cols size
    public int[] createRandomPosition(Grid gameGrid) {
        // create instance of Random class
        Random rand = new Random();

        // Generate two random integers in range 0 to the maximum row and col size
        int xRandom = rand.nextInt(gameGrid.getColSize()) + 1;
        int yRandom = rand.nextInt(gameGrid.getRowSize()) + 1;

        //  The first number will be the xPosition and the second will be the yPosition
        int[] randomNums = {xRandom, yRandom};

        return randomNums;
    }
}
