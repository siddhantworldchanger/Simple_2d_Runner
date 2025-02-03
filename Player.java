import java.awt.*;

public class Player {
    private int x, y;
    private int speedX, speedY;
    private boolean isJumping, isSliding;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        speedX = 0;
        speedY = 0;
    }

    public void update() {
        x += speedX;
        y += speedY;
        // Gravity simulation
        if (isJumping) {
            speedY += 1;
            if (y >= 300) { // Ground level
                y = 300;
                isJumping = false;
                speedY = 0;
            }
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 40, 60); // Simplified player rectangle
    }

    public void jump() {
        if (!isJumping) {
            speedY = -15;
            isJumping = true;
        }
    }

    public void moveLeft() { speedX = -5; }
    public void moveRight() { speedX = 5; }
    public void slide() { isSliding = true; }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 40, 60);
    }
}