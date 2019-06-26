package game.map;

import game.GameObject;
import game.mapObjects.Player;
import game.Settings;
import game.mapObjects.Tile;
import game.mapObjects.enemies.Enemy2;
import game.mapObjects.wall.HLine;
import game.mapObjects.wall.VLine;

public class Map2 extends Map{

    public Tile[][] tilesMapMatrix;

    public static String map2 =
            "00000000000000000000" +
            "00000000000000000000" +
            "00001111111111110000" +
            "00001111111111110000" +
            "03331111111111114440" +
            "03331111111111114440" +
            "00001111111111110000" +
            "00001111111111110000" +
            "00000000000000000000" +
            "00000000000000000000" ;
    public Map2(){
        tilesMapMatrix = new Tile[Settings.NUMBER_OF_COLS][Settings.NUMBER_OF_ROWS];
        this.setTiles();
        this.setWalls();
        this.setEnemies();
        this.setPlayer();
    }

    public void setEnemies(){
        Enemy2 enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tilesMapMatrix[4][2], tilesMapMatrix[4][7]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tilesMapMatrix[5][7], tilesMapMatrix[5][2]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tilesMapMatrix[6][2], tilesMapMatrix[6][7]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tilesMapMatrix[7][7], tilesMapMatrix[7][2]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tilesMapMatrix[8][2], tilesMapMatrix[8][7]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tilesMapMatrix[9][7], tilesMapMatrix[9][2]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tilesMapMatrix[10][2], tilesMapMatrix[10][7]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tilesMapMatrix[11][7], tilesMapMatrix[11][2]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tilesMapMatrix[12][2], tilesMapMatrix[12][7]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tilesMapMatrix[13][7], tilesMapMatrix[13][2]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tilesMapMatrix[14][2], tilesMapMatrix[14][7]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tilesMapMatrix[15][7], tilesMapMatrix[15][2]);
    }

    @Override
    public void signNextMap() {

    }

    /**
     * Đặt xem cái nào là tilesMapMatrix
     */
    public void setTiles(){
        int charPos = 0;
        for (int i = 0; i < Settings.mapMatrix[0].length; i++) {
            for (int j = 0; j < Settings.mapMatrix.length; j++) {
                Settings.mapMatrix[j][i] = Integer.parseInt(String.valueOf(map2.charAt(charPos)));
                charPos++;
            }
        }
        for (int i = 0; i < Settings.NUMBER_OF_COLS; i++) {
            for (int j = 0; j < Settings.NUMBER_OF_ROWS; j++) {
                int tileType = Settings.mapMatrix[i][j];
                if(tileType == Settings.IS_TILE){
                    tilesMapMatrix[i][j] = GameObject.recycle(Tile.class);
                    if ((i + j) % 2 == 0) {
                        tilesMapMatrix[i][j].setInfo(i, j, Settings.IS_BLUE_TILE);
                    } else {
                        tilesMapMatrix[i][j].setInfo(i, j, Settings.IS_WHITE_TILE);
                    }
                }else if(tileType != 0){
                    tilesMapMatrix[i][j] = GameObject.recycle(Tile.class);
                    tilesMapMatrix[i][j].setInfo(i,j,tileType);
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
                    Tile tile = tilesMapMatrix[i][j];
                    //SET RIGHT WALL
                    try {
                        Tile tile1 = tilesMapMatrix[i + 1][j];
                        tile1.active = true;
                    } catch (Exception e) {
                        tile.rightWall = GameObject.recycle(VLine.class);
                        tile.rightWall.position.set(
                                tile.position.x + Settings.TILE_SIZE / 2,
                                tile.position.y);
                    }
                    //SET LEFT WALL
                    try {
                        Tile tile1 = tilesMapMatrix[i - 1][j];
                        tile1.active = true;
                    } catch (Exception e) {
                        tile.leftWall = GameObject.recycle(VLine.class);
                        tile.leftWall.position.set(
                                tile.position.x - Settings.TILE_SIZE / 2,
                                tile.position.y);
                    }

                    //SET TOP WALL
                    try {
                        Tile tile1 = tilesMapMatrix[i][j-1];
                        tile1.active = true;
                    } catch (Exception e) {
                        tile.topWall = GameObject.recycle(HLine.class);
                        tile.topWall.position.set(
                                tile.position.x ,
                                tile.position.y - Settings.TILE_SIZE / 2);
                    }

                    //SET BOTTOM WALL
                    try {
                        Tile tile1 = tilesMapMatrix[i][j+1];
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
                Tile tile = tilesMapMatrix[i][j];
                try {
                    if (tile.isStart) {
                        player.position.set(tile.position);
                    }
                }catch (Exception e){

                }
            }
        }
    }
}
