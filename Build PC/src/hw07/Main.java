/*
*
* Written by Jesus Perez Arias, CS 2012-01, Friday November 13 2020
*
* Each method adds onto the respective passedData method, organizing everything neatly
* until called for Main method
*
*/
package hw07;

public class Main {
    public static void printFacilitiesOfGrade(FacilityDatabase passedData) {
        System.out.println("----Printing all Facilities with 'C' Grade----");
        passedData.displayFacilitiesWithGrade('C', 10);
        System.out.println("----DONE all Facilities with 'C' Grade----\n");
    }

    public static void printFacilitiesOfHigher(FacilityDatabase passedData) {
        System.out.println("----Printing all Facilities with a score higher than 90----");
        passedData.displayFacilitiesWithScoreGreater(90, 10);
        System.out.println("----DONE all Facilities with higher than 90 score----\n");
    }

    public static void printFacilitiesOfLess(FacilityDatabase passedData) {
        System.out.println("----Printing all Facilities with a score less than 79----");
        passedData.displayFacilitiesWithScoreLess(79, 10);
        System.out.println("----DONE all Facilities with less than 80 score----\n");
    }

    public static void printFacilitiesZipCode(FacilityDatabase passedData) {
        System.out.println("----Printing all Facilities with a zip code of 90032----");
        passedData.displayFacilitiesByZipcode(90032, 10);
        System.out.println("----DONE all Facilities with a zip code of 90032----\n");
    }

    public static void printFacilitiesByMonth(FacilityDatabase passedData) {
        System.out.println("----Printing all Facilities with a month of 5----");
        passedData.displayFacilitiesByMonth(5, 10);
        System.out.println("----DONE all Facilities with a month of 5----\n");
    }

    public static void displayCountsByGrade(FacilityDatabase passedData) {
        System.out.println("----Printing the count of all the letter grades of all Facilities----");
        passedData.displayCountsByGrade();
        System.out.println("----DONE count of all the letter grades of all Facilities----");

    }

    public static void main(String[] args) {
        //  Create a new FacilityDatabase with the given, old data .csv file
        FacilityDatabase oldData = CSVReaderWriter.readData("la_facility_ratings");

        //  Print each method below
        printFacilitiesOfGrade(oldData);

        printFacilitiesOfHigher(oldData);

        printFacilitiesOfLess(oldData);

        printFacilitiesZipCode(oldData);

        printFacilitiesByMonth(oldData);

        displayCountsByGrade(oldData);

        //  Write new data file to respective path of the folder
        CSVReaderWriter.writeData(oldData, "new_facility_ratings");

    }
}
