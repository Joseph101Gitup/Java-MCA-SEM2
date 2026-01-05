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
    private int[] ghostX = new int[2];
    private int[] ghostY = new int[2];

    private int score = 0;
    private boolean gameRunning = true;

    private int[][] maze = new int[ROWS][COLS];
    private Random rand = new Random();

    public PacManGame() {
        JFrame frame = new JFrame("Pac-Man");
        frame.setSize(COLS * TILE_SIZE + 16, ROWS * TILE_SIZE + 39);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setVisible(true);
        frame.addKeyListener(this);

        initializeMaze();

        timer = new Timer(150, this);
        timer.start();
    }

    private void initializeMaze() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (i == 0 || j == 0 || i == ROWS - 1 || j == COLS - 1 || rand.nextDouble() < 0.1)
                    maze[i][j] = 1;
                else
                    maze[i][j] = 2;
            }
        }

        maze[pacmanY][pacmanX] = 0;

        for (int i = 0; i < 2; i++) {
            ghostX[i] = COLS - 2 - i;
            ghostY[i] = ROWS - 2;
            maze[ghostY[i]][ghostX[i]] = 0;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (maze[i][j] == 1) {
                    g.setColor(Color.BLUE);
                    g.fillRect(j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                } else if (maze[i][j] == 2) {
                    g.setColor(Color.YELLOW);
                    g.fillOval(j * TILE_SIZE + 8, i * TILE_SIZE + 8, 4, 4);
                }
            }
        }

        g.setColor(Color.ORANGE);
        g.fillOval(pacmanX * TILE_SIZE, pacmanY * TILE_SIZE, TILE_SIZE, TILE_SIZE);

        g.setColor(Color.RED);
        for (int i = 0; i < 2; i++) {
            g.fillOval(ghostX[i] * TILE_SIZE, ghostY[i] * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }

        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 10, 15);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameRunning) return;

        if (maze[pacmanY][pacmanX] == 2) {
            maze[pacmanY][pacmanX] = 0;
            score++;
        }

        moveGhosts();

        for (int i = 0; i < 2; i++) {
            if (pacmanX == ghostX[i] && pacmanY == ghostY[i]) {
                gameRunning = false;
                JOptionPane.showMessageDialog(this, "GAME OVER! Score: " + score);
                timer.stop();
            }
        }

        repaint();
    }

    private void moveGhosts() {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < 2; i++) {
            int d = rand.nextInt(4);
            int nx = ghostX[i] + dx[d];
            int ny = ghostY[i] + dy[d];

            if (nx >= 0 && nx < COLS && ny >= 0 && ny < ROWS && maze[ny][nx] != 1) {
                ghostX[i] = nx;
                ghostY[i] = ny;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int nx = pacmanX;
        int ny = pacmanY;

        if (e.getKeyCode() == KeyEvent.VK_UP) ny--;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) ny++;
        if (e.getKeyCode() == KeyEvent.VK_LEFT) nx--;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) nx++;

        if (nx >= 0 && nx < COLS && ny >= 0 && ny < ROWS && maze[ny][nx] != 1) {
            pacmanX = nx;
            pacmanY = ny;
        }
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new PacManGame();
    }
}
