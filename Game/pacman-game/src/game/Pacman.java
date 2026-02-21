package game;

import java.awt.*;

public class Pacman {
    private int x, y, size;

    public Pacman(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, size, size); // Draw Pac-Man
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
}