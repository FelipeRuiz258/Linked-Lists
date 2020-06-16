package views.panels;

import views.texts.TextsBox;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author Samuel f. Ruiz
 * @version 1.0
 * @since 19/05/20
 */
public class ItemPanel extends JPanel implements TextsBox {

    private JLabel txtItem, txtName, txtId, txtQuantity, txtCost;
    private JComboBox<String> items;

    public ItemPanel(ActionListener listener) {
        init(listener);
        fill();
    }

    private void init(ActionListener listener) {
        items = new JComboBox<>();
        items.addActionListener(listener);
        txtItem = new JLabel(TXT_ITEM);
        txtName = new JLabel(TXT_NAME);
        txtId = new JLabel(TXT_ID);
        txtQuantity = new JLabel(TXT_QUANTITY);
        txtCost = new JLabel(TXT_COST);
    }

    private void fill() {
        add(txtItem);
        add(items);
        add(txtName);
        add(txtId);
        add(txtQuantity);
        add(txtCost);
    }
}
