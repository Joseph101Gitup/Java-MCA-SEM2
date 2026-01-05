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

    private int playerScore = 0;
    private int computerScore = 0;

    private int playerHits = 0;      // Times ball hits player
    private int computerHits = 0;    // Times ball hits computer

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

        // Scores and Hits
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Player Score: " + playerScore, 20, 25);
        g.drawString("Computer Score: " + computerScore, getWidth() - 180, 25);
        g.drawString("Player Hits: " + playerHits, 20, 50);
        g.drawString("Computer Hits: " + computerHits, getWidth() - 200, 50);

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
        int playerSpeed = 8;
        if (movingUp) playerY -= playerSpeed;
        if (movingDown) playerY += playerSpeed;
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
        computerY = Math.max(0, Math.min(computerY, getHeight() - 60));

        // Collision with Player 1
        if (ballX <= 70 && ballX >= 50 && ballY + 10 >= playerY && ballY <= playerY + 60) {
            ballX = 70;
            ballSpeedX = -ballSpeedX;
            playerHits++; // Increment player hits
        }

        // Collision with Computer
        if (ballX + 20 >= 530 && ballX + 20 <= 550 && ballY + 10 >= computerY && ballY <= computerY + 60) {
            ballX = 530 - 20;
            ballSpeedX = -ballSpeedX;
            computerHits++; // Increment computer hits
        }

        // Check if someone misses
        if (ballX <= 0) {
            computerScore++;
            resetBall();
        } else if (ballX >= getWidth() - 20) {
            playerScore++;
            resetBall();
        }

        repaint();
    }

    private void resetBall() {
        ballX = getWidth() / 2 - 10;
        ballY = getHeight() / 2 - 10;
        ballSpeedX = (rand.nextBoolean() ? 6 : -6);
        ballSpeedY = (rand.nextBoolean() ? 4 : -4);
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
