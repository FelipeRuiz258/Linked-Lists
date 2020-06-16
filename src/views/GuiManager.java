package views;

import views.panels.ItemPanel;
import views.panels.LeftPanel;
import views.panels.SouthPanel;
import views.panels.WarehousePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Samuel f. Ruiz
 * @version 1.0
 * @since 11/05/20
 */
public class GuiManager extends JFrame {

    private JPanel itemPanel, leftPanel, southPanel, warehousePanel;

    public GuiManager(ActionListener listener) {
        setLayout(new GridBagLayout());
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init(listener);
        fill();
        setVisible(true);
        setResizable(false);
    }

    private void init(ActionListener listener) {
        itemPanel = new ItemPanel(listener);
        leftPanel = new LeftPanel(listener);
        southPanel = new SouthPanel(listener);
        warehousePanel = new WarehousePanel(listener);
    }

    private void fill() {
        GridBagConstraints gbc = new GridBagConstraints();
        add(leftPanel);
        add(warehousePanel);
        add(southPanel);
        add(itemPanel);
    }
}
