# Pac-Man Game

This project is a simple implementation of the classic Pac-Man game using Java. It features the main character, Pac-Man, who navigates through a maze while avoiding ghosts and collecting pellets.

## Project Structure

```
pacman-game
├── src
│   ├── Main.java
│   ├── game
│   │   ├── Pacman.java
│   │   ├── Ghost.java
│   │   ├── GameBoard.java
│   │   └── Utils.java
│   └── assets
│       └── levels
│           └── level1.txt
├── lib
├── .gitignore
└── README.md
```

## Setup Instructions

1. **Clone the repository**:
   ```
   git clone <repository-url>
   cd pacman-game
   ```

2. **Compile the Java files**:
   Navigate to the `src` directory and compile the Java files:
   ```
   cd src
   javac Main.java game/*.java
   ```

3. **Run the game**:
   After compiling, run the game using:
   ```
   java Main
   ```

## Gameplay

- Control Pac-Man using the arrow keys to navigate through the maze.
- Collect pellets to score points.
- Avoid the ghosts; if you collide with a ghost, the game is over.

## Dependencies

This project does not have any external dependencies, but you may want to include libraries for enhanced graphics or sound in the `lib` directory.

## License

This project is open-source and available for modification and distribution. Please refer to the LICENSE file for more details.