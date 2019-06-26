package game.mapObjects;

import game.GameObject;
import game.Settings;
import game.map.MapManager;
import game.physics.BoxCollider;
import game.renderer.BoxRenderer;
import game.mapObjects.wall.HLine;
import game.mapObjects.wall.VLine;

import java.awt.*;

public class Tile extends GameObject {
    //Todo
    public boolean isGoal;
    public boolean isStart;
    public boolean isTile;
    public boolean isCheckpoint;
    public VLine leftWall;
    public VLine rightWall;
    public HLine topWall;
    public HLine botWall;
    public Color color;


    public Tile(){
        renderer = new BoxRenderer(Settings.TILE_SIZE, Settings.TILE_SIZE, true);
        this.active = true;
    }

    public void setInfo(int i, int j, int tileType){

        //SET POSITION BASED ON MATRIX POSITION
        this.position.set(
                Settings.TILE_START_X + i * Settings.TILE_SIZE,
                Settings.TILE_START_Y + j * Settings.TILE_SIZE);


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
                color = new Color(179, 251, 0);
                this.hitBox = new BoxCollider(this, Settings.TILE_SIZE, Settings.TILE_SIZE);
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
        }    }

    @Override
    public void render(Graphics g){
        g.setColor(color);
        super.render(g);
    }

    @Override
    public void run() {
        this.checkPlayer();
    }

    public void checkPlayer(){
        if(this.hitBox!= null && MapManager.currentMap.numberOfDots == 0){
            Player player = GameObject.findIntersects(Player.class, this.hitBox);
            if (player!=null){
                MapManager.currentMap.isDone = true;
                MapManager.currentMap.signNextMap();
            }
        }
    }
}
