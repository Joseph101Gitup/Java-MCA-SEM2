import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class MiniFootballGame extends JPanel implements ActionListener, KeyListener {

    private Timer timer;
    private int playerY = 150;       // Player 1 Y position
    private int computerY = 150;     // Computer Y position
    private int ballX = 300;         // Ball X position
    private int ballY = 150;         // Ball Y position
    private int ballSpeedX = 6;      // Ball horizontal speed
    private int ballSpeedY = 4;      // Ball vertical speed
    private Random rand = new Random();
    private boolean gameRunning = true;

    // Flags for smooth movement
    private boolean movingUp = false;
    private boolean movingDown = false;

    public MiniFootballGame() {
        JFrame frame = new JFrame("Mini Football Game");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setVisible(true);
        frame.addKeyListener(this);
        this.setFocusable(true);

        timer = new Timer(30, this);  // Game updates every 30ms
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
            return;
        }

        // Player 1
        g.setColor(Color.BLUE);
        g.fillRect(50, playerY, 20, 60);

        // Computer
        g.setColor(Color.RED);
        g.fillRect(530, computerY, 20, 60);

        // Ball
        g.setColor(Color.WHITE);
        g.fillOval(ballX, ballY, 20, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameRunning) return;

        // Smooth player movement
        int playerSpeed = 8; // pixels per timer tick
        if (movingUp) playerY -= playerSpeed;
        if (movingDown) playerY += playerSpeed;

        // Keep player within bounds
        playerY = Math.max(0, Math.min(playerY, getHeight() - 60));

        // Move ball
        ballX += ballSpeedX;
        ballY += ballSpeedY;

        // Bounce off top/bottom
        if (ballY <= 0 || ballY >= getHeight() - 20) {
            ballSpeedY = -ballSpeedY;
        }

        // Simple computer AI
        if (ballY + 10 > computerY + 30) computerY += 4;
        else if (ballY + 10 < computerY + 30) computerY -= 4;

        // Keep computer paddle in bounds
        computerY = Math.max(0, Math.min(computerY, getHeight() - 60));

        // Collision with Player 1
        if (ballX <= 70 && ballX >= 50 && ballY + 10 >= playerY && ballY <= playerY + 60) {
            ballX = 70;
            ballSpeedX = -ballSpeedX; // Bounce back
        }

        // Collision with Computer
        if (ballX + 20 >= 530 && ballX + 20 <= 550 && ballY + 10 >= computerY && ballY <= computerY + 60) {
            ballX = 530 - 20;
            ballSpeedX = -ballSpeedX; // Bounce back
        }

        // Check if someone misses
        if (ballX <= 0) {
            gameRunning = false;
            JOptionPane.showMessageDialog(this, "Computer Wins!");
        } else if (ballX >= getWidth() - 20) {
            gameRunning = false;
            JOptionPane.showMessageDialog(this, "Player Wins!");
        }

        repaint();
    }

    // KeyListener
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) movingUp = true;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) movingDown = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) movingUp = false;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) movingDown = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new MiniFootballGame();
    }
}
