/*
* Written By Jesus Perez Arias, CS 2012-01
* December 13, 2020
*
* Will take each GameObject, as well as the Text to manipulate to the game's functionality listed in the instruction manual.
*
* 
*
* */
package cs2012final;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GameLogic {
    /*  TODO: Data fields for GameLogic */
    Text ammoText, finalHealth; //  Holds the ammoText and final boss health to change the text alter on
    Player player;        //  This is the pass player instance
    FinalBoss finalBoss;  //  This is the final boss instance
    ArrayList<RobberMiniBoss> robberBosses;  //  This is the robber mini bosses (multiple) instance(s)
    ArrayList<MoveMiniBoss> teleportBosses;  //  This is the teleport mini bosses (multiple) instance(s)
    ArrayList<BoostCharger> carrotBoosters;  //  This is the ammo boosters (multiple) instanc(s)
    Pane gameLayout;    //  This is current gameLayout the player is being displayed
    Grid gameGrid;      //  The passed current game grid where the player is playing on

    /*  TODO: Custom constructor being passed the player, finalBoss and all the robber and teleport bosses  */
    public GameLogic(Text ammoText, Text finalHealth, Player player, FinalBoss finalBoss, ArrayList<BoostCharger> carrotBoosters, ArrayList<RobberMiniBoss> robberBosses, ArrayList<MoveMiniBoss> teleportBosses, Grid gameGrid, Pane gameLayout) {
        this.ammoText = ammoText;
        this.finalHealth = finalHealth;
        this.player = player;
        this.carrotBoosters = carrotBoosters;
        this.finalBoss = finalBoss;
        this.robberBosses = robberBosses;
        this.teleportBosses = teleportBosses;
        this.gameGrid = gameGrid;
        this.gameLayout = gameLayout;
    }


    /*  TODO: Create methods for the GameLogic class    */

    //  Method will check if the player is in the same room any of the bosses and potentially return a "gameOver" scene
    public void comparePlayerPosToBoss(Stage window) {
        // check if the player is in the same room (xPos, yPos), the isGameOver will successfully run and end game if true
        finalBoss.isGameOver(player, window);
    }

    //  Method checks if the player is in the same room (xPos, yPos) of a carrot booster, if true then increment the ammo of the player
    public void comparePlayerToBoostCharger(Text ammoText) {
        //  For eachBooster in carrotBoosters, try to find if the player position (x, y) matches any to any position of those boosters
        for(BoostCharger eachBooster: carrotBoosters) {
            //  If it isn't null and the positions match then call the "movePlayer" method from BoostCharger
            if(!(eachBooster == null) && (eachBooster.getxPos() == player.getxPos()) && (eachBooster.getyPos() == player.getyPos())) {
                //  Call the method of the booster to give ammo to player then remove itself from the game grid, found in BoostCharger
                eachBooster.giveAmmoToPlayer(this.player, ammoText, eachBooster, this.gameGrid);
            }
        }
    }

    //  Method checks if the player is in the same room of a robberBoss, if so then decrement the ammo of the player
    public void comparePlayerToRobberBoss(Text ammoText) {
        //  For eachRobber in robberBosses, try to find if the player position (x, y) matches any to any position of those robbers
        for(RobberMiniBoss eachRobber: robberBosses) {
            //  If it isn't null and the positions match then call the "removeAmmoFromPlayer" method from RobberMiniBoss class
            if(!(eachRobber == null) && (eachRobber.getxPos() == player.getxPos()) && (eachRobber.getyPos() == player.getyPos())) {
                //  Call the method of the booster to give ammo to player then remove itself from the game grid
                eachRobber.removeAmmoFromPlayer(this.player, ammoText, eachRobber, this.gameGrid);
            }
        }
    }

    //  Method checks if the player is in the same room of a teleportBoss, if so then move the player to a random position
    public void comparePlayerToTeleportBoss() {
        //  For eachTeleportBoss in teleportBosses, try to find if the player position matches to any position of the teleport bosses
        for(MoveMiniBoss eachTeleportBoss: teleportBosses) {
            //  If it isn't null and the positions match then call the "movePlayer" method from MoveMiniBoss
            if(!(eachTeleportBoss == null) && (eachTeleportBoss.getxPos() == player.getxPos()) && (eachTeleportBoss.getyPos() == player.getyPos())) {
                eachTeleportBoss.movePlayer(this.player, eachTeleportBoss, this.gameGrid);
            }
        }
    }

    //  Method to try and shoot santa. Only works if santa is above, left, right, or downwards of the player
    public void tryToShootSanta(Stage window) {
        //  check if the player is near santa boolean value
        Boolean isPlayerNearSanta = false;

        //  Store the boss position (x, y) below
        int bossXPos = this.finalBoss.getxPos();
        int bossYPos = this.finalBoss.getyPos();

        //  Store the players positions (x, y) below
        int playerXPos = this.player.getxPos();
        int playerYPos = this.player.getyPos();

        //  If the playerX position is the same as the bossXPosition then proceed
        if(playerXPos == bossXPos) {
            //  If the player's above y (y + 1) or below y (y - 1) then call playerShoots()
            if(playerYPos + 1 == bossYPos || playerYPos - 1 == bossYPos) {
                this.player.playerShoots(finalBoss);

                //  Update the finalHealth text and the chargerAmmo text below
                this.ammoText.setText("Your Ammo: " + Integer.toString(this.player.getCountOfAmmo()));
                this.finalHealth.setText("Boss Health: " + Integer.toString(this.finalBoss.getHealth()));
            }
        }

        //  If the playerY position is the same as the bossYPosition then proceed
        if(playerYPos == bossYPos) {
            //  If the player's right x (x + 1) or left matches then call playerShoots()
            if(playerXPos + 1 == bossXPos || playerXPos - 1 == bossXPos) {
                this.player.playerShoots(finalBoss);

                this.ammoText.setText("Your Ammo: " + Integer.toString(this.player.getCountOfAmmo()));
                this.finalHealth.setText("Boss Health: " + Integer.toString(finalBoss.getHealth()));
            }
        }

        //  If the player ammo somehow drops to 0 after clicking this button method, then end the game
        if(player.getCountOfAmmo() < 0) {
            Game game = new Game();
            game.endGame(window, "You");
        }
    }

    //  Method to check if santa has been defeated once the finalHealth is 0, then end the game
    public void checkSantaHealth(Stage window) {
        //  If the finalBoss health is 0 then call the "endGame" method
        if(finalBoss.getHealth() == 0) {
            Game game = new Game();
            game.endGame(window, "You Defeated Santa! Congrats on Winning the Game!!!");
        }
    }

    //  TODO: Create a debug method to toggle each image opacity to 0 or 1
    public void debugMode() {
        //  If the finalBoss opacity is already 0.0 then set it to 1.0
        if(finalBoss.getSpriteImageOpacity() == 0.0) {
            finalBoss.setSpriteImageOpacity(1.0);
        } else {
            //  Else, set the imageOpacity to 0.0
            finalBoss.setSpriteImageOpacity(0.0);
        }

        //  Iterate through eachRobber in the robberBosses
        for(RobberMiniBoss eachRobber: robberBosses) {
            //  If eachRobber's spriteImageOpacity is 0.0 then set it to 1.0
            if(eachRobber.getSpriteImageOpacity() == 0.0) {
                eachRobber.setSpriteImageOpacity(1.0);
            } else {
                //  Else set eachRobber's imageOpacity to 0.0
                eachRobber.setSpriteImageOpacity(0.0);
            }
        }

        //  Iterate through eachTeleportBoss in the teleportBosses
        for(MoveMiniBoss eachTeleportBoss: teleportBosses) {
            //  If eachTeleportBoss's spriteImageOpacity is 0.0 then set it to 1.0
            if(eachTeleportBoss.getSpriteImageOpacity() == 0.0) {
                eachTeleportBoss.setSpriteImageOpacity(1.0);
            } else {
                //  Else set eachTeleportBoss's imageOpacity to 0.0
                eachTeleportBoss.setSpriteImageOpacity(0.0);
            }
        }

        //  Iterate through eachCarrotBooster in the carrotBoosters
        for(BoostCharger eachCarrotBooster: carrotBoosters) {
            //  If eachCarrotBooster's spriteImageOpacity is 0.0 then set it to 1.0
            if(eachCarrotBooster.getSpriteImageOpacity() == 0.0) {
                eachCarrotBooster.setSpriteImageOpacity(1.0);
            } else {
                //  Else set eachTeleportBoss's imageOpacity to 0.0
                eachCarrotBooster.setSpriteImageOpacity(0.0);
            }
        }
    }
}
