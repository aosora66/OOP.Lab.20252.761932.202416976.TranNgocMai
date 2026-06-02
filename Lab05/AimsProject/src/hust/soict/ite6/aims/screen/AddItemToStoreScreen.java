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

        JPanel wrapperPanel = new JPanel();
        wrapperPanel.setLayout(new BorderLayout());
        wrapperPanel.setBorder(BorderFactory.createEmptyBorder(50, 200, 50, 200));

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0, 2, 10, 20));

        createInputFields();

        wrapperPanel.add(centerPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        JButton btnAdd = new JButton("Add Item");
        btnAdd.setFont(new Font("Arial", Font.BOLD, 18));
        btnAdd.setPreferredSize(new Dimension(150, 40));
        btnAdd.addActionListener(e -> addItemToStore());

        buttonPanel.add(btnAdd);
        wrapperPanel.add(buttonPanel, BorderLayout.CENTER);

        cp.add(wrapperPanel, BorderLayout.CENTER);

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