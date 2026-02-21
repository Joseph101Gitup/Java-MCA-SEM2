import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class SimplePacMan extends JPanel implements ActionListener, KeyListener {

    private Timer timer;
    private int playerX = 50, playerY = 50;
    private int playerSpeed = 5;
    private int ghostX = 300, ghostY = 200;
    private int ghostSpeed = 3;
    private int score = 0;
    private boolean gameRunning = true;

    // Dots positions
    private int[][] dots;
    private int dotSize = 10;

    // Movement flags
    private boolean up, down, left, right;

    private Random rand = new Random();

    public SimplePacMan() {
        JFrame frame = new JFrame("Simple Pac-Man");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setVisible(true);
        frame.addKeyListener(this);
        this.setFocusable(true);

        // Initialize dots
        dots = new int[20][2];
        for (int i = 0; i < dots.length; i++) {
            dots[i][0] = rand.nextInt(560) + 20;
            dots[i][1] = rand.nextInt(360) + 20;
        }

        timer = new Timer(30, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        if (!gameRunning) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("GAME OVER!", 200, 200);
            g.drawString("Score: " + score, 230, 250);
            return;
        }

        // Draw dots
        g.setColor(Color.YELLOW);
        for (int[] dot : dots) {
            g.fillOval(dot[0], dot[1], dotSize, dotSize);
        }

        // Draw player
        g.setColor(Color.BLUE);
        g.fillOval(playerX, playerY, 20, 20);

        // Draw ghost
        g.setColor(Color.RED);
        g.fillOval(ghostX, ghostY, 20, 20);

        // Score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Score: " + score, 10, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameRunning) return;

        // Move player
        if (up) playerY -= playerSpeed;
        if (down) playerY += playerSpeed;
        if (left) playerX -= playerSpeed;
        if (right) playerX += playerSpeed;

        // Keep player within bounds
        playerX = Math.max(0, Math.min(playerX, getWidth() - 20));
        playerY = Math.max(0, Math.min(playerY, getHeight() - 20));

        // Move ghost randomly
        ghostX += rand.nextInt(3) - 1; // -1,0,1
        ghostY += rand.nextInt(3) - 1;

        ghostX = Math.max(0, Math.min(ghostX, getWidth() - 20));
        ghostY = Math.max(0, Math.min(ghostY, getHeight() - 20));

        // Check collision with dots
        for (int[] dot : dots) {
            if (Math.abs(playerX - dot[0]) < 20 && Math.abs(playerY - dot[1]) < 20) {
                dot[0] = -100; // remove dot
                dot[1] = -100;
                score++;
            }
        }

        // Check collision with ghost
        if (Math.abs(playerX - ghostX) < 20 && Math.abs(playerY - ghostY) < 20) {
            gameRunning = false;
            JOptionPane.showMessageDialog(this, "GAME OVER! Final Score: " + score);
        }

        repaint();
    }

    // KeyListener for smooth movement
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) up = true;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) down = true;
        if (e.getKeyCode() == KeyEvent.VK_LEFT) left = true;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) right = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) up = false;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) down = false;
        if (e.getKeyCode() == KeyEvent.VK_LEFT) left = false;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) right = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new SimplePacMan();
    }
}
