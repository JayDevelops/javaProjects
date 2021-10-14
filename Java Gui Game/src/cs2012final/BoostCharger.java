/*
* BoostCharger.java Written By Jesus Perez Arias, CS 2012-01
* December 10, 2020
*
*
* Only has one data field for BoostCharger, with getter and setter.
*
* Each instance of BoostCharger will only be allowed to give one piece of ammo to the player, after that
* then the giveAmmoToPlayer() will be called and change the data field to 0 and remove it from the grid
* as it no longer exists on the gameGrid.
*
* */
package cs2012final;

import javafx.scene.text.Text;

public class BoostCharger extends GameObject {
    /*  TODO: Default data field to give the player one more carrot to their ammo supply */
    private int ammoToGive = 1;

    public BoostCharger(Grid gameGrid, String spriteName, String picUrl, int xPos, int yPos) {
        super(gameGrid, spriteName, picUrl, xPos, yPos);
    }

    /*  TODO: Methods for the BoostCharger class   */
    //  Get the current ammoToGive value
    public int getAmmoToGive() { return ammoToGive; }


    //  Set the current ammoToGive to 0 if it's been used up
    public void setAmmoToGive(int ammoToGive) {
        this.ammoToGive = ammoToGive;
    }


    /*  TODO: Methods for BoostCharger below*/

    //  giveAmmoToPlayer method will give it's ammoToGive to the player, remove the picURL and decrease ammoToGive by one
    public void giveAmmoToPlayer(Player player, Text ammoText, BoostCharger carrotCharger, Grid gameGrid) {
        //  Get the previous ammo of the player and set the count of ammo to the player
        int tempAmmo = player.getCountOfAmmo();
        player.setCountOfAmmo(tempAmmo + this.getAmmoToGive());

        //  Set the ammoToGive data field to 0 to stop adding to the player count now
        setAmmoToGive(0);

        //  Remove the sprite image from the game grid
        gameGrid.getChildren().remove(carrotCharger.sprite);

        //  Update the ammoText to the new count now to the user
        ammoText.setText("Your Ammo: " + Integer.toString(player.getCountOfAmmo()));
    }





}
