/*
*
* BinarySearchTree.java written by Jesus Perez Arias
* Binary search tree has all the methods from the homework assignment requirements,
* it can take generic values and uses appropriate compareTo in order to compare one generic value to the other.
*
*
* */
package hw07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>> {
    /*  TODO: Data Fields for BinarySearchTree, Only References the Root Node of the Tree   */
    private BSTNode<E> root;


    /*  TODO: Constructor for BinarySearchTree Below   */

    //  Default constructor initializes an empty tree
    public BinarySearchTree() {
        this.root = null;
    }

    //  Constructor which takes variable length parameter list and populates the tree
    public BinarySearchTree(E ... values) {
        //  Insert into the binary search tree by repeatedly calling the insert method
        for(E eachValue: values) {
            insert(eachValue);
        }
    }

    /*  TODO: Public Methods for Binary Search Tree Below   */

    //  insert() Adds a new value to the tree according to the rules of a Binary Search Tree.
    public void insert(E key) {
        BSTNode<E> child = new BSTNode<E>(key);  // Create a new node instance here

        //  If tree is empty then make the node the root
        if(isEmpty()) {
            this.root = child;
        } else {
            try {
                child.parent = insertionPoint(key);
                if (key.compareTo(child.parent.data) < 0) {
                    child.parent.left = child;
                } else if(key.compareTo(child.parent.data) > 0) {
                    child.parent.right = child;
                }
            } catch (Exception e) {
                throw new DuplicateItemException("Duplicate item found of " + key + " found, delete the duplicate item manually.");
            }
        }
    }

    //  delete(E key) Takes a value (not an index) and deletes that value from the tree.
    public void delete(E key) {
        delete(nodeToDelete(key));
    }

    //  delete(BSTNode<E> node) is a private helper method to check how to reconnect the node where it'll be deleted at
    private void delete(BSTNode<E> node) {
        //  If the node is a leaf then delete(change to null) the appropriate parent left or right node
        if(isLeaf(node)) {
            // If the leaf is a left child then make the parent to null, if right child then change to null
            if(isLeftChild(node)) {
                node.parent.left = null;
            } else if(isRightChild(node)) {
                node.parent.right = null;
            }
        } else if(numChildren(node) == 1) {
            //  If the left node to the passed node isn't null then make child = node.left, else child = node.right
            BSTNode<E> child = node.left != null ? node.left : node.right;

            //  If the node is a leftChild then make the parent.left equal the above child node
            if(isLeftChild(node)) {
                node.parent.left = child;
            } else if(isRightChild(node)) {
                //  If the node is a right child then make the parent.right equal to the above child node
                node.parent.right = child;
            }
        } else if(numChildren(node) == 2) {
            //  Else if the node has two children then find the LHS maximum node and recurse
            BSTNode<E> max = maxLeftSubtree(node);
            node.data = max.data;
            delete(max);
        }
    }

    //  find Returns true or false depending on if the key is found in the tree or not.
    public boolean find(E key) {
        //  Create a temp node to store the root, will be changed in while loop
        BSTNode<E> current = root;

        while (current != null) {
            if(key == current.data) {
                return true;
            } else if(key.compareTo(current.data) < 0) {
                current = current.left;
            } else if(key.compareTo(current.data) > 0) {
                current = current.right;
            }
        }
        return false;   //  If it doesn't return true above, then by default return true
    }

    //  isEmpty Returns true or false when the BST is empty or not
    public boolean isEmpty() {
        return this.root == null; //  Return true if the BST is true
    }

    //  preorder Returns an ArrayList of values generated using preorder traversal
    public ArrayList<E> preorder() {
        return preorder(this.root);
    }

    //  preorder private helper method for preOrder method above
    private ArrayList<E> preorder(BSTNode<E> current) {
        ArrayList<E> result = new ArrayList<E>();

        //  If the current node is null then return the array list
        if(current == null) {
            return result;
        }

        result.add(current.data);   //  Add the current data to the array list

        //  If the left child of the current isn't null then recursively call preorder method to add all values
        if(current.left != null) {
            result.addAll(preorder(current.left));
        }

        //  If the right child of the current isn't null then recursively call the preorder method to add all values
        if(current.right != null) {
            result.addAll(preorder(current.right));
        }

        return result;  //  At the end, return the result
    }

    //  inorder Returns an ArrayList of values generated using inorder traversal.
    public ArrayList<E> inorder() {
        return inorder(this.root);
    }

    //  inorder private helper method for inorder method above
    private ArrayList<E> inorder(BSTNode<E> current) {
        ArrayList<E> result = new ArrayList<E>();

        //  If the current node is null then return the array list
        if(current == null) {
            return result;
        }

        //  If the left child of the current isn't null then recursively call inorder method to add all values
        if(current.left != null) {
            result.addAll(inorder(current.left));
        }

        result.add(current.data);   //  Add the current data to the array list


        //  If the right child of the current isn't null then recursively call the inorder method to add all values
        if(current.right != null) {
            result.addAll(inorder(current.right));
        }

        return result;  //  At the end, return the result
    }

    //  postorder Returns an ArrayList of values generated using postorder traversal
    public ArrayList<E> postorder() {
        return postorder(this.root);
    }

    //  postorder private helper method for postorder method above
    private ArrayList<E> postorder(BSTNode<E> current) {
        ArrayList<E> result = new ArrayList<E>();

        //  If the current node is null then return the array list
        if(current == null) {
            return result;
        }

        //  If the left child of the current isn't null then recursively call postorder method to add all values
        if(current.left != null) {
            result.addAll(postorder(current.left));
        }

        //  If the right child of the current isn't null then recursively call the postorder method to add all values
        if(current.right != null) {
            result.addAll(postorder(current.right));
        }

        result.add(current.data);   //  Add the current data to the array list

        return result;  //  Finally, return the result
    }

    //  breadthfirst Returns an ArrayList of values generated using breadthfirst traversal
    public ArrayList<E> breadthfirst() {
        return breadthfirst(this.root);
    }

    //  breadthfirst private helper method for breadthfirst method above
    private ArrayList<E> breadthfirst(BSTNode<E> current) {
        ArrayList<E> result = new ArrayList<E>();
        Queue<BSTNode<E>> queue = new LinkedList<BSTNode<E>>();

        //  If the current is null then return the result
        if(current == null) {
            return result;
        }

        queue.clear();
        queue.add(current);

        while(!queue.isEmpty()) {
            //  Dequeue then add the node to the result arraylist
            BSTNode<E> node = queue.remove();
            result.add(node.data);

            //  If left node isn't null then add to the queue
            if(node.left != null) {
                queue.add(node.left);
            }

            //  If the right node isn't null then add to the queue
            if(node.right != null) {
                queue.add(node.right);
            }
        }
        return result;  //  In the end, return the resulting array
    }


    //  toString method will return one string to represent the binary search tree
    public String toString() {
        String finalString = "";    //  Final string to return at the end

        //  If the tree is null then return "empty tree"
        if(isEmpty()) {
            return "Empty Tree";
        }

        //  Check if the right is not null, then add to the string
        if(this.root.right != null) {
            finalString += this.addToTreeString(this.root.right, true, "");
        }

        finalString += addNodeValueToString(this.root);


        //  Check if the left is not null, then add to the string
        if(this.root.left != null) {
            finalString += this.addToTreeString(this.root.left, false, "");
        }

        return finalString;
    }



    /*  TODO: Private helper methods to ease up on the public methods above */

    //  addToTreeString is a private method to be called in the toString() method
    private String addToTreeString(BSTNode<E> node, boolean isRight, String indent) {
        String str = "";

        if (node.right != null) {
            str += addToTreeString(node.right, true, indent + (isRight ? "        " : " |      "));
        }
        str += indent;

        if (isRight) {
            str += " /";
        }
        else {
            str += " \\";
        }
        str += "----- ";

        str += addNodeValueToString(node);

        if (node.left != null) {
            str += addToTreeString(node.left, false, indent + (isRight ? " |      " : "        "));
        }

        return str;
    }

    //  addNodeValueToString is a private method to be called in the toString() method
    private String addNodeValueToString(BSTNode<E> node) {
        String str = "";

        if (node == null) {
            str += "<null>";
        } else {
            str += String.valueOf(node.data);
        }

        str += "\n";
        return str;
    }

    //  insertionPoint is a private method which determines what is the parent, is called in the insert() method
    private BSTNode<E> insertionPoint(E key) {
        BSTNode<E> current = root;  //  Current node, to be changed later
        BSTNode<E> parent = null;   //  Parent node, to keep track of the parent node

        while (current != null) {
            if(key.compareTo(current.data) == 0) {
                throw new DuplicateItemException("Duplicate item found of " + key);
            } else if(key.compareTo(current.data) < 0) {
                parent = current;
                current = current.left;  //  Swap the current node to the left one, less than
            } else if(key.compareTo(current.data) > 0) {
                parent = current;
                current = current.right;    //  Swap the current node to the right one, greater than
            }
        }
        return parent;
    }

    //  nodeToDelete is a private method returning the node to delete (or null if node wasn't found)
    private BSTNode<E> nodeToDelete(E key) {
        BSTNode<E> current = root;  //  Current node, to be changed in the while loop

        while(current != null) {
            if(key.compareTo(current.data) == 0) {
                return current;
            } else if(key.compareTo(current.data) < 0) {
                current = current.left; //  If less than, make the current to the left node
            } else if(key.compareTo(current.data) > 0) {
                current = current.right;    //  If greater than, make the current to the right node
            }
        }
        return null;    //  Return null if the key trying to be deleted isn't in the BST
    }

    //  maxLeftSubtree is a private method to find the maximum value in the left side of the BST, is called in delete() method
    private BSTNode<E> maxLeftSubtree(BSTNode<E> current) {
        if(current.left == null) {
            return current;
        }

        BSTNode<E> tempMax = current.left;

        while(tempMax.right != null) {
            tempMax = tempMax.right;
        }
        return tempMax;
    }



    //  isLeaf is a private method to determine if the passed node is a leaf
    private boolean isLeaf(BSTNode<E> node) {
        return node.left == null && node.right == null;
    }

    //  isLeftChild is a private method determining if the passed node is a left child to it's parent node
    private boolean isLeftChild(BSTNode<E> node) {
        //  Get the parent to the node, the node data and the root data below
        BSTNode<E> parentNode = node.parent;
        E nodeData = node.data;
        E rootData = this.root.data;

        //  If it isn't the same as the root data and the left node isn't null then return true
        if(parentNode.left != null) {
            return parentNode.left.data.equals(nodeData);
        }
        return false;   //  Else, return false
    }

    //  isRightChild is a private method determining if the passed node is a right child to it's parent node
    private boolean isRightChild(BSTNode<E> node) {
        //  Get the parent to the node, the node data and the root data below
        BSTNode<E> parentNode = node.parent;
        E nodeData = node.data;
        E rootData = this.root.data;

        //  If it isn't the same as the root data and the right node isn't null then return true
        if(parentNode.right != null) {
            return parentNode.right.data.equals(nodeData);
        }
        return false;   //  Else, return false
    }

    //  numChildren returns the number of children of the given nodes
    private int numChildren(BSTNode<E> node) {
        int count = 0;  //  Keeps track of the count of children

        //  If the left child of the node isn't null, then increase count
        if(node.left != null) {
            count++;
        }

        //  If the right child of the node isn't null, then increase count
        if(node.right != null) {
            count++;
        }

        return count;
    }
}
