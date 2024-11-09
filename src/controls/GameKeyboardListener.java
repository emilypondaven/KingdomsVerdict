package controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import gui.GameView;
import logic.GameEnv;

public class GameKeyboardListener implements KeyListener{
    
    private GameView gameView;
    private GameEnv gameEnvironment;

    private Set<Character> pressedKeys = new HashSet<Character>();

    public GameKeyboardListener(GameView view, GameEnv gameEnvironment) {
        gameView = view;
        this.gameEnvironment = gameEnvironment;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyChar());
        updatePlayerMovement();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyChar());
        updatePlayerMovement();
    }

    private void updatePlayerMovement() {
        int deltaX = 0;
        int deltaY = 0;

        if (pressedKeys.contains('a')) {
            deltaX -= 1; // Move left
        }
        if (pressedKeys.contains('d')) {
            deltaX += 1; // Move right
        }
        if (pressedKeys.contains('s')) {
            deltaY += 1; // Move down
        }
        if (pressedKeys.contains('w')) {
            deltaY -= 1; // Move up
        }

        // Update the player's position
        gameEnvironment.movePlayerX(deltaX);
        gameEnvironment.movePlayerY(deltaY);

        // Repaint the game view
        gameView.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
}
