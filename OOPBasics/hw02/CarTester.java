/*
    WRITTEN BY Jesus Perez Arias on September 4, 2020.
    THIS FILE: CarTester.java demonstrates creates two instances of a Car class (one default, the other custom),
               prints out all properties of both instances then change properties using setters for each and then
               prints out all the properties once again. Finally the methods of each instance are called to show
               they're working.
               .peopleOut decreases the numOfPeople in the car and the
               .peopleIn increases  the numOfPeople in the car.
               .drive increases the position of the car by the number in the call.

               At the end, the getters
               are used to print out all final properties, to ensure the getters are working.
*/

package hw02;

public class CarTester {
    public static void main(String[] args) {
        //  TODO: Create a default and new instance of Car
        Car carOne = new Car();
        Car carTwo = new Car("black", "Honda", 2019, 0, 2, 1);


        // TODO: Print out all properties of respective car
        carOne.printAllProps("First Car");
        carTwo.printAllProps("Second Car");
        System.out.println("\n"); // Spacer


        //  TODO: Change the values of the first default Car
        carOne.setColor("red");
        carOne.setName("cadillac");
        carOne.setModelYear(1999);
        carOne.setModelYear(0); //  Will print out error: "... the year cannot be less than or equal to 0"
        carOne.setPosition(20); //  Position is at 20
        carOne.setNumberOfDoors(4);
        carOne.setNumberOfDoors(0); //  Will print out error: "...can a car really have less than or equal to 0 doors?"
        carOne.setNumOfPeopleInCar(4);
        carOne.setNumOfPeopleInCar(6);  //  Will print out error: "More than five people can't fit..."
        System.out.println("\n");   // Spacer

        //  Now print out the carOne object props again, as they have changed
        carOne.printAllProps("First Car");



        //  TODO: Call the methods of the first car
        carOne.peopleOut();
        System.out.println("Number of people in car one: " + carOne.getNumOfPeopleInCar());  //  Will print out '1'

        carOne.peopleIn();
        carOne.peopleIn();
        carOne.peopleIn();  //  Will print error saying "can't fit more than 5 people in a four door car"
        System.out.println("Number of people in car one: " + carOne.getNumOfPeopleInCar() + "\n");

        carTwo.drive(40);   //  Increments position by 40
        System.out.println("Position of carOne: " + carOne.getPosition() + "\n");



        //  TODO: change the values of the second car
        carTwo.setColor("grey");
        carTwo.setName("Mercedes");
        carTwo.setModelYear(2020);
        carTwo.setModelYear(0); //  Will print out error: "... the year cannot be less than or equal to 0"
        carTwo.setPosition(50); //  Position is at 50
        carTwo.setNumberOfDoors(4);
        carTwo.setNumberOfDoors(0); //  Will print out error: "...can a car really have less than or equal to 0 doors?"
        carTwo.setNumOfPeopleInCar(3);
        carTwo.setNumOfPeopleInCar(10); //  Will print out error: "More than five people can't fit..."
        System.out.println("\n");   //  Spacer

        //  Now print out the carTwo object props again as they have changed
        carTwo.printAllProps("Second Car");



        //  TODO: Call the methods of the second car
        carTwo.peopleOut();
        carTwo.peopleOut();
        System.out.println("Number of people in car two: " + carTwo.getNumOfPeopleInCar());  //  Will print out '1'

        carTwo.peopleIn();
        carTwo.peopleIn();
        carTwo.peopleIn();
        carTwo.peopleIn();
        carTwo.peopleIn();  //  Will print error saying "can't fit more than 5 people in a four door car"
        System.out.println("Number of people in car two: " + carTwo.getNumOfPeopleInCar() + "\n");

        carTwo.drive(20);   //  Increments position by 20
        System.out.println("Current distance of car two is: " + carTwo.getPosition() + "/n");



        //  TODO: Getters for both instances below
        System.out.println("\nGetters working for car one below");
        System.out.println("Car one name: " + carOne.getName());
        System.out.println("Car one color: " + carOne.getColor());
        System.out.println("Car one model year: " + carOne.getColor());
        System.out.println("Car one current position: " + carOne.getPosition());
        System.out.println("Car one number of doors: " + carOne.getNumberOfDoors());
        System.out.println("Car one people in car: " + carOne.getNumOfPeopleInCar() + "\n") ;


        System.out.println("\nGetters working for car two below");
        System.out.println("Car two name: " + carTwo.getName());
        System.out.println("Car two color: " + carTwo.getColor());
        System.out.println("Car two model year: " + carTwo.getColor());
        System.out.println("Car two current position: " + carTwo.getPosition());
        System.out.println("Car two number of doors: " + carTwo.getNumberOfDoors());
        System.out.println("Car two people in car: " + carTwo.getNumOfPeopleInCar() + "\n");


    }
}
