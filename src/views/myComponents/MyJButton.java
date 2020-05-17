package views.myComponents;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author Samuel f. Ruiz
 * @version 1.0
 * @since 17/05/20
 */
public class MyJButton extends JButton {

    public MyJButton(String text, String actionCommand, ActionListener listener) {
        this.setText(text);
        this.setActionCommand(actionCommand);
        this.addActionListener(listener);
    }
}
