package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import controls.GameKeyboardListener;
import io.Resources;
import logic.GameEnv;
import logic.Player;

public class GameView extends JPanel {
    
    private static GameView instance;
    private GameEnv gameEnvironment;

    public GameView() {
        super();
        setBackground(Color.red);
        gameEnvironment = new GameEnv();
        addKeyListener(new GameKeyboardListener(this));
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
