/*
*
* Game.java Written By Jesus Perez Arias, CS 2012-01
* December 10, 2020
*
*
* DATA FIELDS
*   Grid gameGrid
*       holds the current game grid which will differ the row sizes and columns sizes, to place everything in bounds of a Grid
*       Grid extends GridPane in Grid.java
*    Scene mainMenu, gameScene, gameOverScene
*       the game switches between these three scenes, the flow is from mainMenu to gameScene and gameOverScene.
*       mainMenu is the place where they will see the main menu.
*       gameScene is where the player will be able to play the game.
*
* METHODS
*   startGame()
*       will start a new game with the appropriate mini bosses, final boss and items onto the grid within
*       the Grid bounds in random positions, we also add all the layouts to the appropriate scenes here.
*
*   endGame()
*       Will parameter a stage to close the current window and transition to a newGame if the user wishes to do so.
*       It also takes a parameter string indicating if the player lost or won
*
*   initGameGridWithScene()
*       Will hold the code where it will make new instances of every GameObject and hold them in their respective
*       ArrayLists and will be passed to the gameLogic.
*
*   startLayoutButton()
*       Will be the button which will hold all the initGameGridWithScene() and create the buttons, creatures, etc
*       and add them to the gameLayout object which is held in the gameScene
*
*
*   The private methods are not to be used anywhere else and are only helper methods to initialize an instance
*   and return them as an ArrayList of their instance type (FinalBoss, MoveMiniBoss, RobberMiniBoss, BoostCharger).
* */
package cs2012final;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public final class Game {
    /* TODO: Data Fields of NewGame  */
    Grid gameGrid;  //  Create the gameGrid data field which will be changed in the buttons arrow functions
    Scene mainMenu, gameScene, gameOverScene;      //  The below scenes will be switched from the main menu to the game grid

    //  TODO: Method to start the game
    public void startGame(Stage window) {
        //  TODO: Create a back button for the Game Scene
        Button backButton = new Button("Go back to Main Menu");
        backButton.setOnAction(e -> {
            window.setScene(mainMenu);
        });


        //  TODO: Create three buttons for the user to choose with their own custom grid
        Button fiveByFiveButt = startLayoutButton(backButton, "5 x 5 Grid", 5, 5, mainMenu, window);
        Button sevenButt = startLayoutButton(backButton, "7 x 7 Grid", 7, 7, mainMenu, window);
        Button tenBySevenButt = startLayoutButton(backButton, "10 x 7 Grid", 10, 7, mainMenu, window);


        // TODO: Set up the main menu layout by adding all buttons to a VBox
        Text mainLabel = new Text("Choose Your Custom Grid Size Below");
        mainLabel.setLineSpacing(1.5);

        VBox mainLayout = new VBox(20);
        mainLayout.getChildren().addAll(mainLabel, fiveByFiveButt, sevenButt, tenBySevenButt);
        mainLayout.setAlignment(Pos.CENTER);
        mainMenu = new Scene(mainLayout, 300, 300);

        //  TODO: Add the styles to the the mainMenu scene and show mainMenu first to the user
        window.setTitle("Kill Bad Santa");  //  Set the title of the game on the window
        window.setScene(mainMenu);   //  add the scene to the window
        window.show();              //  show the window now
    }

    //  TODO: Method returns a button with gridSize and initializes the game scene
    private Button startLayoutButton(Button backButton, String buttonTitle, int rowSize, int colSize, Scene mainMenu, Stage stage) {
        //  Make a new new button which will be returned as a Grid option layout, and the button will create a new game board
        Button button = new Button(buttonTitle);

        button.setOnAction(event -> {
            //  Init the gameGrid with initGameGridWithScene() method with the gameScene and add it to the gameScene
            initGameGridWithScene(backButton, buttonTitle, rowSize, colSize, mainMenu, stage);
        });

        return button;
    }

    //  TODO: Method to initialize the gameGrid and add it to the gameScene
    private void initGameGridWithScene(Button backButton, String buttonTitle, int rowSize, int colSize, Scene mainMenu, Stage stage) {
        //  CREATE A RANDOM POSITION TO STORE FOR LATER ON
        Position position = new Position();

        //  Create a "untilLimit" to create an array of instances for later use
        int untilLimit = 0;

        //  Create a window width and window length to find out which one to use for the appropriate rowSizes and colSizes grids
        int sceneWidth = 0;
        int sceneLength = 0;

        //  Inside the arrow function, create a Game Grid with the user selected rows and cols
        gameGrid = new Grid(rowSize, colSize, 400);
        gameGrid.translateYProperty().set(50);


        //  Make a Pane to hold the Grid and the backButton
        Pane gameLayout = new Pane();
        gameLayout.getChildren().addAll(gameGrid, backButton);

        /* TODO: Add the game objects to the gameGrid now */

        //  TODO: First, create the player to the game grid and initialize the player props onto the gameScene
        int[] ranPlayerPos = position.createRandomPosition(gameGrid);
        Player player = new Player(gameGrid, "Player", "snowman.png", ranPlayerPos[0], ranPlayerPos[1]);

        //  TODO: Create a text to get the count of ammo for the player and add it to the gameLayout pane
        Text ammoText = new Text("Your Ammo: " + Integer.toString(player.getCountOfAmmo()));
        ammoText.translateYProperty().set(45);
        gameLayout.getChildren().add(ammoText);;


        //  Make a different amount of bosses, depending on the rowSize
        if (rowSize == 10) {
            //  UntilLimit will have 6 to start then decrement by 1 starting form robbers to teleporters to carrot boosters
            untilLimit = 6;

            //  sceneWidth and sceneLength for appropriate grid with rowSize 10 below
            sceneWidth = 700;
            sceneLength= 800;
        } else if(rowSize == 7) {
            //  UntilLimit will have 5 to start then decrement by 1 starting form robbers to teleporters to carrot boosters
            untilLimit = 5;

            //  sceneWidth and sceneLength for appropriate grid with rowSize 10 below
            sceneWidth = 690;
            sceneLength = 650;
        } else {
            //  UntilLimit will have 4 to start then decrement by 1 starting form robbers to teleporters to carrot boosters
            untilLimit = 6;

            //  sceneWidth and sceneLength for appropriate grid with rowSize 10 below
            sceneWidth = 600;
            sceneLength = 500;
        }

        //  TODO: Second, create carrot boosters which will increment the counterAmmo for the player by one, add to the gameGrid
        ArrayList<BoostCharger> carrotBoosters = createCarrotBoosters(untilLimit - 2, gameGrid);

        //  TODO: Third, create the teleportBosses with the untilLimit minus one, add to the gameGrid
        ArrayList<MoveMiniBoss> teleportBosses = createTeleportBosses(untilLimit - 1, gameGrid);

        //  TODO: Fourth, add the robberBosses with the untilLimit, add to the gameGrid
        ArrayList<RobberMiniBoss> robberBosses = createRobbers(untilLimit, gameGrid);

        //  TODO: Fifth, add the Final Boss, evil santa, to the game grid
        FinalBoss finalBoss = checkPlayerAndBoss(ranPlayerPos, gameGrid);
        finalBoss.setSpriteImageOpacity(0.0);   //  Hide the finalBoss by default


        
        //  TODO: Create a text to get the finalSanta health for finalBoss and add it to the gameLayout pane
        Text finalHealth = new Text("Boss Health: " + Integer.toString(finalBoss.getHealth()));
        finalHealth.translateYProperty().set(45);
        finalHealth.translateXProperty().set(200);
        gameLayout.getChildren().add(finalHealth);;

        //  TODO: Pass all the game objects to the GameLogic Instance to keep track of game functionality
        GameLogic gameLogic = new GameLogic(ammoText, finalHealth, player, finalBoss, carrotBoosters, robberBosses, teleportBosses, gameGrid, gameLayout);

        //  TODO: Create a button to try to shoot the evil santa and add it to the gameLayout
        double constraintWidth = sceneWidth - 200.0;
        Button shootButton = new Button("Shoot the Evil Santa");
        shootButton.translateXProperty().set(constraintWidth);
        shootButton.setOnAction(e -> {
            gameLogic.tryToShootSanta(stage);
            gameLogic.checkSantaHealth(stage);
        });
        gameLayout.getChildren().add(shootButton);


        //  TODO: Create a button to toggle on and off the gameObjects opacity to 0 or 1 (debug mode) button
        Button debugButton = new Button("Debug Button");
        debugButton.translateXProperty().set(constraintWidth + 20);
        debugButton.translateYProperty().set(300);
        debugButton.setOnAction(e -> {
            gameLogic.debugMode();
        });
        gameLayout.getChildren().add(debugButton);

        //  Finally, init the game scene and add it to the stage
        gameScene = new Scene(gameLayout, sceneWidth, sceneLength);
        stage.setScene(gameScene);

        //  In case the player lands randomly in a room already with a game object, call playerMovedThenTrigger
        playerMovedThenTrigger(stage, ammoText, gameLogic);

        //  TODO: Add a keyListener to the gameScene, when keys are pressed for the player
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case W:
                        player.moveUp(gameGrid);
                        playerMovedThenTrigger(stage, ammoText, gameLogic);
                        break;
                    case S:
                        player.moveDown(gameGrid);
                        playerMovedThenTrigger(stage, ammoText, gameLogic);
                        break;
                    case A:
                        player.moveLeft(gameGrid);
                        playerMovedThenTrigger(stage, ammoText, gameLogic);
                        break;
                    case D:
                        player.moveRight(gameGrid);
                        playerMovedThenTrigger(stage, ammoText, gameLogic);
                        break;
                }
            }
        });
    }

    //  Check if the player and final boss position isn't the same, then return a final boss
    private FinalBoss checkPlayerAndBoss(int[] ranPlayerPos, Grid gameGrid) {
        //  Init a position to generate a random position
        Position pos = new Position();
        int[] ranBossPos = pos.createRandomPosition(gameGrid);

        FinalBoss finalBoss = new FinalBoss(gameGrid, "Santa", "evilSanta.png", ranBossPos[0], ranBossPos[1]);;

        //  If the player x position is the same as the boss position, then proceed
        if(ranBossPos[0] == ranPlayerPos[0]) {
            //  If the xPosition is less than the row Size, then add one
            if(finalBoss.getxPos() < gameGrid.getColSize()) {
                finalBoss.setxPos(finalBoss.getxPos() + 1);
            } else {
                finalBoss.setxPos(finalBoss.getxPos() - 1);
            }
        }

        return finalBoss;
    }

    //  TODO: Method to combine the trigger of checking the all the gameLogic after moving in any position
    private void playerMovedThenTrigger(Stage stage, Text ammoText, GameLogic gameLogic) {
        //  First check if the player is in the same room as the boss to instantly end the game
        gameLogic.comparePlayerPosToBoss(stage);

        //  Second, check if the player is in the same room as a teleport chimney to move the player to a random position
        gameLogic.comparePlayerToTeleportBoss();

        //  Third, check if the player is in the same room as a carrot booster charger to increment the ammo count
        gameLogic.comparePlayerToBoostCharger(ammoText);

        //  Fourth, check if the player is in the same room as a robber to decremeent the ammo count
        gameLogic.comparePlayerToRobberBoss(ammoText);
    }



    /*  TODO: BELOW METHODS WILL INITIALIZE THE ENEMY OR ITEM INSTANCES AND HOLD RETURN AN ARRAYLIST   */

    //  TODO: Method to create a random amount of RobberMiniBosses and populate to a random position in the grid
    private ArrayList<RobberMiniBoss> createRobbers(int untilLimit, Grid gameGrid) {
        //  Create an array to store all the robbers inside then return it
        ArrayList<RobberMiniBoss> robbers = new ArrayList<RobberMiniBoss>();

        //  Have a counter to track up until the limit
        int counter = 1;

        while(counter < untilLimit) {
            //  Create a new random position each time the loop is runned
            Position pos = new Position();
            int[] randomPos = pos.createRandomPosition(gameGrid);

            //  Make a robber with a random position
            RobberMiniBoss eachRobber = new RobberMiniBoss(gameGrid, "Baby" + Integer.toString(counter), "hungryBaby.png", randomPos[0], randomPos[1]);
            eachRobber.setSpriteImageOpacity(0.0);

            //  Finally, add eachRobber to the robbers array and increment the counter
            robbers.add(eachRobber);
            counter++;
        }
        return robbers;
    }


    //  TODO: Method to create a random amount of MoveMiniBosses and populate to a random position in a grid
    private ArrayList<MoveMiniBoss> createTeleportBosses(int untilLimit, Grid gameGrid) {
        //  Create an array to store all the robbers inside then return it
        ArrayList<MoveMiniBoss> teleportBosses = new ArrayList<MoveMiniBoss>();

        //  Have a counter to track up until the limit
        int index = 1;

        while(index < untilLimit) {
            //  Create a new position each time
            Position pos = new Position();
            int[] randomPos = pos.createRandomPosition(gameGrid);

            //  Make a robber with a random position
            MoveMiniBoss eachTeleportBoss = new MoveMiniBoss(gameGrid, "Chimney" + Integer.toString(index), "teleportChimney.png", randomPos[0], randomPos[1]);
            eachTeleportBoss.setSpriteImageOpacity(0.0);    //  Hide the images by default
            //  Finally, add eachRobber to the robbers array
            teleportBosses.add(eachTeleportBoss);
            index++;
        }
        return teleportBosses;
    }


    //  TODO: Method to create a random amount of carrotBoosters (BoostCharger) and populate to random position on grid
    private ArrayList<BoostCharger> createCarrotBoosters(int untilLimit, Grid gameGrid) {
        //  Create an array to store all the robbers inside then return it
        ArrayList<BoostCharger> carrotBoosters = new ArrayList<BoostCharger>();

        //  Have a counter to track up until the limit
        int index = 1;

        while(index < untilLimit) {
            //  Create a new position each time
            Position pos = new Position();
            int[] randomPos = pos.createRandomPosition(gameGrid);

            //  Make a robber with a random position
            BoostCharger eachCarrotBooster = new BoostCharger(gameGrid, "Carrot" + Integer.toString(index), "carrotBooster.png", randomPos[0], randomPos[1]);
            eachCarrotBooster.setSpriteImageOpacity(0.0);   //  Hide the images by default
            //  Finally, add eachRobber to the robbers array
            carrotBoosters.add(eachCarrotBooster);
            index++;
        }
        return carrotBoosters;
    }


    //  TODO: Method to show a "endGame" scene when shown and end the game when it is called
    public void endGame(Stage window, String finalText) {
        //  First, create a back button to return to the main scene and text saying "Game Over"
        Text gameOver = new Text(finalText);
        Button backToMain = new Button("Start Again");
        backToMain.setOnAction(e -> {
            //  This lambda expression will close the current Stage and will initiate a newGame once again
            window.close();
            Game newGame = new Game();
            newGame.startGame(window);
        });

        //  Create a backLayout where it will have a button to go back with text "Game Over"
        VBox backLayout = new VBox(20);
        backLayout.setAlignment(Pos.CENTER);
        backLayout.getChildren().addAll(gameOver, backToMain);

        //  Create a new gameOverScene and populate it with the backLayout to go back to the mainMenu scene
        Scene gameOverScene = new Scene(backLayout, 400, 400);

        //  Set the scene to the the gameOver scene and show it
        window.setScene(gameOverScene);
        window.show();
    }

}
