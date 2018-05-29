import gui.StartCanvas;

import javax.swing.*;
import java.awt.*;

public class Start extends JFrame {

    public static final int CANVAS_WIDTH = 330;
    public static final int CANVAS_HEIGHT = 330;

    private StartCanvas canvas;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Start();
            }
        });
    }
    public Start() {
        canvas = new StartCanvas();    // Construct the drawing canvas
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

        // Set the Drawing JPanel as the JFrame's content-pane
        Container cp = getContentPane();
        cp.add(canvas);
        // or "setContentPane(canvas);"

        setDefaultCloseOperation(EXIT_ON_CLOSE);   // Handle the CLOSE button
        pack();              // Either pack() the components; or setSize()
        setTitle("Ant Museum");  // "super" JFrame sets the title
        setVisible(true);    // "super" JFrame show
    }
}
