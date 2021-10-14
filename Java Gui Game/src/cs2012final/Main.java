/*
* Main.java Written By Jesus Perez Arias, CS 2012-01
* December 10, 2020
*
* Run this file to start the game, this is only where I pass the Stage window
* to the Game instance, there is useful methods as allowing me to start a newGame by simply
* writing
*   Game newGame = new Game();
*   newGame.startGame(window);
* to init a new game.
*
* */
package cs2012final;


import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage window) throws Exception{
        Game newGame = new Game();
        newGame.startGame(window);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
