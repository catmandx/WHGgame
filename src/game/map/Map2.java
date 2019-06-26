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
            "00011111111111100000" +
            "00011111111111100000" +
            "33311111111111144400" +
            "33311111111111144400" +
            "00011111111111100000" +
            "00011111111111100000" +
            "00000000000000000000" +
            "00000000000000000000" +
            "00000000000000000000" +
            "00000000000000000000";
    public Map2(){
        tilesMapMatrix = new Tile[Settings.NUMBER_OF_COLS][Settings.NUMBER_OF_ROWS];
        this.setTiles();
        this.setWalls();
        this.setEnemies();
        this.setPlayer();
    }

    public void setEnemies(){
        Enemy2 enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tilesMapMatrix[3][0], tilesMapMatrix[3][5]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tilesMapMatrix[4][5], tilesMapMatrix[4][0]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tilesMapMatrix[5][0], tilesMapMatrix[5][5]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tilesMapMatrix[6][5], tilesMapMatrix[6][0]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tilesMapMatrix[7][0], tilesMapMatrix[7][5]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tilesMapMatrix[8][5], tilesMapMatrix[8][0]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tilesMapMatrix[9][0], tilesMapMatrix[9][5]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tilesMapMatrix[10][5], tilesMapMatrix[10][0]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tilesMapMatrix[11][0], tilesMapMatrix[11][5]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tilesMapMatrix[12][5], tilesMapMatrix[12][0]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tilesMapMatrix[13][0], tilesMapMatrix[13][5]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tilesMapMatrix[14][5], tilesMapMatrix[14][0]);
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
