/*
*
* BSTNode.java written by Jesus Perez Arias
*
* This is the node class for the BinarySearchTree.java file, it will store data.
* The parent is the current node, and will reference the left and right nodes.
*
*
*
* */
package hw07;

public class BSTNode<E> {
        /*  TODO: Data fields for BSTNode Below  */
        //  References BSTNodes for the parent and the left plus right child nodes.
        protected BSTNode<E> parent;
        protected BSTNode<E> left;
        protected BSTNode<E> right;
        protected E data;   //  This will store the data of the node

        //  Public constructor to initialize the data for the node
        public BSTNode(E data) { this.data = data; }

}
