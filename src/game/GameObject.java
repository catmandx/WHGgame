package game;

import game.physics.BoxCollider;

import java.awt.*;
import java.util.ArrayList;

public class GameObject {
    //quan li doi tuong
    public static ArrayList<GameObject> objects = new ArrayList<>();

    public GameObject() {
        objects.add(this);
        position = new Vector2D();
        velocity = new Vector2D();
        anchor = new Vector2D(0.5,0.5);
    }


    public static void renderAll(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }
    }

    public static void runAll(){
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).run();
        }
    }

    public Vector2D position;
    public Vector2D velocity;
    public BoxCollider hitBox;
    public boolean active;
    public Vector2D anchor; //vi tri tam anh

    public void paint(Graphics g) {
    }

    public void run(){
        position.add(velocity);
    }
}
