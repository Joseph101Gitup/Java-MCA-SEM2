import game.GameBoard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main extends JPanel implements ActionListener {
    private Timer timer;
    private GameBoard gameBoard;

    public Main() {
        gameBoard = new GameBoard();
        this.setLayout(null); // Optional: Use a layout manager if needed
        this.add(gameBoard); // Add GameBoard as a child component
        timer = new Timer(100, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameBoard.updateGameState(); // Update game state
        gameBoard.repaint(); // Repaint the GameBoard
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pac-Man Game");
        Main game = new Main();
        frame.add(game);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}