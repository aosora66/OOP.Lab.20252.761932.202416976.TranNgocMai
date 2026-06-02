package hust.soict.ite6.aims.screen;

import hust.soict.ite6.aims.media.Book;
import hust.soict.ite6.aims.store.Store;
import javax.swing.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfId;
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;

    public AddBookToStoreScreen(Store store) {
        super(store);
        setTitle("Add Book to Store"); // Đổi tiêu đề cửa sổ cho đẹp
    }

    @Override
    protected void createInputFields() {
        centerPanel.add(new JLabel("ID: "));
        tfId = new JTextField();
        centerPanel.add(tfId);

        centerPanel.add(new JLabel("Title: "));
        tfTitle = new JTextField();
        centerPanel.add(tfTitle);

        centerPanel.add(new JLabel("Category: "));
        tfCategory = new JTextField();
        centerPanel.add(tfCategory);

        centerPanel.add(new JLabel("Cost: "));
        tfCost = new JTextField();
        centerPanel.add(tfCost);
    }

    @Override
    protected void addItemToStore() {
        // Lấy dữ liệu từ các ô nhập (Lưu ý: nhập đúng số cho ID và Cost để không bị lỗi)
        int id = Integer.parseInt(tfId.getText());
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());

        // Khởi tạo đối tượng Book và thêm vào Store
        Book book = new Book(id, title, category, cost);
        store.addMedia(book);

        JOptionPane.showMessageDialog(this, "Book Added Successfully!");

        // Tự động tắt màn hình này và quay lại StoreScreen
        this.dispose();
        new StoreScreen(store);
    }
}