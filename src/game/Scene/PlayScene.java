package game.Scene;

import game.Background;
import game.Enemy;
import game.GameObject;
import game.Player;

public abstract class PlayScene extends Scene {
    @Override
    public void init() {
        GameObject.recycle(Background.class);
        GameObject.recycle(Player.class);
        GameObject.recycle(Enemy.class);
    }
}

