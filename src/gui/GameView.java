package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import controls.GameKeyboardListener;
import io.Resources;
import logic.GameEnv;
import logic.Player;

public class GameView extends JPanel {

    public static final Dimension DEFAULT_DIMENSIONS = new Dimension(1100, 700);
    private static GameView instance;
    private GameEnv gameEnvironment;

    public GameView() {
        super();
        setSize(DEFAULT_DIMENSIONS);
        setPreferredSize(DEFAULT_DIMENSIONS);
        setBackground(Color.red);
        gameEnvironment = new GameEnv();
        addKeyListener(new GameKeyboardListener(this,gameEnvironment));
        setFocusable(true);
        instance = this;
    }

    public static GameView getInstance() {
        return instance == null ? new GameView() : instance;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Resources.getImage(Player.PLAYER_IMAGE_STRING), gameEnvironment.getPlayer().getX(), gameEnvironment.getPlayer().getY(), this);
    }
}
