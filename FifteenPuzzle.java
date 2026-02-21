public class FifteenPuzzle {

    // 4x4 Board representation
    static int[][] board = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 0}   // 0 represents the empty space
    };

    // Print the puzzle
    public static void printBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == 0)
                    System.out.print(" _ ");
                else
                    System.out.printf("%2d ", board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // Slide a tile into the empty space (if valid)
    public static boolean move(int tile) {
        int emptyR = -1, emptyC = -1;
        int tileR = -1, tileC = -1;

        // Find positions of tile and empty space
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                if (board[r][c] == 0) { emptyR = r; emptyC = c; }
                if (board[r][c] == tile) { tileR = r; tileC = c; }
            }
        }

        // Check if tile is adjacent to empty space
        if ((Math.abs(tileR - emptyR) == 1 && tileC == emptyC) ||
            (Math.abs(tileC - emptyC) == 1 && tileR == emptyR)) {

            // Swap tile with empty space
            board[emptyR][emptyC] = tile;
            board[tileR][tileC] = 0;
            return true;
        }

        return false; // invalid move
    }

    public static void main(String[] args) {
        System.out.println("Initial Board:");
        printBoard();

        move(15);  // Example move

        System.out.println("After moving 15:");
        printBoard();
    }
}
