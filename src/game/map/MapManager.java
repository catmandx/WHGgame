package game.map;

import game.GameObject;

public abstract class MapManager {
    public static Map currentMap;

    public static void signNewMap(Map newMap){
            currentMap = newMap;
    }
}
