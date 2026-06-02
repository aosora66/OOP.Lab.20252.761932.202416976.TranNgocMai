package hust.soict.ite6.aims.screen;

import hust.soict.ite6.aims.media.CompactDisc;
import hust.soict.ite6.aims.store.Store;
import javax.swing.*;

public class AddCDToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;
    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfArtist;

    public AddCDToStoreScreen(Store store) {
        super(store);
        setTitle("Add CD to Store");
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

        centerPanel.add(new JLabel("Artist: "));
        tfArtist = new JTextField();
        centerPanel.add(tfArtist);
    }

    @Override
    protected void addItemToStore() {
        // Ép kiểu các trường dữ liệu
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String director = tfDirector.getText();
        int length = Integer.parseInt(tfLength.getText());
        String artist = tfArtist.getText();

        // Khởi tạo đối tượng CompactDisc
        CompactDisc cd = new CompactDisc(title, category, cost, director, length, artist);
        store.addMedia(cd);

        JOptionPane.showMessageDialog(this, "CD Added Successfully!");

        // Tự động tắt màn hình này và quay lại StoreScreen
        this.dispose();
        new StoreScreen(store);
    }
}