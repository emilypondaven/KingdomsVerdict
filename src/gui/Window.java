package gui;
import javax.swing.JFrame;

import io.Resources;

public class Window extends JFrame{

    public Window() {
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        Resources.loadAllImages();
        add(GameView.getInstance());
        pack();
    }
}
