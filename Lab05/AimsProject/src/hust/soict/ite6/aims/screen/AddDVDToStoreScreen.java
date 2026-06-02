package hust.soict.ite6.aims.screen;

import hust.soict.ite6.aims.media.DigitalVideoDisc;
import hust.soict.ite6.aims.store.Store;
import javax.swing.*;

public class AddDVDToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;
    private JTextField tfDirector;
    private JTextField tfLength;

    public AddDVDToStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected void createInputFields() {
        centerPanel.add(new JLabel("Title: "));
        tfTitle = new JTextField();
        centerPanel.add(tfTitle);

        centerPanel.add(new JLabel("Category: "));
        tfCategory = new JTextField();
        centerPanel.add(tfCategory);

        centerPanel.add(new JLabel("Cost: "));
        tfCost = new JTextField();
        centerPanel.add(tfCost);

        centerPanel.add(new JLabel("Director: "));
        tfDirector = new JTextField();
        centerPanel.add(tfDirector);

        centerPanel.add(new JLabel("Length: "));
        tfLength = new JTextField();
        centerPanel.add(tfLength);
    }

    @Override
    protected void addItemToStore() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String director = tfDirector.getText();
        int length = Integer.parseInt(tfLength.getText());

        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
        store.addMedia(dvd);
        JOptionPane.showMessageDialog(this, "DVD Added Successfully!");

        this.dispose();
        new StoreScreen(store);
    }
}