package game.map;

import game.Settings;
import game.mapObjects.Tile;

public class Map3 extends Map {
    public Map3() {
        map =
                        "00000000000000000000" +
                        "00000000000000000000" +
                        "00000000000000000000" +
                        "00000000100000000000" +
                        "00000000111100000000" +
                        "00000000133100000000" +
                        "00000000133100000000" +
                        "00000000111100000000" +
                        "00000000000000000000" +
                        "00000000000000000000";
        tiles = new Tile[Settings.NUMBER_OF_COLS][Settings.NUMBER_OF_ROWS];
        this.setTiles();
        this.setWalls();
        this.setEnemies();
        this.setPlayer();
    }

    @Override
    public void setEnemies() {



    }

    @Override
    public void signNextMap() {
        super.signNextMap();
        if (this.isDone) {
            Settings.NUMBER_OF_DEATHS = 0;
            MapManager.signNewMap(new Map3());
        } else {
            MapManager.signNewMap(new Map3());
        }
    }
}
