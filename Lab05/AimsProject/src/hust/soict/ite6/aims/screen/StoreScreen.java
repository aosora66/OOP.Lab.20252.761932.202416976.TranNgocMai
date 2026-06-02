package hust.soict.ite6.aims.screen;

import hust.soict.ite6.aims.cart.Cart;
import hust.soict.ite6.aims.media.Media;
import hust.soict.ite6.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreScreen extends JFrame {

    private Store store;
    // Cart dung chung cho toan man hinh Store
    private Cart cart = new Cart();

    public StoreScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // ===================== NORTH =====================

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        // 1. Khởi tạo menu con và KHAI BÁO BIẾN rõ ràng cho từng nút
        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem menuAddBook = new JMenuItem("Add Book");
        JMenuItem menuAddCD = new JMenuItem("Add CD");
        JMenuItem menuAddDVD = new JMenuItem("Add DVD");

        // Xử lý khi bấm Add Book
        menuAddBook.addActionListener(e -> {
            new AddBookToStoreScreen(store);
            dispose();
        });

        // Xử lý khi bấm Add CD
        menuAddCD.addActionListener(e -> {
            new AddCDToStoreScreen(store);
            dispose();
        });

        // Gắn sự kiện (Action Listener) cho nút Add DVD
        menuAddDVD.addActionListener(e -> {
            new AddDVDToStoreScreen(store); // Mở màn hình thêm DVD
            dispose(); // Đóng màn hình Store hiện tại
        });

        // 3. Add các nút đã khai báo vào menu con
        smUpdateStore.add(menuAddBook);
        smUpdateStore.add(menuAddCD);
        smUpdateStore.add(menuAddDVD);

        menu.add(smUpdateStore);

        // 4. Xử lý nút View Cart
        JMenuItem menuViewCart = new JMenuItem("View cart");
        menuViewCart.addActionListener(e -> {
            new CartScreen(cart); // Mở Cart Screen (JavaFX nhúng JFXPanel)
        });

        menu.add(new JMenuItem("View store"));
        menu.add(menuViewCart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        // Label "AIMS" mau cyan, font 50px
        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        // Nut "View cart" ben phai
        JButton cartBtn = new JButton("View cart");
        cartBtn.setPreferredSize(new Dimension(100, 50));
        cartBtn.setMaximumSize(new Dimension(100, 50));

        cartBtn.addActionListener(e -> {
            new CartScreen(cart); // Mở màn hình Giỏ hàng
        });

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartBtn);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    // ===================== CENTER =====================

    JPanel createCenter() {
        JPanel center = new JPanel();
        // GridLayout(3, 3, 2, 2) co dinh theo Lab 05 (Figure 15)
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < 9; i++) {
            if (i < mediaInStore.size()) {
                MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
                center.add(cell);
            } else {
                // O trong neu chua du 9 items
                center.add(new JPanel());
            }
        }

        return center;
    }
}