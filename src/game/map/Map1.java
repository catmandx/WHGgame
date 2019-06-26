package game.map;

import game.*;
import game.mapObjects.Player;
import game.mapObjects.Tile;
import game.mapObjects.enemies.Enemy1;
import game.mapObjects.wall.HLine;
import game.mapObjects.wall.VLine;

public class Map1 extends Map{

    public Tile[][] tilesMap1;
    public Map1(){
        tilesMap1 = new Tile[Settings.NUMBER_OF_COLS][Settings.NUMBER_OF_ROWS];
        this.setTiles();
        this.setWalls();
        this.setEnemies();
        this.setPlayer();
    }

    public void setEnemies(){
        Enemy1 enemy1 = GameObject.recycle(Enemy1.class);
        enemy1.setPathHorizontal(tilesMap1[4][2], tilesMap1[15][2]);
        enemy1 = GameObject.recycle(Enemy1.class);
        enemy1.setPathHorizontal(tilesMap1[15][3], tilesMap1[4][3]);
        enemy1 = GameObject.recycle(Enemy1.class);
        enemy1.setPathHorizontal(tilesMap1[4][4], tilesMap1[15][4]);
        enemy1 = GameObject.recycle(Enemy1.class);
        enemy1.setPathHorizontal(tilesMap1[15][5], tilesMap1[4][5]);
        enemy1 = GameObject.recycle(Enemy1.class);
        enemy1.setPathHorizontal(tilesMap1[4][6], tilesMap1[15][6]);
        enemy1 = GameObject.recycle(Enemy1.class);
        enemy1.setPathHorizontal(tilesMap1[15][7], tilesMap1[4][7]);
        enemy1 = GameObject.recycle(Enemy1.class);
        enemy1.setPathHorizontal(tilesMap1[4][8], tilesMap1[15][8]);
    }
    /**
     * Đặt xem cái nào là tilesMapMatrix
     */
    public void setTiles(){
        int charPos = 0;
        for (int i = 0; i < Settings.mapMatrix[0].length; i++) {
            for (int j = 0; j < Settings.mapMatrix.length; j++) {
                Settings.mapMatrix[j][i] = Integer.parseInt(String.valueOf(Settings.s.charAt(charPos)));
                charPos++;
            }
        }
        for (int i = 0; i < Settings.NUMBER_OF_COLS; i++) {
            for (int j = 0; j < Settings.NUMBER_OF_ROWS; j++) {
                int tileType = Settings.mapMatrix[i][j];
                if(tileType == Settings.IS_TILE){
                    tilesMap1[i][j] = GameObject.recycle(Tile.class);
                    if ((i + j) % 2 == 0) {
                        tilesMap1[i][j].setInfo(i, j, Settings.IS_BLUE_TILE);
                    } else {
                        tilesMap1[i][j].setInfo(i, j, Settings.IS_WHITE_TILE);
                    }
                }else if(tileType != 0){
                    tilesMap1[i][j] = GameObject.recycle(Tile.class);
                    tilesMap1[i][j].setInfo(i,j,tileType);
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
                if(Settings.mapMatrix[i][j]!=0) {
                    Tile tile = tilesMap1[i][j];
                    //SET RIGHT WALL
                    try {
                        Tile tile1 = tilesMap1[i + 1][j];
                        tile1.active = true;
                    } catch (Exception e) {
                        tile.rightWall = GameObject.recycle(VLine.class);
                        tile.rightWall.position.set(
                                tile.position.x + Settings.TILE_SIZE / 2,
                                tile.position.y);
                    }
                    //SET LEFT WALL
                    try {
                        Tile tile1 = tilesMap1[i - 1][j];
                        tile1.active = true;
                    } catch (Exception e) {
                        tile.leftWall = GameObject.recycle(VLine.class);
                        tile.leftWall.position.set(
                                tile.position.x - Settings.TILE_SIZE / 2,
                                tile.position.y);
                    }

                    //SET TOP WALL
                    try {
                        Tile tile1 = tilesMap1[i][j-1];
                        tile1.active = true;
                    } catch (Exception e) {
                        tile.topWall = GameObject.recycle(HLine.class);
                        tile.topWall.position.set(
                                tile.position.x ,
                                tile.position.y - Settings.TILE_SIZE / 2);
                    }

                    //SET BOTTOM WALL
                    try {
                        Tile tile1 = tilesMap1[i][j+1];
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

    public void setPlayer(){
        Player player = GameObject.recycle(Player.class);
        for (int i = 0; i < Settings.NUMBER_OF_COLS; i++) {
            for (int j = 0; j < Settings.NUMBER_OF_ROWS; j++) {
                Tile tile = tilesMap1[i][j];
                try {
                    if (tile.isStart) {
                        player.position.set(tile.position);
                    }
                }catch (Exception e){

                }
            }
        }
    }

    @Override
    public void signNextMap(){
        super.signNextMap();
        MapManager.signNewMap(new Map2());
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
