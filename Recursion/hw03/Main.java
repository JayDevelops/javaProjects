/*
*
* Jesus Perez Arias
* CS 2013-01
*
* Main class will read the tiles into the Hexagon[] array and we will pass the said array
* to a Recursion class in order to try to solve the hexagon array by recursion in Recursion.java
*
* */
package hw03;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //  TODO: Professor Keenan, change the filePath variable for your own testing purposes
        String filePath = printMenu();

        //  Instantiate the hexagon array below from the file path
        Hexagon[] hexArr = ReadTiles.importTiles(filePath);

        Recursion tryToSolve = new Recursion(hexArr);
        tryToSolve.mainSolve();
    }

    public static String printMenu() {
        System.out.print("Please enter a file path: ");
        Scanner scanner = new Scanner(System.in);
        String file = scanner.nextLine();
        return file;
    }
}
