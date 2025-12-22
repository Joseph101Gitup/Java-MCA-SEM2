package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameBoard extends JPanel implements ActionListener {
    private Timer timer;
    private Pacman pacman;
    private Ghost[] ghosts;
    private int score;

    public GameBoard() {
        this.setPreferredSize(new Dimension(400, 400));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.pacman = new Pacman(200, 200, 20); // Updated constructor
        this.ghosts = new Ghost[4];
        for (int i = 0; i < ghosts.length; i++) {
            ghosts[i] = new Ghost(100 * (i + 1), 100, 20, "#FF0000"); // Updated constructor
        }
        this.score = 0;
        this.timer = new Timer(100, this);
        this.timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        pacman.draw(g);
        for (Ghost ghost : ghosts) {
            ghost.draw(g);
        }
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 10, 10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateGameState();
        repaint();
    }

    public void updateGameState() {
        pacman.move(1, 0); // Example movement
        for (Ghost ghost : ghosts) {
            ghost.move();
        }
        checkCollisions();
    }

    private void checkCollisions() {
        // Implement collision detection logic
    }

    public void updateScore(int points) {
        score += points;
    }
}