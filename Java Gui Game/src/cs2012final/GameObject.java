/*
*
* GameObject.java Written By Jesus Perez Arias, CS 2012-01
* December 10, 2020
*
* The item, player, RobberMiniBoss and MoveMiniBoss are the subclasses of the GameObject.java class.
*
* Data Fields
*       String spriteName, picUrl
*           Sprite name and the picUrl as strings which will be used to init the GameObject on the grid
*       ImageView sprite
*           Sprite is the reference of the sprite created, as an imageview
*       int xPos, yPos
*           These will reference where in the gridpane it's at, x being row and y being col
*       private int rowLength, colLength
*           This will reference the limits of the passed gameGrids
*
*
* Methods
*       createSprite()
*           Method to create a new ImageView and place it in the gameGrid with the GridPane.add() functionality
*
*       getSpriteImageOpacity()
*           Getter which will be used to help turn on the debug mode on or off
*
*       The other methods are getters and setters of the data fields which will be used for the GameLogic and shared among subclasses
* */
package cs2012final;

import javafx.scene.image.ImageView;

public class GameObject {
    /*  TODO: Data fields for all game objects  */
    String spriteName, picUrl;  //  Sprite name and the picUrl as strings
    ImageView sprite;   //  Sprite is the reference of the sprite created, as an imageview
    int xPos, yPos; //  This references where in the gridpane it's at, x being row and y being col
    private int rowLength, colLength;   //  This will reference the limits of the gameGrids

    /*  TODO: Constructor accepting the gameGrid and places the GameObject to the grid  */
    public GameObject(Grid gameGrid, String spriteName, String picUrl, int xPos, int yPos) {
        this.spriteName = spriteName;
        this.picUrl = picUrl;
        this.sprite = createSprite(this.picUrl);
        this.xPos = xPos - 1;   //  Because arrays start at 0
        this.yPos = yPos - 1;   //  Because arrays start at 0
        this.rowLength = gameGrid.getRowSize(); //  Initialize the rowLength, can't be used publicly
        this.colLength = gameGrid.getColSize(); //  Initialize the colLength, can't be used publicly

        //  Now, add the sprite to the gameGrid with a random index (we'll add random indeces later)
        gameGrid.add(this.sprite, this.xPos, this.yPos);

    }

    /*  TODO: Methods Below */

    //  Method to create a new ImageView and place it in the gameGrid
    public ImageView createSprite(String picUrl) {
        //  Make a new image view, fit for the cells and return it
        ImageView sprite = new ImageView(picUrl);
        sprite.setFitHeight(50);
        sprite.setFitWidth(50);

        return sprite;
    }

    //  Getter to get the sprite image view opacity
    public double getSpriteImageOpacity() {
        return this.sprite.getOpacity();
    }

    //  Getter to return the spriteName
    public String getSpriteName() { return spriteName; }

    //  Getter to return the current x position, the row where it's at
    public int getxPos() { return xPos; }

    //  Getter to return the current y position, the column where it's at
    public int getyPos() { return yPos; }

    //  Getter to return the row length
    public int getRowLength() {
        return rowLength;
    }

    //  Getter to get the current column length
    public int getColLength() { return colLength; }

    //  Setter for setting the new opacity of the image view sprite
    public void setSpriteImageOpacity(Double opacityValue) {
        this.sprite.setOpacity(opacityValue);
    }
    //  Setter to set/update the x position, where in the row it will be at
    public void setxPos(int xPos) {
        //  If the xPosition is greater than or equal to 0 and is less than rowLength of the array, set a new xPosition
        if (!(xPos == -1) && (xPos < this.getColLength())) {
            this.xPos = xPos;
        }
    }

    //  Setter to set/update the y position, where in the column it will be at
    public void setyPos(int yPos) {
        //  If the yPosition is greater than or equal to 0 and is less than rowLength of the array set a new yPosition
        if(!(yPos == -1) && (yPos < this.getRowLength())) {
            this.yPos = yPos;
        }
    }
}
