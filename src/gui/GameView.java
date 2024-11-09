package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

import javax.swing.JPanel;

import controls.GameKeyboardListener;
import io.Resources;
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
        setBackground(new Color(149, 201, 75));
        gameEnvironment = new GameEnv();
        addKeyListener(new GameKeyboardListener(this,gameEnvironment));
        setFocusable(true);
        instance = this;
        // Initialize game loop Timer
        gameLoopTimer = new Timer(TARGET_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameEnvironment.getPlayer().setIdle();
                updateGame(); // Update game state (e.g., move player)
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
        // g.drawImage(Resources.getImage("background.png").getScaledInstance((int)DEFAULT_DIMENSIONS.getWidth(), (int)DEFAULT_DIMENSIONS.getHeight(), Image.SCALE_SMOOTH), 0, 0, this);
        g.drawImage(Resources.getImage("commonfolkVillage.png"), 20, 20, this);
        BufferedImage outlawsVillage = Resources.getImage("outlawsVillage.png");
        g.drawImage(outlawsVillage, (int) DEFAULT_DIMENSIONS.getWidth() - 20 - outlawsVillage.getWidth(), 20, this);
        BufferedImage environmentVillage = Resources.getImage("environmentVillage.png");
        g.drawImage(environmentVillage, 20, (int) DEFAULT_DIMENSIONS.getHeight() - 20 - environmentVillage.getHeight(), this);
        BufferedImage nobleVillage = Resources.getImage("nobleVillage.png");
        g.drawImage(nobleVillage, (int) DEFAULT_DIMENSIONS.getWidth() - 20 - nobleVillage.getWidth(), (int) DEFAULT_DIMENSIONS.getHeight() - 20 - nobleVillage.getHeight(), this);
        // g.drawImage(Resources.getImage(TOOL_TIP_TEXT_KEY), ABORT, TARGET_DELAY, instance)
        g.drawImage(gameEnvironment.getPlayer().getPlayerSprite(), gameEnvironment.getPlayerX(), gameEnvironment.getPlayerY(), this);
    }

    // // Method to update game state, e.g., move player
    private void updateGame() {
        // update the animation cycle
        gameEnvironment.getPlayer().updateAnimationStage();
    }
}
