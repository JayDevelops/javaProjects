/*
* Created by Jesus Perez Arias, CS 2013-01
*
*
* This Main class will test all the methods in the SortedSet.java and the SortedSetUtils.java
*
* */
public class Main {

    public static void main(String[] args) {
        testIntegers();

        System.out.println("\n");   //Spacer

        testStrings();

        System.out.println("\n");   //Spacer

        testIntersection();

        System.out.println("\n");   //Spacer

        testUnion();
    }

    //  This method will test SortedSet with integers
    public static void testIntegers() {
        System.out.println("----- Test With Integers Below ----");
        System.out.println("The integerSet will be 1, 2, 3, 4, 5. The below is getting the Sorted Set using toString()");

        //  Print the set using toString()
        SortedSet<Integer> integerSet = new SortedSet(1, 2, 3, 4, 5);
        System.out.println("Printing array using toString() " + integerSet.toString());

        //  Add to the integerSet by using addAll
        System.out.println("Values to be added to the integerSet is 0, 10, 9, 30, 40, and 60 using addAll() method");
        integerSet.addAll(0, 10, 9, 30, 40, 60);
        System.out.println("After adding new values using addAll(): " + integerSet.toString());

        //  Add to the integerSet by using add
        System.out.println("Let's add one more integer in the middle by using add(). Let it be  8");
        integerSet.add(8);
        System.out.println("After adding 8 to the set using add(): " + integerSet.toString());

        //  Remove from the integerSet by using remove
        System.out.println("Let's remove 5 by using remove() of the integer set");
        integerSet.remove(5);
        System.out.println("After removing 5 using remove(): " + integerSet.toString());

        //  Check the exists method
        System.out.println("Let's see if the number 5 is still in our set by using exists()");
        System.out.println("Does the number 5 exist? : " + integerSet.exists(5));

        System.out.println("Let's see if the number 40 is still in our set by using exists()");
        System.out.println("Does the number 40 exist? : " + integerSet.exists(40));

        System.out.println("Print the last set below and conclude the integer set testing");
        System.out.println("Final " + integerSet.toString());
        System.out.println("Final size of the set is " + integerSet.size());
        System.out.println("----- ENDED TESTING FOR INTEGER SET ----");
    }

    //  This method will test SortedSet with Strings
    public static void testStrings() {
        System.out.println("----- Test With Strings Below ----");

        //  Print the set using toString() method
        System.out.println("The stringSet will be 'Hello', 'Make', 'Yikes', 'Sheesh'.The below is getting the Sorted Set using toString()");
        SortedSet<String> stringSet = new SortedSet("Hello", "Make", "Yikes", "Sheesh");
        System.out.println("Printing array using toString() " + stringSet.toString());

        //  Print the set after adding new values
        stringSet.addAll("Fox", "Apple", "Nice", "Burrito");
        System.out.println("Values to be added are 'Fox', 'Apple', 'Nice', and 'Burrito' to the stringSet array");
        System.out.println("After adding new values: " + stringSet.toString());


        //  Print the stringSet after removing Nice
        System.out.println("Remove the word 'Nice' from the set using remove()");
        stringSet.remove("Nice");
        System.out.println("After removing Nice: " + stringSet.toString());

        //  Add to the stringSet by using add
        System.out.println("Let's add one more word in the middle by using add('Grooming'). Let it be 'Grooming'");
        stringSet.add("Grooming");
        System.out.println("After adding Grooming to the set using add(): " + stringSet.toString());

        //  Remove the word Fox by using remove()
        System.out.println("Let's remove the word Hello by using remove('Fox')");
        stringSet.remove("Fox");
        System.out.println("After removing 'Fox' by using remove()" + stringSet.toString());


        //  Check the exists method
        System.out.println("Let's see if the word 'Fox' is still in our set by using exists('Fox')");
        System.out.println("Does the word 'Fox' exist? : " + stringSet.exists("Fox"));

        System.out.println("Let's see if the word 'Hello' is in our set by using exists('Hello')");
        System.out.println("Does the word 'Hello' exist? : " + stringSet.exists("Hello"));

        //  Final printing stuff
        System.out.println("Print the last set below and conclude the string testing");
        System.out.println("Final " + stringSet.toString());
        System.out.println("Final size of the set is " + stringSet.size());
        System.out.println("----- ENDED TESTING FOR STRING SET ----");
    }

    //  Test intersection below
    public static void testIntersection() {
        System.out.println("-----Test Union Below with the following sets----");

        //  Print intSetOne
        SortedSet<Integer> intSetOne = new SortedSet(2, 4, 8, 10, 20, 19);
        System.out.println("Set one is " + intSetOne.toString());

        //  Print intSetTwo
        SortedSet<Integer> intSetTwo= new SortedSet(5, 2, 8, 10, 21, 19, 30);
        System.out.println("Set two is " + intSetTwo.toString());

        SortedSet<Integer> intersectionOne = SortedSetUtils.intersection(intSetOne, intSetTwo);
        System.out.println("Intersection solution for the above two integers sets is below");
        System.out.println(intersectionOne.toString());


        //  Try out with strings now

        //  Print setOne
        SortedSet<String> strSetOne = new SortedSet("Hello", "Mate", "Pizza", "Cookie", "World");
        System.out.println("Set one is " + strSetOne.toString());

        //  Print setTwo
        SortedSet<String> strSetTwo= new SortedSet("Bye", "Bro", "Pizza", "Cookie", "Sky");
        System.out.println("Set two is " + strSetTwo.toString());

        SortedSet<String> intersectionTwo = SortedSetUtils.intersection(strSetOne, strSetTwo);
        System.out.println("Intersection solution for the above two string sets is below");
        System.out.println(intersectionTwo.toString());

        System.out.println("-----INTERSECTION TESTS ENDED----");
    }

    //  Test Union below
    public static void testUnion() {
        System.out.println("-----Test Intersection Below with the following sets----");

        //  Print intSetOne
        SortedSet<Integer> intSetOne = new SortedSet(1, 2, 7, 9, 10, 20);
        System.out.println("Set one is " + intSetOne.toString());

        //  Print intSetTwo
        SortedSet<Integer> intSetTwo= new SortedSet(0, 3, 7, 9, 11, 15, 18);
        System.out.println("Set two is " + intSetTwo.toString());

        SortedSet<Integer> unionSetOne = SortedSetUtils.union(intSetOne, intSetTwo);
        System.out.println("Union solution for the above two integers sets is below");
        System.out.println(unionSetOne.toString());


        //  Try out with strings now

        //  Print setOne
        SortedSet<String> strSetOne = new SortedSet("Hello", "Bake", "Anime", "Wait", "Sky");
        System.out.println("Set one is " + strSetOne.toString());

        //  Print setTwo
        SortedSet<String> strSetTwo= new SortedSet("Apple", "Lime", "Anime", "Wait", "Orange", "Banana", "Sky");
        System.out.println("Set two is " + strSetTwo.toString());

        SortedSet<String> unionSetTwo = SortedSetUtils.intersection(strSetOne, strSetTwo);
        System.out.println("Union solution for the above two string sets is below");
        System.out.println(unionSetTwo.toString());

        System.out.println("-----UNION TESTS ENDED----");
    }
}
