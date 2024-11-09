package gui;
import javax.swing.JFrame;

import io.Resources;

import java.awt.Dimension;

public class Window extends JFrame{
    
    public static final Dimension DEFAULT_DIMENSIONS = new Dimension(1100, 700);

    public Window() {
        setSize(DEFAULT_DIMENSIONS);
        setPreferredSize(DEFAULT_DIMENSIONS);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        Resources.loadAllImages();
        add(GameView.getInstance());
    }
}
