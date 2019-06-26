package game.map;

import game.GameObject;
import game.Settings;
import game.mapObjects.Player;
import game.mapObjects.Tile;
import game.mapObjects.wall.HLine;
import game.mapObjects.wall.VLine;

public abstract class Map {
    public int numberOfDots;
    public Tile[][] tiles;
    public String map;
    public boolean isDone = false;
    public abstract void setEnemies();

    public void signNextMap(){
        GameObject.clearAll();
    }
    public void setTiles(){
        /**
         * Đặt xem cái nào là tilesMapMatrix
         */
            int charPos = 0;
            for (int i = 0; i < Settings.mapMatrix[0].length; i++) {
                for (int j = 0; j < Settings.mapMatrix.length; j++) {
                    Settings.mapMatrix[j][i] = Integer.parseInt(String.valueOf(map.charAt(charPos)));
                    charPos++;
                }
            }
            for (int i = 0; i < Settings.NUMBER_OF_COLS; i++) {
                for (int j = 0; j < Settings.NUMBER_OF_ROWS; j++) {
                    int tileType = Settings.mapMatrix[i][j];
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

    public void setPlayer(){
        Player player = GameObject.recycle(Player.class);
        for (int i = 0; i < Settings.NUMBER_OF_COLS; i++) {
            for (int j = 0; j < Settings.NUMBER_OF_ROWS; j++) {
                Tile tile = tiles[i][j];
                try {
                    if (tile.isStart) {
                        player.position.set(tile.position);
                    }
                }catch (Exception e){

                }
            }
        }
    }

    public void setWalls(){
        for (int i = 0; i < Settings.NUMBER_OF_COLS; i++) {
            for (int j = 0; j <  Settings.NUMBER_OF_ROWS; j++) {
                if(Settings.mapMatrix[i][j]!=0) {
                    Tile tile = tiles[i][j];
                    //SET RIGHT WALL
                    try {
                        Tile tile1 = tiles[i + 1][j];
                        tile1.active = true;
                    } catch (Exception e) {
                        tile.rightWall = GameObject.recycle(VLine.class);
                        tile.rightWall.position.set(
                                tile.position.x + Settings.TILE_SIZE / 2,
                                tile.position.y);
                    }
                    //SET LEFT WALL
                    try {
                        Tile tile1 = tiles[i - 1][j];
                        tile1.active = true;
                    } catch (Exception e) {
                        tile.leftWall = GameObject.recycle(VLine.class);
                        tile.leftWall.position.set(
                                tile.position.x - Settings.TILE_SIZE / 2,
                                tile.position.y);
                    }

                    //SET TOP WALL
                    try {
                        Tile tile1 = tiles[i][j-1];
                        tile1.active = true;
                    } catch (Exception e) {
                        tile.topWall = GameObject.recycle(HLine.class);
                        tile.topWall.position.set(
                                tile.position.x ,
                                tile.position.y - Settings.TILE_SIZE / 2);
                    }

                    //SET BOTTOM WALL
                    try {
                        Tile tile1 = tiles[i][j+1];
                        tile1.active = true;
                    } catch (Exception e) {
                        tile.botWall = GameObject.recycle(HLine.class);
                        tile.botWall.position.set(
                                tile.position.x ,
                                tile.position.y + Settings.TILE_SIZE / 2);
                    }
                }
            }
        }
    }
}
