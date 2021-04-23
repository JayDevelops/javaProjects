/*
    Written by Jesus Perez on September 4, 2020.
    THIS FILE: Person.java demonstrates has two constructors, one for the default values and another to change declare new values when made into an instance.
               The data fields are name, city, gender, healthLevel, hungerLevel, and age.
               The health level is out of 100 and the higher it increase to 100, the healthier a person is
               while the hunger level is out of 100 and the higher it increases to 100, the hungrier a person is.

               The methods for the Person class are takesMedicine (which increases the health level of Person),
               eatsMeal (which decreases the hunger level of Person) and a printAll method to print all characteristics out.
*/

package hw02;

public class Person {

    /*  Data fields of the person class below   */
    String name, city, gender;
    double healthLevel, hungerLevel;
    int age;


    /*  TODO: Constructors for default values and program change later on   */

    //  Default constructor for the hw02.Person class
    public Person() {
        this.name = "John Prosser"; //  Default Name of hw02.Person
        this.city = "Los Angeles";  //  Default city hw02.Person lives in
        this.gender = "male";   //  Default gender of hw02.Person
        this.healthLevel = 70.0;   //  Health level is out of 100, 100 being full health
        this.hungerLevel = 0.0; //  Hunger level can go up to 100, 100 being extremely hungry
        this.age = 18; //   Default age of hw02.Person
    }

    //  Constructor to change defaults of the hw02.Person class
    public Person(String name, String city, String gender, double healthLevel, double hungerLevel, int age) {
        this.name = name;
        this.city = city;
        this.gender = gender;
        this.healthLevel = healthLevel;
        this.hungerLevel = hungerLevel;
        this.age = age;
    }



    /* TODO: Create getters and setters for each data field */

    //  Getter and setter for the name
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    //  Getter and setter for the city they live in
    public String getCity() { return this.city; }
    public void setCity(String city) { this.city = city; }

    //  Getter and setter for the gender of hw02.Person
    public String getGender() { return this.gender; }
    public void setGender(String gender) { this.gender = gender; }

    //  Getter and setter for the health level of hw02.Person
    public double getHealthLevel() { return this.healthLevel; }
    public void setHealthLevel(double healthLevel) {
        if (healthLevel < 0.0) {
            System.out.println("Please input a non negative value for the health level of Person");
        } else if(healthLevel > 100.0){
            System.out.println("Please input a health level less than 100.0");
        } else {
            this.healthLevel = healthLevel;
        }
    }

    //  Getter and setter for the hungerLevel of a person
    public double getHungerLevel() { return this.hungerLevel; }
    public void setHungerLevel(double hungerLevel) {
        if (hungerLevel < 0.0) {
            System.out.println("Please input a non negative value for the hunger level of Person.");
        } else if (hungerLevel > 100.0) {
            System.out.println("Please input a hunger level less than 100.0");
        } else {
            this.hungerLevel = hungerLevel;
        }
    }

    //  Getter and setter for the age of hw02.Person
    public int getAge() { return this.age; }
    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Please input an age which is not a negative number");
        } else {
            this.age = age;
        }
    }


    /*  TODO: Create methods for the hw02.Person class   */

    //  Method when a Person eats a meal, their hunger level decreases
    public void eatsMeal() {
        if (this.hungerLevel <= 100.0 && this.hungerLevel >= 0) {
            //  Create a newHungerLevel from the current hunger level
            double newHungerLevel = this.hungerLevel - 30.0;

            //  If the newHungerLevel is less than 0, then keep the same hunger level; else assign to newHungerLevel
            this.hungerLevel = newHungerLevel < 0 ? this.hungerLevel : newHungerLevel;
        } else {
            System.out.println("The person has hunger level of " + hungerLevel + " and is satisfied.");
        }
    }

    //  Method when a person takes medicine, their health level increases
    public void takesMedicine() {
        if (this.healthLevel >= 0 && this.healthLevel <= 100) {
            //  Create a new health level from the current health level
            double newHealthLevel = this.healthLevel + 10.0;

            //  If the new health level is less than 100, assign the newHealthLevel; else keep the same health level
            this.healthLevel = newHealthLevel <= 100 ? newHealthLevel : this.healthLevel;
        } else {
            System.out.println("The person has health level of " + healthLevel + " and is healthy.");
        }
    }

    //  Method to print out all the Person data fields
    public void printAll(String whichPerson) {
        System.out.println("Below are the characteristics of " + whichPerson);

        System.out.println("Person's name: " + this.name);
        System.out.println("Person lives in: " + this.city);
        System.out.println("Person is " + this.gender);
        System.out.println("Person's health level is " + this.healthLevel);
        System.out.println("Person's hunger level is " + this.hungerLevel);
        System.out.println("Person's age is " + this.age + "\n");
    }


}
