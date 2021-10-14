/*
* Grid.java Written By Jesus Perez Arias, CS 2012-01
* December 10, 2020
*
* This will extend GridPane to create a Grid for the gameScene and initialize it with colors and rowSize and colSize, passed.
*
*
* Data Fields
*   private int[][] gridArr
*       This is where each tile in the grid will be located at, using 2D array
*   private int colSize
*       This is the column size of the grid
*   private int rowSize;
*       This is the row size of the grid
*   private int windowLength
*       This is the window length to not go over the horizontal limit
*
* Constructor
*   Constructor will make a custom grid for the player with the data fields listed above
*   Will only take the rowSize, colSize, and windowLength to create the custom Grid
*
* */
package cs2012final;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Grid extends GridPane {
    /*  TODO: Data fields for the Grid  */
    private int[][] gridArr;    //  This is where each tile in the grid will be located at, using 2D array
    private int colSize;    //  This is the column size of the grid
    private int rowSize;    //  This is the row size of the grid
    private int windowLength;   //  This is the window length to not go over the horizontal limit


    /*  TODO: Constructor will make a custom grid for the player when a button is pressed   */
    public Grid(int rowSize, int colSize, int windowLength) {
        this.gridArr = new int[rowSize][colSize]; //  Create a grid with the custom columns and rows
        this.colSize = colSize;
        this.rowSize = rowSize;
        this.windowLength = windowLength;

        //  Initialise a a grid with it's rowSize and column size
        init(rowSize, colSize, windowLength);
    }


    /*  TODO: Create methods for the Grid class */

    //  The init method initializes the game grid below, it refers to "this"
    private void init(int rowSize, int colSize, int windowLength) {
        //  Create a new grid with the 2D array
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                this.gridArr[i][j] = 0;

                Rectangle tile = new Rectangle(70, 70);
                tile.setFill(Color.AQUA);
                tile.setStroke(Color.BLACK);

                this.setRowIndex(tile, i);
                this.setColumnIndex(tile, j);

                this.getChildren().addAll(tile);
            }
        }
    }

    //  Getter method for the rows length of the 2D array grid size
    public int getRowSize() { return rowSize; }

    //  Getter method for the columns length of the 2D array grid size
    public int getColSize() { return colSize; }
}
