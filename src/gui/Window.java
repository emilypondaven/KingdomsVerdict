package gui;
import javax.swing.JFrame;
import java.awt.Dimension;

public class Window extends JFrame{
    
    private static final Dimension DEFAULT_DIMENSIONS = new Dimension(1100, 700);

    public Window() {
        setSize(DEFAULT_DIMENSIONS);
        setPreferredSize(DEFAULT_DIMENSIONS);
        setLocationRelativeTo(null);
        setVisible(true);
        add(GameView.getInstance());
    }
}
