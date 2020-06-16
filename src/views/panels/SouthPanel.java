package views.panels;

import controllers.ActionCommand;
import views.myComponents.MyJButton;
import views.texts.TextsBox;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author Samuel f. Ruiz
 * @version 1.0
 * @since 18/05/20
 */
public class SouthPanel extends JPanel implements TextsBox {

    private JButton btnCreateItem, btnRegistrySold, btnAddWarehouse, btnAddItem;

    public SouthPanel(ActionListener listener) {
        init(listener);
        fill();
    }

    private void init(ActionListener listener) {
        btnCreateItem = new MyJButton(BTN_CREATE_ITEM, ActionCommand.BTN_CREATE_ITEM, listener);
        btnRegistrySold = new MyJButton(BTN_REGISTRY_SOLD, ActionCommand.BTN_REGISTRY_SOLD, listener);
        btnAddWarehouse = new MyJButton(BTN_ADD_WAREHOUSE, ActionCommand.BTN_ADD_WAREHOUSE, listener);
        btnAddItem = new MyJButton(BTN_ADD_ITEM, ActionCommand.BTN_ADD_ITEM, listener);
    }

    private void fill() {
        add(btnCreateItem);
        add(btnAddItem);
        add(btnAddWarehouse);
        add(btnRegistrySold);
    }
}
