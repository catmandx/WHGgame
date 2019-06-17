package game;

import game.renderer.BoxRenderer;
import game.wall.HLine;
import game.wall.VLine;

import java.awt.*;

public class Tile extends GameObject{
    //Todo
    boolean isGoal;
    boolean isStart;
    boolean isTile;
    boolean isCheckpoint;
    VLine leftWall;
    VLine rightWall;
    HLine topWall;
    HLine botWall;
    Color color;


    public Tile(){
        renderer = new BoxRenderer(Settings.WAY_SIZE, Settings.WAY_SIZE, true);
        this.active = true;
    }

    public void setInfo(int i, int j, int tileType){

        //SET COLOR BASED ON TILETYPE
        switch (tileType){
            case Settings.IS_BLUE_TILE:
                color = new Color(230, 230, 255);
                this.isTile = true;
                break;
            case Settings.IS_WHITE_TILE:
                color = new Color(247 , 248 , 252);
                this.isTile = true;
                break;
            case Settings.IS_GOAL_TILE:
                color = new Color(179, 251, 179);
                this.isGoal = true;
                break;
            case Settings.IS_START_TILE:
                color = new Color(179, 251, 179);
                this.isStart = true;
                break;
            case Settings.IS_CHECKPOINT_TILE:
                color = new Color(179, 251, 179);
                this.isCheckpoint = true;
                break;
        }

        //SET POSITION BASED ON MATRIX POSITION
        this.position.set(
                Settings.TILE_START_X + i * Settings.WAY_SIZE,
                Settings.TILE_START_Y + j * Settings.WAY_SIZE);
    }

    @Override
    public void render(Graphics g){
        g.setColor(color);
        super.render(g);
    }
}
