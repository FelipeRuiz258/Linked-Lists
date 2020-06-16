package views.panels;

import controllers.ActionCommand;
import views.texts.TextsBox;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author Samuel f. Ruiz
 * @version 1.0
 * @since 18/05/20
 */
public class WarehousePanel extends JPanel implements TextsBox {

    private JLabel txtAddress, txtItemQuantity;
    private JButton btnSeeInventoryCost;

    public WarehousePanel(ActionListener listener) {
        init(listener);
        fill();
    }

    private void init(ActionListener listener) {
        btnSeeInventoryCost = new JButton(BTN_SEE_INVENTORY_COST);
        btnSeeInventoryCost.setActionCommand(ActionCommand.BTN_SEE_INVENTORY_COST);
        btnSeeInventoryCost.addActionListener(listener);
        txtAddress = new JLabel(TXT_ADDRESS);
        txtItemQuantity = new JLabel(TXT_ITEM_QUANTITY);
    }

    private void fill() {
        add(txtAddress);
        add(txtItemQuantity);
        add(btnSeeInventoryCost);
    }
}
