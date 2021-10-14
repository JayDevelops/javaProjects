/*
*
* MoveMiniBoss.java Written By Jesus Perez Arias, CS 2012-01
* December 10, 2020
*
*
* This subclass of GameObject will land your player to a random position of the Grid.
*
* It only had one data field (with getter and setter) and it is canMovePlayer, which is true by default. It will only turn false
* when the movePlayer() method is called, where it will remove the MoveMiniBoss image from the grid and
* can no longer move the player because it doesn't exit on the GameGrid now.
*
*
*
*/
package cs2012final;


public class MoveMiniBoss extends GameObject {
    //  canMovePlayer will be able to move a player once, then afterwards can no longer move the player
    private boolean canMovePlayer = true;

    //  Constructor of the MoveMiniBoss class
    public MoveMiniBoss(Grid gameGrid, String spriteName, String picUrl, int xPos, int yPos) {
        super(gameGrid, spriteName, picUrl, xPos, yPos);
    }


    /*  TODO: Create methods for the MoveMiniBoss   */

    //  Get the current canMovePlayer status
    public boolean isCanMovePlayer() { return canMovePlayer; }

    //  Set the current canMovePlayer status
    public void setCanMovePlayer(boolean canMovePlayer) {
        this.canMovePlayer = canMovePlayer;
    }

    //  Method will be able to move a player to a random position
    public void movePlayer(Player player, MoveMiniBoss teleportBoss, Grid gameGrid) {
        //  If canMovePlayer is true then do the following
        if(canMovePlayer) {
            //  Teleport the player to a random position on the grid
            player.teleportPlayer(gameGrid);

            //  Set the status to false so this boss can't move the player anymore
            setCanMovePlayer(false);

            //  Remove the mini boss from the gameGrid
            gameGrid.getChildren().remove(teleportBoss.sprite);
        }
    }
}
