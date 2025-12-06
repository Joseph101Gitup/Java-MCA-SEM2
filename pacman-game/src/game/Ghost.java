package game;

import java.awt.*;

public class Ghost {
    private int x, y, size;
    private String color;

    public Ghost(int x, int y, int size, String color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(Color.decode(color));
        g.fillRect(x, y, size, size); // Draw Ghost
    }

    public void move() {
        // Example movement logic
        x += 1;
        y += 1;
    }
}