/*
*
* Written by Jesus Perez Arias
* CS 2013-01
*
*
* This class will read the file of integers line by line and place them in an array of integers.
* */
package hw06;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Integer;

public class InitArrayList extends ArrayList<Integer> {
    //  The public constructor will take a filepath string and store it to this arraylist
    public InitArrayList(String filepath) {
        init(filepath);
    }

    //  The private init() method will read the file and store the numbers into this arraylist, will be called in the constructor
    private void init(String filePath) {
        try {
            File file = new File(filePath);
            Scanner sc = new Scanner(file);

            //  While it has a next line, add it to this arraylist
            while(sc.hasNextLine()) {
                this.add(Integer.parseInt(sc.nextLine()));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /*  TODO: Public Methods to Use */

    //  printAllItems() will print all the items stored in the array list
    public void printAllItems() {
        for(Integer item: this) {
            System.out.println(item);
        }
    }

    //  printItemsUntil() will print items until the specified passed int index, inclusive to the index
    public void printItemsUntil(int untilIndex) {
        //  Iterate the list until the index has reached then print
        for (int i = 0; i < untilIndex + 1; i++) {
//            System.out.print(this.get(i) + ", ");
            if(!(i == untilIndex)) {
                System.out.print(this.get(i) + ", ");
            } else {
                System.out.print(this.get(i));
            }
        }
    }

}
