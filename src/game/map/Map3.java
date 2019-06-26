package game.map;

import game.GameObject;
import game.Scene.Scene;
import game.Scene.SceneManager;
import game.Scene.win.WinScene;
import game.Settings;
import game.mapObjects.Tile;
import game.mapObjects.enemies.Enemy1;
import game.mapObjects.enemies.Enemy31;
import game.mapObjects.enemies.Enemy32;

public class Map3 extends Map {
    public Map3() {
        map =
                        "00000333044400000000" +
                        "00000333044400000000" +
                        "00000100010000000000" +
                        "00000110110000000000" +
                        "00000110110000000000" +
                        "00000110110000000000" +
                        "00011110111100000000" +
                        "00011000001100000000" +
                        "00011111111100000000" +
                        "00000111110000000000";
        tiles = new Tile[Settings.NUMBER_OF_COLS][Settings.NUMBER_OF_ROWS];
        this.setTiles();
        this.setWalls();
        this.setEnemies();
        this.setPlayer();
    }

    @Override
    public void setEnemies() {
        Enemy32 enemy32 = GameObject.recycle(Enemy32.class);
        enemy32.setPath(tiles[6][3], tiles[5][3]);
        enemy32 = GameObject.recycle(Enemy32.class);
        enemy32.setPath(tiles[5][4], tiles[6][4]);
        enemy32 = GameObject.recycle(Enemy32.class);
        enemy32.setPath(tiles[6][5], tiles[5][5]);
        enemy32 = GameObject.recycle(Enemy32.class);
        enemy32.setPath(tiles[5][6], tiles[6][6]);
        enemy32 = GameObject.recycle(Enemy32.class);
        enemy32.setPath(tiles[3][6], tiles[4][6]);
        enemy32 = GameObject.recycle(Enemy32.class);
        enemy32.setPath(tiles[4][7], tiles[3][7]);
        enemy32 = GameObject.recycle(Enemy32.class);
        enemy32.setPath(tiles[3][8], tiles[4][8]);
        enemy32 = GameObject.recycle(Enemy32.class);
        enemy32.setPath(tiles[8][3], tiles[9][3]);
        enemy32 = GameObject.recycle(Enemy32.class);
        enemy32.setPath(tiles[9][4], tiles[8][4]);
        enemy32 = GameObject.recycle(Enemy32.class);
        enemy32.setPath(tiles[8][5], tiles[9][5]);
        enemy32 = GameObject.recycle(Enemy32.class);
        enemy32.setPath(tiles[9][6], tiles[8][6]);
        enemy32 = GameObject.recycle(Enemy32.class);
        enemy32.setPath(tiles[11][6], tiles[10][6]);
        enemy32 = GameObject.recycle(Enemy32.class);
        enemy32.setPath(tiles[10][7], tiles[11][7]);
        enemy32 = GameObject.recycle(Enemy32.class);
        enemy32.setPath(tiles[11][8], tiles[10][8]);

        Enemy31 enemy31 = GameObject.recycle(Enemy31.class);
        enemy31.setPath(tiles[5][8], tiles[5][9]);
        enemy31 = GameObject.recycle(Enemy31.class);
        enemy31.setPath(tiles[6][9], tiles[6][8]);
        enemy31 = GameObject.recycle(Enemy31.class);
        enemy31.setPath(tiles[7][8], tiles[7][9]);
        enemy31 = GameObject.recycle(Enemy31.class);
        enemy31.setPath(tiles[8][9], tiles[8][8]);
        enemy31 = GameObject.recycle(Enemy31.class);
        enemy31.setPath(tiles[9][8], tiles[9][9]);
    }

    @Override
    public void signNextMap() {
        super.signNextMap();
        if (this.isDone) {
//            Settings.NUMBER_OF_DEATHS = 0;
//            MapManager.signNewMap(new Map4());
            SceneManager.signNewScene(new WinScene());
        } else {
            MapManager.signNewMap(new Map3());
        }
    }
}
