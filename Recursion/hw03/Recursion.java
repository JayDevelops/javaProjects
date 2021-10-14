/*
*
* Jesus Perez Arias
* CS 2013-01
*
*
* The private solve method will try to solve the hexagon outer by rotating then copying once again.
*
* It will try to check the color and tile position through a nested for loop then compare to the checkedHexArray.
*
*
*
* */

package hw03;

public class Recursion {
    int hexArrSize; //  The size of the passed hexagon array
    int solutionTotal;  //  Checks the total amount of solutions there are
    Hexagon[] checkedHexArr = new Hexagon[hexArrSize];    //  Solutions will get passed here
    Hexagon[] passedHexArr = new Hexagon[hexArrSize]; //  This is the passed hexagon array from Main class


    //  Constructor for Recursion below
    public Recursion(Hexagon[] passedHexArr) {
        //  Get the hexagon array size from the passed hexagon array length
        this.hexArrSize = passedHexArr.length;

        //  Init the checked and passed hex array sizes
        this.checkedHexArr = new Hexagon[hexArrSize];
        this.passedHexArr = new Hexagon[hexArrSize];

        //  Pass the hexagon array here
        this.passedHexArr = passedHexArr;
    }

    public void mainSolve() {
        //  Call the solve method below to try to solve
        solve(this.checkedHexArr, 0);

        if(this.solutionTotal == 0) {
            System.out.println("None found");
        }

    }

    public void solve(Hexagon[] hexArr, int currentPos) {
        //  Create a temporary hexagon array by deep copying the passed hexagon array, not the checked hexagon array
        Hexagon[] tempHexArr = createNewHexArr(this.passedHexArr);

        //  If the last position isn't null then increment the solution total and print the solution out
        if (checkedHexArr[6] != null) {
            this.solutionTotal++;
            System.out.println("Solution Number" + this.solutionTotal + "\n" + this + "\n");
        }
        else {
            //  Iterate twice through the current tile and then compare the each color according to isSafe method
            for(int tile = 0; tile < 7; tile++) {
                for(int charColor = 0; charColor < 6; charColor++) {
                    //  If it's any other hexagon besides the center, then rotate
                    if(currentPos == 0) {
                        tempHexArr[tile].rotateColorsClockwise();
                    }

                    //  If the isSafe checks the colors do match then recurse and add one to the current position
                    if(isSafe(checkedHexArr, currentPos, tempHexArr[tile])) {
                        checkedHexArr[currentPos] = tempHexArr[tile];

                        solve(checkedHexArr, currentPos + 1);

                        checkedHexArr[currentPos] = null;
                    }
                }
            }
        }
    }

    private boolean isSafe(Hexagon[] hexArr, int currHexPos, Hexagon currHexagon) {
        //  Check if the checked array middle tile is null and it checks the middle tile as 0
        if(hexArr[0] == null && currHexPos == 0) {
            return true;
        }

        //  This will check if the hexagon array does exist at the current hexagon position
        if(hexArr[currHexPos] != null) {
            return false;
        }

        //  check if center solution[0] side color corresponds to currPos currTile color
        if( !(currHexPos == 1 && currHexagon.getCharAtIndex(3) == hexArr[0].getCharAtIndex(0)) ) {
            return false;
        }
        if( !(currHexPos == 2 && currHexagon.getCharAtIndex(4) == hexArr[0].getCharAtIndex(1)) ) {
            return false;
        }
        if( !(currHexPos == 3 && currHexagon.getCharAtIndex(5) == hexArr[0].getCharAtIndex(2)) ) {
            return false;
        }
        if( !(currHexPos == 4 && currHexagon.getCharAtIndex(0) == hexArr[0].getCharAtIndex(3)) ) {
            return false;
        }
        if( !(currHexPos == 5 && currHexagon.getCharAtIndex(1) == hexArr[0].getCharAtIndex(4)) ) {
            return false;
        }
        if( !(currHexPos == 6 && currHexagon.getCharAtIndex(2) == hexArr[0].getCharAtIndex(5)) ) {
            return false;
        }


        //  Now we check the each tile counterclockwise if it's valid
        if( !(currHexPos == 2 && currHexagon.getCharAtIndex(5) == hexArr[1].getCharAtIndex(2)) ) {
            return false;
        }
        if( !(currHexPos == 3 && currHexagon.getCharAtIndex(0) == hexArr[2].getCharAtIndex(3)) ) {
            return false;
        }
        if( !(currHexPos == 4 && currHexagon.getCharAtIndex(1) == hexArr[3].getCharAtIndex(4)) ) {
            return false;
        }
        if( !(currHexPos == 5 && currHexagon.getCharAtIndex(2) == hexArr[4].getCharAtIndex(4)) ) {
            return false;
        }
        if( !(currHexPos == 6 && currHexagon.getCharAtIndex(3) == hexArr[5].getCharAtIndex(0)) ) {
            return false;
        }

        return true;
    }

    //  Helper Method to make a temp hexagon array and return it
    private Hexagon[] createNewHexArr(Hexagon[] hexArr) {
        Hexagon[] tempHexArr = new Hexagon[hexArr.length];

        //  Iterate through to make a copy of the array
        for (int i = 0; i < hexArr.length; i++) {
            Hexagon newHexagon = new Hexagon(hexArr[i]);
            tempHexArr[i] = newHexagon;
        }

        return tempHexArr;
    }
}
