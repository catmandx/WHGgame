package game.map;

import game.GameObject;
import game.Settings;
import game.mapObjects.Player;
import game.mapObjects.Tile;
import game.mapObjects.enemies.Enemy1;
import game.mapObjects.wall.HLine;
import game.mapObjects.wall.VLine;

public class Map1 extends Map {

    public Map1() {
        map =
                "00000000000000000000" +
                "33300000000000011444" +
                "33301111111111110444" +
                "33301111111111110444" +
                "33301111111111110444" +
                "33301111111111110444" +
                "33301111111111110444" +
                "33301111111111110444" +
                "33301111111111110444" +
                "33311000000000000000";
        tiles = new Tile[Settings.NUMBER_OF_COLS][Settings.NUMBER_OF_ROWS];
        this.setTiles();
        this.setWalls();
        this.setEnemies();
        this.setPlayer();
    }

    public void setEnemies() {
        Enemy1 enemy1 = GameObject.recycle(Enemy1.class);
        enemy1.setPath(tiles[4][2], tiles[15][2]);
        enemy1 = GameObject.recycle(Enemy1.class);
        enemy1.setPath(tiles[15][3], tiles[4][3]);
        enemy1 = GameObject.recycle(Enemy1.class);
        enemy1.setPath(tiles[4][4], tiles[15][4]);
        enemy1 = GameObject.recycle(Enemy1.class);
        enemy1.setPath(tiles[15][5], tiles[4][5]);
        enemy1 = GameObject.recycle(Enemy1.class);
        enemy1.setPath(tiles[4][6], tiles[15][6]);
        enemy1 = GameObject.recycle(Enemy1.class);
        enemy1.setPath(tiles[15][7], tiles[4][7]);
        enemy1 = GameObject.recycle(Enemy1.class);
        enemy1.setPath(tiles[4][8], tiles[15][8]);
    }

    @Override
    public void signNextMap() {
        super.signNextMap();
        if (this.isDone) {
            MapManager.signNewMap(new Map2());
        } else {
            MapManager.signNewMap(new Map1());

        }
    }
}
