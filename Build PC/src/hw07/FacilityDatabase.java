/*
*
* Written by Jesus Perez Arias, CS 2012-01, Friday November 13 2020
*
* FacilityDatabase extends an ArrayList so it has all the good ArrayList methods
* but here we made our own methods. No data fields or contstructors
*
*
* METHODS
*   displayFacilitiesWithGrade()
*       This method will iterate over the list of facilities and display only those facilities that have a grade indicated by facilityGrade
*
*   displayFacilitiesWithScoreGreater()
*       This method will iterate over the list of facilities and display only those facilities that have a grade indicated by the parameter value
*
*   displayFacilitiesWithScoreLess()
*       This method will iterate over the list of facilities and display only those facilities that have a score less than to the compareScore parameter.
*
*   displayFacilitiesByZipcode()
*       This method will iterate over the list of facilities and display only those facilities that have a score greater than to the compareScore parameter.
*
*   displayFacilitiesByZipcode()
*       This displayFacilitiesByZipcode shall iterate over the list of facilities and display, only those facilities that have a zipcode indicated by the parameter value.
*
*   displayFacilitiesByMonth()
*       This method shall iterate over the list of facilities and display only those facilities that have an inspection date month indicated by the parameter value.
*
*   displayCountsByGrade()
*       This method shall iterate over the list of facilities and display a count facilities received each possible grade (A, B, and C are the only options)
* */
package hw07;

import java.util.ArrayList;

public class FacilityDatabase extends ArrayList<Facility> {
    //  Default constructor, shouldn't be initialized
    public FacilityDatabase() {}

    /*  TODO:   Methods for the FacilityDatabase    */


    //  This method will iterate over the list of facilities and display only those facilities that have a grade indicated by the parameter value.
    public void displayFacilitiesWithGrade(char facilityGrade, int displayUntil) {
        int matchedGradeCount = 0;  //  Keeps track how much times the char matches
        int localCount = 1; //  To track the index later

        //  For each facility instance in "this" (database), count how much each time the grade char matches with the facilityGrade
        for(Facility eachFacility: this) {
            if(eachFacility.getGrade() ==facilityGrade) {
                matchedGradeCount += 1; //  Count one more for each matched grade
            }
        }

        /*  Now iterate the instance and print up to the limit (if the displayUntil is less than or equal matchedGradeCount),
        *   print the exact amount of characters to the limit (if the displayUntil is exact to the matchedGradeCount),
        *   and if the displayUntil is exactly -1 then print all the facilityGrades.    */

        if(displayUntil == -1) {
            //  Print each matched character, doesn't matter the size
            for(Facility eachFacility: this) {
                char eachGrade = eachFacility.getGrade();

                if(eachGrade == facilityGrade) {
                    System.out.println("Name:  " + eachFacility.getName() + " with Grade: " + eachGrade);
                }
            }
        } else if(displayUntil <= matchedGradeCount) {
            for(Facility eachFacility: this) {
                //  Get eachGrade from eachFacility instance
                char eachGrade = eachFacility.getGrade();

                //  If the localCount is less than the displayUntil, print out up until the localCount reaches displayUntil
                if(localCount <= displayUntil && eachGrade == facilityGrade) {
                    System.out.println("Name:  " + eachFacility.getName() + " with Grade: " + eachGrade);
                    localCount += 1;
                }
            }

        }
    }

    //  This method will iterate over the list of facilities and display only those facilities that have a score greater than to the compareScore parameter.
    public void displayFacilitiesWithScoreGreater(int compareScore, int displayUntil) {
        int counter = 0;    //  Counter to track how much iterations has gone through

        //  Iterate through eachFacility instance in "this"
        for (Facility eachFacility: this) {
            int eachScore = eachFacility.getScore();    //  Get each score

            //  If displayUntil is -1, print each score
            if(displayUntil == -1 && eachScore > compareScore) {
                System.out.println(eachFacility.getName() + " with a score of " + eachScore);
            } else if(eachScore > compareScore && counter < displayUntil) {
                //  other than the above, print eachScore greater than but up to the limit of displayUntil
                System.out.println(eachFacility.getName() + " with a score of " + eachScore);
                counter += 1;
            }
        }
    }


    //  This method will iterate over the list of facilities and display only those facilities that have a score less than to the compareScore parameter.
    public void displayFacilitiesWithScoreLess(int compareScore, int displayUntil) {
        int localCounter = 0;    //  Counter to track iterations

        //  Iterate through eachFacility instance in "this"
        for (Facility eachFacility: this) {
            int eachScore = eachFacility.getScore();    //  Get each score

            if(displayUntil == -1 && eachScore < compareScore) {
                System.out.println(eachFacility.getName() + " with a score of " + eachScore);
            } else if(eachScore < compareScore && localCounter < displayUntil) {
                //  other than the above, print eachScore less than but up to the limit of displayUntil
                System.out.println(eachFacility.getName() + " with a score of " + eachScore);
                localCounter += 1;
            }
        }
    }

    /*  This displayFacilitiesByZipcode shall iterate over the list of facilities and display
        only those facilities that have a zipcode indicated by the parameter value. */
    public void displayFacilitiesByZipcode(int possibleZipCode, int displayUntil) {
        int localCounter = 0;   //  Counter to track how many times it has iterated

        for(Facility eachFacility: this) {
            int eachZipCode = eachFacility.getZipcode();

            //  If the displayUntil is -1 then print each one until all of them are done
            if(displayUntil == -1 && eachZipCode == possibleZipCode) {
                System.out.println(eachFacility.getName() + " with zipcode of " + eachZipCode);
            } else if(eachZipCode == possibleZipCode && localCounter < displayUntil) {
                //  if eachZipCode matches to the possibleZipCode and it's in bounds of displayUntil, print
                System.out.println(eachFacility.getName() + " with zipcode of " + eachZipCode);
                localCounter += 1;
            }
        }
    }


    /*  This method shall iterate over the list of facilities and display only those facilities
        that have an inspection date month indicated by the parameter value. */
    public void displayFacilitiesByMonth(int compareMonth, int displayUntil) {
        int localCounter = 0;   //  Counter to track how many times it has iterated

        for (Facility eachFacility: this) {
            int eachMonth = eachFacility.getMonth();

            //  if the displayUntil is -1 then print all of the months which match
            if(displayUntil == -1 && eachMonth == compareMonth) {
                System.out.println("Name: " + eachFacility.getName() + " with Month: " + eachMonth);
            } else if(eachMonth == compareMonth && localCounter < eachMonth) {
                System.out.println("Name: " + eachFacility.getName() + " with Month: " + eachMonth);
                localCounter += 1;
            }
        }
    }


    /*  This method shall iterate over the list of facilities and display how many
        facilities received each possible grade (A, B, and C are the only options) */
    public void displayCountsByGrade() {
        //  Counters for respective A, B, and C grades below
        int counterA = 0;
        int counterB = 0;
        int counterC = 0;

        for(Facility eachFacility: this) {
            //  Get eachFacility name and letter grade below
            String eachName = eachFacility.getName();
            char eachGrade = eachFacility.getGrade();


            //  Count how many times each letter grade comes up by incrementing their counters
            if(eachGrade == 'A') {
                counterA += 1;
            } else if(eachGrade == 'B') {
                counterB += 1;
            } else if(eachGrade == 'C') {
                counterC += 1;
            }
        }

        //  Print out the results below, first make it into a string below
        String finalStr = "A-Grade Facilities: " + counterA + "\nB-Grade Facilities: " + counterB + "\nC-Grade Facilities: " + counterC;

        System.out.println(finalStr);
    }

}
