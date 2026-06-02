package hust.soict.ite6.aims.screen;

import javax.swing.JFrame;
import javafx.embed.swing.JFXPanel;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import hust.soict.ite6.aims.cart.Cart; // Import lớp Cart của bạn

public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart) {
        super();

        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    // Khởi tạo bộ nạp FXMLLoader trỏ đến tệp cấu hình giao diện cart.fxml
                    FXMLLoader loader = new FXMLLoader(getClass()
                            .getResource("/hust/soict/ite6/aims/screen/cart.fxml"));

                    // Tạo bộ điều khiển Controller và truyền dữ liệu giỏ hàng (cart) vào
                    CartScreenController controller = new CartScreenController(cart);

                    // Thiết lập Controller thủ công cho bộ nạp trước khi gọi lệnh load()
                    loader.setController(controller);

                    // Nạp cấu trúc giao diện từ file FXML vào nút gốc Parent
                    Parent root = loader.load();

                    // Tạo một Scene mới chứa giao diện JavaFX và gắn nó vào cấu phần JFXPanel của Swing
                    fxPanel.setScene(new Scene(root));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}