package game.renderer;

import game.GameObject;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimationRenderer extends Renderer {

    public ArrayList<BufferedImage> images;
    public int currentImageIndex;
    public int nextImageCount;
    public boolean isOnce;

    public AnimationRenderer(ArrayList<BufferedImage> images, int nextImageCount, boolean isOnce) {
        this.images = images;
        this.nextImageCount = nextImageCount;
        this.isOnce = isOnce;
    }

    public AnimationRenderer(String url, int nextImageCount, boolean isOnce) {
        this(SpriteUtils.loadImages(url), nextImageCount, isOnce);
    }

    @Override
    public void render(Graphics g, GameObject master) {
        if(images != null) {
            BufferedImage currentImage = images.get(currentImageIndex);
            this.drawImage(g, master, currentImage);

            nextImageCount++;
            if(nextImageCount > 6) {
                currentImageIndex++;
                if(currentImageIndex >= images.size()) {
                    currentImageIndex = 0;
                    if(isOnce) {
                        master.deactive();
                    }
                }
                nextImageCount = 0;
            }
        }
    }
}
