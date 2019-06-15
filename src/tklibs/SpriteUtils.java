package tklibs;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by huynq on 5/11/17.
 */
public class SpriteUtils {

    public static BufferedImage loadImage(String url) {
        try {
            return ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    //assets/images/players/straight

    public static ArrayList<BufferedImage> loadImages(String dirUrl){
        ArrayList<BufferedImage> images = new ArrayList<>();
        try{
            String[] fileNames = new File(dirUrl).list();
            Arrays.sort(fileNames);
            for(int i = 0; i<fileNames.length; i++){
                String fileName = fileNames[i]; //0.png, abc.txt
                if(fileName.toLowerCase().endsWith(".png")){
                    String fileURL = dirUrl+"/"+fileName;
                    BufferedImage image = loadImage(fileURL);
                    images.add(image);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            images.clear();
        }

        return images;
    }

    public static void renderAtCenter(Graphics graphics, BufferedImage image, double x, double y) {
        graphics.drawImage(image, (int)(x - (double)image.getWidth() / 2), (int)(y - (double) image.getHeight() / 2), null);
    }

    public static BufferedImage maskWhite(BufferedImage image) {
        BufferedImage returnImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int color = image.getRGB(x, y);
                int alpha = color & 0xFF000000;
                if (alpha != 0) {
                    returnImage.setRGB(x, y, color | 0x00FFFFFF | alpha);
                } else {
                    returnImage.setRGB(x, y, color);
                }
            }
        }

        return returnImage;
    }

    public static void main(String[] args) {
        ArrayList<BufferedImage> images;
        images = loadImages("assets/images/players/explosions");
        System.out.println(images.size());
    }
}
