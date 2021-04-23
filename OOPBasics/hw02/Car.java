/*
    Written by Jesus Perez on September 4, 2020.
    THIS FILE: Car.java demonstrates has two constructors, one for the default values and another to change declare new values when made into an instance.
               The data fields are color, name, modelYear, position, numberOfDoors, numOfPeopleInCar.

               In each car, a four door car can typically hold up to 5 people while typically a two door car can hold only two people,
               this class makes sure those conditions are being followed in the setters and the methods.

               The methods for the Car class are peopleOut (which decreases the number of people in the car),
               peopleIn (which increases the number of people in the car) and a printAll method to print all characteristics out.
               There is also a drive method to increase the position of the car (in either a negative value or positive value, as
               long as the distance is not 0) to the position data-field.
*/


package hw02;

public class Car {
    /* TODO: Data fields for the car below  */
    String color, name;     //  Color and name of the car
    int modelYear, position, numberOfDoors;    //  Model year of the car, the position of the car, and number of doors the car has
    int numOfPeopleInCar;   //  This keeps track how many people are in the car


    /*  TODO: Constructors for default values and program change later on   */


    //  Constructor to initialize the default values of the car
    public Car() {
        this.color = "test white";
        this.name = "test name";
        this.modelYear = 1999;  //  Model year default value
        this.position = 0;  //  Position of car starts at 0
        this.numberOfDoors = 2; //  Number of doors default value
        this.numOfPeopleInCar = 1;  //  Number of people in car default value, usually a 4 door car holds 5 people
    }


    //  Constructor to change default values when a new instance is created
    public Car(String color, String name, int modelYear, int position, int numberOfDoors, int numOfPeopleInCar) {
        this.color = color;
        this.name = name;
        this.modelYear = modelYear;
        this.position = position;
        this.numberOfDoors = numberOfDoors;
        this.numOfPeopleInCar = numOfPeopleInCar;
    }



    /*  TODO: Create setters and getters of each data field   */

    //  Getter and setter for the color of the car
    public String getColor() { return this.color; }
    public void setColor(String color) { this.color = color; }


    //  Getter and setter for the name of the car
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }


    //  Getter and setter for the model year below
    public int getModelYear() { return this.modelYear; }
    public void setModelYear(int modelYear) {
        if (modelYear <= 0) {
            System.out.println("This is an invalid model year, the year cannot be less than or equal to 0. Try again.");
        } else {
            this.modelYear = modelYear;
        }
    }

    //  Getter and setter for the position of the car
    public int getPosition() { return this.position; }
    public void setPosition(int position) { this.position = position; }


    //  Getter and setter for the number of doors of the car
    public int getNumberOfDoors() { return this.numberOfDoors; }
    public void setNumberOfDoors(int numberOfDoors) {
        if (numberOfDoors <= 0) {
            System.out.println("Come on, can a car really have less than or equal to 0 doors? Input a valid number.");
        } else {
            this.numberOfDoors = numberOfDoors;
        }
    }


    //  Getter and setter for the number of people in the car
    public int getNumOfPeopleInCar() { return this.numOfPeopleInCar; }
    public void setNumOfPeopleInCar(int numOfPeopleInCar) {
        if(numOfPeopleInCar < 0) {
            System.out.println("come on, a car cannot have less than 0 people. Input a valid number.");
        } else if(numOfPeopleInCar > 5 && numberOfDoors <= 4) {
            System.out.println("More than five people can't fit inside a 4 dour car, try again");
        } else {
            this.numOfPeopleInCar = numOfPeopleInCar;
        }
    }



    /*  TODO: Methods for the car below   */

    //  Method to add a new position when there is a distance the car travelled
    public void drive(int distance) {
        if (distance == 0) {
            System.out.println("Come on, the car didn't drive if moved 0 units. Try again");
        } else {
            this.position += distance;
        }
    }

    //  Method to add one person into the car
    public void peopleIn() {
        int numDoors = this.numberOfDoors;
        int numPeople = this.numOfPeopleInCar;

        if (numDoors <= 2 && numPeople > 2) {
            System.out.println("Can't fit more than 2 people in a two door car, please try again.");
        } else if (numDoors >= 4 && numPeople >= 5 ) {
            System.out.println("Can't fit more than than 5 people in a four door car, please try again.");
        } else {
            this.numOfPeopleInCar++; //  Add one person inside the car
        }
    }

    //  Method to take out one person in the car
    public void peopleOut() {
        if(this.numOfPeopleInCar <= 0) {
            System.out.println("Can't take out 0 people in an empty car, try again. ");
        } else {
            this.numOfPeopleInCar--; //  Subtract one person inside the car
        }
    }

    //  Method to print out all the data fields of the "Car"
    public void printAllProps(String whichCar) {
        System.out.println("\nBelow are the properties of the " + whichCar);
        System.out.println("The color of the car is " + this.color);
        System.out.println("The name of the car is " + this.name);
        System.out.println("The model year of the car is " + this.modelYear);
        System.out.println("The current position of the car is " + this.position);
        System.out.println("The number of doors the car has is " + this.numberOfDoors);
        System.out.println("The number of people in the car is " + this.numOfPeopleInCar + "\n");
    }
}
