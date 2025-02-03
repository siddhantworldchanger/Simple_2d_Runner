import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Player player;
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Coin> coins;
    private Background background;
    private Timer timer;
    private boolean isGameOver;
    private int score;

    public GamePanel() {
        setFocusable(true);
        addKeyListener(this);
        player = new Player(100, 300);
        obstacles = new ArrayList<>();
        coins = new ArrayList<>();
        background = new Background();
        timer = new Timer(16, this); // ~60 FPS
        isGameOver = false;
        score = 0;
    }

    public void startGame() {
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        background.draw(g);
        player.draw(g);
        for (Obstacle o : obstacles) o.draw(g);
        for (Coin c : coins) c.draw(g);
        drawHUD(g);
        if (isGameOver) drawGameOver(g);
    }

    private void drawHUD(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 10, 20);
    }

    private void drawGameOver(Graphics g) {
        g.setColor(Color.RED);
        g.drawString("GAME OVER! Final Score: " + score, 600, 600);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isGameOver) {
            update();
            checkCollisions();
            spawnObjects();
            repaint();
        }
    }

    private void update() {
        player.update();
        background.update();
        obstacles.forEach(Obstacle::update);
        coins.forEach(Coin::update);
        score += 1; // Increment score over time
    }

    private void checkCollisions() {
        Rectangle playerBounds = player.getBounds();
        obstacles.removeIf(o -> {
            if (playerBounds.intersects(o.getBounds())) {
                isGameOver = true;
                return true;
            }
            return false;
        });
        coins.removeIf(c -> {
            if (playerBounds.intersects(c.getBounds())) {
                score += 50; // Coin bonus
                return true;
            }
            return false;
        });
    }

    private void spawnObjects() {
        Random rand = new Random();
        if (rand.nextInt(100) < 2) { // 2% chance per frame
            obstacles.add(new Obstacle(800, rand.nextInt(400) + 100));
        }
        if (rand.nextInt(100) < 1) { // 1% chance per frame
            coins.add(new Coin(800, rand.nextInt(400) + 100));
        }
    }

    // KeyListener Methods
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) player.jump();
        if (key == KeyEvent.VK_LEFT) player.moveLeft();
        if (key == KeyEvent.VK_RIGHT) player.moveRight();
        if (key == KeyEvent.VK_DOWN) player.slide();
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
}