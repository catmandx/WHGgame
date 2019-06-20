package game.Scene.Welcome;

import game.Scene.Scene;

public abstract class wellcomeScene extends Scene {
    @Override
    public void init() {
        BackgroundWellcome background = new BackgroundWellcome();
    }
}
