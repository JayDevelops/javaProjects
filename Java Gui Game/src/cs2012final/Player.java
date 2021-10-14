/*
*
* Player.java Written By Jesus Perez Arias, CS 2012-01
* December 10, 2020
*
*
*
* It only had one data field (with getter and setter) and it is countOfAmmo.
* It will only turn false increment when it is acknowledged by the GameLogic
* to decrease it or increase it depending on the enemy where it landed on.
*
* It also has a move functionality of up, down, left right as represented by methods.
*
* Each time playerShoots() is triggered, finalBoss health decreases by one
*
* Each time teleportPlayer() is triggered, it moves the player to a random position.
*
*/
package cs2012final;


public class Player extends GameObject {
    /*  TODO: Data fields for the Player class below    */
    private int countOfAmmo;    //  How much ammo the player has remaining/has

    /* TODO: Create constructor to pass to the super constructor */
    public Player(Grid gameGrid, String spriteName, String picUrl, int xPos, int yPos) {
        super(gameGrid, spriteName, picUrl, xPos, yPos);
        this.countOfAmmo = 4;   //  Starts with three but will need 4 to defeat the final boss
    }


    /*  TODO: Add getters  and setters*/
    //  Getter for getting the amount of ammo remaining
    public int getCountOfAmmo() { return countOfAmmo; }

    //  Setter for setting the amount of ammo remaining
    public void setCountOfAmmo(int countOfAmmo) {
        if(countOfAmmo >= 0) {
            this.countOfAmmo = countOfAmmo;
        } else {
            this.countOfAmmo = 0;
        }
    }

    /*  TODO: Create methods for Player below   */

    //  Method to moveUp for the player and decrease the current yPosition
    public void moveUp(Grid gameGrid) {
        //  First, remove the image from the gameGrid (which is the sprite data field)
        gameGrid.getChildren().remove(this.sprite);

        //  Second, reassign a new sprite with the picUrl
        this.sprite = this.createSprite(this.picUrl);

        //  Third, set the yPosition by the last yPosition and adding one
        setyPos(this.getyPos() - 1);

        //  Finally, set the new sprite image with the updated x and y positions
        gameGrid.add(this.sprite, this.getxPos(), this.getyPos());
    }

    //  Method to moveDown for the player and add one to the current yPosition
    public void moveDown(Grid gameGrid) {
        //  First, remove the image from the gameGrid (which is the sprite data field)
        gameGrid.getChildren().remove(this.sprite);

        //  Second, reassign a new sprite with the picUrl
        this.sprite = this.createSprite(this.picUrl);

        //  Third, set the yPosition by the last yPosition and adding one
        setyPos(this.getyPos() + 1);

        //  Finally, set the new sprite image with the updated x and y positions
        gameGrid.add(this.sprite, this.getxPos(), this.getyPos());
    }

    //  Method to moveLeft for the player and decrease one to the current x position
    public void moveLeft(Grid gameGrid) {
        //  First, remove the image from the gameGrid (which is the sprite data field)
        gameGrid.getChildren().remove(this.sprite);

        //  Second, reassign a new sprite with the picUrl
        this.sprite = this.createSprite(this.picUrl);

        //  Third, set the yPosition by the last yPosition and adding one
        setxPos(this.getxPos() - 1);

        //  Finally, set the new sprite image with the updated x and y positions
        gameGrid.add(this.sprite, this.getxPos(), this.getyPos());
    }

    //  Method to moveLeft for the player and decrease one to the current x position
    public void moveRight(Grid gameGrid) {
        //  First, remove the image from the gameGrid (which is the sprite data field)
        gameGrid.getChildren().remove(this.sprite);

        //  Second, reassign a new sprite with the picUrl
        this.sprite = this.createSprite(this.picUrl);

        //  Third, set the yPosition by the last yPosition and adding one
        setxPos(this.getxPos() + 1);

        //  Finally, set the new sprite image with the updated x and y positions
        gameGrid.add(this.sprite, this.getxPos(), this.getyPos());
    }


    //  teleportPlayer() will teleport the player in a random position in the grid, will be called in RobberMiniBoss
    public void teleportPlayer(Grid gameGrid) {
        //  Initialize a new position class
        Position position = new Position();

        //  Now generate a random position for the player given the gameGrid limits
        int[] newPosition = position.createRandomPosition(gameGrid);

        //  First, remove the image from the gameGrid (which is the sprite data field)
        gameGrid.getChildren().remove(this.sprite);

        //  Second, reassign a new sprite with the picUrl
        this.sprite = this.createSprite(this.picUrl);

        //  Third, set the xPosition by the new random xPosition
        setxPos(newPosition[0]);

        //  Fourth, set the yPosition by the new random yPosition
        setyPos(newPosition[1]);

        //  Finally, set the new sprite image with the updated x and y positions
        gameGrid.add(this.sprite, this.getxPos(), this.getyPos());
    }


    //  Each time playerShoots fires, finalBoss decreases by one
    public void playerShoots(FinalBoss finalBoss) {
        //  Store the previous ammo as temporary
        int tempAmmo = this.getCountOfAmmo();

        //  If the playerAmmo is greater than 0 then shoot
        if(tempAmmo > 0) {
            //  Get the previous health of the finalBoss
            int previousHealth = finalBoss.getHealth();

            //  Set the new finalBoss health of the previous minus 1
            finalBoss.setHealth(previousHealth - 1);

            //  Set the new ammo lower to one below
            this.setCountOfAmmo(tempAmmo - 1);
        }
    }
}
