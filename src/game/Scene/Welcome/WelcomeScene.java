package game.Scene.Welcome;

import game.GameObject;
import game.Scene.Scene;

public class WelcomeScene extends Scene {
    @Override
    public void init() {
        BackgroundWelcome background = new BackgroundWelcome();
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}

