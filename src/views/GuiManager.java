package views;

import javax.swing.*;
import java.awt.*;

/**
 * @author Samuel f. Ruiz
 * @version 1.0
 * @since 11/05/20
 */
public class GuiManager extends JFrame {

    public GuiManager() {
        setLayout(new BorderLayout());
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }
}
