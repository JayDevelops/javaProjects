/*
*
* Written by Jesus Perez Arias, CS 2012-01, Friday November 13 2020
*
* No data fields or default constructors, and the class is Final
*
*
* METHODS
*   readData()
*       This method reads the each line of la_facility_ratings.csv and splits up each word or number or character
*       to their own variables. It creates a new Facility instance and try to populate them to their own
*       FacilityDataBase.
*
*   writeData()
*       passes a FacilityDatabase instance and a file name to create a new file, identical
*       with the given .csv file we started. Line by line and adding commas between each word.
*
*
*/

package hw07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public final class CSVReaderWriter {
    /* No data fields for this class */

    //  TODO:   Default constructor of CSVReaderWriter, no props init at all
    public CSVReaderWriter() {}



    /*  TODO: Methods of this class below   */

    //  readData method returns a populated FacilityDatabase array list with Facility Instances
    public static FacilityDatabase readData(String fileName){
        //  Create a new file with the passed string
        File currFile = new File(fileName + ".csv");

        //  Create a FacilityData base to keep adding Facility instances to it
        FacilityDatabase newDatabase = new FacilityDatabase();


        /*  Try iterating each line in the .csv file and split them up */
        try {
            //  Scanner to read each line and each word in the file
            Scanner reader = new Scanner(currFile);

            //  Iterate each line in the current file
            while(reader.hasNextLine()) {
                //  Store the nextLine in a string
                String nextLine = reader.nextLine();

                //  Split each line after the "," into an array of Strings
                String[] splitWords = nextLine.split(",");


                //  TODO: Store each word under each appropriate variable
                String facility_name = splitWords[0];
                String facility_address = splitWords[1];
                int facility_zipcode = Integer.parseInt(splitWords[2]); //   Store the zipcode as an integer
                String date_of_inspection = splitWords[3];
                int score = Integer.parseInt(splitWords[4]);   //   Store the score as an integer
                String wholeGrade = splitWords[5];  //  Store the entire letter grade as String, then split up below
                char grade = wholeGrade.charAt(0);  //  Create the grade as a character to save memory

                //  Create a new facility instance with the above
                try {
                    Facility eachFacility = new Facility(facility_name, facility_address, facility_zipcode, date_of_inspection, score, grade);

                    //  Populates each facility instance to the FacilityDatabase
                    newDatabase.add(eachFacility);
                } catch (DateFormatException dateFormatException) {
                    dateFormatException.printStackTrace();
                }
                //  TODO: Try to create a FacilityDatabase Instance from the above
            }   /*  end of while loop */
        } catch(FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch(Exception e) {
            System.out.println("Uncaught exception found, you're screwed.");
            e.printStackTrace();
        }

        return newDatabase;
    }



    //  writeData method
    public static void writeData(FacilityDatabase database, String newFileName) {
        //  Create an output File instance we want to add values to
        File outputFile = new File(newFileName + ".csv");


        //  TODO: Try to create a PrintWriter to write data to the output file
        try {
            PrintWriter pw = new PrintWriter(outputFile);

            for(Facility eachFacility: database) {
                //  Assign the date of inspection to one string only
                String date = eachFacility.getYear() + "-" + eachFacility.getMonth() + "-" + eachFacility.getDay();

                String eachLine = eachFacility.getName() + "," +
                        eachFacility.getAddress() + "," +
                        eachFacility.getZipcode() + "," +
                        date + "," +
                        eachFacility.getScore() + "," +
                        eachFacility.getGrade();

                //  Now print each line to the .csv file
                pw.println(eachLine);
            }

            pw.flush();
            pw.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }


    /*  This displayFacilitiesByZipcode shall iterate over the list of facilities and display only those facilities
        that have a zipcode indicated by the parameter value. */
    public void displayFacilitiesByZipcode(int possibleZip, int displayUntil) {
        int localCounter = 1;
    }
}


