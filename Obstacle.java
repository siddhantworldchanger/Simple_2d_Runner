// Obstacle.java
import java.awt.*;

public class Obstacle {
    private int x, y;
    private static final int SPEED = -5; // Move left

    public Obstacle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
        x += SPEED;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 30, 30);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 30, 30);
    }
}

