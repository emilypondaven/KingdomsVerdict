package gui;
import javax.swing.JFrame;
import javax.swing.OverlayLayout;

import io.Resources;

public class Window extends JFrame{

    private static Window instance = null;

    public Window() {
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        Resources.loadAllSprites();
        Resources.loadAllFonts();
        getContentPane().setLayout(new OverlayLayout(getContentPane()));
        getContentPane().add(GameView.getInstance());
        pack();
        instance = this;
    }

    public static Window getInstance() {
        return instance == null ? new Window() : instance;
    }
}
