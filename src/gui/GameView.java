package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
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
    private int votes;
    private int population;
    private int gold;
    private GameKeyboardListener keyListener;
    
        public GameView() {
            super();
            setSize(DEFAULT_DIMENSIONS);
            setPreferredSize(DEFAULT_DIMENSIONS);
            // setBackground(new Color(149, 201, 75));
            gameEnvironment = new GameEnv();
            keyListener = new GameKeyboardListener(this, gameEnvironment);
            addKeyListener(keyListener);
            setFocusable(true);
            setFocusCycleRoot(true);
            votes = gameEnvironment.getPlayer().getVoteCount();
            population = gameEnvironment.getPlayer().getTotalPopulation();
            gold = gameEnvironment.getPlayer().getGold();
            // Initialize game loop Timer
            gameLoopTimer = new Timer(TARGET_DELAY, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameEnvironment.getPlayer().setIdle();
                    updateGame(); // Update game state (e.g., move player)
                    repaint(); // Repaint the screen
                    requestFocusInWindow();
                }
            });
            instance = this;
            gameLoopTimer.start(); // Start the game loop
    
        }
    
        public static GameView getInstance() {
            return instance == null ? new GameView() : instance;
        }
    
        private static final int PADDING = 40;
    
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(Resources.getImage("background.png").getScaledInstance((int)DEFAULT_DIMENSIONS.getWidth(), (int)DEFAULT_DIMENSIONS.getHeight(), Image.SCALE_SMOOTH), 0, 0, this);
            g.setColor(new Color(77, 38, 5));
            g.setFont(Resources.getFont("Jacquard12-Regular.ttf"));
            g.drawString("Common Folk Village", 15, 30);
            g.drawString("Votes: " + votes + " /" + population, 400, 30);
            g.drawString("Gold: " + gold, 680, 30);
            g.drawImage(Resources.getImage("commonfolkVillage.png"), PADDING, PADDING, this);
            BufferedImage outlawsVillage = Resources.getImage("outlawVillage.png");
            g.drawString("Outlaw Village", 850, 30);
            g.drawImage(outlawsVillage, (int) DEFAULT_DIMENSIONS.getWidth() - PADDING - outlawsVillage.getWidth(), PADDING, this);
            BufferedImage nobleVillage = Resources.getImage("nobleVillage.png");
            g.drawString("Noble Village", 15, 685);
            g.drawImage(nobleVillage, PADDING, (int) DEFAULT_DIMENSIONS.getHeight() - PADDING - nobleVillage.getHeight(), this);
            BufferedImage environmentVillage = Resources.getImage("environVillage.png");
            g.drawString("Environmentalist Village", 765, 685);
            g.drawImage(environmentVillage, (int) DEFAULT_DIMENSIONS.getWidth() - PADDING - environmentVillage.getWidth(), (int) DEFAULT_DIMENSIONS.getHeight() - PADDING - environmentVillage.getHeight(), this);
            g.drawImage(gameEnvironment.getPlayer().getPlayerSprite(), gameEnvironment.getPlayerX(), gameEnvironment.getPlayerY(), this);
        }
    
        // // Method to update game state, e.g., move player
        private void updateGame() {
            // update the animation cycle
            gameEnvironment.getPlayer().updateAnimationStage();
            votes = gameEnvironment.getPlayer().getVoteCount();
            gold = gameEnvironment.getPlayer().getGold();
            population = gameEnvironment.getPlayer().getTotalPopulation();
        if (gameEnvironment.getCurrentVillage() != null) {
            //make the choce screen.
            System.out.println("BEFORE");
            gameEnvironment.resetPlayerCoords();
            keyListener.resetPressedKeys();
             // Create the custom popup dialog
            JDialog dialog = new JDialog(Window.getInstance(), gameEnvironment.getCurrentVillage().getName(), true); // 'true' makes it modal
            dialog.setSize(1000, 550);
            dialog.setLayout(new BorderLayout());

            // Make the dialog visible
            dialog.setLocationRelativeTo(Window.getInstance()); // Center the dialog relative to the main window
            dialog.setVisible(true); // Show the dialog
            ChoiceScreen.createScreen(dialog, gameEnvironment.getCurrentVillage().getPrompt(), gameEnvironment.getPlayer(), gameEnvironment.getCurrentVillage());
            gameEnvironment.resetCurrentVillage();
            System.out.println("AFTER");
        }
    }
}
