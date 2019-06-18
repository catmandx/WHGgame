package game.physics;

import game.GameObject;
import game.Vector2D;

public class BoxCollider {
    public Vector2D position;
    public int width;
    public int height;
    public Vector2D anchor;

    public BoxCollider(GameObject master, int width, int height) {
        this.position = master.position;
        this.width = width;
        this.height = height;
        this.anchor = master.anchor;
    }

    public static void main(String[] args) {


    }

    public boolean intersects(BoxCollider other) {
        return other.right() >= this.left() && other.left() <= this.right()
                && other.bot() >= this.top() && other.top() <= this.bot();
    }

    /**
     * Kiểm tra xem va chạm giữa master và other là bên trái hay phải
     * @param other
     * @return "right" hoặc "left"
     */
    public String checkSides(BoxCollider other) {
        if (intersects(other)) {
            if (Math.abs(this.right() - other.right()) >= Math.abs(this.left() - other.right())) {
                return "left";
            } else if (Math.abs(this.left() - other.left()) > Math.abs(this.right() - other.right())) {
                return "right";
            } else {
                return "else";
            }
        } else {
            return null;
        }
    }

    /**
     * Kiểm tra xem va chạm giữa master và other là bên TRÊN hay DƯỚI
     * @param other
     * @return "top" || "bottom"
     */
    public String checkTopBottom(BoxCollider other) {
        if (intersects(other)) {
            if (Math.abs(this.top() - other.top()) <= Math.abs(this.bot() - other.top())) {
                return "top";
            } else {
                return "bottom";
            }
        } else {
            return null;
        }
    }

    public double top() {
        return position.y - anchor.y * height;
    }

    public double bot() {
        return top() + height;
    }

    public double left() {
        return position.x - anchor.x * width;
    }

    public double right() {
        return left() + width;
    }


    public String toString(){
        return "hitbox pos x:"+position.x +" pos y:"+position.y+" width:"+width+" Height: "+height;
    }
}
