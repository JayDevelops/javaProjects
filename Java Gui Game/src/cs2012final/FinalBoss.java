/*
*
* FinalBoss.java Written By Jesus Perez Arias, CS 2012-01
* December 10, 2020
*
*
* Only has one data field for the final boss, with getter and setter.
* Once the health reaches 0 then the GameLogic class will take note of this change
* and will show the screen of "You Win, Game Over"
*
*
* */
package cs2012final;

import javafx.stage.Stage;

public class FinalBoss extends GameObject {
    //  Data field for finalBoss below, starting health level
    private int health = 3;

    public FinalBoss(Grid gameGrid, String spriteName, String picUrl, int xPos, int yPos) {
        super(gameGrid, spriteName, picUrl, xPos, yPos);
    }

    /*  TODO: Methods for the finalBoss go below  */

    //  Getter for the finalBoss health
    public int getHealth() { return health; }

    //  Setter for the finalBoss health
    public void setHealth(int health) { this.health = health; }

    //  Method to check if the player is in the same room (xPos, yPos) and if true then end the game
    public void isGameOver(Player player, Stage window) {
        //  If the player is in a room with the finalBoss, then show a "Game Over" scene
        if ((this.getxPos() == player.getxPos()) && (this.getyPos() == player.getyPos())) {
            //  Make a new Game instance and call "endGame" to end the game
            Game game = new Game();
            game.endGame(window, "Game Over, You Lost");
        }
    }


}
