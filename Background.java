import java.awt.*;

public class Background {
    private int x1, x2;

    public Background() {
        x1 = 0;
        x2 = 800; // Assuming panel width 800
    }

    public void update() {
        x1 -= 2;
        x2 -= 2;
        if (x1 + 800 <= 0) x1 = x2 + 800;
        if (x2 + 800 <= 0) x2 = x1 + 800;
    }

    public void draw(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(x1, 0, 800, 600);
        g.fillRect(x2, 0, 800, 600);
    }
}