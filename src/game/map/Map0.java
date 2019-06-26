package game.map;

import game.GameObject;

public class Map0 extends Map {
    @Override
    public void setEnemies() {

    }

    @Override
    public void signNextMap() {
        super.signNextMap();
        MapManager.signNewMap(new Map1());
    }
}
