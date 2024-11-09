package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.JPanel;

import controls.GameKeyboardListener;
import logic.GameEnv;

public class GameView extends JPanel {

    public static final Dimension DEFAULT_DIMENSIONS = new Dimension(1100, 700);
    private static GameView instance;
    private GameEnv gameEnvironment;
    private static final int TARGET_FPS = 5; // Set target FPS
    private static final int TARGET_DELAY = 1000 / TARGET_FPS; // Calculate delay between frames (in milliseconds)
    private Timer gameLoopTimer;

    public GameView() {
        super();
        setSize(DEFAULT_DIMENSIONS);
        setPreferredSize(DEFAULT_DIMENSIONS);
        setBackground(Color.GREEN);
        gameEnvironment = new GameEnv();
        addKeyListener(new GameKeyboardListener(this,gameEnvironment));
        setFocusable(true);
        instance = this;
        // Initialize game loop Timer
        gameLoopTimer = new Timer(TARGET_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // updateGame(); // Update game state (e.g., move player)
                repaint(); // Repaint the screen
            }
        });

        gameLoopTimer.start(); // Start the game loop
    }

    public static GameView getInstance() {
        return instance == null ? new GameView() : instance;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(gameEnvironment.getPlayer().getPlayerSprite(), gameEnvironment.getPlayerX(), gameEnvironment.getPlayerY(), this);
    }

    // // Method to update game state, e.g., move player
    // private void updateGame() {
    //     // update the animation cycle
    //     gameEnvironment.getPlayer().updateAnimationStage();
    // }
}
