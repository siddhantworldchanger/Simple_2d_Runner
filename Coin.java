// Coin.java
import java.awt.*;

public class Coin {
    private int x, y;
    private static final int SPEED = -5;

    // Add constructor with parameters
    public Coin(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
        x += SPEED;
    }

    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, 20, 20); // Different shape from obstacles
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 20, 20);
    }
}