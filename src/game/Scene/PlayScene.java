package game.Scene;

import game.*;

public class PlayScene extends Scene {
    @Override
    public void init() {
        new Map1();
        GameObject.recycle(Player.class);
        GameObject.recycle(Enemy.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}

