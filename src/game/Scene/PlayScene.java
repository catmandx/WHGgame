package game.Scene;

import game.*;
import game.map.Map1;
import game.map.MapManager;

public class PlayScene extends Scene {
    @Override
    public void init() {
        MapManager.currentMap.signNextMap();
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }

    public void newMap(){

    }
}

