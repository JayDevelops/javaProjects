/*
*
* Hexagon.java written by Jesus Perez Arias
*
* Each index of array is the position located for each hexagon.
* The index of the array is the position of the side
*   1 (Side A): North
*   2 (Side B): North East
*   3 (Side C): South East
*   4 (Side D): South
*   5 (Side E): South West
*   6 (Side F): North West
*
*
*   Constructor will init a Hexagon instance and a copy constructor will make a deep copy of Hexagon.
*   This will hold the tilePosition, tileNumber and the array of color characters.
*
*
*
* */
package hw03;

public class Hexagon {
    //  Create a new hex array below
    private char[] hex = new char[6];

    private int tilePosition;   //  This tracks the current tile position
    private int tileNumber; //  Tracks which tile number it is

    //  Constructor for Hexagon instance
    public Hexagon(int tilePosition, int tileNumber, char[] hex) {
        System.arraycopy(hex, 0, this.hex, 0, 6);
        this.tilePosition = tilePosition;
        this.tileNumber = tileNumber;
    }

    //  Copy constructor of Hexagon
    public Hexagon(Hexagon hexagon) {
        char[] tempArr = new char[6];
        int index = 0;

        for(char color: hexagon.hex) {
            tempArr[index] = color;
            hex[index] = tempArr[index];
        }

        tilePosition = hexagon.getTilePosition();
        tileNumber = hexagon.getTileNumber();
    }

    /*  TODO: Methods for the Hexagon class below   */

    //  Rotate each color char in the array once clockwise
    public void rotateColorsClockwise() {
        //  Make a tempArray to hold the new rotated array
        char[] tempArr = new char[6];
        tempArr[0] = this.hex[5];

        //  Iterate through and copy to the tempArr
        for (int i = 1, j = 0; i < 6; i++, j++) {
            tempArr[i] = this.hex[j];
        }

        System.arraycopy(tempArr, 0, this.hex, 0, 6);
    }

    //  Get the colors from the hex array
    public char[] getColors() {
        return this.hex;
    }

    //  Set the colors for the hex array
    public void setColors(char[] hex) {
        this.hex = hex;
    }

    //  Get the current tile position of the hexagon
    public int getTilePosition() {
        return this.tilePosition;
    }

    //  Set the tile position of the hexagon
    public void setTilePosition(int tilePosition) {
        this.tilePosition = tilePosition;
    }

    //  Get the char at the current index of the hexagon
    public char getCharAtIndex(int index) {
        return this.hex[index];
    }

    //  Get the current tile number of the hexagon
    public int getTileNumber() {
        return this.tileNumber;
    }

    //  Set the tile position of the hexagon
    public void setTileNumber(int tileNumber) {
        this.tileNumber = tileNumber;
    }

    //  Get the hexagon color array
    public char[] getHexColArr() {
        return this.hex;
    }

    //  Get the current size of the hexagon character color array
    public int getCharArrSize() {
        return this.hex.length;
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("Position " + this.tilePosition + ": " + "Tile #" + this.tileNumber + ":\t");

        for(char i : hex) {
            string.append(i).append("\t");
        }

        return string.toString();
    }
}
