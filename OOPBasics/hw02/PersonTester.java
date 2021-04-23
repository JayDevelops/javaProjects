/*
    WRITTEN BY Jesus Perez Arias on September 4, 2020.
    THIS FILE: PersonTester.java demonstrates creates two instances of a Person class (one default, the other custom),
               prints out all properties of both instances then change properties using setters for each and then
               prints out all the properties once again. Finally the methods of each instance are called to show
               they're working.
               .takesMedicine increases the health level of the individual object and the
               .eatsMeal decreases the hunger level of the individual object. At the end, the getters
               are used to print out all final properties, to ensure the getters are working.
*/

package hw02;

public class PersonTester {
    public static void main(String[] args) {
        //  Create a default and new custom instance of Person class
        Person personOne = new Person();
        Person personTwo = new Person("Peter Parker", "New York", "male", 90.5, 40.5, 16);



        //  TODO: Print out all properties of Person class
        personOne.printAll("Person One");
        personTwo.printAll("Person Two");

        //  TODO: Change the properties of personOne
        personOne.setName("Katy Mclean");
        personOne.setAge(20);
        personOne.setGender("female");
        personOne.setCity("Chicago");
        personOne.setHealthLevel(80);
        personOne.setHealthLevel(-10);  //  Print error
        personOne.setHungerLevel(80);
        personOne.setHungerLevel(120);  //  Print error
        System.out.println();   // spacer

        //  Print the characteristics of personOne as they have changed
        personOne.printAll("Person One");
        System.out.println();   // spacer

        //  TODO: Call the methods for personOne
        personOne.eatsMeal();
        personOne.eatsMeal();   //  Will return 20.0
        personOne.eatsMeal();   //  Will not decrement and stay to the previous level
        System.out.println("Person's one hunger level is " + personOne.getHungerLevel() + "\n");

        personOne.takesMedicine();  //  Will be 90
        personOne.takesMedicine();  //  Will be 100
        personOne.takesMedicine();  //  Will not increment because it reached the limit of 100
        System.out.println("Person's health level is " + personOne.getHealthLevel() + "\n");



        //  TODO: Change the properties of personTwo
        personTwo.setName("Richard Henderson");
        personTwo.setAge(28);
        personTwo.setGender("male");
        personTwo.setCity("Silicon Valley");
        personTwo.setHealthLevel(90);
        personTwo.setHealthLevel(-1);  //  Print error
        personTwo.setHungerLevel(10);
        personTwo.setHungerLevel(120);  //  Print error
        System.out.println();   // spacer

        //  Print the characteristics of personTwo as they have changed
        personTwo.printAll("Person Two");

        //  TODO: Call the methods for personOne
        personTwo.eatsMeal();   //  Will not decrement and stay to the previous level
        System.out.println("Person's two hunger level is " + personTwo.getHungerLevel() + "\n");

        personTwo.takesMedicine();  //  Will return 100.0
        System.out.println("Person's two health level is " + personTwo.getHealthLevel() + "\n");



        //  TODO: Getters for the methods for each instance
        System.out.println("\nGetters working for Person One below");
        System.out.println("Person One Name: " + personOne.getName());
        System.out.println("Person One Age: " + personOne.getAge());
        System.out.println("Person One Gender: " + personOne.getGender());
        System.out.println("Person One City: " + personOne.getCity());
        System.out.println("Person Health Level: " + personOne.getHealthLevel());
        System.out.println("Person Hunger Level: " + personOne.getHungerLevel() + "\n");


        System.out.println("\nGetters working for Person Two below");
        System.out.println("Person Two Name: " + personTwo.getName());
        System.out.println("Person Two Age: " + personTwo.getAge());
        System.out.println("Person Two Gender: " + personTwo.getGender());
        System.out.println("Person Two City: " + personTwo.getCity());
        System.out.println("Person Two Health Level: " + personTwo.getHealthLevel());
        System.out.println("Person Two Hunger Level: " + personTwo.getHungerLevel() + "\n");
    }
}
