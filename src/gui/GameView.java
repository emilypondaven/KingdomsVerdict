package gui;

import java.awt.Color;

import javax.swing.JPanel;

public class GameView extends JPanel {
    
    private static GameView instance;

    public GameView() {
        super();
        setBackground(Color.red);
        instance = this;
    }

    public static GameView getInstance() {
        return instance == null ? new GameView() : instance;
    }
}
