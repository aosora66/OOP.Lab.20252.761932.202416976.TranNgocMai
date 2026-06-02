package hust.soict.ite6.aims.screen;

import hust.soict.ite6.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected JPanel centerPanel;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createMenuBar(), BorderLayout.NORTH);

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0, 2, 5, 5));

        createInputFields();

        // Nút bấm chung để Add
        JButton btnAdd = new JButton("Add Item");
        btnAdd.addActionListener(e -> addItemToStore());
        centerPanel.add(btnAdd);

        cp.add(centerPanel, BorderLayout.CENTER);

        setTitle("Add Item to Store");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    protected abstract void createInputFields();
    protected abstract void addItemToStore();

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        return menuBar;
    }
}