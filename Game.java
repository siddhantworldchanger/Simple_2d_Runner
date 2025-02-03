import javax.swing.*;

public class Game {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Subway Surfers");
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        gamePanel.startGame();
    }
}