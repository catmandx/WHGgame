package game;

import game.wall.HLine;
import game.wall.VLine;

import java.util.Set;

public class Map1 {

    public static int columns = 2;

    public static int rows = 2;

    public Tile[][] tiles;

    public Map1(){
        tiles = new Tile[Settings.NUMBER_OF_COLS][Settings.NUMBER_OF_ROWS];
        this.setTiles();
        this.setWalls();
    }

    /**
     * Đặt xem cái nào là tiles
     */
    public void setTiles(){
        int charPos = 0;
        for (int i = 0; i < Settings.map1[0].length; i++) {
            for (int j = 0; j < Settings.map1.length; j++) {
                Settings.map1[j][i] = Integer.parseInt(String.valueOf(Settings.s.charAt(charPos)));
                charPos++;
            }
        }
        for (int i = 0; i < Settings.NUMBER_OF_COLS; i++) {
            for (int j = 0; j < Settings.NUMBER_OF_ROWS; j++) {
                int tileType = Settings.map1[i][j];
                if(tileType == Settings.IS_TILE){
                    tiles[i][j] = GameObject.recycle(Tile.class);
                    if ((i + j) % 2 == 0) {
                        tiles[i][j].setInfo(i, j, Settings.IS_BLUE_TILE);
                    } else {
                        tiles[i][j].setInfo(i, j, Settings.IS_WHITE_TILE);
                    }
                }else if(tileType != 0){
                    tiles[i][j] = GameObject.recycle(Tile.class);
                    tiles[i][j].setInfo(i,j,tileType);
                }
            }
        }
    }

    /**
     * Nhìn tên tự hiểu nha
     */
    public void setWalls(){
        for (int i = 0; i < Settings.NUMBER_OF_COLS; i++) {
            for (int j = 0; j <  Settings.NUMBER_OF_ROWS; j++) {
                if(Settings.map1[i][j]!=0) {
                    Tile tile = tiles[i][j];
                    //SET RIGHT WALL
                    try {
                        Tile tile1 = tiles[i + 1][j];
                        tile1.active = false;
                    } catch (Exception e) {
                        tile.rightWall = GameObject.recycle(VLine.class);
                        tile.rightWall.position.set(
                                tile.position.x + Settings.WAY_SIZE / 2,
                                tile.position.y);
                    }
                    //SET LEFT WALL
                    try {
                        Tile tile1 = tiles[i - 1][j];
                        tile1.active = false;
                    } catch (Exception e) {
                        tile.leftWall = GameObject.recycle(VLine.class);
                        tile.leftWall.position.set(
                                tile.position.x - Settings.WAY_SIZE / 2,
                                tile.position.y);
                    }

                    //SET TOP WALL
                    try {
                        Tile tile1 = tiles[i][j-1];
                        tile1.active = false;
                    } catch (Exception e) {
                        tile.topWall = GameObject.recycle(HLine.class);
                        tile.topWall.position.set(
                                tile.position.x ,
                                tile.position.y - Settings.WAY_SIZE / 2);
                    }

                    //SET BOTTOM WALL
                    try {
                        Tile tile1 = tiles[i][j+1];
                        tile1.active = false;
                    } catch (Exception e) {
                        tile.botWall = GameObject.recycle(HLine.class);
                        tile.botWall.position.set(
                                tile.position.x ,
                                tile.position.y + Settings.WAY_SIZE / 2);
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Tile tile = new Tile();
        System.out.println(tile);
        Tile[] tiles = new Tile[2];
        System.out.println(tiles[0] + " " + tiles[1]);
        tiles[0] = GameObject.recycle(Tile.class);
        Map1 map1 = new Map1();
    }
}
