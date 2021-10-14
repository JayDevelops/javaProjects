/*
*
* Written by Jesus Perez Arias, CS 2013-01
*
* This Array2DNode stores the item, and gets the reference of the next column and the next row.
*
*
* */
package hw05;

public class Array2DNode<E> {
    /*  TODO: Data fields of the Array2DNode    */
    private E item; //  store the data here, aka the data item here
    protected Array2DNode<E> nextCol;  //  This is the data which is next to the item, in the same column
    protected Array2DNode<E> nextRow;  //  This is the data which is next to the item, in the same row


    /*  TODO: Constructors for Array2DNode  */
    //  Default constructor which takes no parameters.
    public Array2DNode() { }

    //  Constructor which takes an item of any type and initializes the item data field.
    public Array2DNode(E item) {
        this.item = item;
    }

    //  Get the item (getter) below
    public E getItem() {
        return item;
    }

    //  Set the item (setter) below
    public void setItem(E item) {
        this.item = item;
    }
}
