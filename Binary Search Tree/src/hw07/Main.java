/*
*
* Main.java written by Jesus Perez Arias
*
* This calls all the public methods found under the BinarySearchTree.java  and tests them to the output.
* It uses integers and strings to test the methods.
*
*
* */
package hw07;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        testIntBST();

        System.out.println("\n\n\n");   // Spacer

        testStringBST();
    }

    public static void testIntBST() {
        System.out.println("------------TESTING WITH INTEGERS------------");

        //  Print the initial binary search tree using toString method
        System.out.println("Testing toString() method");
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(32, 83, 3, 60, 24, 85, 7, 37, 20, 94, 93, 90, 74, 15, 53);
        System.out.println(bst.toString());

        //  Print the preorder arraylist using the preorder method
        System.out.println("Testing Preorder Method Below");
        ArrayList<Integer> preorderList = bst.preorder();
        System.out.println(preorderList);

        //  Print the inorder arraylist using the preorder method
        System.out.println("Testing Inorder Method Below");
        ArrayList<Integer> inorderList = bst.inorder();
        System.out.println(inorderList);


        //  Print the postorder arraylist using the postorder method
        System.out.println("Testing Postorder Method Below");
        ArrayList<Integer> postorderList = bst.postorder();
        System.out.println(postorderList);

        //  Print the breadthfirst arraylist using the breadthfirst method
        System.out.println("Testing breadthfirst Method Below");
        ArrayList<Integer> breadthfirstList = bst.breadthfirst();
        System.out.println(breadthfirstList);

        //  Testing the find() method below
        System.out.println(""); //  Spacer
        System.out.println("~~~Testing the find() method below~~~");
        System.out.println("Is the number 32 in the Binary Search Tree?: " + bst.find(32));
        System.out.println("Is the number 40 in the Binary Search Tree?: " + bst.find(40));
        System.out.println("Is the number 7 in the Binary Search Tree?: " + bst.find(7));
        System.out.println("Is the number 75 in the Binary Search Tree?: " + bst.find(75));


        //  Inserting values 14, 16, 2, 61, 89 in this order using insert() method
        System.out.println("\nInserting values 14, 16, 2, 61, 89 in this order using insert() method.");
        bst.insert(14);
        bst.insert(16);
        bst.insert(2);
        bst.insert(61);
        bst.insert(89);
        System.out.println("~~~Printing integer tree with new values below~~~" + "\n" + bst.toString());


        //  Deleting values 16, 14, 32, 83, 74 in this order using delete() method
        System.out.println("\nDeleting values 16, 14, 32, 83, 74 in this order using delete() method ");
        bst.delete(16);
        bst.delete(14);
        bst.delete(32);
        bst.delete(83);
        bst.delete(74);
        System.out.println("~~~Printing integer tree with  deleted values below~~~" + "\n" + bst.toString());

        System.out.println("------------TESTING WITH INTEGERS COMPLETED------------");
    }

    public static void testStringBST() {
        System.out.println("------------TESTING WITH STRINGS------------");

        //  Print the initial binary search tree using toString method
        System.out.println("Testing toString() method");
        BinarySearchTree<String> bst = new BinarySearchTree<String>("Dog", "Pizza", "Anime", "Potato", "Hot Dog", "Flower", "Pillow", "Park", "Water");
        System.out.println(bst.toString());

        //  Print the preorder arraylist using the preorder method
        System.out.println("Testing Preorder Method Below");
        ArrayList<String> preorderList = bst.preorder();
        System.out.println(preorderList);

        //  Print the inorder arraylist using the preorder method
        System.out.println("Testing Inorder Method Below");
        ArrayList<String> inorderList = bst.inorder();
        System.out.println(inorderList);


        //  Print the postorder arraylist using the postorder method
        System.out.println("Testing Postorder Method Below");
        ArrayList<String> postorderList = bst.postorder();
        System.out.println(postorderList);

        //  Print the breadthfirst arraylist using the breadthfirst method
        System.out.println("Testing breadthfirst Method Below");
        ArrayList<String> breadthfirstList = bst.breadthfirst();
        System.out.println(breadthfirstList);

        //  Testing the find() method below
        System.out.println(""); //  Spacer
        System.out.println("~~~Testing the find() method below~~~");
        System.out.println("Is the number \"Dog\" in the Binary Search Tree?: " + bst.find("Dog"));
        System.out.println("Is the number \"Megumin\" in the Binary Search Tree?: " + bst.find("Megumin"));
        System.out.println("Is the number \"Pizza\" in the Binary Search Tree?: " + bst.find("Pizza"));


        //  Inserting values "Watch", "Paper", "Cereal" in this order using insert() method
        System.out.println("\nInserting values \"Watch\", \"Paper\", \"Cereal\" in this order using insert() method");
        bst.insert("Watch");
        bst.insert("Paper");
        bst.insert("Cereal");
        System.out.println("~~~Printing string tree with new values below~~~" + "\n" + bst.toString());


        //  Deleting values "Watch", "Anime", "Hot Dog", 83, 74 in this order using delete() method
        System.out.println("\nDeleting values \"Watch\", \"Anime\", \"Hot Dog\", 83, 74 in this order using delete() method");
        bst.delete("Watch");
        bst.delete("Anime");
        bst.delete("Hot Dog");
        System.out.println("~~~Printing tree with  deleted values below~~~" + "\n" + bst.toString());

        System.out.println("------------TESTING WITH STRINGS COMPLETED------------");
    }
}
