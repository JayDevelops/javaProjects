/*
*
* Array2D.java
*
* Written by Jesus Perez, CS 2013-01.
*
* Array2D is a single linked list which traverses from the head either to the right or downwards in order to create a 2D Array using linked lists.
*
* */
package hw05;

import java.util.ArrayList;

public class Array2D<E> {
    /*  TODO: Data fields of the Array2D  */
    private int rows;   //  The number of rows in the array linked list
    private int cols;   //  The number of columns in the array linked list
    private Array2DNode<E> head;    //  Array2DNode reference, which points to the node at position (0,0) in the array.
    private Array2DNode<E> rowTail;    //  Array2DNode reference, which points to the node at the beginning of the last row.
    private Array2DNode<E> colTail;    //  Array2DNode reference, which points to the node at the beginning of the last col.


    /*  TODO: Constructors for Array2D  */
    //  Default constructor will have 0 rows and 0 columns. No nodes are in this.
    public Array2D() {
        //  There are no nodes in this default constructor so leave it at 0
        this.rows = 0;
        this.cols = 0;

        //  Head, rowTail, colTail references start with nulls
        this.head = null;
        this.rowTail = null;
        this.colTail = null;
    }

    //  Constructor which takes the initial number of rows and columns of the Array2D, rows is row size and col is col size. The nodes are empty.
    public Array2D(int rows, int cols) {
        //  Check if the passed rows and columns aren't less than 0
        if(rows < 0 || cols < 0) {
            throw new IndexOutOfBoundsException("Rows or columns cannot be less than 0.");
        }

        //  Finally, create a blank empty Array2D linked list with passed rows and cols
        initEmptyArray2D(rows, cols);
    }


    //  Constructor which takes in a 2D array and fills them to be nodes here
    public Array2D(E[][] array) {
        //  First, get the passed rows and columns of the passed in array
        int rows = array.length;
        int cols = array[0].length - 1;

        //  Next, create a blank empty Array2D linked list with passed rows and cols
        initEmptyArray2D(rows, cols);

        //  Now since the Array2D is filled with empty values, we can repeatedly call the this.set method to fill in the passed array values
        for (int i = 0; i < this.rowSize(); i++) {
            for (int j = 0; j < this.colSize(); j++) {
                this.set(i, j, array[i][j]);
            }
        }
    }


    /*  TODO: Public Methods for Array2D Below  */

    // Adds a new column of empty node(s) to the beginning of the list at each column level
    public void addFirstCol() {
        //  Make a new newNode so we can populate it to the head
        Array2DNode<E> newNode = new Array2DNode<E>();

        //  If the Array2D linked list is empty then simply make the head the tempNode and col/rowTail the same this.head reference
        if(isEmpty()) {
            this.head = newNode;
            this.colTail = this.head;
            this.rowTail = this.head;

            this.rows = 1;
            this.cols =1;
        } else {
            //  Else, swap the previous column's head and make the new node it's head
            newNode.nextCol = this.head;
            this.head = newNode;

            //  Now relink the new columns nodes to the right and fill the node's below the new head as well by traversing downwards
            Array2DNode<E> newHead = this.head;
            Array2DNode<E> prevHead = newNode.nextCol;

            //  While we reach to the second to last row, keep traversing downwards and relink the new first column to the previous column's nodes
            while(prevHead.nextRow != null) {
                newHead.nextRow = new Array2DNode<E>(); //  Make the node below the new head equal a blank new node
                newHead = newHead.nextRow;  //  Get the next row's node
                newHead.nextCol = prevHead.nextRow; //  Link the column to the right of the node below the new head to the bottom of the old head, thus relinking
                prevHead = prevHead.nextRow;    //  Change the previous head to the next row below so we can keep relinking once again
            }
            this.cols++;
        }
    }

    // Adds a new row of empty node(s) to the beginning of the list at each row level
    public void addFirstRow() {
        //  Make a new newNode so we can populate it to the head
        Array2DNode<E> newNode = new Array2DNode<E>();

        //  If the Array2D linked list is empty then simply make the head the tempNode and col/rowTail the same this.head reference
        if(isEmpty()) {
            this.head = newNode;
            this.colTail = this.head;
            this.rowTail = this.head;

            this.rows = 1;
            this.cols = 1;
        } else {
            //  Else, swap the previous column's head and make the new node it's head
            newNode.nextRow = this.head;
            this.head = newNode;

            //  Now relink the new row's nodes to the previous rows' nodes below it
            Array2DNode<E> newHead = this.head;
            Array2DNode<E> prevHead = newNode.nextRow;

            //  While we reach to the second to last column of the previous row, keep traversing to the right and relink bottom node to the top new row
            while(prevHead.nextCol != null) {
                newHead.nextCol = new Array2DNode<E>(); //  Make the node to the right of the new head blank nodes
                newHead = newHead.nextCol;  //  Get the next column's node to the right in order to keep filling towards the right
                newHead.nextRow = prevHead.nextCol; //  Link the node below the new node at the top to the previous' rows node at the bottom to the right
                prevHead = prevHead.nextCol;    //  Change the previous head to the next column below so we can keep relinking once again
            }
            this.rows++;
        }
    }

    //  addLastCol(): Adds a new column to the end of the list.
    public void addLastCol() {
        //  If the Array2D linked list is empty then simply add the first column
        if(isEmpty()) {
            addFirstCol();
        } else {
            //  First, find the colTail of the Array2D by iterating to the right
            Array2DNode<E> currentNode = this.head;
            Array2DNode<E> tempColTail = new Array2DNode<E>();  //  Temp colTail will be stored here

            //  While the right column node isn't null, then store the tempColTail node and go to the next column
            while(currentNode.nextCol != null) {
                currentNode = currentNode.nextCol;
                tempColTail = currentNode;
            }

            //  Now, we simply iterate downwards and add null values to the right side of the last column of the newColTail
            while(currentNode != null) {
                currentNode.nextCol = new Array2DNode<E>();
                tempColTail = currentNode.nextCol;
                currentNode = currentNode.nextRow;
            }

            //  Now set the tempColTail equal to the stored tempColTail from above
            this.colTail = tempColTail;
            this.cols++;
        }
    }

    //  TODO: COME BACK TO THIS ONE Adds a new row to the end of the list.
    public void addLastRow() {
        //  If the Array2D linked list is empty then simply add the first column
        if(isEmpty()) {
            addFirstRow();
        } else {
            //  First, find the rowTail of the Array2D by iterating to the right
            Array2DNode<E> currentNode = this.head;
            Array2DNode<E> tempRowTail = new Array2DNode<E>();  //  Temp colTail will be stored here

            //  While the right column node isn't null, then store the tempColTail node and go to the next column
            while(currentNode.nextRow != null) {
                currentNode = currentNode.nextRow;
                tempRowTail = currentNode;
            }

            //  Now, we simply iterate to the right and add null values to the bottom side of the previous last row of the tempRowTail
            while(currentNode != null) {
                currentNode.nextRow = new Array2DNode<E>();
                tempRowTail = currentNode.nextRow;
                currentNode = currentNode.nextCol;
            }

            //  Now set the tempRowTail equal to the stored tempColTail from above
            this.rowTail = tempRowTail;
            this.rows++;
        }
    }

    //  insertCol() Inserts a column at the given index. (Insert here means the columns shift over by 1 from the insertion point onward)
    public void insertCol(int index) {
        //  Create a newNode to make the new top node and fill the column downwards with new nodes
        Array2DNode<E> newNode = new Array2DNode<E>();

        //  First check if the passed column index is in bounds
        if(index < 0 || index > this.colSize()) {
            throw new IndexOutOfBoundsException("Index out of bounds for column at " + index);
        } else if(index == 0) {
            this.addFirstCol();  //  If the column index is at 0 then simply add a first column
        } else if(index == this.colSize()) {
            this.addLastCol();   //  If the column index is at the end then simply add a new last column
        } else {
            /*
            * Else, find the node before and after the desired column index.
            * From the beforeNode, must connect it to our newNode to the right by traversing downwards of the beforeNode.
            *
            * Then, must connect the newNode to the afterNode to the right as well.
            *
            * While relinking the three columns together, I have to make a new blank node below the newNode
            * */

            //  First find the node before and after the current index
            Array2DNode<E> beforeNode = this.head;
            Array2DNode<E> afterNode = new Array2DNode<E>();
            int colCount = 0;

            //  Traverse to the right and get the node before and after the new specified col index
            while(colCount < index - 1) {
                beforeNode = beforeNode.nextCol;    //  The beforeNode will be the next column of the this.head reference, to the right
                afterNode = beforeNode.nextCol;     //  The afterNode will be next to the beforeNode in the next column
                colCount++;
            }

            /*  Now traverse downwards to link the beforeNode to our newNode and link the newNode to the afterNode to the right.
                Make sure to make blankNodes below the newNode */
            while(beforeNode != null) {
                //  Link to the left and right side(node) of the newNode
                beforeNode.nextCol = newNode;
                newNode.nextCol = afterNode;

                //  Make the bottom node (nextRow) of the newNode equal a blankNode
                newNode.nextRow = new Array2DNode<E>();

                //  Finally, traverse downwards for the three nodes
                beforeNode = beforeNode.nextRow;
                newNode = newNode.nextRow;
                afterNode = afterNode.nextRow;
            }
            this.cols++;    //  Finally, add one to the columns
        }
    }

    //  insertRow(index) Inserts a row at the given index. (Insert here means the rows shift over by 1 from the insertion point onward).
    public void insertRow(int index) {
        //  Create a newNode to make it the new top node at the far left row level and then fill new nodes to the right
        Array2DNode<E> newNode = new Array2DNode<E>();

        //  First check if the passed row index is in bounds
        if(index < 0 || index > this.rowSize()) {
            throw new IndexOutOfBoundsException("Index out of bounds for row at " + index);
        } else if(index == 0) {
            this.addFirstRow();  //  If the row index is at 0 then simply add a row in the beginning
        } else if(index == this.rowSize()) {
            this.addLastRow();   //  If the row index is at the end then simply add a new last row
        } else {
            /*
             * Else, find the node before and after the desired row index.
             * From the beforeNode, must connect it to our newNode to the top and bottom by traversing to the right of the beforeNode.
             *
             * Then, must connect the newNode to the afterNode to the top as well.
             *
             * While relinking the three columns together, I have to make a new blank node to the right of the newNode
             * */

            //  First find the node before and after the node where we want to insert the new row at
            Array2DNode<E> beforeNode = this.head;
            Array2DNode<E> afterNode = new Array2DNode<E>();
            int rowCount = 0;

            //  Traverse to the right and get the node before and after the new specified col index
            while(rowCount < index - 1) {
                beforeNode = beforeNode.nextRow;    //  Get the node before the passed row index
                afterNode = beforeNode.nextRow;  //  Get the node after the passed row index
                rowCount++;
            }

            /*  Now traverse to the right then link the beforeNode to our newNode and link the newNode to the afterNode to the right.
                Make sure to make blankNodes to the right of the newNode */
            while(beforeNode != null) {
                //  Link to the top and bottom of the new node
                beforeNode.nextRow = newNode;
                newNode.nextRow = afterNode;

                //  Make the right node (next column) of the newNode equal a blank node
                newNode.nextCol = new Array2DNode<E>();

                //  Finally traverse to the right by switching the three nodes and iterate once again
                beforeNode = beforeNode.nextCol;
                newNode = newNode.nextCol;
                afterNode = afterNode.nextCol;
            }
            this.rows++;    //  Finally, add one to the row size
        }
    }

    //  deleteFirstCol() Removes the first column.
    public void deleteFirstCol() {
        if(isEmpty()) {
            throw new RuntimeException("There is nothing in the Array2D. Can't delete when it's empty.");
        } else if(this.colSize() == 1) {
            //  If the column size is 1 then make the head a blank Array2DNode and set the colTail to the head now
            this.head = new Array2DNode<E>(null);
            this.colTail = this.head;

            //  If for some reason there's only one row as well, then make the the colTail equal the rowTail as well
            if(this.rowSize() == 1) {
                this.rowTail = this.colTail;
            }
            this.cols--;
        } else if(this.head != null) {
            //  Create a temporary currentNode to store the next column node below and make it the new head below
            Array2DNode<E> currentNode = this.head.nextCol;
            this.head = currentNode; //  Make the this.head equal to the current. Everything else becomes garbage

            //  Now find the new colTail by traversing to the right and assigning it the colTail reference
            while(currentNode != null) {
                colTail = currentNode;  //  Assign the colTail to the next column's node
                currentNode = currentNode.nextCol;  //  Then make the current equal to the next column's node over
            }
            this.cols--;    //  Decrement the cols size, no matter what
        }

    }

    //  deleteFirstRow() Removes the first row.
    public void deleteFirstRow() {
        if(isEmpty()) {
            throw new RuntimeException("The Array2D is empty, there is nothing to delete.");
        } else if(this.rowSize() == 1) {
            //  If the row size is 1 then make the head a blank Array2DNode and set the rowTail to the head now
            this.head = new Array2DNode<E>(null);
            this.rowTail = this.head;

            //  If there is only one column as well, then make the colTail equal to the rowTail as well
            if(this.colSize() == 1) {
                this.colTail = this.rowTail;
            }
            this.cols--;
        } else if(this.head != null) {
            //  If the Array2D linked list isn't empty then make a new tempHead and make this.head equal to the new tempHead. The row below becomes garbage
            Array2DNode<E> currentNode = head.nextRow;
            head = currentNode;

            //  Now find the new rowTail by traversing downwards and assigning to this.rowTail reference
            while(currentNode != null) {
                colTail = currentNode;
                currentNode = currentNode.nextRow;
            }
            this.rows--;
        }
    }

    //  deleteLastCol() Removes the last column.
    public void deleteLastCol() {
        //  Make sure the list isn't empty
        if (isEmpty()) {
            throw new RuntimeException("There are no nodes in the linked list. Cannot delete last column.");
        } else if(this.head.nextCol == null) {
            //  If the head's next column equal to null then there's no next column, thus we make the head equal to null
            this.head = null;
            this.rowTail = this.colTail = null;
            this.cols--;
        } else if(this.head != null) {
            //  If the head doesn't equal null then find the colTail and make a tempNode to assign it to the colTail
            Array2DNode<E> tempColTail = this.head;

            //  Traverse to the right until the last node in the first row
            while (tempColTail.nextCol != null) {
                tempColTail = tempColTail.nextCol;
            }

            this.colTail = tempColTail;    //  Finally, set the column tail to the tempNode. Everything else becomes garbage
            this.cols--;
        }
    }

    //  deleteLastRow() Removes the last row.
    public void deleteLastRow() {
        //  Make sure the list isn't empty
        if (isEmpty()) {
            throw new RuntimeException("There are no nodes in the linked list. Cannot delete last column.");
        } else if(this.head.nextRow == null) {
            //  If the head's next row equal to null then there's no next row, thus we make the head equal to null
            this.head = null;
            this.rowTail = this.colTail = null;
            this.rows--;
        } else if(this.head != null) {
            //  If the head doesn't equal null then find the colTail and make a tempNode to assign it to the colTail
            Array2DNode<E> tempRowTail = this.head;

            //  Traverse downwards until the last node in the first column
            while (tempRowTail.nextRow != null) {
                tempRowTail = tempRowTail.nextRow;
            }

            this.rowTail = tempRowTail;    //  Finally, set the row tail to the tempNode. Everything else becomes garbage
            this.rows--;
        }
    }

    //  deleteCol(index) Removes the column at the given index.
    public void deleteCol(int index) {
        //  First check if the index is in bounds
        if(index < 0 || index >= this.colSize()) {
            throw new IndexOutOfBoundsException("Column index is out of bounds for Array2D linked list. Entered index is: " + index + " out of total current columns: " + colSize());
        } else if(index == 0) {
            //  If the index is at 0 then simply call deleteFirstCol method
            deleteFirstCol();
        } else if(index == this.colSize() - 1) {
            deleteLastCol();    //  If the index is the last column then call deleteLastCol
        } else {
            //  Anything else, we want to get the node at the column before the passed column index
            int colCount = 0;
            Array2DNode<E> previousNode = this.head;

            //  Traverse to the right until the column before the passed index and get that node reference
            while(colCount < index - 1) {
                colCount++;
                previousNode = previousNode.nextCol;
            }

            previousNode.nextCol = previousNode.nextCol.nextCol;    //  Make the next column equal to the secondary next column

            //  Now traverse from the top node reference of the previous node to link the rows together
            while(previousNode != null) {
                previousNode.nextCol = previousNode.nextCol.nextCol;
                previousNode = previousNode.nextRow;
            }

            //  Find the new colTail by iterating to the right column by column
            Array2DNode<E> tempColTail = this.head;

            while (tempColTail.nextCol != null) {
                tempColTail = tempColTail.nextCol;
            }

            this.colTail = tempColTail;    //  Finally, set the column tail to the new tempColTail
            this.cols--;
        }
    }

    //  deleteRow(index) Removes the row at the given index.
    public void deleteRow(int index) {
        //  First check if the index is in bounds
        if(index < 0 || index >= this.rowSize()) {
            throw new IndexOutOfBoundsException("Row index is out of bounds for Array2D linked list. Entered index is: " + index + " out of total current rows: " + this.rowSize());
        } else if(index == 0) {
            //  If the index is at 0 then simply call deleteFirstRow method
            deleteFirstRow();
        } else if(index == this.rowSize() - 1) {
            deleteLastRow();    //  If the index is the last row then call deleteLastRow
        } else {
            //  Anything else, we want to get the node at the column before the passed column index
            int rowCount = 0;
            Array2DNode<E> previousNode = this.head;

            //  Traverse to downwards until the column before the passed index and get that node reference
            while(rowCount < index - 1) {
                rowCount++;
                previousNode = previousNode.nextRow;
            }

            previousNode.nextRow = previousNode.nextRow.nextRow;    //  Make the next column equal to the secondary next column

            //  Now traverse from the top node reference of the previous node to link the columns together
            while(previousNode != null) {
                previousNode.nextRow = previousNode.nextRow.nextRow;
                previousNode = previousNode.nextCol;
            }

            //  Find the new colTail by iterating to the right column by column
            Array2DNode<E> tempRowTail = this.head;
            while (tempRowTail.nextRow != null) {
                tempRowTail = tempRowTail.nextRow;
            }

            this.rowTail = tempRowTail;    //  Finally, set the row tail to the new tempRowTail
            this.rows--;
        }
    }

    //  get(row, col) Returns the item at the given (row, col) (not the array2dnode)
    public E get(int row, int col) throws IndexOutOfBoundsException {
        //  First check if either the row or columns are within bounds
        if(row < 0 || row >= this.rowSize()) {
            throw new IndexOutOfBoundsException("Index out of bounds for row at " + row);
        }
        if(col < 0 || col >= this.colSize()) {
            throw new IndexOutOfBoundsException("Index out of bounds for column at " + col);
        }

        //  Make the current node to this.head and locate the node at the desired position
        Array2DNode<E> currentNode = this.head;
        Array2DNode<E> tempNode = returnNodeAtPosition(row, col, currentNode);

        //  Finally, once found get the item of the currentNode
        return tempNode.getItem();
    }

    //  getCol(col) Returns an ArrayList<E> which holds the values from the requested column
    public ArrayList<E> getCol(int col) {
        //  First check if the column is in bounds
        if(col < 0 || col >= this.colSize()) {
            throw new IndexOutOfBoundsException("Index out of bounds for column at " + col);
        }

        //  Create a new array list and make the currentNode equal to this.head
        ArrayList<E> arrayList = new ArrayList<E>();
        Array2DNode<E> currentNode = this.head;
        int colCount = 0;   //  Keep track of the row counts


        //  Find the node at the passed column index
        while(colCount < col) {
            currentNode = currentNode.nextCol;
            colCount++;
        }

        //  Iterate through the rows downwards in the currentNode's column and store them in the arrayList
        while(currentNode != null) {
            //  Get the currentItem and add it to the arrayList
            E item = currentNode.getItem();
            arrayList.add(item);

            //  Then make iterate to the bottom node, the next row down, and iterate again
            currentNode = currentNode.nextRow;
        }

        return arrayList;   //  Finally, return the arrayList
    }

    //  getRow(row) Returns an ArrayList<E> which holds the values from the requested row.
    public ArrayList<E> getRow(int row) throws IndexOutOfBoundsException {
        //  First check if the row is in bounds
        if(row < 0 || row >= rowSize()) {
            throw new IndexOutOfBoundsException("Index out of bounds for row at " + row);
        }
        //  Create a new array list and make the currentNode equal to this.head
        ArrayList<E> arrayList = new ArrayList<E>();
        Array2DNode<E> currentNode = this.head;
        int rowCount = 0;   //  Keep track of the row counts


        //  Find the node at the passed row index
        while(rowCount < row) {
            currentNode = currentNode.nextRow;
            rowCount++;
        }

        //  Iterate through the columns to the right in the currentNode's column and store them in the arrayList
        while(currentNode != null) {
            //  Get the currentItem and add it to the arrayList
            E item = currentNode.getItem();
            arrayList.add(item);

            //  Then iterate to the right node (nextColumn)
            currentNode = currentNode.nextCol;
        }
        return arrayList;   //  Finally, return the arrayList
    }

    //  set(row, col, item) Assigns the given item to the Array2DNode at position (row, col).
    public void set(int row, int col, E item) throws IndexOutOfBoundsException {
        //  Create a temp node to traverse to the right row, col position and then store the item there
        Array2DNode<E> currentNode = this.head;

        //  First check if either the row or columns are within bounds
        if(row < 0 || row >= this.rowSize()) {
            throw new IndexOutOfBoundsException("Index out of bounds for row at " + row);
        }
        if(col < 0 || col >= this.colSize()) {
            throw new IndexOutOfBoundsException("Index out of bounds for column at " + col);
        }

        //  Check if the Array2D is empty to make it tempNode, if not then make the passed item the row tail and col tail
        if(this.head == null) {
            this.head = new Array2DNode<E>();
            this.colTail = this.head;
            this.rowTail = this.head;
        } else {
            currentNode = returnNodeAtPosition(row, col, currentNode);
            currentNode.setItem(item);
        }
    }

    //  colSize() returns the number of columns
    public int colSize() { return this.cols; }

    //  rowSize() returns the number of rows
    public int rowSize() { return this.rows; }



    /*  TODO: Private Methods for Array2D Below */
    //  isEmpty() will check if the list has empty (null) nodes and returns a boolean
    private boolean isEmpty() {
        //  Will return true if the head, rowTail, colTail are all null as well as the columns and rows are equal to 0
        return (this.head == null && this.rowTail == null && this.colTail == null && this.cols == 0 && this.rows == 0);
    }

    //  Method to make an empty Array2D linked list, in order to fill the values later down the road.
    private void initEmptyArray2D(int rows, int cols) {
        //  Create a row and column column to keep track
        int rowCount = 0;
        int colCount = 0;

        //  While the row count is less than the passed rows, keep making rows
        while(rowCount < rows) {
            this.addFirstRow();
            rowCount++;
        }

        //  While the colCount is less than the passed columns, then keep making columns
        while(colCount < cols) {
            this.addFirstCol();
            colCount++;
        }
    }

    //  Private method to locate and return the Array2DNode at the desired row and column position below
    private Array2DNode<E> returnNodeAtPosition(int row, int col, Array2DNode<E> currentNode) {
        //  Traverse downwards from the first row until it gets to the desired row node
        for (int i = 0; i < row; i++) {
            if (currentNode.nextRow != null) {
                currentNode = currentNode.nextRow;
            }
        }

        //  Traverse to the right from the current row above until it gets to the desired column node
        for (int i = 0; i < col; i++) {
            if (currentNode.nextCol != null) {
                currentNode = currentNode.nextCol;
            }
        }
        return currentNode; //  Finally, return the node at the row, col position
    }
}
