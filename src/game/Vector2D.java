package game;

public class Vector2D {
    public double x;
    public double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D() {
        this(0, 0);
    }

    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(-3, 0);
        System.out.println(v1.getLength()); //4.2
        System.out.println(v1.getAngle());//Pi/4
        v1.setLength(10);
        System.out.println(v1.getLength()); //10
        v1.setAngle(Math.PI / 2);
        System.out.println(v1.getAngle());
        v1.setAngle(-3 * Math.PI / 2);
        System.out.println(v1.getAngle());//Math.Pi /6
        for (int i = 0; i < 4; i++) {
            v1.setAngle(i * (Math.PI / 4));
            System.out.println("x: " + v1.x + " y: " + v1.y);
        }
    }

    //phuong thuc
    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void add(Vector2D other) {
        this.x += other.x;
        this.y += other.y;
    }

    public void substract(double x, double y) {
        this.x -= x;
        this.y -= y;
    }

    public void scale(double rate) {
        this.x = this.x * rate;
        this.y = this.y * rate;
    }

    public Vector2D clone() {
        return new Vector2D(x, y);
    }

    //dat lai gia tri
    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getLength() {
        return (Math.sqrt(x * x + y * y));
    }

    public void setLength(double length) {
        double oldLength = this.getLength();
        if (oldLength != 0) {
            x = x * length / oldLength;
            y = y * length / oldLength;
        }
    }

    public double getAngle() { //tra ve goc so voi truc hoanh
        return Math.atan2(this.y, this.x);
    }

    public void setAngle(double angle) {
        double length = getLength();
        if (length != 0) {
            this.x = Math.cos(angle) * length;
            this.y = Math.sin(angle) * length;
        }
    }

    public String toString() {
        return "x: " + x + ", y: " + y;
    }

}
