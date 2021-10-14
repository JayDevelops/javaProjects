/*
* RobberMiniBoss.java Written By Jesus Perez Arias, CS 2012-01
*
* December 11, 2020
*
* It only has one data field and it is the value to take away the ammo from the player, acknowledged in GameLogic.java
*
* removeAmmoFromPlayer() when triggered removes the ammo from the player by negative one and
* removes the instance on the game grid, then sets the ammoToTakeAway to 0 as it no longer exists on the gameGrid
* */
package cs2012final;


import javafx.scene.text.Text;

public class RobberMiniBoss extends GameObject {
    /*  TODO: Default data field to take away one carrot from their ammo supply */
    private int ammoToTakeAway = -1;


    public RobberMiniBoss(Grid gameGrid, String spriteName, String picUrl, int xPos, int yPos) {
        super(gameGrid, spriteName, picUrl, xPos, yPos);
    }


    //  Get the current ammoToTakeAway value
    public int getAmmoToTakeAway() { return ammoToTakeAway; }


    //  Set the current ammoToGive to 0 if it's been used up
    public void setAmmoToTakeAway(int ammoToTakeAway) {
        this.ammoToTakeAway = ammoToTakeAway;
    }


    /*  TODO: Methods for the RobberMiniBoss below  */

    //  Method below will take away one ammo charge, carrot, from the player
    public void removeAmmoFromPlayer(Player player, Text ammoText, RobberMiniBoss robberBoss, Grid gameGrid) {
        //  Get the previous ammo of the player and set the count of ammo to the player
        int tempAmmo = player.getCountOfAmmo();
        player.setCountOfAmmo(tempAmmo + this.getAmmoToTakeAway());

        //  Set the ammoToTakeAway data field to 0 to stop taking away from the player
        setAmmoToTakeAway(0);

        //  Remove the robber sprite image from the game grid
        gameGrid.getChildren().remove(robberBoss.sprite);

        //  Update the ammoText to the new count now to the user
        ammoText.setText("Your Ammo: " + Integer.toString(player.getCountOfAmmo()));
    }
}
