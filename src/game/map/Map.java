package game.map;

import game.GameObject;

public abstract class Map {
    public boolean isDone = false;
    public abstract void setEnemies();
    public void signNextMap(){
        GameObject.clearAll();
    }
}
