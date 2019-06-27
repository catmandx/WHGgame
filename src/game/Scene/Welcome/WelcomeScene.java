package game.Scene.Welcome;

import game.GameObject;
import game.Scene.Scene;
import tklibs.AudioUtils;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class WelcomeScene extends Scene {
    Clip music;
    @Override
    public void init() {
        music = AudioUtils.loadSound("assets/Music/Stereo Madness (online-audio-converter.com).wav");
        music.loop(Clip.LOOP_CONTINUOUSLY);
        BackgroundWelcome background = new BackgroundWelcome();
    }

    @Override
    public void clear() {
        music.stop();
        GameObject.clearAll();
    }
}

