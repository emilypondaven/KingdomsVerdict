package controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gui.GameView;

public class GameKeyboardListener implements KeyListener{
    private GameView gameView;

    public GameKeyboardListener(GameView view) {
        gameView = view;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a':
                // gameView
                break;
        
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
}
