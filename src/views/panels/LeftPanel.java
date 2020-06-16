package views.panels;

import controllers.ActionCommand;
import views.myComponents.MyJButton;
import views.texts.TextsBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Samuel f. Ruiz
 * @version 1.0
 * @since 13/05/20
 */
public class LeftPanel extends JPanel {

    private JButton btnSeeWChainStats;
    private JComboBox<String> cbWarehouseChains, cbWarehouses;
    private JLabel txtWarehouses, txtWarehouseChains;

    public LeftPanel(ActionListener listener) {
        setBorder(BorderFactory.createEmptyBorder(10,5,10,5));
        setLayout(new GridLayout(5,1));
        init(listener);
        fill();
    }

    private void init(ActionListener listener) {
        btnSeeWChainStats = new MyJButton(
                TextsBox.BTN_SEE_WCHAIN_STATS, ActionCommand.BTN_SEE_WCHAIN_STATS, listener
        );
        cbWarehouseChains = new JComboBox<>();
        cbWarehouses = new JComboBox<>();
        txtWarehouseChains = new JLabel(TextsBox.TXT_WAREHOUSE_CHAINS);
        txtWarehouses = new JLabel(TextsBox.TXT_WAREHOUSES);
    }

    private void fill() {
        add(txtWarehouseChains);
        add(cbWarehouseChains);
        add(txtWarehouses);
        add(cbWarehouses);
        add(btnSeeWChainStats);
    }
}
