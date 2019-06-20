package game.Scene.Game_over;

import game.GameObject;
import game.Scene.Scene;
import game.Scene.SceneManager;

public class GameoverScene extends Scene {
    @Override
    public void init() {
        GameObject.recycle(BackgroundGameover.class);
    }
    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
