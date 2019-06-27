package game.map;

import game.Settings;
import game.mapObjects.Tile;
import game.mapObjects.enemies.Enemy;
import game.mapObjects.enemies.Enemy4;

public class Map4 extends Map {
    public Map4() {
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
    @Override
    public void setEnemies() {
        Enemy4 enemy = new Enemy4();
        enemy.setInfo(3, tiles[8][5].position,4,90);
    }


}
