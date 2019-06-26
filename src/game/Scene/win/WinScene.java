package game.Scene.win;

import game.GameObject;
import game.Scene.Scene;

public class WinScene extends Scene {

    @Override
    public void init() {
        BackgroundWin backgroundWin = new BackgroundWin();
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
