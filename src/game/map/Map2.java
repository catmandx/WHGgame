package game.map;

import game.GameObject;
import game.mapObjects.Player;
import game.Settings;
import game.mapObjects.Tile;
import game.mapObjects.enemies.Enemy2;
import game.mapObjects.wall.HLine;
import game.mapObjects.wall.VLine;

public class Map2 extends Map{

    public Map2(){
        map =
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
        tiles = new Tile[Settings.NUMBER_OF_COLS][Settings.NUMBER_OF_ROWS];
        this.setTiles();
        this.setWalls();
        this.setEnemies();
        this.setPlayer();
    }

    public void setEnemies(){
        Enemy2 enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tiles[4][2], tiles[4][7]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tiles[5][7], tiles[5][2]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tiles[6][2], tiles[6][7]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tiles[7][7], tiles[7][2]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tiles[8][2], tiles[8][7]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tiles[9][7], tiles[9][2]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tiles[10][2], tiles[10][7]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tiles[11][7], tiles[11][2]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tiles[12][2], tiles[12][7]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tiles[13][7], tiles[13][2]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tiles[14][2], tiles[14][7]);
        enemy2 = GameObject.recycle(Enemy2.class);
        enemy2.setPath(tiles[15][7], tiles[15][2]);
    }

    @Override
    public void signNextMap() {
        super.signNextMap();
        if (this.isDone) {
            MapManager.signNewMap(new Map2());
        } else {
            MapManager.signNewMap(new Map2());

        }
    }
}
