import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class PacManGame extends JPanel implements ActionListener, KeyListener {

    private Timer timer;
    private final int TILE_SIZE = 20;
    private final int ROWS = 15;
    private final int COLS = 20;
    private int pacmanX = 1, pacmanY = 1;
    private int ghostX = COLS - 2, ghostY = ROWS - 2;
    private int score = 0;
    private boolean gameRunning = true;

    private int[][] maze = new int[ROWS][COLS]; // 0 = path, 1 = wall, 2 = dot
    private Random rand = new Random();

    // Movement flags
    private boolean up, down, left, right;

    public PacManGame() {
        JFrame frame = new JFrame("Pac-Man");
        frame.setSize(COLS * TILE_SIZE + 16, ROWS * TILE_SIZE + 39);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setVisible(true);
        frame.addKeyListener(this);
        this.setFocusable(true);

        initializeMaze();

        timer = new Timer(150, this); // slow enough for gameplay
        timer.start();
    }

    private void initializeMaze() {
        // Randomly create walls and dots
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (i == 0 || j == 0 || i == ROWS - 1 || j == COLS - 1 || rand.nextDouble() < 0.1) {
                    maze[i][j] = 1; // wall
                } else {
                    maze[i][j] = 2; // dot
                }
            }
        }
        maze[pacmanY][pacmanX] = 0; // Pac-Man starting position
        maze[ghostY][ghostX] = 0; // Ghost starting position
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw maze
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (maze[i][j] == 1) { // wall
                    g.setColor(Color.BLUE);
                    g.fillRect(j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                } else if (maze[i][j] == 2) { // dot
                    g.setColor(Color.YELLOW);
                    g.fillOval(j * TILE_SIZE + 8, i * TILE_SIZE + 8, 4, 4);
                }
            }
        }

        // Draw Pac-Man
        g.setColor(Color.ORANGE);
        g.fillOval(pacmanX * TILE_SIZE, pacmanY * TILE_SIZE, TILE_SIZE, TILE_SIZE);

        // Draw Ghost
        g.setColor(Color.RED);
        g.fillOval(ghostX * TILE_SIZE, ghostY * TILE_SIZE, TILE_SIZE, TILE_SIZE);

        // Score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Score: " + score, 5, 15);

        if (!gameRunning) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("GAME OVER!", 100, ROWS * TILE_SIZE / 2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameRunning) return;

        // Move Pac-Man
        movePacman();

        // Collect dot
        if (maze[pacmanY][pacmanX] == 2) {
            maze[pacmanY][pacmanX] = 0;
            score++;
        }

        // Move ghost randomly
        moveGhost();

        // Check collision with ghost
        if (pacmanX == ghostX && pacmanY == ghostY) {
            gameRunning = false;
            JOptionPane.showMessageDialog(this, "GAME OVER! Score: " + score);
        }

        // Check if all dots collected
        boolean dotsLeft = false;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (maze[i][j] == 2) dotsLeft = true;
            }
        }
        if (!dotsLeft) {
            gameRunning = false;
            JOptionPane.showMessageDialog(this, "YOU WIN! Score: " + score);
        }

        repaint();
    }

    private void movePacman() {
        int nextX = pacmanX, nextY = pacmanY;
        if (up) nextY--;
        if (down) nextY++;
        if (left) nextX--;
        if (right) nextX++;

        if (nextX >= 0 && nextX < COLS && nextY >= 0 && nextY < ROWS && maze[nextY][nextX] != 1) {
            pacmanX = nextX;
            pacmanY = nextY;
        }
    }

    private void moveGhost() {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int dir = rand.nextInt(4);
        int nextX = ghostX + dx[dir];
        int nextY = ghostY + dy[dir];

        if (nextX >= 0 && nextX < COLS && nextY >= 0 && nextY < ROWS && maze[nextY][nextX] != 1) {
            ghostX = nextX;
            ghostY = nextY;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up = true; down = left = right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = true; up = left = right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = true; up = down = right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = true; up = down = left = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new PacManGame();
    }
}
