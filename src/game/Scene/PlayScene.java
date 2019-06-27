package game.Scene;

import game.*;
import game.map.Map1;
import game.map.MapManager;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;

public class PlayScene extends Scene {
    Clip music;
    @Override
    public void init() {
        music = AudioUtils.loadSound("assets/Music/Back On Track (online-audio-converter.com).wav");
        music.loop(Clip.LOOP_CONTINUOUSLY);
        MapManager.currentMap.signNextMap();

    }

    @Override
    public void clear() {
        music.stop();
        GameObject.clearAll();
    }

    public void newMap(){

    }
}

